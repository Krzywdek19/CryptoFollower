package com.krzywdek19.cryptoFollower.crypto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@NoArgsConstructor
@AllArgsConstructor
@Data
public class CryptoCurrencyDetailsDTO {
    private String id;
    private String symbol;
    private String name;
    private Double current_price;
}
