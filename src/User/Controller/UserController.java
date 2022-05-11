package User.Controller;

import java.util.Scanner;

import User.Entity.User;
import User.Model.UserModel;
import User.View.UserView;

public class UserController 
{
    public void insert() 
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Donnez le nom: ");
        String lastname = scanner.next();
        System.out.print("Donnez le prenom: ");
        String firstname = scanner.next();
        System.out.print("Donnez le login: ");
        String login = scanner.next();
        System.out.print("Donnez le mot de passe: ");
        String password = scanner.next(); 

        User user = new User(lastname, firstname, login, password);


        UserModel userModel = new UserModel();
        boolean result =  userModel.insert(user);

        UserView userView = new UserView();
        userView.insert(result);
    }   
}
