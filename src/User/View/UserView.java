package User.View;

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
}
