package com.sparta.currency_user.currency.dto;

import com.sparta.currency_user.currency.entity.Currency;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NonNull;

import java.math.BigDecimal;

@Getter
public class CurrencyRequestDto {
    @Valid
    @NotBlank(message = "통화 이름은 필수 사항입니다.")
    private String currencyName;

    @Valid
    @NotNull(message = "환율은 필수 사항입니다.")
    private BigDecimal exchangeRate;

    @Valid
    @NotBlank(message = "심볼은 필수 사항입니다.")
    private String symbol;

    public Currency toEntity() {
        return new Currency(
                this.currencyName,
                this.exchangeRate,
                this.symbol
        );
    }
}
