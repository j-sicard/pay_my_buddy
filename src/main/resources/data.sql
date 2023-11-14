CREATE DATABASE IF NOT EXISTS paymybuddy_db;
USE paymybuddy_db;

CREATE TABLE IF NOT EXISTS user_accounts (
    user_account_pk INT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(50),
    password VARCHAR(200),
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    balance_account INTEGER,
    billing INTEGER
);

CREATE TABLE IF NOT EXISTS contacts (
    contact_pk INT AUTO_INCREMENT PRIMARY KEY,
    wording VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS accounts_contacts (
    user_accounts_contact_pk INT AUTO_INCREMENT PRIMARY KEY,
    account_fk INT,
    contact_fk INT,
    FOREIGN KEY (account_fk) REFERENCES user_accounts(user_account_pk),
    FOREIGN KEY (contact_fk) REFERENCES contacts(contact_pk)
);

CREATE TABLE IF NOT EXISTS bank_accounts (
    bank_account_pk INT AUTO_INCREMENT PRIMARY KEY,
    account_fk INT,
    bank_name VARCHAR(100),
    account_number INT,
    balance_account INT,
    FOREIGN KEY (account_fk) REFERENCES user_accounts(user_account_pk)
);

CREATE TABLE IF NOT EXISTS transfers (
    transfer_pk INT AUTO_INCREMENT PRIMARY KEY,
    credit VARCHAR(100),
    description VARCHAR(100),
    amount INT,
    debtor VARCHAR(100)
);