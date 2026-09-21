package kr.yp_crowdfunding.persistence.dao;

import kr.yp_crowdfunding.persistence.dto.ProjectDTO;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProjectsDAO extends DAO {

    public enum Columns{
        ID("id"),
        TITLE("title"),
        DURATION("duration"),
        START_DATE("start_date"),
        GOAL("goal"),
        WRITER("writer"),
        APPROVAL_STATUS("approval_status");

        private final String name;
        Columns(String name){
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public ProjectsDAO(DataSource dataSource) {
        super(dataSource);
    }


    public List<ProjectDTO> getAllProjects() throws SQLException {
        final String sql = "select * from projects";
        List<ProjectDTO> result = new ArrayList<>();

        try(Statement statement = dataSource.getConnection().createStatement()){
            ResultSet rs = statement.executeQuery(sql);
            ProjectDTO dto = new ProjectDTO();
            while(rs.next()){
                dto.setId(rs.getLong(Columns.ID.name));
                dto.setTitle(rs.getString(Columns.TITLE.name));
                dto.setDuration(rs.getInt(Columns.DURATION.name));
                dto.setStartDate(rs.getDate(Columns.START_DATE.name));
                dto.setGoal(rs.getLong(Columns.GOAL.name));
                dto.setWriterID(rs.getLong(Columns.WRITER.name));
                dto.setApprovalStatus(ProjectDTO.ApprovalStatus.valueOf(rs.getString(Columns.APPROVAL_STATUS.name)));
            }
            result.add(dto);
        }
        return result;
    }

}
