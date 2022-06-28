INSERT INTO m_users (username, surname, birth_date, gender, login, password, passport, car_n, e_mail, phone) VALUES ('pasha', 'fey', '1995-10-27', 'MALE', 'loginpasha', 'password', 'MP2223323', null, null, null);
INSERT INTO m_users (username, surname, birth_date, gender, login, password, passport, car_n, e_mail, phone) VALUES ('vlad', 'hors', '1986-10-27', 'MALE', 'loginvlad', 'password', 'MP2223326', null, null, null);
INSERT INTO m_users (username, surname, birth_date, gender, login, password, passport, car_n, e_mail, phone) VALUES ('dasha', 'gye', '1998-10-27', 'FEMALE', 'logindasha', 'password', 'MP2223322', null, null, null);
INSERT INTO m_users (username, surname, birth_date, gender, login, password, passport, car_n, e_mail, phone) VALUES ('gena', 'join', '1996-10-27', 'MALE', 'logingena', 'password', 'MP2223327', null, null, null);
INSERT INTO m_users (username, surname, birth_date, gender, login, password, passport, car_n, e_mail, phone) VALUES ('test1', 'test1', '1999-06-14', 'MALE1', 'TEST1', null, 'TEST1', 8, 'qaWFEFf@gmail.com', '+375110001100');
INSERT INTO m_users (username, surname, birth_date, gender, login, password, passport, car_n, e_mail, phone) VALUES ('sasha', 'testProject', '2020-12-04', 'MALE', 'sasha', null, 'MP9999999', 5, 'tsybinsasha5@gmail.com', '+3751110011');

INSERT INTO m_cars (model, guarantee_expiration_date, price_rent, colors, creation, capacity_l, country_of_creation, brand, rent) VALUES ('17', '2030-01-01', 30000, 'red', '2014-10-27', 4, 'Germany', 'audi', true);
INSERT INTO m_cars (model, guarantee_expiration_date, price_rent, colors, creation, capacity_l, country_of_creation, brand, rent) VALUES ('20', '2030-01-01', 1000, 'red', '2015-10-27', 2, 'Germany', 'ravon', true);
INSERT INTO m_cars (model, guarantee_expiration_date, price_rent, colors, creation, capacity_l, country_of_creation, brand, rent) VALUES ('7', '2020-10-27', 400, 'black', '2014-10-27', 3, 'Germany', 'mini', true);
INSERT INTO m_cars (model, guarantee_expiration_date, price_rent, colors, creation, capacity_l, country_of_creation, brand, rent) VALUES ('14', '2029-10-27', 40000, 'blue', '2013-10-27', 3.5, 'Germany', 'bmw', true);
INSERT INTO m_cars (model, guarantee_expiration_date, price_rent, colors, creation, capacity_l, country_of_creation, brand, rent) VALUES ('15', '2022-10-27', 200, 'red', '2020-10-27', 2, 'Germany', 'mercedesBenz', true);
INSERT INTO m_cars (model, guarantee_expiration_date, price_rent, colors, creation, capacity_l, country_of_creation, brand, rent) VALUES ('16', '2029-01-01', 2000, 'red', '2019-10-27', 1, 'Lithuania', 'cadillac', false);
INSERT INTO m_cars (model, guarantee_expiration_date, price_rent, colors, creation, capacity_l, country_of_creation, brand, rent) VALUES ('4', '2023-10-27', 50000, 'red', '2019-10-27', 1.6, 'Russia', 'kia', true);
INSERT INTO m_cars (model, guarantee_expiration_date, price_rent, colors, creation, capacity_l, country_of_creation, brand, rent) VALUES ('6', '2024-10-27', 350, 'grey', '2020-10-27', 3, 'Germany', 'changan', true);

INSERT INTO m_contract (user_id, car_id, id, name_contract, time_rent_start, time_rent_end) VALUES (389, 8, 112, 'TEST1', '2020-12-29', '2020-12-29');

INSERT INTO m_auto_dealer (name, address, capacity, created, changed, year_of_foundation) VALUES ('carshome', 'Belarus', 10, '2019-10-27 19:36:59.000000', '2020-10-27 19:37:07.000000', '2011-10-28');
INSERT INTO m_auto_dealer (name, address, capacity, created, changed, year_of_foundation) VALUES ('cars', 'Germany', 5, '2000-10-27 19:35:23.000000', '2017-10-27 19:35:39.000000', '1998-10-27');
INSERT INTO m_auto_dealer (name, address, capacity, created, changed, year_of_foundation) VALUES ('russiancars', 'Russia', 15, '2020-10-27 19:38:07.000000', '2020-10-27 19:38:31.000000', '2016-10-27');

INSERT INTO m_accident (damages, data_accident, price_damages, contract_id) VALUES ('ТРУХА', '2020-12-29', 10000000000, 112);