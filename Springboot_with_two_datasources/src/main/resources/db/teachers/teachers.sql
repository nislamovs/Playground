CREATE DATABASE IF NOT EXISTS db1 ;
use db1 ;

CREATE TABLE IF NOT EXISTS teachers (
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
	firstname VARCHAR(50),
	lastname VARCHAR(50),
	email VARCHAR(50) UNIQUE,
	birthdate DATE

) ENGINE = InnoDB DEFAULT CHARSET = UTF8;


insert into teachers (id, firstname, lastname, email, birthdate) values (1, 'Marshall', 'Dalmon', 'mdalmon0@gmail.com', STR_TO_DATE('09/24/1982', '%m/%d/%Y'));
insert into teachers (id, firstname, lastname, email, birthdate) values (2, 'Malvina', 'Woodworth', 'mwoodworth1@gmail.com', STR_TO_DATE('05/03/1970', '%m/%d/%Y'));
insert into teachers (id, firstname, lastname, email, birthdate) values (3, 'Ludovika', 'Dagon', 'ldagon2@inbox.lv', STR_TO_DATE('02/25/1963', '%m/%d/%Y'));
insert into teachers (id, firstname, lastname, email, birthdate) values (4, 'Jameson', 'Ludlom', 'jludlom3@inbox.lv', STR_TO_DATE('02/14/1979', '%m/%d/%Y'));
insert into teachers (id, firstname, lastname, email, birthdate) values (5, 'Melonie', 'Doveston', 'mdoveston4@youku.com', STR_TO_DATE('03/22/1971', '%m/%d/%Y'));
insert into teachers (id, firstname, lastname, email, birthdate) values (6, 'Arin', 'Marcinkowski', 'amarcinkowski5@inbox.lv', STR_TO_DATE('08/12/1970', '%m/%d/%Y'));
insert into teachers (id, firstname, lastname, email, birthdate) values (7, 'Lise', 'Prevost', 'lprevost6@craigslist.org', STR_TO_DATE('07/15/1982', '%m/%d/%Y'));
insert into teachers (id, firstname, lastname, email, birthdate) values (8, 'Carine', 'Willimott', 'cwillimott7@yahoo.com', STR_TO_DATE('04/04/1962', '%m/%d/%Y'));
insert into teachers (id, firstname, lastname, email, birthdate) values (9, 'Thorn', 'Joscelin', 'tjoscelin8@hibu.com', STR_TO_DATE('08/17/1964', '%m/%d/%Y'));
insert into teachers (id, firstname, lastname, email, birthdate) values (10, 'Kinsley', 'Bullingham', 'kbullingham9@boston.com',  STR_TO_DATE('07/21/1973', '%m/%d/%Y'));
insert into teachers (id, firstname, lastname, email, birthdate) values (11, 'Torry', 'Croke', 'tcrokea@networksolutions.com', STR_TO_DATE('08/31/1981', '%m/%d/%Y'));
insert into teachers (id, firstname, lastname, email, birthdate) values (12, 'Adrian', 'Dobrowolski', 'adobrowolskib@mail.ru', STR_TO_DATE('08/19/1972', '%m/%d/%Y'));