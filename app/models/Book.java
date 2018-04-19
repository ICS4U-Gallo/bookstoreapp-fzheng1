package models;

import java.util.HashSet;
import java.util.Set;

public class Book{

    private int id;
    private String title;
    private int price;
    private String author;

    public Book(){

    }

    public Book(int id, String title, int price, String author){
        this.id = id;
        this.title = title;
        this.price = price;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    private static Set<Book> books;

    static {
        books = new HashSet<>();
        books.add(new Book(1, "C++", 20, "ABC"));
        books.add(new Book(2, "Java", 30, "XYZ"));
    }

    public static Set<Book> allBooks(){
        return books;
    }

    public static Book findById(int id){
        for (Book book: books) {
            if(id == book.id){
                return book;
            }
        }
        return null;
    }

    public static void add(Book book){
        books.add(book);
    }

    public static boolean remove(Book book){
        return books.remove(book);
    }






}
