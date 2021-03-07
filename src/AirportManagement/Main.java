package AirportManagement;

import com.sun.xml.bind.v2.runtime.output.SAXOutput;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Scanner scan = new Scanner(System.in);
        String URL = "jdbc:postgresql://localhost:5432/Airport";
        String username = "postgres";
        String pass = "dbhec123";
        Methods proj=new Methods();
        System.out.println("Welcome to the airline\n");

        proj.View();

        proj.Inform();

        System.out.println("1 - Sign In\n" +
                           "2 - Registration ");
        int s=scan.nextInt();
        if(s==1){
            proj.Login();
        }
        else{
            proj.addUser();
        }
        proj.card();
        System.out.println("You buy a ticket!!!Congrats!!!We send it for your email");



    }
}