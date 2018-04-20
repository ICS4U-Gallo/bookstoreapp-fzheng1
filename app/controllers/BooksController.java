package controllers;

import models.Book;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;
import java.util.Set;

import views.html.books.create;
import views.html.books.edit;
import views.html.books.index;
import views.html.books.show;

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
        if (book == null){
            return notFound("Book Not Found");
        }
        Form<Book> bookForm = formFactory.form(Book.class).fill(book);


        return ok(edit.render(bookForm));
    }

    public Result update(){
        Book book = formFactory.form(Book.class).bindFromRequest().get();
        Book oldBook = Book.findById(book.getId());
        if (oldBook == null){
            return notFound("Book not found");
        }
        oldBook.setTitle(book.getTitle());
        oldBook.setPrice(book.getPrice());
        oldBook.setAuthor(book.getAuthor());
        oldBook.setId(book.getId());


        return redirect(routes.BooksController.index());
    }

    public Result destroy(int id){
        Book book = Book.findById(id);
        if(book == null){
            return notFound("Book Not Found");
        }
        Book.remove(book);


        return redirect(routes.BooksController.index());
    }

    // for book details
    public Result show(int id){
        Book book = Book.findById(id);
        if (book == null){
            return notFound("Book Not Found");
        }
        return ok(show.render(book));
    }

    // save book
    public Result save(){
        Form<Book> bookForm = formFactory.form(Book.class).bindFromRequest();
        Book book = bookForm.get();
        Book.add(book);
        return redirect(routes.BooksController.index());
    }

}
