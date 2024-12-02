package com.sparta.currency_user.currencyExchange.service;

import com.sparta.currency_user.common.error.ErrorCode;
import com.sparta.currency_user.currency.entity.Currency;
import com.sparta.currency_user.currencyExchange.dto.ExchangeRequestDto;
import com.sparta.currency_user.currencyExchange.dto.ExchangeResponseDto;
import com.sparta.currency_user.currencyExchange.dto.TotalExchangeResponsDto;
import com.sparta.currency_user.currencyExchange.entity.ExchangeCurrency;
import com.sparta.currency_user.user.entity.User;
import com.sparta.currency_user.currencyExchange.repository.CurrencyExchangeRepository;
import com.sparta.currency_user.currency.repository.CurrencyRepository;
import com.sparta.currency_user.user.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CurrencyExchangeService {

    private final CurrencyExchangeRepository exchangeRepository;
    private final UserRepository userRepository;
    private final CurrencyRepository currencyRepository;


    // 환전 요청
    @Transactional
    public ExchangeResponseDto exchangeRequest(ExchangeRequestDto dto) {

        //유저 및 통화 확인
        User user =  userRepository.findById(dto.getUserId()).orElseThrow(() -> new IllegalArgumentException(String.valueOf(ErrorCode.BAD_REQUEST_ERROR)));
        Currency currency = currencyRepository.findById(dto.getCurrencyId()).orElseThrow(() -> new IllegalArgumentException(String.valueOf(ErrorCode.BAD_REQUEST_ERROR)));


        //환전 연산
        BigDecimal amountAfterExchange = dto.getAmountInKrw().divide(currency.getExchangeRate(), 2, RoundingMode.HALF_UP);
        //생성자로 초기화
        ExchangeCurrency newExchange = new ExchangeCurrency(user, currency, dto.getAmountInKrw(), amountAfterExchange, "NORMAL");
        //데이터베이스에 저장
        ExchangeCurrency SaveExchange = exchangeRepository.save(newExchange);

        //값 반환
        return ExchangeResponseDto.toDto(SaveExchange);
    }

    //유저 id로 환전 요청 기록 조회
    @Transactional
    public List<ExchangeResponseDto> findExchange(Long userId) {
        //유저 확인
        User user =  userRepository.findById(userId).orElseThrow();

        return exchangeRepository.findAllByUser(user);
    }

    //status 수정
    @Transactional
    public ExchangeResponseDto updateStatus(Long id) {
        ExchangeCurrency exchangeCurrency = exchangeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException(String.valueOf(ErrorCode.BAD_REQUEST_ERROR)));
        exchangeCurrency.setStatus("cancelled");
        exchangeRepository.save(exchangeCurrency);
        return ExchangeResponseDto.toDto(exchangeCurrency);
    }

    @Transactional
    public TotalExchangeResponsDto findExchangeCurrenciesByUser(Long userId) {
        User user =  userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException(String.valueOf(ErrorCode.BAD_REQUEST_ERROR)));
        // 쿼리 실행: userId에 맞는 count와 totalAmountInKrw 값을 가져옴
        return exchangeRepository.findExchangeCurrenciesByUser(user);
    }
}
