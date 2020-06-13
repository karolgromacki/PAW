INSERT INTO products (id, author, category, description, image, price, product_name) VALUES
(0, 'Andrzej Sapkowski',1, 'Fantastyka', 1, 31.3, 'Ostatnie Życzenie')
,(1, 'Andrzej Sapkowski',1, 'Fantastyka', 1, 31.3, 'Ostatnie Życzenie')
,(2, 'Andrzej Sapkowski',1, 'Fantastyka', 2, 32.3, 'Miecz Przeznaczenia')
,(3, 'Andrzej Sapkowski',1, 'Fantastyka', 3, 33.3, 'Krew Elfów')
,(4, 'Andrzej Sapkowski',1, 'Fantastyka', 4, 34.3, 'Czas Pogardy')
,(5, 'Andrzej Sapkowski',1, 'Fantastyka', 5, 35.3, 'Chrzest Ognia')
,(6, 'Andrzej Sapkowski',1, 'Fantastyka', 6, 36.3, 'Wieża Jaskółki')
,(7, 'Andrzej Sapkowski',1, 'Fantastyka', 7, 37.3, 'Pani Jeziora')
,(8, 'Andrzej Sapkowski',1, 'Fantastyka', 8, 38.3, 'Sezon Burz')
,(9, 'Różni',1, 'description', 9, 32, 'Szpony i Kły');
--
--
--SELECT setval('products_id_seq', max(id))FROM products;