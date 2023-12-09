CREATE TABLE IF NOT EXISTS users
(
    id INT PRIMARY KEY ,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL ,
    account_non_expired BOOLEAN NOT NULL ,
    account_non_locked BOOLEAN NOT NULL ,
    credentials_non_expired BOOLEAN NOT NULL,
    enabled BOOLEAN NOT NULL
);;