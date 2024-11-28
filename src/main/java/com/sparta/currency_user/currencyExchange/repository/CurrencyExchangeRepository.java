package com.sparta.currency_user.currencyExchange.repository;


import com.sparta.currency_user.currencyExchange.dto.ExchangeResponseDto;
import com.sparta.currency_user.currencyExchange.entity.ExchangeCurrency;
import com.sparta.currency_user.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CurrencyExchangeRepository extends JpaRepository<ExchangeCurrency, Long> {

    List<ExchangeResponseDto> findAllByUser(User userId);
}
