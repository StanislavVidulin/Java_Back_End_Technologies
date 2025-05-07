package de.ait.homework_12.controllers;

import de.ait.homework_12.dto.DateTimeDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@RestController
public class CurrentDateRestController {

    @RequestMapping(value = "/now", method = RequestMethod.GET)
    public DateTimeDto getCurrentDateAndTime() {
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy", new Locale("en"));
        DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("HH:mm", new Locale("en"));
        return new DateTimeDto(dateTime.format(formatterDate), dateTime.format(formatterTime));
    }
}
