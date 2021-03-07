package ass1;

import ass1.Book;
import ass1.Library;

import java.util.Locale;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {


    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Scanner scan = new Scanner(System.in).useLocale(Locale.US);
        String jdbcURL = "jdbc:postgresql://localhost:5432/library";
        String dbUsername = "postgres";
        String dbpassword = "dbhec123";
        System.out.println("1)AZBUKA ASTANA\n" +
                "2)Abay library\n" +
                "3)Exit\n");
        int num = scan.nextInt();

        switch (num) {
            //for AZBUKA ASTANA
            case 1: {
                System.out.println("1)See the all book\n" +
                        "2)see information about book\n" +
                        "3)borrow book\n" +
                        "4)return book\n" +
                        "5)see the address\n");
                int choose = scan.nextInt();
                switch (choose) {
                    //See all book
                    case 1:
                        try {
                            Connection connection = DriverManager.getConnection(jdbcURL, dbUsername, dbpassword);
                            String sql = "SELECT * FROM book";

                            Statement statement = connection.createStatement();
                            ResultSet result = statement.executeQuery(sql);

                            int count = 0;

                            while (result.next()) {
                                String bookname = result.getString("bookname");
                                String book_author = result.getString("book_author");
                                int price_book = result.getInt("price_book");
                                int book_page = result.getInt("book_page");
                                Book book=new Book(bookname,book_author,price_book,book_page);

                                System.out.println("book name:" + book.getBookname());
                            }
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                        break;
                        // SEE INFORMATIONS ABOUT BOOK
                    case 2:
                        try {
                            Connection connection = DriverManager.getConnection(jdbcURL, dbUsername, dbpassword);
                            String bookname = scan.nextLine();
                            String sql = "SELECT * FROM book where bookname=?";
                            System.out.println("Write the book name:");
                            PreparedStatement stat = connection.prepareStatement(sql);
                            stat.setString(1, scan.nextLine());
                            ResultSet result = stat.executeQuery();



                            while (result.next()) {
                                String book_author = result.getString("book_author");
                                int price_book = result.getInt("price_book");
                                int book_page = result.getInt("book_page");
                                Book book=new Book(bookname,book_author,price_book,book_page);

                                System.out.println("bookname:" + book.getBookname() + " book_author:" + book.getBook_author() + " price:" + book.getPrice_book() + "$" + " page:" + book.getBook_page());
                            }

                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                        break;
                        //RENT THE BOOK
                    case 3:
                        try {
                            Connection connection = DriverManager.getConnection(jdbcURL, dbUsername, dbpassword);
                            String kuka = "DELETE FROM book WHERE book_id=?;";
                            String Kuanysh = "SELECT * FROM book ";
                            Statement statement = connection.createStatement();
                            ResultSet result = statement.executeQuery(Kuanysh);
                            while (result.next()){
                                System.out.println("ID: "+result.getInt("book_id")+
                                        "-"+result.getString("bookname"));
                            }
                            PreparedStatement statementt = connection.prepareStatement(kuka);
                            System.out.println("Write ID of book");
                            int book_id = scan.nextInt();
                            String qwerty = "select * from book where book_id =" + book_id;
                            PreparedStatement statement4 = connection.prepareStatement(qwerty);
                            ResultSet result4 = statement.executeQuery(qwerty);
                            while (result4.next()){
                                String qwer = "INSERT INTO rent (book_id,bookname, book_author, price_book, book_page) " +
                                        "VALUES (?,?, ?, ?, ?)";
                                PreparedStatement stat = connection.prepareStatement(qwer);
                                int bookid = result4.getInt("book_id");
                                String bookname = result4.getString("bookname");
                                String book_author = result4.getString("book_author");
                                int price_book= result4.getInt("price_book");
                                int book_page = result4.getInt("book_page");

                                stat.setInt(1, bookid);
                                stat.setString(2, bookname);
                                stat.setString(3, book_author);
                                stat.setInt(4, price_book);
                                stat.setInt(5, book_page);
                                int rowsInserted = stat.executeUpdate();
                                if (rowsInserted > 0) {
                                    System.out.println("You rented!!!");
                                }
                            }

                            statementt.setInt(1,book_id );

                            int rowsInserted = statementt.executeUpdate();
                            if (rowsInserted > 0) {
                                System.out.println("IT WORKS");
                            }

                            connection.close();
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }


                        break;
                    case 4:
                        try {

                            Connection connection = DriverManager.getConnection(jdbcURL, dbUsername, dbpassword);
                            String kuka = "DELETE FROM rent WHERE book_id=?;";
                            String Kuanysh = "SELECT * FROM rent ";
                            Statement statement = connection.createStatement();
                            ResultSet result = statement.executeQuery(Kuanysh);


                            while (result.next()){
                                System.out.println("ID: "+result.getInt("book_id")+
                                        "-"+result.getString("bookname"));
                            }


                            PreparedStatement statementt = connection.prepareStatement(kuka);
                            System.out.println("Write ID of book");
                            int book_id = scan.nextInt();



                            String sql4 = "select * from rent where book_id =" + book_id;
                            PreparedStatement statement4 = connection.prepareStatement(sql4);

                            ResultSet result4 = statement.executeQuery(sql4);

                            while (result4.next()){


                                String sql3 = "INSERT INTO book (book_id,bookname, book_author, price_book, book_page) " +
                                        "VALUES (?,?, ?, ?, ?)";
                                PreparedStatement stat = connection.prepareStatement(sql3);
                                int bookid = result4.getInt("book_id");
                                String bookname = result4.getString("bookname");
                                String book_author = result4.getString("book_author");
                                int price_book= result4.getInt("price_book");
                                int book_page = result4.getInt("book_page");


                                stat.setInt(1, bookid);
                                stat.setString(2, bookname);
                                stat.setString(3, book_author);
                                stat.setInt(4, price_book);
                                stat.setInt(5, book_page);
                                int rowsInserted = stat.executeUpdate();
                                if (rowsInserted > 0) {
                                    System.out.println("You return the book!!!");
                                }
                            }



                            statementt.setInt(1,book_id );

                            int rowsInserted = statementt.executeUpdate();
                            if (rowsInserted > 0) {
                                System.out.println("IT WORKS");
                            }

                            connection.close();
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }


                        break;
                    case 5:
                        try {
                            Connection connection = DriverManager.getConnection(jdbcURL, dbUsername, dbpassword);
                            String sql = "SELECT * FROM library";

                            Statement statement = connection.createStatement();
                            ResultSet result = statement.executeQuery(sql);

                            while (result.next()) {
                                String library_name = result.getString("library_name");
                                String library_address = result.getString("library_address");
                                Library library=new Library(library_name,library_address);
                                System.out.println("library_name:" + library.getLibrary_name()+" library_address:"+library.getLibrary_address()+" Works from 09:00 to 17:00");
                            }
                        }
                        catch (SQLException ex) {
                            ex.printStackTrace();

                        }
                }

            break;
            }
            case 2: {
                System.out.println("1)See the all book\n" +
                        "2)see information about book\n" +
                        "3)borrow book\n" +
                        "4)return book\n" +
                        "5)see the address\n");
                int choose = scan.nextInt();
                switch (choose) {
                    case 1:
                        try {
                            Connection connection = DriverManager.getConnection(jdbcURL, dbUsername, dbpassword);
                            String sql = "SELECT * FROM book1";

                            Statement statement = connection.createStatement();
                            ResultSet result = statement.executeQuery(sql);

                            int count = 0;

                            while (result.next()) {
                                String bookname = result.getString("bookname");
                                String book_author = result.getString("book_author");
                                int price_book = result.getInt("price_book");
                                int book_page = result.getInt("book_page");
                                Book book=new Book(bookname,book_author,price_book,book_page);

                                System.out.println("book name:" + book.getBookname());
                            }
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                        break;
                    case 2:
                        try {
                            Connection connection = DriverManager.getConnection(jdbcURL, dbUsername, dbpassword);
                            String bookname = scan.nextLine();
                            String sql = "SELECT * FROM book1 where bookname=?";
                            System.out.println("Write the book name:");
                            PreparedStatement stat = connection.prepareStatement(sql);
                            stat.setString(1, scan.nextLine());
                            ResultSet result = stat.executeQuery();


                            while (result.next()) {
                                String book_author = result.getString("book_author");
                                int price_book = result.getInt("price_book");
                                int book_page = result.getInt("book_page");
                                Book book=new Book(bookname,book_author,price_book,book_page);
                                System.out.println("bookname:" + bookname + " book_author:" + book_author + " price:" + price_book + "$" + " page:" + book_page);
                            }

                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                        break;


                    case 3:
                        try {

                            Connection connection = DriverManager.getConnection(jdbcURL, dbUsername, dbpassword);
                            String kuka = "DELETE FROM book1 WHERE book_id=?;";
                            String Kuanysh = "SELECT * FROM book1 ";

                            Statement statement = connection.createStatement();
                            ResultSet result = statement.executeQuery(Kuanysh);

                            while (result.next()){
                                System.out.println("ID: "+result.getInt("book_id")+
                                        "-"+result.getString("bookname"));
                            }


                            PreparedStatement statementt = connection.prepareStatement(kuka);
                            System.out.println("Write ID of book");
                            int book_id = scan.nextInt();




                            String sql4 = "select * from book1 where book_id =" + book_id;
                            PreparedStatement statement4 = connection.prepareStatement(sql4);

                            ResultSet result4 = statement.executeQuery(sql4);

                            while (result4.next()){


                                String qwer = "INSERT INTO rent2 (book_id,bookname, book_author, price_book, book_page,quontity) " +
                                        "VALUES (?,?, ?, ?, ?,?)";
                                PreparedStatement stat = connection.prepareStatement(qwer);
                                int bookid = result4.getInt("book_id");
                                String bookname = result4.getString("bookname");
                                String book_author = result4.getString("book_author");
                                int price_book= result4.getInt("price_book");
                                int book_page = result4.getInt("book_page");
                                int quontity = result4.getInt("quontity");

                                stat.setInt(1, bookid);
                                stat.setString(2, bookname);
                                stat.setString(3, book_author);
                                stat.setInt(4, price_book);
                                stat.setInt(5, book_page);
                                stat.setInt(6, quontity-1);
                                int rowsInserted = stat.executeUpdate();
                                if (rowsInserted > 0) {
                                    System.out.println("You rented!!!");
                                }
                            }



                            statementt.setInt(1,book_id );

                            int rowsInserted = statementt.executeUpdate();
                            if (rowsInserted > 0) {
                                System.out.println("IT WORKS");
                            }

                            connection.close();
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                        break;

                    case 4:
                        try {

                            Connection connection = DriverManager.getConnection(jdbcURL, dbUsername, dbpassword);
                            String kuka = "DELETE FROM rent2 WHERE book_id=?;";
                            String Kuanysh = "SELECT * FROM rent2 ";
                            Statement statement = connection.createStatement();
                            ResultSet result = statement.executeQuery(Kuanysh);


                            while (result.next()){
                                System.out.println("ID: "+result.getInt("book_id")+
                                        "-"+result.getString("bookname"));
                            }


                            PreparedStatement statementt = connection.prepareStatement(kuka);
                            System.out.println("Write ID of book");
                            int book_id = scan.nextInt();



                            String sql4 = "select * from rent2 where book_id =" + book_id;
                            PreparedStatement statement4 = connection.prepareStatement(sql4);

                            ResultSet result4 = statement.executeQuery(sql4);

                            while (result4.next()){


                                String sql3 = "INSERT INTO book1 (book_id,bookname, book_author, price_book, book_page,quontity) " +
                                        "VALUES (?,?, ?, ?, ?,?)";
                                PreparedStatement stat = connection.prepareStatement(sql3);
                                int bookid = result4.getInt("book_id");
                                String bookname = result4.getString("bookname");
                                String book_author = result4.getString("book_author");
                                int price_book= result4.getInt("price_book");
                                int book_page = result4.getInt("book_page");
                                int quontity = result4.getInt("quontity");

                                stat.setInt(1, bookid);
                                stat.setString(2, bookname);
                                stat.setString(3, book_author);
                                stat.setInt(4, price_book);
                                stat.setInt(5, book_page);
                                stat.setInt(6, quontity+1);
                                int rowsInserted = stat.executeUpdate();
                                if (rowsInserted > 0) {
                                    System.out.println("You return the book!!!");
                                }
                            }



                            statementt.setInt(1,book_id );

                            int rowsInserted = statementt.executeUpdate();
                            if (rowsInserted > 0) {
                                System.out.println("IT WORKS");
                            }

                            connection.close();
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }


                        break;
                    case 5:
                        try {
                            Connection connection = DriverManager.getConnection(jdbcURL, dbUsername, dbpassword);
                            String sql = "SELECT * FROM library";

                            Statement statement = connection.createStatement();
                            ResultSet result = statement.executeQuery(sql);

                            while (result.next()) {
                                String library_name = result.getString("library_name");
                                String library_address = result.getString("library_address");
                                Library library=new Library(library_name,library_address);
                                System.out.println("library_name:" + library.getLibrary_name()+" library_address:"+library.getLibrary_address()+" Works from 09:00 to 17:00");
                            }
                        }
                        catch (SQLException ex) {
                            ex.printStackTrace();

                        }
                }
             break;
            }
            case 3:
                System.out.println("...GOOD BYE...");
                System.exit(1);
        }
        }
    }

