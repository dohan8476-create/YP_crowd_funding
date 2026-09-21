package kr.yp_crowdfunding;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Properties;

public class PooledDataSource implements AutoCloseable {
    private final BasicDataSource basicDS = new BasicDataSource();

    public PooledDataSource(){
        try(InputStream inputStream = getClass().getResourceAsStream("/config/db.properties")){
            Properties properties = new Properties();
            properties.load(inputStream);
            basicDS.setDriverClassName(properties.getProperty("DRIVER_CLASS"));
            basicDS.setUrl(properties.getProperty("DB_CONNECTION_URL"));
            basicDS.setUsername(properties.getProperty("DB_USER"));
            basicDS.setPassword(properties.getProperty("DB_PWD"));
            basicDS.setInitialSize(10);
            basicDS.setMaxTotal(10);
        }catch(IOException e){
            System.err.println("Error : " + e);
        }
    }

    public DataSource getDataSource(){
        return basicDS;
    }

    public void close() throws SQLException {
        basicDS.close();
    }
}
