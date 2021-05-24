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

INSERT INTO users (id, email, first_name, last_name, password, ROLE , user_name)
VALUES
(1, 'admin@admin.com', 'Admin', 'Admin', '$2y$12$pt3b9lsi9Pu9d5QcC2bZDegHYMNBMXU2tmJneJeoafiRNBe2966n6', 'ROLE_ADMIN', 'admin'),
(2, 'hello@gmail.com', 'Nikola', 'Zigic', '$2y$12$7xGsRfmnTojYLY8gkUpvhuutxSc3/AaJ2YvkVWkUUVbmCI1MSgUXW', 'ROLE_ADMIN', 'nzigic'), --hello
(3, 'bastarh@gmail.com', 'Basta', 'Rimes', '$2y$12$RtCsRMORp.aDEMljs1vOJ.B9sxjnxyJgGnKOA1iJBXt3Z142q4Wm6','ROLE_USER', 'bastarh'), --rhimesbasta
(4, 'petar12@yahoo.com', 'Petar', 'Petrovic', '$2y$12$dr7FhlW0OwN8TpfWe7/4qO9xKEZm4WTT.zw3.WBpLKvMbKo01smT2','ROLE_USER', 'ppetar'), --njegos
(5, 'rasputchin@hotmail.com', 'Nikola', 'Raspucin', '$2y$12$W7zjrcp4ObDFrdIplLWyoOM0derUmLU9Dk2LB7m6Fe2wZpGq6UXRu','ROLE_USER', 'raspuchin'), --raspy132
(6, 'brave@usnet.com', 'Robin', 'Hud', '$2y$12$JTP1VZK.qreBltvsdQII5O1d2r1LcHK2fxyNLliPpIqBYNZ6EfLmO', 'ROLE_USER','robinhud'), --england
(7, 'ricard@engleska.en', 'Ricard', 'Lavljesrce', '$2y$12$pUfy04Y7dDGFM04VqUICPOaum.JPywtBIgR68LkKUx1VUcl7oPtZO','ROLE_USER', 'lavic'); --krstaskirat

INSERT INTO rentedbooks (date_of_renting, user_id, book_copy_id, book_id)
VALUES
('2020-07-19', 2, 1, 1),
('2020-07-11', 3, 3, 1),
('2020-07-10', 4, 2, 1),
('2020-07-01', 7, 11, 6),
('2020-06-12', 5, 12, 6);

INSERT INTO archives (id, book_copy_id, book_id, date_of_renting, date_of_returning, user_id)
VALUES
(1, 2, 1, '2020-07-15', '2020-07-30', 2),
(2, 8, 4, '2020-05-05', '2020-05-30', 3),
(3, 14, 7, '2020-05-15', '2020-05-25', 5),
(4, 2, 1, '2020-02-01', '2020-04-01', 5),
(5, 3, 1, '2020-01-25', '2020-03-01', 4),
(6, 6, 3, '2020-04-19', '2020-05-02', 7),
(7, 13, 6, '2020-02-20', '2020-03-25', 6);