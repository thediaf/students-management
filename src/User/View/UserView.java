package User.View;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserView 
{
    public void menu()
    {
        System.out.println("+ --------------------------------------- + ");
        System.out.println("|                   MENU                  | ");
        System.out.println("+ --------------------------------------- + ");
        System.out.println("|       1 - Afficher toute la liste       | ");   
        System.out.println("|       2 - Ajouter un etudiant        | ");   
        System.out.println("|       3 - Modifier un etudiant       | ");   
        System.out.println("|       4 - Supprimer un etudiant      | ");   
        System.out.println("|       5 - Quitter                       | "); 
        System.out.println("+ --------------------------------------- + ");   
    }

    public void insert(boolean result) 
    {
        
        if (result) {
            System.out.println("etudiant insere");
        }
        else
            System.out.println("etudiant ajoute");
    }    

    public void displayUsers(ResultSet result) throws SQLException
    {
        System.out.println("+ ---- + ----------------- + ----------------- + ");
        System.out.println("|  id  |        Nom        |       Prenom      | ");
        System.out.println("+ ---- + ----------------- + ----------------- + ");
        while (result.next())
        {
            int id = result.getInt("id");
            String firstname = result.getString("firstname");
            String lastname = result.getString("lastname");
            
            System.out.printf("|  %d  |        %s        |       %s      | \n", id, firstname, lastname);
        }
        System.out.println("+ ---- + ----------------- + ----------------- + ");
    }

    public void delete(boolean response) 
    {   
        if (response) {
            System.out.println("etudiant supprime");
        }
        else
            System.out.println("etudiant supprime");
    } 
    
    public void update(int response) 
    {
        
        if (response != 0) {
            System.out.println("etudiant modifie");
        }
        else
            System.out.println("Une erreur est subvenue");
    }
}
