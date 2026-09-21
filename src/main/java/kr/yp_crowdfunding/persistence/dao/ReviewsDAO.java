package kr.yp_crowdfunding.persistence.dao;

import javax.sql.DataSource;

public class ReviewsDAO extends DAO{
    public enum Columns{
        USER_ID("user_id"),
        PROJECT_ID("project_id"),
        REWARD_NAME("reward_name"),
        STAR("star"),
        CONTENTS("contents"),
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
    public ReviewsDAO(DataSource dataSource) {
        super(dataSource);
    }
}
