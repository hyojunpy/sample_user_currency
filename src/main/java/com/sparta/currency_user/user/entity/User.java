package com.sparta.currency_user.user.entity;

import com.sparta.currency_user.common.entity.BaseEntity;
import com.sparta.currency_user.currencyExchange.entity.ExchangeCurrency;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private final List<ExchangeCurrency> exchangeCurrencies = new ArrayList<>();

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public User() {}
}