package org.example;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws URISyntaxException {

        ResponseEntity<ArrayList<CommentDto>> response = getCommentsFromServer("http://jsonplaceholder.typicode.com/comments");
        System.out.println("Статус код: " + response.getStatusCode());
        System.out.println("Заголовки: " + response.getHeaders());

//        PostDto[] body = response.getBody();
        ArrayList<CommentDto> listAllComments = response.getBody();
        // var позволяет любой тип использовать(var сам определит какой это тип данных)
        // в javascript можно изменить var, в java var нельзя изменить
        for (var post : listAllComments) {
            System.out.println(post);
            System.out.println();
        }

        // получение всех комментариев заданного поста
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер поста: ");
        int postId = scanner.nextInt();
        // 1-ый вариант решения (ещё раз идём на сервер)
//        response = getCommentsFromServer("http://jsonplaceholder.typicode.com/comments?postId=" + postId);
//        ArrayList<CommentDto> listOfComments = response.getBody();
//        listOfComments.forEach(System.out::println);
        // 2-ой вариант решения (не идём ещё раз на сервер, проходимся стримом )
        List<CommentDto> listOfComments = listAllComments.stream().filter(c -> c.getPostId().equals(postId)).toList();
        listOfComments.forEach(System.out::println);
    }

    private static ResponseEntity<ArrayList<CommentDto>> getCommentsFromServer(String uriString) throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        URI uri = new URI(uriString);
        RequestEntity<String> request = new RequestEntity<>(HttpMethod.GET, uri);
//        ResponseEntity<String> response = restTemplate.exchange(request, String.class);
//        ResponseEntity<PostDto[]> response = restTemplate.exchange(request, PostDto[].class);

        //получаем лист, какую-то коллекцию
        ResponseEntity<ArrayList<CommentDto>> response =
                restTemplate.exchange(request, new ParameterizedTypeReference<ArrayList<CommentDto>>() {
                });
//        System.out.println(response.getBody());
        return response;
    }
}