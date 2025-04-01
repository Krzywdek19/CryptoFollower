package com.krzywdek19.cryptoFollower.crypto;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.*;
import java.util.stream.Collectors;

@Service

public class CryptoService {
    private final WebClient webClient;

    public CryptoService() {
        webClient = WebClient.create("https://api.coingecko.com/api/v3");
    }
    public Mono<List<CryptoCurrencyDetailsDTO>> getCryptoCurrencies() {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/coins/markets")
                        .queryParam("vs_currency","usd")
                        .queryParam("order", "market_cap_desc")
                        .queryParam("per_page", 100)
                        .queryParam("page", 1)
                        .queryParam("sparkLine", false)
                        .build())
                .retrieve()
                .bodyToFlux(CryptoCurrencyDetailsDTO.class)
                .collect(Collectors.toList());
    }

    public CryptoCurrencyDetailsDTO getDetailsAboutCryptoCurrency(String id) {
        return null;
    }
}
