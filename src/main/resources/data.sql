insert into books (author_name, date_of_publishing, publisher, title)
values
('Miljneko Cutuk', '2020-05-05', 'Laguna', 'Mostarski Skok'),
('Tejsi Ris', '1984-02-22', 'Penguin', 'Pescani Sat'),
('Tim Hob', '1999-12-24', 'Pulsar', 'Godina Zmaja'),
('Filip Visnjic', '1980-05-01', 'Zvezda', 'Karadjordje i Turci'),
('Marinko Rokvic', '1978-09-12', 'Juzni vetar', 'Zapevajmo Slozno'),
('Dijego Maradona', '2001-04-29', 'Omladinska Knjiga', 'Magicna Ruka'),
('Nikola Zigic', '1998-11-28', 'Plava Ptica', 'Strategija Kontre');

INSERT INTO bookcopyies (id, serial_number, book_id)
VALUES
(1, '563281ff-de00-4d28-9f56-49426cf668bf', 1),
(2, '222160cc-cac4-11ea-87d0-0242ac130003', 1),
(3, '464618a8-cac4-11ea-87d0-0242ac130003', 1),
(4, '4ff7144c-cac4-11ea-87d0-0242ac130003', 2),
(5, '7856509e-529b-46ce-93a8-268679d02f57', 2),
(6, '7a893adc-cac4-11ea-87d0-0242ac130003', 3),
(7, '8a7c29c2-cac4-11ea-87d0-0242ac130003', 3),
(8, '0b11d76c-9dea-4074-bea3-3dacdbe4d054', 4),
(9, 'c4f4ce1a-9119-41de-87f4-cfd19133c24d', 4),
(10, '57f99c5e-3fb4-4131-af0f-2d0fdb7e4d9a', 5),
(11, '563281ff-de00-4d28-9f56-49426cf668bf', 6),
(12, '2437d313-9a66-4ff1-bc15-fee139913dfe', 6),
(13, '225442d0-a31c-4755-9322-fd9847d7f89f', 6),
(14, '54f7aac4-746b-40e1-a461-7ffda76633c0', 7);

INSERT INTO users (id, email, first_name, last_name, password, user_name)
VALUES
(1, 'hello@gmail.com', 'Nikola', 'Zigic', 'hello', 'nzigic'),
(2, 'bastarh@gmail.com', 'Basta', 'Rimes', 'rhimesbasta', 'bastarh'),
(3, 'petar12@yahoo.com', 'Petar', 'Petrovic', 'njegos', 'ppetar'),
(4, 'rasputchin@hotmail.com', 'Nikola', 'Raspucin', 'raspy132', 'raspuchin'),
(5, 'brave@usnet.com', 'Robin', 'Hud', 'england', 'robinhud'),
(6, 'ricard@engleska.en', 'Ricard', 'Lavljesrce', 'krstaskirat', 'lavic');

INSERT INTO rentedbooks (date_of_renting, user_id, book_copy_id, book_id)
VALUES
('2020-07-19', 1, 1, 1),
('2020-07-11', 2, 3, 1),
('2020-07-10', 3, 2, 1),
('2020-07-01', 6, 11, 6),
('2020-06-12', 4, 12, 6);

INSERT INTO archives (id, book_copy_id, book_id, date_of_renting, date_of_returning, user_id)
VALUES
(1, 2, 1, '2020-07-15', '2020-07-30', 1),
(2, 8, 4, '2020-05-05', '2020-05-30', 2),
(3, 14, 7, '2020-05-15', '2020-05-25', 4),
(4, 2, 1, '2020-02-01', '2020-04-01', 4),
(5, 3, 1, '2020-01-25', '2020-03-01', 3),
(6, 6, 3, '2020-04-19', '2020-05-02', 6),
(7, 13, 6, '2020-02-20', '2020-03-25', 5);