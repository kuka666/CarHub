package Airport;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class Main { // the class that launches the application

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Scanner scan = new Scanner(System.in);
        String URL = "jdbc:postgresql://localhost:5432/Airport";   //connect to database
        String username = "postgres";
        String pass = "dbhec123";
        Methods proj=new Methods();  // creating methods to use them
        System.out.println("Welcome to the airline\n");  // application greeting output

        proj.View();  // View method call

        proj.Inform();  // Inform method call

        System.out.println("1 - Sign In\n" +
                "2 - Registration ");
        int s=scan.nextInt();
        if(s==1){    // choice between logging into an existing account or creating a new one
            proj.Login();  // Login method call
        }
        else{
            proj.addUser();  // addUser method call
        }
        proj.card();
        System.out.println("You buy a ticket!!!Congrats!!!We send it for your email");  // total ticket purchase



    }
}