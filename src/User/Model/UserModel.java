package User.Model;

import java.sql.*;

import User.Entity.User;

/**
 * UserModel
 */
public class UserModel 
{
    private final String url = "jdbc:mysql://localhost:3306/java_exercice";
    private final String user = "root";
    private final String password = "root";

    /**
     * Connect to the PostgreSQL database
     *
     * @return a Connection object
     */
    public Connection connexion() throws SQLException 
    {
        return DriverManager.getConnection(url, user, password);
    }

    public boolean insert(User user) 
    {
        boolean result = true;

        String query = "INSERT INTO user(lastname, firstname, login, password) "
                + "VALUES(?, ?, ?, ?)";

        try 
        {
            Connection connect = connexion();

            PreparedStatement preparedStmt = connect.prepareStatement(query);
            preparedStmt.setString(1, user.getLastname());
            preparedStmt.setString(2, user.getFirstname());
            preparedStmt.setString(3, user.getLogin());
            preparedStmt.setString(4, user.getPassword());

            result = preparedStmt.execute();
            
            connect.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return result;
    }

    public ResultSet select() 
    {
        ResultSet result = null;

        String query = "SELECT * FROM user";

        try
        {

            Connection connect = connexion();

            Statement statement = connect.createStatement();
            
            result = statement.executeQuery(query);
            

            // statement.close();

        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
        }    

        return result;
        
    }

    public boolean delete(int id) 
    {
        boolean response = true;
        String query = "delete from user where id = ?";

        try
        {
            Connection connect = connexion();

            PreparedStatement preparedStmt = connect.prepareStatement(query);
            preparedStmt.setInt(1, id);

            response = preparedStmt.execute();
            
            connect.close();
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
        }

        return response;
    }

    public int update(int id, String attribute, String value) 
    {
        int response = 0;
        // String query = "delete from user where id = ?";
        String query = "update user set login = ? where id = ?";

        try
        {
            Connection connect = connexion();

             // create the java mysql update preparedstatement
            PreparedStatement preparedStmt = connect.prepareStatement(query);
            
            // preparedStmt.setString(1, attribute);
            preparedStmt.setString(1, value);
            preparedStmt.setInt(2, id);

            response = preparedStmt.executeUpdate();
            
            connect.close();
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
        }

        return response;
    }
}