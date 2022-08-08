import java.sql.SQLException;

import Student.Controller.StudentController;

/**
 * Main
 */
public class Main 
{
    public static void main(String args[]) {
        
        StudentController studentController = new StudentController();
        
        try {
            studentController.menu();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}