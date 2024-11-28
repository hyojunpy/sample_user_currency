package com.sparta.currency_user.currencyExchange.controller;

import com.sparta.currency_user.currencyExchange.dto.ExchangeRequestDto;
import com.sparta.currency_user.currencyExchange.dto.ExchangeResponseDto;
import com.sparta.currency_user.currencyExchange.service.CurrencyExchangeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exchange")
@RequiredArgsConstructor
public class CurrencyExchangeController {

    private final CurrencyExchangeService currencyExchangeService;

    @PostMapping
    public ResponseEntity<?> exchangeRequest(
            @RequestBody ExchangeRequestDto dto
    ) {
        ExchangeResponseDto exchangeResponseDto = currencyExchangeService.exchangeRequest(dto);
        return ResponseEntity.status(HttpStatus.OK).body(exchangeResponseDto);
    }

    @GetMapping
    public ResponseEntity<List<ExchangeResponseDto>> findByUser(
            Long userId
    ) {
        List<ExchangeResponseDto> responseDtos = currencyExchangeService.findExchange(userId);

        return ResponseEntity.ok().body(responseDtos);
    }

    @PatchMapping
    public ResponseEntity<?> updateStatus(
            Long id
    ) {
        ExchangeResponseDto exchangeResponseDto = currencyExchangeService.updateStatus(id);

        return ResponseEntity.status(HttpStatus.OK).body(exchangeResponseDto);
    }

}
