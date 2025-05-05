package org.example;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class Main {
    /*
    Ваша задача написать программу, которая получает List комментариев (объекты коллекции)
    comments на сайте https://jsonplaceholder.typicode.com/
     */
    public static void main(String[] args) throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        URI uri = new URI("https://jsonplaceholder.typicode.com/comments");

        RequestEntity<String> request = new RequestEntity<>(HttpMethod.GET, uri);
        ResponseEntity<ArrayList<CommentDto>>
                response = restTemplate.exchange(request, new ParameterizedTypeReference<ArrayList<CommentDto>>() {
        });

        ArrayList<CommentDto> body = response.getBody();
        for (CommentDto comment : body) {
            System.out.println(comment);
            System.out.println();
        }
    }
}