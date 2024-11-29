package com.sparta.currency_user.currencyExchange.dto;

import com.sparta.currency_user.currencyExchange.entity.ExchangeCurrency;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class ExchangeRequestDto {

    private Long userId;
    private Long currencyId;
    @Valid
    @NotNull(message = "환전 금액은 필수 입력입니다.")
    private BigDecimal amountInKrw;
}
