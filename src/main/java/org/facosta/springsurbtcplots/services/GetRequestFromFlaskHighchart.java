package org.facosta.springsurbtcplots.services;

import org.facosta.springsurbtcplots.services.Interfaces.GetRequestHandlerService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service("Highchart")
@Primary
public class GetRequestFromFlaskHighchart implements GetRequestHandlerService
{
    private RestTemplate restTemplate;
    private final String baseUrl;
    private final int port;

    public GetRequestFromFlaskHighchart(RestTemplate restTemplate,
                                       @Value("${flask.adress}") String baseUrl,
                                       @Value("${flask.port}") int port)
    {
        this.restTemplate = restTemplate;
        this.baseUrl = baseUrl;
        this.port = port;
    }

    public String getHttpRequest(String resample)
    {
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder
                .fromUriString(baseUrl)
                .port(port)
                .path("/ohlc")
                .queryParam("resample", resample);
        return restTemplate.getForObject(uriComponentsBuilder.toUriString(), String.class);
    }
}
