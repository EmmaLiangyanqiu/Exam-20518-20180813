package utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * Created by Emma on 2018/8/13.
 */
public class DBUtils {
    public static Connection con;
    public static PreparedStatement ps;
    public static ResultSet rs;
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("驱动加载成功");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getCon() {
        Properties p = new Properties();
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("db.properties");
        String username = null;
        String password = null;
        String url = null;
        try {
            p.load(inputStream);
            username = p.getProperty("username");
            password = p.getProperty("password");
            url = p.getProperty("url");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {

            if (con == null) {
                con = DriverManager.getConnection(url, username, password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    public static void closeCon() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps!=null){
                ps.close();
            }
            if (con!=null){
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
