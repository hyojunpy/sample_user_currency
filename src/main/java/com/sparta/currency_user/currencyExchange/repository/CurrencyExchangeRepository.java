package com.sparta.currency_user.currencyExchange.repository;


import com.sparta.currency_user.currencyExchange.dto.ExchangeResponseDto;
import com.sparta.currency_user.currencyExchange.dto.TotalExchangeResponsDto;
import com.sparta.currency_user.currencyExchange.entity.ExchangeCurrency;
import com.sparta.currency_user.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
@Transactional
public interface CurrencyExchangeRepository extends JpaRepository<ExchangeCurrency, Long> {

    @Query("select new com.sparta.currency_user.currencyExchange.dto.TotalExchangeResponsDto(count(ec.id) , SUM(ec.amountInKrw))" +
            "from ExchangeCurrency ec " +
            "where ec.user =:user group by ec.user" )
    TotalExchangeResponsDto findExchangeCurrenciesByUser(@Param("user") User user);

    List<ExchangeResponseDto> findAllByUser(User userId);
}
