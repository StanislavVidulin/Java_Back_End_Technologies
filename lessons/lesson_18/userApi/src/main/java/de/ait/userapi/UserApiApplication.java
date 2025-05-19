package de.ait.userapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class UserApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApiApplication.class, args);
//        PasswordEncoder encoder = new BCryptPasswordEncoder();
//        String encode1 = encoder.encode("qwerty"); // создаёт новый хэш со случайной солью
//        System.out.println(encode1); // выводит хэш
//        System.out.println(encoder.matches("qwerty", encode1)); // true — пароль совпадает с хэшем
//        System.out.println(encoder.matches("qwerty1", encode1)); // false
//        System.out.println(encoder.encode("qwerty")); // новый хэш, тоже для "qwerty", но другой
    }
}
