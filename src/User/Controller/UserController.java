package User.Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
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
    
    public void select() throws SQLException 
    {
        UserModel userModel = new UserModel();
        ResultSet result =  userModel.select();

        UserView userView = new UserView();
        userView.displayUsers(result);
    }

    public void update()  
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Donnez l'id de l'utilisateur: ");
        int id = scanner.nextInt();
        System.out.print("Donnez l'attribut: ");
        String attribute = scanner.next();
        System.out.print("Donnez la valeur: ");
        String value = scanner.next();

        UserModel userModel = new UserModel();
        int response = userModel.update(id, attribute, value);

        UserView userView = new UserView();
        userView.update(response);
    }

    public void delete()  
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Donnez l'id de l'utilisateur: ");
        int id = scanner.nextInt();

        UserModel userModel = new UserModel();
        boolean response = userModel.delete(id);

        UserView userView = new UserView();
        userView.delete(response);
    }
}
