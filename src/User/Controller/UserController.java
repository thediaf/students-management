package User.Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import User.Entity.User;
import User.Model.UserModel;
import User.View.UserView;

public class UserController 
{
    private Scanner scanner; 
    private UserModel userModel;
    private UserView userView;

    public UserController()
    {
        this.scanner = new Scanner(System.in);
        this.userModel = new UserModel();
        this.userView = new UserView();
    }
    public void menu() throws SQLException
    {
        int choice;
        
        do {
            userView.menu();
            System.out.print("Choisissez une option: ");
            choice = this.scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("\n ############   Affichage de la liste   ###########\n ");
                    this.select();
                    break;
                case 2:
                    System.out.print("\n ############   Ajouter un utilisateur   ###########\n ");
                    this.insert();
                    break;
                case 3:
                    System.out.print("\n ############   Modifier un utilisateur   ###########\n ");
                    this.update();
                    break;
                case 4:
                    System.out.print("\n ############   Supprimer un utilisateur   ###########\n ");
                    this.delete();
                    break;
                case 5:
                    System.out.print("\n ############   Au revoir (-_>)   ###########\n ");
                    System.exit(0);
                    break;
                default:
                    System.out.print("\n ############   Au revoir (-_>)   ###########\n ");
                    break;
            }
        } while (choice != 5);
    }

    public void insert() 
    {

        System.out.print("Donnez le nom: ");
        String lastname = this.scanner.next();
        System.out.print("Donnez le prenom: ");
        String firstname = this.scanner.next();
        System.out.print("Donnez le login: ");
        String login = this.scanner.next();
        System.out.print("Donnez le mot de passe: ");
        String password = this.scanner.next(); 

        User user = new User(lastname, firstname, login, password);


        boolean result =  userModel.insert(user);

        userView.insert(result);
    }
    
    public void select() throws SQLException 
    {
        ResultSet result =  userModel.select();

        userView.displayUsers(result);
    }

    public void update()  
    {

        System.out.print("Donnez l'id de l'utilisateur: ");
        int id = this.scanner.nextInt();
        System.out.print("Donnez l'attribut: ");
        String attribute = this.scanner.next();
        System.out.print("Donnez la valeur: ");
        String value = this.scanner.next();
        String query = ""; 
        switch (attribute) {
            case "nom":
                query = "update user set lastname = ? where id = ?";
                break;
            case "prenom":
                query = "update user set firstname = ? where id = ?";
                break;
            case "login":
                query = "update user set login = ? where id = ?";
                break;
            case "password":
                query = "update user set lastname = ? where id = ?";
                break;
            default:
                break;
        }
        int response = userModel.update(id, value, query);

        userView.update(response);
    }

    public void delete()  
    {

        System.out.print("Donnez l'id de l'utilisateur: ");
        int id = this.scanner.nextInt();

        boolean response = userModel.delete(id);

        userView.delete(response);
    }
}
