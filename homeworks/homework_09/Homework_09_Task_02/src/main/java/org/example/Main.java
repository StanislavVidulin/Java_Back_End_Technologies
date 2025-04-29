package org.example;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    /*
   Ваша программа должна запрашивать номер (id) поста на сайте https://jsonplaceholder.typicode.com/
   и получить список всех комментариев для этого поста
     */
    public static void main(String[] args) throws URISyntaxException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter id post:");
        int idPost = scanner.nextInt();

        RestTemplate restTemplate = new RestTemplate();
        URI uri = new URI("https://jsonplaceholder.typicode.com/comments?postId=" + idPost);

        RequestEntity<String> request = new RequestEntity<>(HttpMethod.GET, uri);
        ResponseEntity<ArrayList<CommentDto>> response =
                restTemplate.exchange(request, new ParameterizedTypeReference<ArrayList<CommentDto>>() {
                });

        ArrayList<CommentDto> comments = response.getBody();
        for (CommentDto comment : comments) {
            System.out.println(comment);
            System.out.println();
        }
    }
}