package databases;

import java.sql.*;

public class Connect {

    private static String dbname;
    private static String mysql_username;
    private static String mysql_password;

    public static void setProperties() {
        dbname = "sms_application";
        mysql_username = "root";
        mysql_password = "";
    }

    public static Connection getConnection() {
        setProperties();
        if (dbname == null) {
            return null;
        }
        Connection con = null;
        try {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                System.out.println("Error: unable to load driver class!");
                System.exit(1);
            }
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dbname, mysql_username, mysql_password);
            //System.out.println("Successfully");
        } catch (Exception e) {
            System.out.println("Error: unable to connect to database!");
        }
        return con;
    }
}
    