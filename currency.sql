CREATE TABLE user (
    id BIGINT NOT NULL PRIMARY KEY ,
    email VARCHAR(40) ,
    name VARCHAR(20),
    create_at DATETIME,
    modified_at DATETIME
)

CREATE TABLE currency (
    id BIGINT NOT NULL PRIMARY KEY ,
    currency_name NOT NULL VARCHAR(20),
    exchange_rate NOT NULL DECIMAL,
    symbol NOT NULL VARCHAR(10),
    create_at DATETIME,
    modified_at DATETIME
)

CREATE TABLE exchange_currency (
    id BIGINT NOT NULL PRIMARY KEY ,
    user_id BIGINT NOT NULL ,
    currency_id BIGINT NOT NULL ,
    amount_in_krw DECIMAL NOT NULL ,
    amount_after_exchange DECIMAL NOT NULL ,
    create_at DATETIME,
    modified_at DATETIME,
    FOREIGN KEY (user_id) REFERENCES USER(id),
    FOREIGN KEY (currency_id) REFERENCES currency(id)
)

