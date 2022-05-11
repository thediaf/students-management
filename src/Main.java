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

        // userController.insert();

        UserController userController = new UserController();

        try {
            userController.select();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        userController.delete();
    }
}