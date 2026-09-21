package kr.yp_crowdfunding;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {

        try (Application application = new Application()) {
            application.start();
        } catch (SQLException e) {
            System.out.println("SQL Error : " + e);
        }
    }
}
