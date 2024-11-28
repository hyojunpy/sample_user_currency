package com.sparta.currency_user.currencyExchange.entity;

import com.sparta.currency_user.common.entity.BaseEntity;
import com.sparta.currency_user.currency.entity.Currency;
import com.sparta.currency_user.user.entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
public class ExchangeCurrency extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "users_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "to_currency_id")
    private Currency currency;

    private BigDecimal amountInKrw;

    private BigDecimal amountAfterExchange;

    @Setter
    private String status = "OK";

    public ExchangeCurrency(User user, Currency currency, BigDecimal amountInKrw, BigDecimal amountAfterExchange, String status) {
        this.user = user;
        this.currency = currency;
        this.amountInKrw = amountInKrw;
        this.amountAfterExchange = amountAfterExchange;
        this.status = status;
    }

    public ExchangeCurrency() {}

}
