-- com.openclassroom.paymybuddy
--
-- UserAccountServiceTest
-- UserAccountServiceTest::testWidthdrawWithUnsufficientBalance
INSERT INTO user_accounts(id, email, password, first_name, last_name, balance) VALUES(1, 'withdrawUnsufficient@test.fr', 'password', 'testName', 'testLastName', 40);
INSERT INTO bank_accounts(id, name, balance, id_user_account) VALUES(1, 'Caisse d''epargne', 20, 1);
INSERT INTO bank_accounts(id, name, balance, id_user_account) VALUES(2, 'Boursorama', 200, 1);
-- UserAccountServiceTest::testWidthdrawWithSufficientBalance
INSERT INTO user_accounts(id, email, password, first_name, last_name, balance) VALUES(2, 'withdrawSufficient@test.fr', 'password', 'testName', 'testLastName', 100);
INSERT INTO bank_accounts(id, name, balance, id_user_account) VALUES(3, 'Credit Mutuel', 40, 2);
INSERT INTO bank_accounts(id, name, balance, id_user_account) VALUES(4, 'Fortuneo', 75, 2);
--
-- TransferBusinessService
-- TransferBusinessService::testWithdrawToBankSuccess
INSERT INTO user_accounts(id, email, password, first_name, last_name, balance) VALUES(3, 'withdrawToBankSuccess@test.fr', 'password', 'testName', 'testLastName', 100);
INSERT INTO bank_accounts(id, name, balance, id_user_account) VALUES(5, 'BNP', 50, 3);
INSERT INTO bank_accounts(id, name, balance, id_user_account) VALUES(6, 'Société Générale', 300, 3);
-- TransferBusinessService::testWithdrawToBankSuccess
INSERT INTO user_accounts(id, email, password, first_name, last_name, balance) VALUES(4, 'withdrawToBankFailure@test.fr', 'password', 'testName', 'testLastName', 50);
INSERT INTO bank_accounts(id, name, balance, id_user_account) VALUES(7, 'BNP', 50, 4);
INSERT INTO bank_accounts(id, name, balance, id_user_account) VALUES(8, 'Société Générale', 300, 4);
--
-- BankAccountServiceTest
-- BankAccountServiceTest::testCreditBalanceSuccess
INSERT INTO user_accounts(id, email, password, first_name, last_name, balance) VALUES(5, 'creditBalance@test.fr', 'password', 'testName', 'testLastName', 40);
INSERT INTO bank_accounts(id, name, balance, id_user_account) VALUES(9, 'Caisse d''epargne', 20, 5);
INSERT INTO bank_accounts(id, name, balance, id_user_account) VALUES(10, 'Boursorama', 200, 5);
--
-- TransferBusinessService
-- TransferBusinessService::withdrawBankToAccountSuccess
INSERT INTO user_accounts(id, email, password, first_name, last_name, balance) VALUES(6, 'withdrawBankToAccount@test.fr', 'password', 'testName', 'testLastName', 100);
INSERT INTO bank_accounts(id, name, balance, id_user_account) VALUES(11, 'Caisse d''epargne', 100, 6);
INSERT INTO bank_accounts(id, name, balance, id_user_account) VALUES(12, 'Boursorama', 100, 6);
-- TransferBusinessService::withdrawBankToAccountFailure
INSERT INTO user_accounts(id, email, password, first_name, last_name, balance) VALUES(7, 'withdrawBankToAccount@test.fr', 'password', 'testName', 'testLastName', 100);
INSERT INTO bank_accounts(id, name, balance, id_user_account) VALUES(13, 'Caisse d''epargne', 100, 7);
INSERT INTO bank_accounts(id, name, balance, id_user_account) VALUES(14, 'Boursorama', 100, 7);
-- TransferBusinessService::getProfileUserByEmailSuccess
INSERT INTO user_accounts(id, email, password, first_name, last_name, balance) VALUES(8, 'getProfileUserByEmail@test.fr', 'password', 'getProfileUserByEmailSuccess', 'testLastName', 100);
INSERT INTO bank_accounts(id, name, balance, id_user_account) VALUES(15, 'Caisse d''epargne', 100, 8);
INSERT INTO bank_accounts(id, name, balance, id_user_account) VALUES(16, 'Boursorama', 100, 8);
--
-- BankAccountServiceTest
-- BankAccountServiceTest::testgetBalance
INSERT INTO user_accounts(id, email, password, first_name, last_name, balance) VALUES(9, 'creditBalance@test.fr', 'password', 'testName', 'testLastName', 100);
INSERT INTO bank_accounts(id, name, balance, id_user_account) VALUES(17, 'Caisse d''epargne', 132, 9);
INSERT INTO bank_accounts(id, name, balance, id_user_account) VALUES(18, 'Boursorama', 100, 9);
-- BankAccountServiceTest::testWithdrawForBankSuccess
INSERT INTO user_accounts(id, email, password, first_name, last_name, balance) VALUES(10, 'testWithdrawForBank@test.fr', 'password', 'testName', 'testLastName', 100);
INSERT INTO bank_accounts(id, name, balance, id_user_account) VALUES(19, 'Caisse d''epargne', 100, 10);
INSERT INTO bank_accounts(id, name, balance, id_user_account) VALUES(20, 'Boursorama', 100, 10);
-- BankAccountServiceTest::testWithdrawForBankFailure
INSERT INTO user_accounts(id, email, password, first_name, last_name, balance) VALUES(11, 'testWithdrawForBank@test.fr', 'password', 'testName', 'testLastName', 100);
INSERT INTO bank_accounts(id, name, balance, id_user_account) VALUES(21, 'Caisse d''epargne', 100, 10);
INSERT INTO bank_accounts(id, name, balance, id_user_account) VALUES(22, 'Boursorama', 100, 10);
--
-- UserAccountServiceTest
-- UserAccountServiceTest::testgetBalance
INSERT INTO user_accounts(id, email, password, first_name, last_name, balance) VALUES(12, 'testgetBalance@test.fr', 'password', 'testName', 'testLastName', 40);
INSERT INTO bank_accounts(id, name, balance, id_user_account) VALUES(23, 'Caisse d''epargne', 20, 12);
INSERT INTO bank_accounts(id, name, balance, id_user_account) VALUES(24, 'Boursorama', 200, 12);
-- UserAccountServiceTest::testGetUser
INSERT INTO user_accounts(id, email, password, first_name, last_name, balance) VALUES(13, 'testGetUser@test.fr', 'passwordtestGetUser', 'FirstNametestGetUser', 'LastNametestGetUser', 40);
INSERT INTO bank_accounts(id, name, balance, id_user_account) VALUES(25, 'Caisse d''epargne', 20, 13);
INSERT INTO bank_accounts(id, name, balance, id_user_account) VALUES(26, 'Boursorama', 200, 13);
-- UserAccountServiceTest::testFindBankAccounts
INSERT INTO user_accounts(id, email, password, first_name, last_name, balance) VALUES(14, 'testGetUser@test.fr', 'password', 'testName', 'testLastName', 100);
INSERT INTO bank_accounts(id, name, balance, id_user_account) VALUES(27, 'Caisse d''epargne', 20, 14);
INSERT INTO bank_accounts(id, name, balance, id_user_account) VALUES(28, 'Boursorama', 200, 14);
-- UserAccountServiceTest::testCredit
INSERT INTO user_accounts(id, email, password, first_name, last_name, balance) VALUES(15, 'testCredit@test.fr', 'passwordtestGetUser', 'FirstNametestGetUser', 'LastNametestGetUser', 100);
INSERT INTO bank_accounts(id, name, balance, id_user_account) VALUES(29, 'Caisse d''epargne', 20, 15);
INSERT INTO bank_accounts(id, name, balance, id_user_account) VALUES(30, 'Boursorama', 200, 15);
-- UserAccountServiceTest:: testGetUserByEmail
INSERT INTO user_accounts(id, email, password, first_name, last_name, balance) VALUES(16, 'testgetUserByEmail@test.fr', 'passwordtestGetUser', 'FirstNamegetUserByEmail', 'LastNamegetUserByEmail', 100);
INSERT INTO bank_accounts(id, name, balance, id_user_account) VALUES(31, 'Caisse d''epargne', 20, 16);
INSERT INTO bank_accounts(id, name, balance, id_user_account) VALUES(32, 'Boursorama', 200, 16);
--
-- UserFriendBusinessServiceTest
-- UserFriendBusinessServiceTest::testAddNewFriend
INSERT INTO user_accounts(id, email, password, first_name, last_name, balance) VALUES(17, 'testAddNewFriend@test.fr', 'password', 'testName', 'testLastName', 100);
INSERT INTO bank_accounts(id, name, balance, id_user_account) VALUES(33, 'Caisse d''epargne', 20, 17);
INSERT INTO bank_accounts(id, name, balance, id_user_account) VALUES(34, 'Boursorama', 200, 17);
INSERT INTO user_accounts(id, email, password, first_name, last_name, balance) VALUES(18, 'NewFriend@test.fr', 'password', 'NewFriend', 'testLastName', 100);
INSERT INTO bank_accounts(id, name, balance, id_user_account) VALUES(35, 'Caisse d''epargne', 20, 18);
INSERT INTO bank_accounts(id, name, balance, id_user_account) VALUES(36, 'Boursorama', 200, 18);
