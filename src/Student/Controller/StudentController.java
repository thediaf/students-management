package Student.Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import Student.Entity.Student;
import Student.Model.StudentModel;
import Student.View.StudentView;

public class StudentController 
{
    private Scanner scanner; 
    private StudentModel studentModel;
    private StudentView studentView;

    public StudentController()
    {
        this.scanner = new Scanner(System.in);
        this.studentModel = new StudentModel();
        this.studentView = new StudentView();
    }
    public void menu() throws SQLException
    {
        int choice;
        
        do {
            studentView.menu();
            System.out.print("Choisissez une option: ");
            choice = this.scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("\n ############   Affichage de la liste   ###########\n ");
                    this.select();
                    break;
                case 2:
                    System.out.print("\n ############   Ajouter un etudiant   ###########\n ");
                    this.insert();
                    break;
                case 3:
                    System.out.print("\n ############   Modifier un etudiant   ###########\n ");
                    this.update();
                    break;
                case 4:
                    System.out.print("\n ############   Supprimer un etudiant   ###########\n ");
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
        System.out.print("Donnez le nom: ");
        String code = this.scanner.next();
        System.out.print("Donnez le prenom: ");
        String classroom = this.scanner.next();

        Student student = new Student(lastname, firstname, code, classroom);


        boolean result =  studentModel.insert(student);

        studentView.insert(result);
    }
    
    public void select() throws SQLException 
    {
        ResultSet result =  studentModel.select();

        studentView.displayStudents(result);
    }

    public void update()  
    {

        System.out.print("Donnez l'id de l'etudiant: ");
        int id = this.scanner.nextInt();
        System.out.print("Donnez l'attribut: ");
        String attribute = this.scanner.next();
        System.out.print("Donnez la valeur: ");
        String value = this.scanner.next();
        String query = ""; 
        switch (attribute) {
            case "nom":
                query = "update student set lastname = ? where id = ?";
                break;
            case "prenom":
                query = "update student set firstname = ? where id = ?";
                break;
            case "code":
                query = "update student set code = ? where id = ?";
                break;
            case "classe":
                query = "update student set classroom = ? where id = ?";
                break;
            default:
                break;
        }
        int response = studentModel.update(id, value, query);

        studentView.update(response);
    }

    public void delete()  
    {

        System.out.print("Donnez l'id de l'etudiant: ");
        int id = this.scanner.nextInt();

        boolean response = studentModel.delete(id);

        studentView.delete(response);
    }
}
