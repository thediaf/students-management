import java.sql.SQLException;

import User.Controller.UserController;

/**
 * Main
 */
public class Main 
{
    public static void main(String args[]) {
        
        UserController userController = new UserController();
        
        try {
            userController.menu();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}