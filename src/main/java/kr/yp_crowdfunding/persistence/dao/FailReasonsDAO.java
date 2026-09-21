package kr.yp_crowdfunding.persistence.dao;

import javax.sql.DataSource;

public class FailReasonsDAO extends DAO{

    public enum Columns{
        ID("id"),
        PROJECT_ID("project_id"),
        REASON("reason"),
        DATE("date");

        private final String name;
        Columns(String name){
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }
    public FailReasonsDAO(DataSource dataSource) {
        super(dataSource);
    }
}
