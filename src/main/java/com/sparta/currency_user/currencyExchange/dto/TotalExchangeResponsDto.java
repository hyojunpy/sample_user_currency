package com.sparta.currency_user.currencyExchange.dto;

import lombok.Getter;

import java.math.BigDecimal;
import java.util.Optional;

@Getter
public class TotalExchangeResponsDto {
    private final Long count;
    private final BigDecimal totalAmountInKrw;

    public TotalExchangeResponsDto(Long count, BigDecimal totalAmountInKrw) {
        this.count = count;
        this.totalAmountInKrw = totalAmountInKrw;
    }

    public static TotalExchangeResponsDto toDto(TotalExchangeResponsDto responseDto) {
        return new TotalExchangeResponsDto(responseDto.getCount(), responseDto.getTotalAmountInKrw());
    }
}
