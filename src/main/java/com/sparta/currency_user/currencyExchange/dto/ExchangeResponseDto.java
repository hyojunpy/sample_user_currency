package com.sparta.currency_user.currencyExchange.dto;

import com.sparta.currency_user.currencyExchange.entity.ExchangeCurrency;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
public class ExchangeResponseDto {
    private final Long id;
    private final BigDecimal amountInKrw;
    private final BigDecimal amountAfterExchange;
    private final String status;
    private final LocalDateTime modifiedAt;

    public ExchangeResponseDto(Long id, BigDecimal amountInKrw, BigDecimal amountAfterExchange, String status, LocalDateTime modifiedAt) {
        this.id = id;
        this.amountInKrw = amountInKrw;
        this.amountAfterExchange = amountAfterExchange;
        this.status = status;
        this.modifiedAt = modifiedAt;
    }

    public static ExchangeResponseDto toDto(ExchangeCurrency exchangeCurrency) {
        return new ExchangeResponseDto(
                exchangeCurrency.getId(),
                exchangeCurrency.getAmountInKrw(),
                exchangeCurrency.getAmountAfterExchange(),
                exchangeCurrency.getStatus(),
                exchangeCurrency.getModifiedAt()
        );
    }
}
