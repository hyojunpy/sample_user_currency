package com.sparta.currency_user.currencyExchange.controller;

import com.sparta.currency_user.currencyExchange.dto.ExchangeRequestDto;
import com.sparta.currency_user.currencyExchange.dto.ExchangeResponseDto;
import com.sparta.currency_user.currencyExchange.dto.TotalExchangeResponsDto;
import com.sparta.currency_user.currencyExchange.service.CurrencyExchangeService;
import jakarta.validation.Valid;
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

    //환전 요청 생성
    @PostMapping
    public ResponseEntity<?> exchangeRequest(@Valid @RequestBody ExchangeRequestDto dto) {
        ExchangeResponseDto exchangeResponseDto = currencyExchangeService.exchangeRequest(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(exchangeResponseDto);
    }

    //유저ID로 환전 요청 기록 조회
    @GetMapping
    public ResponseEntity<List<ExchangeResponseDto>> findByUser(Long userId) {
        List<ExchangeResponseDto> responseDtos = currencyExchangeService.findExchange(userId);

        return ResponseEntity.ok().body(responseDtos);
    }

    //환전 상태 수정
    @PatchMapping
    public ResponseEntity<?> updateStatus(Long id) {
        ExchangeResponseDto exchangeResponseDto = currencyExchangeService.updateStatus(id);

        return ResponseEntity.status(HttpStatus.OK).body(exchangeResponseDto);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> findTotalAmountAndPost(@PathVariable Long userId) {
        TotalExchangeResponsDto responsDto = currencyExchangeService.findExchangeCurrenciesByUser(userId);

        return ResponseEntity.status(HttpStatus.OK).body(responsDto);
    }

}
