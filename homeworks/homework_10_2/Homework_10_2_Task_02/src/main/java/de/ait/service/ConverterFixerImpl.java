package de.ait.service;

import de.ait.dto.ResultDto;
import de.ait.model.Conversion;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.math.BigDecimal;
import java.net.URI;

public class ConverterFixerImpl implements Converter {
    private static final String URL= "https://api.apilayer.com/fixer/convert";

    private static final String TOKEN = "clapgFim8UjAIHpueTGgIVdeL7Vglyzi";  // свой ключ
    private static final RestTemplate REST_TEMPLATE = new RestTemplate();

    @Override
    public Conversion convert(String from, String to, double amount) {
        System.out.println("Fetch fixer API .....");
        from = from.toLowerCase().trim();
        to=to.toLowerCase().trim();
        HttpHeaders headers = new HttpHeaders();
        headers.add("apikey", TOKEN);
        try {

            URI uri = UriComponentsBuilder.fromUriString(URL)
                    .queryParam("from", from)
                    .queryParam("to", to)
                    .queryParam("amount", amount)
                    .build()
                    .toUri();
            RequestEntity<Object> requestEntity = new RequestEntity<>(headers, HttpMethod.GET, uri);
            ResponseEntity<ResultDto> response = REST_TEMPLATE.exchange(requestEntity, ResultDto.class);
            Conversion result = new Conversion(from, to, new BigDecimal(amount));
            result.setAmountTo(response.getBody().getResult());
            result.setRate(response.getBody().getInfo().getRate());
            return result;

        } catch (HttpClientErrorException e) {  // 4xx - HttpClientErrorException
            throw new RuntimeException("Client error: " + e.getStatusCode(),e);
        } catch (HttpServerErrorException e) {  // 5xx - HttpServerErrorException
            throw new RuntimeException("Server error: " + e.getStatusCode(),e);
        } catch (ResourceAccessException e) {
            throw new RuntimeException("Resource Access error: " + e.getMessage(),e);
        } catch (Exception e){
            throw new RuntimeException("Something gone wrong!",e);
        }
    }
}
