package AirportManagement;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;


import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
public class Methods {  //this class contains all the methods that are used in the project
    String URL = "jdbc:postgresql://localhost:5432/Airport";  //connect to database
    String username = "postgres";
    String pass = "dbhec123";
    Scanner scan = new Scanner(System.in);


    public void addUser() throws SQLException {  // method that add new users into database
        try {
            Scanner scam = new Scanner(System.in);
            Connection connection = DriverManager.getConnection(URL, username, pass);
            String sql = "insert into users (userName, email, password) " +  // inserting in sql
                    "VALUES (?, ?, ?)";

            PreparedStatement statement = connection.prepareStatement(sql);
            System.out.println("Write your username:");
            statement.setString(1, scam.nextLine()); // adding username in 1 column
            System.out.println("Write your email:");
            statement.setString(2, scam.nextLine()); // adding email in 2 column
            System.out.println("Password must to contain at least 1 uppercase letter, 1 lowercase letter, 1 digit, 1 special symbol(@,$,!,^) and length more or equal to 8.");
            System.out.println("Write your password:");
            String pq = scam.nextLine();
            statement.setString(3, pq);  // adding password in 3 column
            Checker check = new Checker();
            if (check.checkerPassoword(pq)) {   // check password with checker
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {  // checking data additions to the database
                    System.out.println("You have successfully registered !!!");
                }
            } else {
                System.exit(1);
            }

            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    public void quantity(String start,String  end,String date,String flighthour) throws SQLException {  //a method that reduces the number of tickets from the box office when they are purchased
        try {

            Connection connection = DriverManager.getConnection(URL, username, pass);
            String sql = "update flight set placequantity=placequantity-1 where startportname=? and finishportname=? and flightdate=? and flightdatehour=?";  // reducing the number of seats with sql

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, start);
            statement.setString(2, end);
            statement.setString(3, date);
            statement.setString(4, flighthour);


            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {       // checking data additions to the database
                System.out.println(" ");
            }

            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

























    //to login
    public void Login() throws SQLException {  //a method that checks the existence of a given user in the database
        try {
            Scanner scam = new Scanner(System.in);
            Connection connection = DriverManager.getConnection(URL, username, pass);
            PreparedStatement st = (PreparedStatement) connection
                    .prepareStatement("Select username, password from users where username=? and password=?"); //verification is done using a select in sql
            System.out.println("Write your login:");
            String log = scam.nextLine();
            System.out.println("Enter your password");
            String passw = scam.nextLine();
            User user = new User('1', log, "kduas@mail", passw);
            st.setString(1, user.getUserName());
            st.setString(2, user.getPassword());
            ResultSet rs = st.executeQuery();
            if (rs.next()) {           // if the data match, then the application works on
                System.out.println("You have successfully logged in");
            } else {
                System.out.println("Wrong Username & Password");
                System.exit(1);
            }
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    //email

    public void mail (String start, String end, String date,int cost, String email) {
        final String user = "godrengodmou@gmail.com";
        final String password = "dbhec789";
        Scanner scam = new Scanner(System.in);

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(user, password);
                    }
                });

        try {
            Message sobsh = new MimeMessage(session);
            sobsh.setFrom(new InternetAddress("godrengodmou@gmail.com"));
            sobsh.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(email)
            );
            sobsh.setSubject("Ticket");
            sobsh.setText("You buyed a ticket" +
                    " Your start point" + start +
                    "Your end point" + end +
                    "Date:" + date);

            Transport.send(sobsh);


        } catch (MessagingException e) {
            e.printStackTrace();

        }
    }



    public void pay(int cost, String date) throws SQLException {  // method that is called if the flight is only one way and calculates the total price

        System.out.println("Choose which one");
        Scanner scam = new Scanner(System.in);
        int q = scam.nextInt();
        if (q == 1) {         // there is a choice between flights
            System.out.println("1)business class\n" +
                    "2)econom class");
            int w = scam.nextInt();
            if (w == 1) {
                cost = cost + 60000;   //adding a price when choosing a business class
            } else {
                cost = cost;  // when choosing an economy class, the price is not changed
            }
            System.out.println("Do you have a disscount?\n" +
                    "1)Yes\n" +
                    "2)No");
            int e = scam.nextInt();
            if (e == 1) {
                cost = cost - 15000;  // availability of a discount reduces the price
            } else {
                cost = cost;  // if there is no discount, the price is not changed
            }
            System.out.println("How much does your luggage weigh?\n" +
                    "1)More than 20kg\n" +
                    "2)Less than 20kg");
            int r = scam.nextInt();
            if (r == 1) {
                cost = cost + 5000;  // with luggage more than 20 kg, the price increases
            } else {
                cost = cost; // with luggage below 20 kg, the price is not changed
            }
            if (date.charAt(0) == 48 && date.charAt(1) > 48 && date.charAt(1) < 58) {     // the closer the flight date is to the day of ticket purchase, the more expensive the ticket
                cost = cost + 40000;
            } else if (date.charAt(0) == 49 &&  date.charAt(1) > 48&& date.charAt(1) < 58) {
                cost = cost + 30000;
            } else if (date.charAt(0) == 50 &&  date.charAt(1) > 48&& date.charAt(1) <= 53) {
                cost = cost + 20000;
            } else {
                cost = cost + 10000;
            }

        } else if (q == 2) {    // there is a choice between flights
            System.out.println("1)business class\n" +
                    "2)econom class");
            int w = scam.nextInt();
            if (w == 1) {
                cost = cost + 60000;   //adding a price when choosing a business class
            } else {
                cost = cost;    // when choosing an economy class, the price is not changed
            }
            System.out.println("Do you have a disscount?\n" +
                    "1)Yes\n" +
                    "2)No");
            int e = scam.nextInt();
            if (e == 1) {
                cost = cost - 15000;   // availability of a discount reduces the price
            } else {
                cost = cost;    // if there is no discount, the price is not changed
            }
            System.out.println("How much does your luggage weigh?\n" +
                    "1)More than 20kg\n" +
                    "2)Less than 20kg");
            int r = scam.nextInt();
            if (r == 1) {
                cost = cost + 5000;   // with luggage more than 20 kg, the price increases
            } else {
                cost = cost;    // with luggage below 20 kg, the price is not changed
            }
            if (date.charAt(0) == 48 && date.charAt(1) > 48 && date.charAt(1) < 58) {    // the closer the flight date is to the day of ticket purchase, the more expensive the ticket
                cost = cost + 40000;
            } else if (date.charAt(0) == 49 &&  date.charAt(1) > 48&& date.charAt(1) < 58) {
                cost = cost + 30000;
            } else if (date.charAt(0) == 50 &&  date.charAt(1) > 48&& date.charAt(1) <= 53) {
                cost = cost + 20000;
            } else {
                cost = cost + 10000;
            }
        }
        System.out.println("Your price equal to: " + cost);    // calculation of the entire amount that the user must pay

    }
    public int allpay1(int cost, String date, String cal,String start,String end,int k) throws SQLException {   // the method that is called if 2 flights are needed calculates the price of the 1st flight
        System.out.println("Select Additional for" + start+" to "+ end );
        if (k == 1) {      // there is a choice between flights
            System.out.println("1)business class\n" +
                    "2)econom class");
            int w = scan.nextInt();
            if (w == 1) {
                cost = cost + 60000;   //adding a price when choosing a business class
            } else {
                cost = cost;    // when choosing an economy class, the price is not changed
            }
            System.out.println("Do you have a disscount?\n" +
                    "1)Yes\n" +
                    "2)No");
            int e = scan.nextInt();
            if (e == 1) {
                cost = cost - 15000;   // availability of a discount reduces the price
            } else {
                cost = cost;    // if there is no discount, the price is not changed
            }
            System.out.println("How much does your luggage weigh?\n" +
                    "1)More than 20kg\n" +
                    "2)Less than 20kg");
            int r = scan.nextInt();
            if (r == 1) {
                cost = cost + 5000;   // with luggage more than 20 kg, the price increases
            } else {
                cost = cost;    // with luggage below 20 kg, the price is not changed
            }
            if (date.charAt(0) == 48 && date.charAt(1) > 48 && date.charAt(1) < 58) {    // the closer the flight date is to the day of ticket purchase, the more expensive the ticket
                cost = cost + 40000;
            } else if (date.charAt(0) == 49 &&  date.charAt(1) > 48&& date.charAt(1) < 58) {
                cost = cost + 30000;
            } else if (date.charAt(0) == 50 &&  date.charAt(1) > 48&& date.charAt(1) <= 53) {
                cost = cost + 20000;
            } else {
                cost = cost + 10000;
            }

        }
        else if(k==2){     // there is a choice between flights
            System.out.println("1)business class\n" +
                    "2)econom class");
            int w = scan.nextInt();
            if (w == 1) {
                cost = cost + 60000;   //adding a price when choosing a business class
            } else {
                cost = cost;   // when choosing an economy class, the price is not changed
            }
            System.out.println("Do you have a disscount?\n" +
                    "1)Yes\n" +
                    "2)No");
            int e = scan.nextInt();
            if (e == 1) {
                cost = cost - 15000;    // availability of a discount reduces the price
            } else {
                cost = cost;   // if there is no discount, the price is not changed
            }
            System.out.println("How much does your luggage weigh?\n" +
                    "1)More than 20kg\n" +
                    "2)Less than 20kg");
            int r = scan.nextInt();
            if (r == 1) {
                cost = cost + 5000;   // with luggage more than 20 kg, the price increases
            } else {
                cost = cost;    // with luggage below 20 kg, the price is not changed
            }
            if (date.charAt(0) == 48 && date.charAt(1) > 48 && date.charAt(1) < 58) {       // the closer the flight date is to the day of ticket purchase, the more expensive the ticket
                cost = cost + 40000;
            } else if (date.charAt(0) == 49 &&  date.charAt(1) > 48&& date.charAt(1) < 58) {
                cost = cost + 30000;
            } else if (date.charAt(0) == 50 &&  date.charAt(1) > 48&& date.charAt(1) <= 53) {
                cost = cost + 20000;
            } else {
                cost = cost + 10000;
            }
        }
        return cost;
    }
    public int allpay2(int cost1, String date, String cal,String start,String end,int k) throws SQLException {   // the method that is called if 2 flights are needed calculates the price of the 2nd flight
        System.out.println("Select Additional for" + end+" to "+ start );
        if (k == 1) {      // there is a choice between flights
            System.out.println("1)business class\n" +
                    "2)econom class");
            int w = scan.nextInt();
            if (w == 1) {
                cost1 = cost1 + 60000;      //adding a price when choosing a business class
            } else {
                cost1 = cost1;    // when choosing an economy class, the price is not changed
            }
            System.out.println("Do you have a disscount?\n" +
                    "1)Yes\n" +
                    "2)No");
            int e = scan.nextInt();
            if (e == 1) {
                cost1 = cost1 - 15000;    // availability of a discount reduces the price
            } else {
                cost1 = cost1;    // if there is no discount, the price is not changed
            }
            System.out.println("How much does your luggage weigh?\n" +
                    "1)More than 20kg\n" +
                    "2)Less than 20kg");
            int r = scan.nextInt();
            if (r == 1) {
                cost1 = cost1 + 5000;   // with luggage more than 20 kg, the price increases
            } else {
                cost1 = cost1;    // with luggage below 20 kg, the price is not changed
            }
            if (cal.charAt(0) == 48 && cal.charAt(1) > 48 && cal.charAt(1) < 58) {    // the closer the flight date is to the day of ticket purchase, the more expensive the ticket
                cost1 = cost1 + 40000;
            } else if (cal.charAt(0) == 49 &&  cal.charAt(1) > 48&& cal.charAt(1) < 58) {
                cost1 = cost1 + 30000;
            } else if (cal.charAt(0) == 50 &&  cal.charAt(1) > 48&& cal.charAt(1) <= 53) {
                cost1 = cost1 + 20000;
            } else {
                cost1 = cost1 + 10000;
            }

        }
        else if(k==2){     // there is a choice between flights
            System.out.println("1)business class\n" +
                    "2)econom class");
            int w = scan.nextInt();
            if (w == 1) {
                cost1 = cost1 + 60000;    //adding a price when choosing a business class
            } else {
                cost1 = cost1;    // when choosing an economy class, the price is not changed
            }
            System.out.println("Do you have a disscount?\n" +
                    "1)Yes\n" +
                    "2)No");
            int e = scan.nextInt();
            if (e == 1) {
                cost1 = cost1 - 15000;   // availability of a discount reduces the price
            } else {
                cost1 = cost1;   // if there is no discount, the price is not changed
            }
            System.out.println("How much does your luggage weigh?\n" +
                    "1)More than 20kg\n" +
                    "2)Less than 20kg");
            int r = scan.nextInt();
            if (r == 1) {
                cost1 = cost1 + 5000;    // with luggage more than 20 kg, the price increases
            } else {
                cost1 = cost1;   // with luggage below 20 kg, the price is not changed
            }
            if (cal.charAt(0) == 48 && cal.charAt(1) > 48 && cal.charAt(1) < 58) {     // the closer the flight date is to the day of ticket purchase, the more expensive the ticket
                cost1 = cost1 + 40000;
            } else if (cal.charAt(0) == 49 &&  cal.charAt(1) > 48&& cal.charAt(1) < 58) {
                cost1 = cost1 + 30000;
            } else if (cal.charAt(0) == 50 &&  cal.charAt(1) > 48&& cal.charAt(1) <= 53) {
                cost1 = cost1 + 20000;
            } else {
                cost1 = cost1 + 10000;
            }
        }
        return cost1;
    }


    public void View() throws SQLException {    // a method that shows suitable flights, taking into account the user's request, and gives you a choice between them
        Connection connection = DriverManager.getConnection(URL, username, pass);
        String start;
        String end;
        String date;
        PreparedStatement sql = (PreparedStatement) connection
                .prepareStatement("Select startportname, finishportname, flightdate,flightdatehour,flightcost from flight where startportname=? and finishportname=? and flightdate=?");  //search for suitable flights from the database
        PreparedStatement sql2 = (PreparedStatement) connection
                .prepareStatement("Select startportname, finishportname, flightdate,flightdatehour,flightcost from flight where startportname=? and finishportname=? and flightdate=?");  //search for suitable flights from the database
        System.out.println("Where are you flying from\n");
        start = scan.nextLine();    // entry point of departure
        System.out.println("Where do you want to fly?\n");
        end = scan.nextLine();     // destination entry
        System.out.println("When do you want to fly?\n" +
                "HINT:Write the format like(dd-MM-yyyy)");
        date = scan.nextLine();   // departure date input
        Scanner scam = new Scanner(System.in);
        try {
            System.out.println("Do you want to fly back?\n" +
                    "1)YES SIR\n" +
                    "2)NO BOY NEXT DOOR");
            int a = scan.nextInt();  // choice between single flight and with return flight
            if(a==1) {
                System.out.println("When do you want to fly back?\n" +
                        "HINT:Write the format like(dd-MM-yyyy)");
                String cal = scam.nextLine();  // return flight date input
                sql.setString(1, start);
                sql.setString(2, end);
                sql.setString(3, date);
                sql.setString(3, date);
                ResultSet result = sql.executeQuery();
                int i = 0;
                int all1;
                int all2;
                System.out.println("Flight to: "+end);  // data output of the 1st flight
                while (result.next()) {
                    i++;
                    String startportname = result.getString("startportname");
                    String finishportname = result.getString("finishportname");
                    String flightdate = result.getString("flightdate");
                    String flightdatehour = result.getString("flightdatehour");
                    int flightcost = result.getInt("flightcost");
                    Flight flight = new Flight(startportname, finishportname, flightdate);
                    flight.setFlightCost(flightcost);
                    flight.setFlighthour(flightdatehour);
                    System.out.println(i + ") " + "Start port: " + flight.getStartPortName() + " Finish port: " + flight.getFinishPortName() + " Flight date: " + flight.getFlightdate() + " Flight date hour: " + flight.getFlighthour() + " Flight cost: " + flight.getFlightCost());

                }

                System.out.println("Flight to: " + start);  // data output of the 2nd flight
                sql2.setString(1, end);
                sql2.setString(2, start);
                sql2.setString(3, cal);
                ResultSet re = sql.executeQuery();
                int b = 0;
                while (re.next()) {
                    b++;
                    String startportname = re.getString("startportname");
                    String finishportname = re.getString("finishportname");
                    String flightdate = re.getString("flightdate");
                    String flightdatehour = re.getString("flightdatehour");
                    int flightcost = re.getInt("flightcost");
                    Flight flight2 = new Flight(finishportname, startportname, cal);
                    flight2.setFlightCost(flightcost);
                    flight2.setFlighthour(flightdatehour);
                    System.out.println(b + ") " + "Start port: " + flight2.getStartPortName() + " Finish port: " + flight2.getFinishPortName() + " Flight date: " + flight2.getFlightdate() + " Flight date hour: " + flight2.getFlighthour() + " Flight cost: " + flight2.getFlightCost());
                }
                ResultSet res = sql.executeQuery();
                while (res.next()) {
                    System.out.println("Choose which one for "+start+" to "+end); // flight selection for the first flight
                    int k = scam.nextInt();
                    String startportname = res.getString("startportname");
                    String finishportname = res.getString("finishportname");
                    String flightdate = res.getString("flightdate");
                    String flightdatehour = res.getString("flightdatehour");
                    int flightcost = res.getInt("flightcost");
                    quantity(start,end,date,flightdatehour);
                    int d = allpay1(flightcost, date, cal, startportname, finishportname, k); // price for the first flight
                    System.out.println("Choose which one for "+end+" to "+start);  // selection of a flight back
                    int l = scam.nextInt();
                    int v = allpay2(flightcost, date, cal, startportname, finishportname, l);  // price for the second trip
                    int all=d+v;  // price for round trip
                    if(l==1){
                        String hour="12:00";
                        quantity(end,start,cal,hour); // decrease in the number of tickets for this flight
                    }
                    else {
                        String hour="00:00";
                        quantity(end,start,cal,hour); // decrease in the number of tickets for this flight
                    }

                    System.out.println("ALl equal: " +all); // displaying the price to the user
                    System.out.println("Write your email");
                    Scanner scaq = new Scanner(System.in);
                    String email=scaq.nextLine();

                    mail(start,end,date,flightcost,email);
                    mail(end,start,cal,flightcost,email);

                    break;
                }

            }

            else if(a==2){  // if you have chosen a one-way ticket
                sql.setString(1, start);
                sql.setString(2,end);
                sql.setString(3,date);
                ResultSet result = sql.executeQuery();
                int i=0;

                while (result.next()) {  // data output of the flight
                    i++;
                    String startportname = result.getString("startportname");
                    String finishportname = result.getString("finishportname");
                    String flightdate = result.getString("flightdate");
                    String flightdatehour = result.getString("flightdatehour");
                    int flightcost = result.getInt("flightcost");
                    Flight flight = new Flight(startportname, finishportname, flightdate);
                    flight.setFlightCost(flightcost);
                    flight.setFlighthour(flightdatehour);
                    System.out.println(i + ") " + "Start port: " + flight.getStartPortName() + " Finish port: " + flight.getFinishPortName() + " Flight date: " + flight.getFlightdate() + " Flight date hour: " + flight.getFlighthour() + " Flight cost: " + flight.getFlightCost());
                }
                ResultSet res = sql.executeQuery();
                while (res.next()) {
                    int cost = res.getInt("flightcost");
                    String date1=res.getString("flightdate");
                    String fg = res.getString("flightdatehour");
                    pay(cost,date1);      // calculation of the price for the flight
                    quantity(start,end,date,fg);  // decrease in the number of tickets for this flight
                    Scanner scaq = new Scanner(System.in);
                    System.out.println("Write your email");
                    String email=scaq.nextLine();

                    mail(start,end,date,cost,email);
                    break;
                }



            }
            else {
                System.exit(1);
            }
            connection.close();
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    public void See() throws SQLException {

    }

    public void Inform() throws SQLException {    // a method that enters passenger data into the database
        try {
            Connection connection = DriverManager.getConnection(URL, username, pass);
            String sql = "insert into passangers (PassangerName,PassangerSurname, DateOfBirth) " +
                    "VALUES (?, ?, ?)";    // data entry using sql
            Scanner scam = new Scanner(System.in);
            PreparedStatement statement = connection.prepareStatement(sql);
            System.out.println("Write your Passenger Name:");
            statement.setString(1, scam.nextLine());   // insert into 1 column
            System.out.println("Write your Passenger Surname:");
            statement.setString(2, scam.nextLine());    // insert into 2 column
            System.out.println("Write your Passenger date of birth:"+
                    "HINT:Write the format like(dd-MM-yyyy)");
            String az=scam.nextLine();
            statement.setString(3, az);    // insert into 3 column
            Checker check=new Checker();
            if(check.checkage(az)){
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {    // checking data additions to the database
                    System.out.println("NEXT");
                }
            }
            else {
                System.exit(1);
            }


            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void card() throws SQLException{   // the method that enters the card data from which the ticket will be purchased
        Scanner scam = new Scanner(System.in);
        System.out.println("Write your card number: ");
        String a=scam.nextLine();
        Checker check=new Checker();
        check.checkercardnumber(a);    // checking the validity of the entered data
        System.out.println("Write your date card : ");
        String b=scam.nextLine();
        check.checkercarddate(b);    // checking the validity of the entered data
        System.out.println("Write your date CVV : ");
        String  c=scam.nextLine();
        check.checkCVV(c);    // checking the validity of the entered data
    }

}