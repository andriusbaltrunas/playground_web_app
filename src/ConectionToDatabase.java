import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by andriusbaltrunas on 4/3/2018.
 */
public class ConectionToDatabase {
    public Connection getConnection() {
        InputStream striem = getClass().getResourceAsStream("../properties/Database.properties");
        Properties properties = new Properties();
        Connection conn = null;
        try {
            properties.load(striem);
            getClass().forName(properties.getProperty("drivers"));
            conn = DriverManager.getConnection(properties.getProperty("url"),
                    properties.getProperty("username"), properties.getProperty("password"));
        } catch (Exception e) {
            System.out.println(e);
        }
        return conn;
    }
}
