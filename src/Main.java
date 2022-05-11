import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Main
 */
public class Main {
    // // The JDBC Connector Class.
    // private static final String dbClassName = "com.mysql.jdbc.Driver";

    // // Connection string. emotherearth is the database the program
    // // is connecting to. You can include user and password after this
    // // by adding (say) ?user=paulr&password=paulr. Not recommended!

    // private static final String CONNECTION =
    //                         "jdbc:mysql://127.0.0.1/DGI_ESP";

    // public static void main(String[] args) throws
    //                         ClassNotFoundException,SQLException
    // {
    // System.out.println(dbClassName);
    // // Class.forName(xxx) loads the jdbc classes and
    // // creates a drivermanager class factory
    // Class.forName(dbClassName);

    // // Properties for user and password. Here the user and password are both 'paulr'
    // Properties p = new Properties();
    // p.put("user","paulr");
    // p.put("password","paulr");

    // // Now try to connect
    // Connection c = DriverManager.getConnection(CONNECTION,p);

    // System.out.println("It works !");
    // c.close();
    // }

    private static final String url = "jdbc:mysql://localhost";
 
    private static final String user = "root";
 
    private static final String password = "";

 
    public static void main(String args[]) {
        try {
            // Connection con = DriverManager.getConnection(url, user, password);
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/DGI_ESP","root","root"); 
            // PreparedStatement ps = connection.prepareStatement("CREATE DATABASE java_exercise");
            // int result = ps.executeUpdate();
            System.out.println("Success");
        
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}