import java.sql.SQLException;

import User.Controller.UserController;
import User.Model.UserModel;

/**
 * Main
 */
public class Main 
{
    public static void main(String args[]) {

        // UserController userController = new UserController();

        
        UserController userController = new UserController();
        // userController.insert();

        // try {
        //     userController.select();
        // } catch (SQLException e) {
        //     // TODO Auto-generated catch block
        //     e.printStackTrace();
        // }

        try {
            userController.menu();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}