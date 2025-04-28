package com.ait;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        Person p = new Person("Jack", 18);
        Person[] people = {
                new Person("john", 22),
                new Person("lena", 23),
                new Person("igor", 25),
                new Person("mike", 21),
        };

        /********************************************************
         получить из объекта JSON - необходимы геттеры
         получить из  JSON объект - необходим пустой конструктор
         ************************************************************/

        // получить из объекта строку - JSON
        String json = mapper.writeValueAsString(p);
        System.out.println(json);

        // получить из объекта файл - JSON
        mapper.writeValue(new File("p1.json"), p);
        mapper.writeValue(new File("p2.json"), people);


//-----------------------------------------------------------------------------------
        // прочитать JSON -> в объект
        Person person = mapper.readValue(new File("p1.json"), Person.class);
//        Person[] people1 = mapper.readValue(new File("p2.json"), Person[].class);
//        HashSet<Person> people1 = mapper.readValue(new File("p2.json"), new TypeReference<HashSet<Person>>() {
            ArrayList<Person> people1 = mapper.readValue(new File("p2.json"), new TypeReference<ArrayList<Person>>() {
        });
        System.out.println("person: " + person);
//        System.out.println(Arrays.toString(people1));
        System.out.println(people1);
    }
}