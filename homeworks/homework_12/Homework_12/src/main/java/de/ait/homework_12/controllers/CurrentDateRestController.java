package de.ait.homework_12.controllers;

import de.ait.homework_12.dto.DataTimeDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@RestController
public class CurrentDateRestController {

    @RequestMapping(value = "/now", method = RequestMethod.GET)
    public DataTimeDto getCurrentDateAndTime() {
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy", new Locale("en"));
        DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("HH:mm", new Locale("en"));
        return new DataTimeDto(dateTime.format(formatterDate), dateTime.format(formatterTime));
    }
}
