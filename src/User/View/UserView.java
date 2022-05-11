package User.View;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import User.Controller.UserController;
import User.Entity.User;

public class UserView 
{
    public void insert(boolean result) 
    {
        
        if (result) {
            System.out.println("Utilisateur insere");
        }
        else
            System.out.println("Une erreur est subvenue");
    }    

    public void displayUsers(ResultSet result) throws SQLException
    {
        System.out.println("+ ---- + ----------------- + ----------------- + ----------------- + ----------------- + ");
        System.out.println("|  id  |        Nom        |       Prenom      |       Login       |    Mot de passe   | ");
        System.out.println("+ ---- + ----------------- + ----------------- + ----------------- + ----------------- + ");
        while (result.next())
        {
            int id = result.getInt("id");
            String firstname = result.getString("firstname");
            String lastname = result.getString("lastname");
            String login = result.getString("login");
            String password = result.getString("password");
            
            System.out.printf("|  %d  |        %s        |       %s      |       %s       |    %s   | \n", id, firstname, lastname, login, password);
        }
        System.out.println("+ ---- + ----------------- + ----------------- + ----------------- + ----------------- + ");
    }

    public void delete(boolean response) 
    {   
        if (response) {
            System.out.println("Utilisateur supprime");
        }
        else
            System.out.println("Une erreur est subvenue");
    } 
    
    public void update(int response) 
    {
        
        if (response != 0) {
            System.out.println("Utilisateur modifie");
        }
        else
            System.out.println("Une erreur est subvenue");
    }
}
