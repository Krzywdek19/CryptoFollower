package com.krzywdek19.cryptoFollower.crypto;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CryptoCurrencyController {
    private final CryptoService cryptoService;

    @GetMapping("/get")
    public ResponseEntity<Mono<List<CryptoCurrencyDetailsDTO>>> getCryptoCurrencies() {
        return ResponseEntity.ok(cryptoService.getCryptoCurrencies());
    }


}
