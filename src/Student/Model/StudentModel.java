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

    public boolean insert(Student student) throws SQLException 
    {
        String query = "INSERT INTO student(lastname, firstname, code, classroom) "
                + "VALUES(?, ?, ?, ?)";

        PreparedStatement preparedStmt = connect.prepareStatement(query);
        preparedStmt.setString(1, student.getLastname());
        preparedStmt.setString(2, student.getFirstname());
        preparedStmt.setString(3, student.getCode());
        preparedStmt.setString(4, student.getClassroom());

        return preparedStmt.execute();
    }

    public ResultSet select() throws SQLException 
    {
        String query = "SELECT * FROM student";

        Statement statement = connect.createStatement();
        
        return statement.executeQuery(query);
        
    }

    public boolean delete(int id) throws SQLException 
    {
        String query = "delete from student where id = ?";

        PreparedStatement preparedStmt = connect.prepareStatement(query);
        preparedStmt.setInt(1, id);

        return preparedStmt.execute();
    }

    public int update(int id, String value, String query) throws SQLException 
    {
        // String query = "update student set classroom = ? where id = ?";

        PreparedStatement preparedStmt = connect.prepareStatement(query);
        preparedStmt.setString(1, value);
        preparedStmt.setInt(2, id);
        
        return preparedStmt.executeUpdate();
    }
}