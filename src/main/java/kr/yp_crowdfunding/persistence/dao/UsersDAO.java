package kr.yp_crowdfunding.persistence.dao;

import kr.yp_crowdfunding.persistence.dto.UserDTO;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsersDAO extends DAO {

    public enum Columns{
        ID("id"),
        ADDRESS("address"),
        NAME("name"),
        TYPE("type"),
        PASSWORD("password"),
        REGDATE("regDate"),
        LOGIN_ID("login_id");

        private final String name;
        Columns(String name){
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public UsersDAO(DataSource dataSource) {
        super(dataSource);
    }

    private static final String INSERT_SQL =
            "INSERT INTO users (id, address, name, type, regdate, login_id, password) VALUES (?, ?, ?, ?, ?, ?, ?)";

    public void insert(UserDTO userDTO) throws SQLException {
        try(Connection conn = dataSource.getConnection();
            PreparedStatement psmt = conn.prepareStatement(INSERT_SQL)){

            psmt.setLong(1, userDTO.getUserID());
            psmt.setString(2, userDTO.getAddress());
            psmt.setString(3, userDTO.getName());
//          psmt.setString(4, userDTO.getUserType().name());
            //기본을 SUPPORT로 받는 형식으로??
            psmt.setString(4, UserDTO.UserType.SUPPORTER.name());
            psmt.setTimestamp(5, new java.sql.Timestamp(userDTO.getRegDate().getTime()));
            psmt.setString(6, userDTO.getLoginID());
            psmt.setString(7, userDTO.getEncryptedPassword());

            psmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }


    public List<UserDTO> getAllUsers() throws SQLException {
        final String sql = "select * from users";
        List<UserDTO> result = new ArrayList<>();

        try(Statement statement = dataSource.getConnection().createStatement()){
            ResultSet rs = statement.executeQuery(sql);
            UserDTO dto = new UserDTO();
            while(rs.next()){
                dto.setUserID(rs.getLong(Columns.ID.name));
                dto.setAddress(rs.getString(Columns.ADDRESS.name));
                dto.setName(rs.getString(Columns.NAME.name));
                dto.setUserType(UserDTO.UserType.valueOf(rs.getString(Columns.TYPE.name)));
                dto.setEncryptedPassword(rs.getString(Columns.PASSWORD.name));
                dto.setRegDate(rs.getDate(Columns.REGDATE.name));
                dto.setLoginID(rs.getString(Columns.LOGIN_ID.name));
            }
            result.add(dto);
        }
        return result;
    }

}
