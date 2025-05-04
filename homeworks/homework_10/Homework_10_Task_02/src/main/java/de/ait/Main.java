package de.ait;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import org.springframework.http.HttpHeaders;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static final Map<String, Double> cache = new HashMap<>();
    private static final String cacheFile = "cache.json";
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) throws IOException {
        loadCache();
        String endPointUrl = "https://api.apilayer.com/fixer/convert?";
        String token = "clapgFim8UjAIHpueTGgIVdeL7Vglyzi";

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the transfer currency from: ");
        String from = scanner.nextLine();
        System.out.println("Enter the transfer currency to: ");
        String to = scanner.nextLine();
        System.out.println("Enter amount: ");
        Double amount = Double.parseDouble(scanner.nextLine());

        String key = from + "_" + to + "_" + amount;

        if (cache.containsKey(key)) {
            System.out.println("Result from cache file: " + amount + " " + from + " = " + cache.get(key) + " " + to);
        } else {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.add("apikey", token);

            URI uri = UriComponentsBuilder.fromHttpUrl(endPointUrl)
                    .queryParam("from", from)
                    .queryParam("to", to)
                    .queryParam("amount", amount)
                    .build()
                    .toUri();

            RequestEntity<String> request = new RequestEntity<>(headers, HttpMethod.GET, uri);
            ResponseEntity<ResultDto> response = restTemplate.exchange(request, ResultDto.class);
            double result = response.getBody().getResult();

            cache.put(key, result);

            System.out.println(amount + " " + from + " in " + to + " is: " + result + " " + to);

            saveCache();

            System.out.println(cache);
        }
    }

    private static void loadCache() throws IOException {
        File file = new File(cacheFile);
        if (file.exists()) {
            cache.putAll(objectMapper.readValue(file, new TypeReference<Map<String, Double>>() {
            }));
        }
    }

    private static void saveCache() throws IOException {
        objectMapper.writeValue(new File(cacheFile), cache);
    }
}