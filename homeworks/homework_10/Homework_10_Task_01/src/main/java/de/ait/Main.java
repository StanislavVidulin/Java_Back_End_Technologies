package de.ait;

import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import org.springframework.http.HttpHeaders;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

public class Main {
    public static void main(String[] args) {
        String imgUrl = "https://cdn.javarush.com/images/article/431abcb1-71aa-4137-97bd-ad26d7aa0e00/800.jpeg";
        String token = "Basic YWNjX2FkY2RlNzQwZjA2YWVmNTo2ZTY1YjlhNjI0ODViYjVhYTJjY2VjZjUzMmE0Y2Y1ZQ==";
        String endPointUrl = "https://api.imagga.com/v2/text?";

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", token);

        URI uri = UriComponentsBuilder.fromHttpUrl(endPointUrl)
                .queryParam("image_url", imgUrl)
                .build()
                .toUri();
        RequestEntity<String> request = new RequestEntity<>(headers, HttpMethod.GET, uri);
        ResponseEntity<TextsResponseDto> response = restTemplate.exchange(request, TextsResponseDto.class);

        response.getBody().getResult().getText().forEach(data -> {
            System.out.print(data.getData() + " ");
        });

    }
}