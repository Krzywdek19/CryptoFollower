package com.krzywdek19.cryptoFollower.crypto;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Service

public class CryptoReactiveScheduler {

    public CryptoReactiveScheduler(CryptoService cryptoService, SimpMessagingTemplate simpMessagingTemplate) {

        Flux.interval(Duration.ofSeconds(30))
                .flatMap(tick -> cryptoService.getCryptoCurrencies())
                .doOnNext(cryptoCurrencies -> {
                    simpMessagingTemplate.convertAndSend("/topic/cryptoCurrencies", cryptoCurrencies);
                    System.out.println("Fetch actual data");
                })
                .subscribe();
    }
}
