package ass1;

import java.util.Scanner;

public class Book {
    String bookname;
    String book_author;
    int price_book;
    int book_page;
    Scanner scan = new Scanner(System.in);

    public Book(String bookname,String book_author,int price_book,int book_page){
        this.bookname=bookname;
        this.book_author=book_author;
        this.price_book=price_book;
        this.book_page=book_page;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getBook_author() {
        return book_author;
    }

    public void setBook_author(String book_author) {
        this.book_author = book_author;
    }

    public int getPrice_book() {
        return price_book;
    }

    public void setPrice_book(int price_book) {
        this.price_book = price_book;
    }

    public int getBook_page() {
        return book_page;
    }

    public void setBook_page(int book_page) {
        this.book_page = book_page;
    }

}