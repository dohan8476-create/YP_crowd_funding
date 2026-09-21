package kr.yp_crowdfunding.persistence.dao;

import javax.sql.DataSource;

public class LikesDAO extends DAO{

    public enum Columns{
        USER_ID("user_id"),
        PROJECT_ID("project_id");
        private final String name;
        Columns(String name){
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public LikesDAO(DataSource dataSource) {
        super(dataSource);
    }
}
