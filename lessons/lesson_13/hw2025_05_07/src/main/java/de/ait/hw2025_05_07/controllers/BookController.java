package de.ait.hw2025_05_07.controllers;

import de.ait.hw2025_05_07.model.Author;
import de.ait.hw2025_05_07.model.Book;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {
    private static List<Book> booksDB = new ArrayList<>(
            List.of(
                    new Book(new Author("Лев", "Толстой"), "Война и мир"),
                    new Book(new Author("Лев", "Толстой"), "Анна Каренина"),
                    new Book(new Author("Федор", "Достоевский"), "Идиот"),
                    new Book(new Author("Михаил", "Булгаков"), "Собачье сердце")
            )
    );


    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public List<Book> getBooks() {
        return booksDB;
    }

    @RequestMapping(value = "/books", method = RequestMethod.PUT)
    public void updateBook(){
        System.out.println("put!!!!!");
    }
}
