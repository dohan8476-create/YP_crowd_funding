package kr.yp_crowdfunding.persistence.dao;

import kr.yp_crowdfunding.persistence.dto.UserDTO;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
