package de.ait;

import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
//import java.net.http.HttpHeaders;

public class Main {
    public static void main(String[] args) {
        String imgUrl = "https://imagga.com/static/images/tagging/wind-farm-538576_640.jpg";
        String language = "en,de,ru";
        // ключ авторизации
        String token = "Basic YWNjX2FkY2RlNzQwZjA2YWVmNTo2ZTY1YjlhNjI0ODViYjVhYTJjY2VjZjUzMmE0Y2Y1ZQ==";
        String urlEndPoint = "https://api.imagga.com/v2/tags?";

        RestTemplate restTemplate = new RestTemplate();

        // Установить http-заголовки
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", token);

        // Получить uri строку
        URI uri = UriComponentsBuilder.fromHttpUrl(urlEndPoint)
                .queryParam("image_url", imgUrl)
                .queryParam("language", language)
                .queryParam("limit", 4)
                .build()
                .toUri();

        // создали RequestEntity
        RequestEntity<String> request = new RequestEntity<>(headers, HttpMethod.GET, uri);

        // вызвали restTemplate
        ResponseEntity<TagsResponseDto> response = restTemplate.exchange(request, TagsResponseDto.class);

        response.getBody().getResult().getTags().forEach(System.out::println);

        // можно и массивом вывести
//        TagDto[] tags = response.getBody().getResult().getTags();
//        for (var el : tags) {
//            System.out.println(el);
//        }
    }
}