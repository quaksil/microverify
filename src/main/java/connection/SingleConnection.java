package connection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SingleConnection {

    static {
        connect();
    }

    private static Connection conn;

    public SingleConnection() {
        connect();
    }

    private static void connect() {

        String rootPath = Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResource("dbConn.properties")).getPath();
        InputStream input = null;

        try {
            input = new FileInputStream(rootPath);
        } catch (FileNotFoundException e) {
            Logger.getLogger(SingleConnection.class.getName()).log(Level.SEVERE, null, e);
        }
        Properties props = new Properties();

        try {
            props.load(input);
        } catch (IOException e) {
            Logger.getLogger(SingleConnection.class.getName()).log(Level.SEVERE, null, e);
        }
        try {
            input.close();
        } catch (IOException e) {
            Logger.getLogger(SingleConnection.class.getName()).log(Level.SEVERE, null, e);
        }

        String driver = props.getProperty("driver.name");
        String url = props.getProperty("server.name");
        String username = props.getProperty("user.name");
        String passwd = props.getProperty("user.password");
        
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            Logger.getLogger(SingleConnection.class.getName()).log(Level.SEVERE, null, e);
        }
        try {
            conn = DriverManager.getConnection(url, username, passwd);
        } catch (SQLException e) {
            Logger.getLogger(SingleConnection.class.getName()).log(Level.SEVERE, null, e);

        }
    }

    public static Connection getConnection() {
        return conn;
    }
}