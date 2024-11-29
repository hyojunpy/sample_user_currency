package com.sparta.currency_user.common.Validation;

import com.sparta.currency_user.currency.entity.Currency;
import com.sparta.currency_user.currency.repository.CurrencyRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class Validate {

    private final CurrencyRepository currencyRepository;

    //Lv4 PostConstruct 적용
    @PostConstruct
    public void inspectExchangeRate() {
        List<Currency> currency = currencyRepository.findAll();
        for(Currency currency1 : currency ) {
            if(currency1.getExchangeRate().compareTo(BigDecimal.ZERO) <= 0) {
                log.error(currency1.getExchangeRate().toString());
            }
        }
    }

}
