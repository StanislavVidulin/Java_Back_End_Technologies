package de.ait.hw2025_05_07.controllers;

import de.ait.hw2025_05_07.model.DateTime;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
public class TimeController {

    @GetMapping("/now")
    public DateTime getTime() {
        LocalDateTime now = LocalDateTime.now();
        return DateTime.builder()
                .day(now.getDayOfMonth())
                .month(now.getMonth().getValue())
                .year(now.getYear())
//                .hour(now.getHour())
//                .minute(now.getMinute())
                .build();
    }

    @GetMapping("/now2")
    public String getTime2() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm"));
    }
}
