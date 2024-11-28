package com.sparta.currency_user.currencyExchange.dto;

import com.sparta.currency_user.currencyExchange.entity.ExchangeCurrency;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class ExchangeRequestDto {

    private Long userId;
    private Long currencyId;
    private BigDecimal amountInKrw;
}
