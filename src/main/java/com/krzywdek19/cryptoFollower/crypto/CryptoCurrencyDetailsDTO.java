package com.krzywdek19.cryptoFollower.crypto;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class CryptoCurrencyDetailsDTO {
    private String id;
    private String symbol;
    private String name;
    private Map<String, Double> currentPrice = new HashMap<String, Double>();
}
