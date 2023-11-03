CREATE DATABASE IF NOT EXISTS paymybuddy_db;
USE paymybuddy_db;

CREATE TABLE IF NOT EXISTS user_accounts (
    user_account_pk INTEGER PRIMARY KEY,
    email VARCHAR(50),
    password VARCHAR(200),
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    balance_account INTEGER,
    billing INTEGER
);

CREATE TABLE IF NOT EXISTS banks (
    bank_pk INTEGER PRIMARY KEY,
    wording VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS bank_accounts (
    bank_account_pk INTEGER PRIMARY KEY,
    account_fk INTEGER,
    bank_fk INTEGER,
    account_number INTEGER,
    balance_account INTEGER,
    FOREIGN KEY (account_fk) REFERENCES user_accounts(user_account_pk),
    FOREIGN KEY (bank_fk) REFERENCES banks(bank_pk)
);

CREATE TABLE IF NOT EXISTS transfers (
    transfer_pk INTEGER PRIMARY KEY,
    credit VARCHAR(100),
    description VARCHAR(100),
    amount INTEGER,
    debtor VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS contacts (
    contact_pk INTEGER PRIMARY KEY,
    wording VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS accounts_contacts (
    user_accounts_contact_pk INTEGER PRIMARY KEY,
    account_fk INTEGER,
    contact_fk INTEGER,
    FOREIGN KEY (account_fk) REFERENCES user_accounts(user_account_pk),
    FOREIGN KEY (contact_fk) REFERENCES contacts(contact_pk)
);
