package de.ait.homework_12.controllers;

import de.ait.homework_12.entity.Film;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FilmsRestController {

    @RequestMapping(value = "/films", method = RequestMethod.GET)
    public List<Film> getFilms() {
        List<Film> films = new ArrayList<>();
        films.add(new Film(1,"Interstellar", 2014));
        films.add(new Film(2,"The Shawshank Redemption", 1994));
        films.add(new Film(3,"The Gentlemen", 2019));
        films.add(new Film(4,"The Green Mile", 1999));
        films.add(new Film(5,"Forrest Gump", 1994));
        films.add(new Film(6,"Fight Club", 1999));
        films.add(new Film(7,"Inception", 2010));
        films.add(new Film(8,"Titanic", 1997));
        films.add(new Film(9,"The Matrix", 1999));
        films.add(new Film(10,"The Shawshank Redemption", 1994));
        return films;
    }
}
