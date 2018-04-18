package controllers;

import models.Book;
import play.mvc.Controller;
import play.mvc.Result;
import java.util.Set;
import views.html.books.index;


public class BooksController extends Controller {

    // showing all books to user
    public Result index(){

        Set<Book> books = Book.allBooks();
        return ok(index.render(books));
    }

    // to create book
    public Result create(){
        return TODO;
    }

    // save book
    public Result save(){
        return TODO;
    }

    // edit book
    public Result edit(int id){
        return TODO;
    }

    public Result update(){
        return TODO;
    }

    public Result destroy(int id){
        return TODO;
    }

    // for book details
    public Result show(int id){
        return TODO;
    }

}
