package com.krzywdek19.cryptoFollower.crypto;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class CryptoService {
    private final String API_URL = "https://api.coingecko.com/api/v3";

    public List<CryptoCurrencyDTO> getCryptoCurrencies() {
        RestTemplate restTemplate = new RestTemplate();
        return Arrays.asList(Objects.requireNonNull(restTemplate.getForObject(API_URL + "/coins/list", CryptoCurrencyDTO[].class)));
    }

    public CryptoCurrencyDetailsDTO getDetailsAboutCryptoCurrency(String id) {
        RestTemplate restTemplate = new RestTemplate();
        Map response = restTemplate.getForEntity(API_URL + "/coins/" + id, Map.class).getBody();

        var cryptoDetailsDTO = new CryptoCurrencyDetailsDTO();
        assert response != null;
        cryptoDetailsDTO.setId((String) response.get("id"));
        cryptoDetailsDTO.setSymbol((String) response.get("symbol"));
        cryptoDetailsDTO.setName((String) response.get("name"));

        Map marketData = (Map<String, Object>) response.get("market_data");
        Map<String, Object> currentPrice = (Map<String, Object>) marketData.get("current_price");
        currentPrice.forEach((s, o) -> {
            cryptoDetailsDTO.getCurrentPrice().put(s, Double.parseDouble(o.toString()));
        });
        return cryptoDetailsDTO;
    }
}
