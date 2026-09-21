package kr.yp_crowdfunding.persistence.dao;

import javax.sql.DataSource;

public class CategoriesDAO extends DAO{
    public enum Columns{
        PROJECT_ID("project_id"),
        CATEGORY("category");

        private final String name;
        Columns(String name){
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }


    public CategoriesDAO(DataSource dataSource) {
        super(dataSource);
    }
}
