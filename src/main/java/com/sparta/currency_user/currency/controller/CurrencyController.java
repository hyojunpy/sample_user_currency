package com.sparta.currency_user.currency.controller;

import com.sparta.currency_user.currency.dto.CurrencyRequestDto;
import com.sparta.currency_user.currency.dto.CurrencyResponseDto;
import com.sparta.currency_user.currency.service.CurrencyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/currencies")
@RequiredArgsConstructor
public class CurrencyController {
    private final CurrencyService currencyService;

    //모든 통화 찾기
    @GetMapping
    public ResponseEntity<List<CurrencyResponseDto>> findCurrencies() {
        return ResponseEntity.ok().body(currencyService.findAll());
    }

    //통화 찾기
    @GetMapping("/{id}")
    public ResponseEntity<CurrencyResponseDto> findCurrency(@PathVariable Long id) {
        return ResponseEntity.ok().body(currencyService.findById(id));
    }

    //통화 등록 하기
    @PostMapping
    public ResponseEntity<CurrencyResponseDto> createCurrency(@Valid @RequestBody CurrencyRequestDto currencyRequestDto) {
        return ResponseEntity.ok().body(currencyService.save(currencyRequestDto));
    }
}
