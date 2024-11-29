package com.sparta.currency_user.currencyExchange.service;

import com.sparta.currency_user.currencyExchange.dto.ExchangeRequestDto;
import com.sparta.currency_user.currencyExchange.dto.ExchangeResponseDto;
import com.sparta.currency_user.currency.entity.Currency;
import com.sparta.currency_user.currencyExchange.entity.ExchangeCurrency;
import com.sparta.currency_user.user.entity.User;
import com.sparta.currency_user.currencyExchange.repository.CurrencyExchangeRepository;
import com.sparta.currency_user.currency.repository.CurrencyRepository;
import com.sparta.currency_user.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CurrencyExchangeService {

    private final CurrencyExchangeRepository exchangeRepository;
    private final UserRepository userRepository;
    private final CurrencyRepository currencyRepository;

    @Transactional
    public ExchangeResponseDto exchangeRequest(ExchangeRequestDto dto) {

        //유저 및 통화 확인
        User user =  userRepository.findById(dto.getUserId()).orElseThrow();
//        User user =  userRepository.findById(dto.getUserId()).orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다."));
        Currency currency = currencyRepository.findById(dto.getCurrencyId()).orElseThrow(() -> new IllegalArgumentException("통화를 찾을 수 없습니다."));

        //환전 연산
        BigDecimal amountAfterExchange = dto.getAmountInKrw().divide(currency.getExchangeRate(), 2, RoundingMode.HALF_UP);
        //생성자로 초기화
        ExchangeCurrency newExchange = new ExchangeCurrency(user, currency, dto.getAmountInKrw(), amountAfterExchange, "normal");
        //데이터베이스에 저장
        ExchangeCurrency SaveExchange = exchangeRepository.save(newExchange);

        //값 반환
        return ExchangeResponseDto.toDto(SaveExchange);
    }

    @Transactional
    public List<ExchangeResponseDto> findExchange(Long userId) {
        //유저 확인
        User user =  userRepository.findById(userId).orElseThrow();

        return exchangeRepository.findAllByUser(user);
    }

    @Transactional
    public ExchangeResponseDto updateStatus(Long id) {
        ExchangeCurrency exchangeCurrency = exchangeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("요청을 찾을 수 없습니다."));
        exchangeCurrency.setStatus("cancelled");
        exchangeRepository.save(exchangeCurrency);
        return ExchangeResponseDto.toDto(exchangeCurrency);
    }


}
