package controllers;

import models.Book;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;
import java.util.Set;

import views.html.books.create;
import views.html.books.index;
import javax.inject.Inject;


public class BooksController extends Controller {

    @Inject
    FormFactory formFactory;


    // showing all books to user
    public Result index(){

        Set<Book> books = Book.allBooks();
        return ok(index.render(books));
    }

    // to create book
    public Result create(){
        Form<Book> bookForm = formFactory.form(Book.class);
        return ok(create.render(bookForm));
    }

    // edit book
    public Result edit(int id){
        Book book = Book.findById(id);
        Form<Book> bookForm = formFactory.form(Book.class);


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

    // save book
    public Result save(){
        Form<Book> bookForm = formFactory.form(Book.class).bindFromRequest();
        Book book = bookForm.get();
        System.out.println(book.getAuthor() + book.getId() + book.getTitle() + book.getPrice());
        Book.add(book);
        return redirect(routes.BooksController.index());
    }

}
