package de.ait;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String imgUrl = "https://cdn.javarush.com/images/article/431abcb1-71aa-4137-97bd-ad26d7aa0e00/800.jpeg";
        String token = "Basic YWNjX2FkY2RlNzQwZjA2YWVmNTo2ZTY1YjlhNjI0ODViYjVhYTJjY2VjZjUzMmE0Y2Y1ZQ==";
        String urlEndPoint = "https://api.imagga.com/v2/text";

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", token);

        URI uri = UriComponentsBuilder.fromUriString(urlEndPoint)
                .queryParam("image_url", imgUrl)
                .build()
                .toUri();

        RequestEntity<String> request = new RequestEntity<>(headers, HttpMethod.GET, uri);

        try {
            ResponseEntity<ResultDto> response = restTemplate.exchange(request, ResultDto.class);

            if (response.getStatusCode() == HttpStatus.OK) {
                String resultString = response.getBody().getResult().getText().stream()
                        .map(DataDto::getData)
                        .collect(Collectors.joining(" "));
                System.out.println(resultString);
            } else {
                System.out.println("Error!");
            }
        } catch (Exception e) {
            System.out.println("Ошибка запроса");
            e.printStackTrace();
        }
    }
}