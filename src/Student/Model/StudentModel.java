package Student.Model;

import java.sql.*;

import Student.Entity.Student;

/**
 * StudentModel
 */
public class StudentModel 
{
    private final String url = "jdbc:mysql://localhost:3306/java_exercice";
    private final String user = "root";
    private final String password = "root";

    Connection connect; 
    public StudentModel()
    {
        try {
            connect = this.connexion();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public Connection connexion() throws SQLException 
    {
        return DriverManager.getConnection(url, user, password);
    }

    public boolean insert(Student student) 
    {
        boolean result = true;

        String query = "INSERT INTO student(lastname, firstname, code, classroom) "
                + "VALUES(?, ?, ?, ?)";

        try 
        {

            PreparedStatement preparedStmt = connect.prepareStatement(query);
            preparedStmt.setString(1, student.getLastname());
            preparedStmt.setString(2, student.getFirstname());
            preparedStmt.setString(3, student.getCode());
            preparedStmt.setString(4, student.getClassroom());

            result = preparedStmt.execute();
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return result;
    }

    public ResultSet select() 
    {
        ResultSet result = null;

        String query = "SELECT * FROM student";

        try
        {

            Statement statement = connect.createStatement();
            
            result = statement.executeQuery(query);

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
        String query = "delete from student where id = ?";

        try
        {

            PreparedStatement preparedStmt = connect.prepareStatement(query);
            preparedStmt.setInt(1, id);

            response = preparedStmt.execute();
            
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
        }

        return response;
    }

    public int update(int id, String value, String query) 
    {
        int response = 0;
        // String query = "update student set classroom = ? where id = ?";

        try
        {
            PreparedStatement preparedStmt = connect.prepareStatement(query);
            
            preparedStmt.setString(1, value);
            preparedStmt.setInt(2, id);

            response = preparedStmt.executeUpdate();
            
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
        }

        return response;
    }
}