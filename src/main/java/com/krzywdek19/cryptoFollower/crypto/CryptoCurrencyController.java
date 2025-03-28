package com.krzywdek19.cryptoFollower.crypto;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CryptoCurrencyController {
    private final CryptoService cryptoService;

    @GetMapping("/get")
    public ResponseEntity<List<CryptoCurrencyDTO>> getCryptoCurrencies() {
        return ResponseEntity.ok(cryptoService.getCryptoCurrencies());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<CryptoCurrencyDetailsDTO> getDetails(@PathVariable String id){
        return ResponseEntity.ok(cryptoService.getDetailsAboutCryptoCurrency(id));
    }
}
