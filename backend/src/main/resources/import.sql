INSERT INTO products (id, author, category, description, image_url, price, product_name, discount_type)  VALUES (1, 'Andrzej Sapkowski', 1, 'Fantastyka',  'https://cf2-taniaksiazka.statiki.pl/images/popups/123/68007901377KS.jpg', 31.3, 'Ostatnie Życzenie',1),  (2, 'Andrzej Sapkowski', 1, 'Fantastyka',  'https://cf2-taniaksiazka.statiki.pl/images/popups/123/68007901377KS.jpg', 32.3, 'Miecz Przeznaczenia', 1),  (3, 'Andrzej Sapkowski', 1, 'Fantastyka',  'https://cf2-taniaksiazka.statiki.pl/images/popups/123/68007901377KS.jpg', 33.3, 'Krew Elfów', 1),  (4, 'Andrzej Sapkowski', 1, 'Fantastyka',  'https://cf2-taniaksiazka.statiki.pl/images/popups/123/68007901377KS.jpg', 34.3, 'Czas Pogardy', 1),  (5, 'Andrzej Sapkowski', 1, 'Fantastyka',  'https://cf2-taniaksiazka.statiki.pl/images/popups/123/68007901377KS.jpg', 35.3, 'Chrzest Ognia', 1),  (6, 'Andrzej Sapkowski', 1, 'Fantastyka',  'https://cf2-taniaksiazka.statiki.pl/images/popups/123/68007901377KS.jpg', 36.3, 'Wieża Jaskółki', 1),  (7, 'Andrzej Sapkowski', 1, 'Fantastyka',  'https://cf2-taniaksiazka.statiki.pl/images/popups/123/68007901377KS.jpg', 37.3, 'Pani Jeziora', 2),  (8, 'Andrzej Sapkowski', 1, 'Fantastyka',  'https://cf2-taniaksiazka.statiki.pl/images/popups/123/68007901377KS.jpg', 38.3, 'Sezon Burz', 2),  (9, 'Różni', 1, 'description', 'https://cf2-taniaksiazka.statiki.pl/images/popups/123/68007901377KS.jpg', 32,  'Szpony i Kły', 2),  (10, 'Andrzej Sapkowski', 1, 'Fantastyka',  'https://cf2-taniaksiazka.statiki.pl/images/popups/123/68007901377KS.jpg', 31.3, 'Ostatnie Życzenie',0);
insert into clients (id,address,nip,blocked,email,enabled,first_name,last_name,login,password,phone_number,token_expired) values (1,'address 123/123','nip',false,'e1@c.com',true,'employee','one','e1','$2y$12$8wK6n5F4erTCl206bR7em.x4LuYW3ytBtEFpGntvbxEkW9mF0lNMW','123456789',false), (2,'address 321/123','nip',false,'e2@c.com',true,'employee','two','e2','$2y$12$8wK6n5F4erTCl206bR7em.x4LuYW3ytBtEFpGntvbxEkW9mF0lNMW','123456789',false);

INSERT INTO ROLE (ID, NAME) VALUES (1, 'ROLE_ADMIN'), (2, 'ROLE_EMPLOYEE');
INSERT INTO PRIVILEGE (ID, NAME) VALUES (1, 'PRIVILEGE_FOR_ROLE_ADMIN_1'), (2, 'PRIVILEGE_FOR_ROLE_EMPLOYEE_1');
INSERT INTO ROLES_PRIVILEGES (ROLE_ID, PRIVILEGE_ID) VALUES (1, 1), (1, 2), (2, 2);
INSERT INTO CLIENTS_ROLES (clients_ID, ROLE_ID) VALUES (1, 1), (2, 2);


SELECT setval('products_id_seq', max(id))  FROM products;
SELECT setval('clients_id_seq', max(id))  FROM clients;
SELECT setval('ROLE_id_seq', max(id))  FROM ROLE;
SELECT setval('PRIVILEGE_id_seq', max(id))  FROM PRIVILEGE;
