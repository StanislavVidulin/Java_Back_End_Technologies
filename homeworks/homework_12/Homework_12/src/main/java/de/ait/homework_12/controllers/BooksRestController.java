package de.ait.homework_12.controllers;

import de.ait.homework_12.entity.Book;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BooksRestController {

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public List<Book> getBooks() {
        List<Book> books = new ArrayList<>();
        books.add(new Book(1,"Горе от ума", "Александр Грибоедов", 1828));
        books.add(new Book(2,"Собачье сердце", "Михаил Булгаков", 1925));
        books.add(new Book(3,"Мёртвые души", "Николай Гоголь", 1842));
        books.add(new Book(4,"Три товарища", "Эрих Мария Ремарк", 1936));
        books.add(new Book(5,"Три мушкетёра", "Александр Дюма", 1844));
        books.add(new Book(6,"Отцы и дети", "Иван Тургенев", 1860));
        books.add(new Book(7,"Воскресение", "Лев Толстой", 1899));
        books.add(new Book(8,"Подросток", "Фёдор Достоевский", 1875));
        books.add(new Book(9,"Руслан и Людмила", "Александр Пушкин", 1820));
        books.add(new Book(10,"Вишнёвый сад", "Антон Чехов", 1903));
        return books;
    }
}
