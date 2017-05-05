INSERT INTO bell.cart (id, user_id, product_id, quantity, created_date, modified_date) VALUES
(1, 1, 2, 1, '2017-05-05 03:36:29', NULL),
(2, 1, 2, 3, '2017-05-05 03:36:29', NULL),
(3, 2, 9, 4, '2017-05-05 03:37:27', NULL),
(4, 2, 5, 11, '2017-05-05 03:37:27', NULL),
(14, 1, 6, 4, '2017-05-05 07:40:01', NULL),
(16, 1, 9, 2, '2017-05-05 07:40:27', NULL),
(17, 1, 11, 19, '2017-05-05 07:46:14', NULL);

INSERT INTO bell.catalog (id, name_en, name_fr, description_en, description_fr, created_date, modified_date) VALUES
(1, 'Winter Catalog', 'Catalogue Hiver', '...', '...', '2017-05-01 05:26:50', NULL),
(2, 'Summer Catalog', 'Catalogue Été', '...', '...', '2017-05-01 05:25:49', NULL);

INSERT INTO bell.mark (id, name, description_en, description_fr, product_type_id, created_date, modified_date) VALUES
(1, 'Nike', '1st Sport Mark ...', '1ère Marque De Sport ...', 1, '2017-05-02 06:05:40', NULL),
(2, 'Adidas', '2nd Sport Mark ...', '2ème Marque De Sport ...', 1, '2017-05-02 06:05:40', NULL),
(3, 'Converse', 'Street Shoes Mark (Chuck Taylor) ...', 'Marque De Chaussures De Ville (Chuck Taylor) ...', 1, '2017-05-02 06:08:01', NULL),
(4, 'U-Boat', 'Luxury Watches ...', 'Montres De Luxe ...', 2, '2017-05-02 06:08:01', NULL),
(5, 'Diesel', 'Jeans, Clothing, Shoes, Bags & Watches ...', 'Jeans, Vêtements, Chaussures, Sacs & Montres ...', 2, '2017-05-02 06:12:26', NULL),
(6, 'Tissot', 'Switzerland Luxury Watches ...', 'Montres De Luxe Suisse ...', 2, '2017-05-02 06:12:26', NULL);


INSERT INTO bell.product (id, name_en, name_fr, description_en, description_fr, price, created_date, modified_date, active, catalog_id, product_type_id, mark_id) VALUES
(1, 'Nike Shox', 'Nike Shox', 'Shox Description ...', 'Description Shox ...', 220.00, '2017-05-01 05:33:38', NULL, 1, 1, 1, 1),
(2, 'Kobe 10', 'Kobe 10', 'NBA Shoes By Kobe Bryant ...', 'Chaussures de Basketball (NBA) de Kobe Bryant ...', 110.00, '2017-05-01 05:33:38', NULL, 1, 2, 1, 1),
(3, 'Boost Shoes', 'Boost Shoes', 'Set your new pace in these men''s shoes built with ultra-cushioned boost.', 'Trouve ton rythme avec cette chaussure hommes équipée de l''amorti dynamique boost', 85.50, '2017-05-01 06:31:50', NULL, 1, 2, 1, 2),
(4, 'CRAZY EXPLOSIVE LOW PRIMEKNIT SHOES', 'CRAZY EXPLOSIVE LOW PRIMEKNIT SHOES', 'Blow past defenders with an explosive first step. Lightweight and quick in transition, these basketball shoes are built for the player who thrives on unpredictability.', 'Transperce la défense adverse avec un jeu explosif. Légère et réactive, cette chaussure de basketball est conçue pour les joueurs imprévisibles sur le parquet', 45.95, '2017-05-01 06:31:50', NULL, 1, 1, 1, 2),
(5, 'Lebron James 14', 'Lebron James 14', 'NBA Shoes By Lebron James 2014 ...', 'Chaussures de Basketball (NBA) de Lebron James 2014 ...', 290.00, '2017-05-02 01:42:31', NULL, 1, 2, 1, 1),
(6, 'Lebron James 13', 'Lebron James 13', 'NBA Shoes By Lebron James 2013 ...', 'Chaussures de Basketball (NBA) de Lebron James 2013 ...', 320.00, '2017-05-02 01:43:38', NULL, 1, 1, 1, 1),
(7, 'Harden Vol. 1', 'Harden Vol. 1', 'James Harden dropped 37 points in his debut with the Rockets, and he''s been on fire ever since.', 'James Harden a inscrit 37 points dans ses débuts avec les Rockets, et est en feu depuis.', 260.00, '2017-05-02 02:22:11', NULL, 1, 1, 1, 2),
(8, 'ALL STAR LIGHT ACOUSTIC HI', 'ALL STAR LIGHT ACOUSTIC HI', 'Sneaker High - Black.', 'Haute Sneaker - Noire.', 90.00, '2017-05-22 16:41:58', NULL, 1, 1, 1, 3),
(9, 'U-Boat U.25', 'U-Boat U.25', 'Flightdeck Black Dial Automatic Chronograph Men''s Watch ...', 'Flightdeck Black Dial Automatic Chronograph Montre Homme ...', 1995.50, '2017-05-11 11:42:31', NULL, 1, 2, 2, 4),
(10, 'U-Boat U.21', 'U-Boat U.21', 'Flightback Eclipse 50 Automatic Men''s Watch ...', 'Flightback Eclipse 50 Automatic Montre Homme ...', 11000.00, '2017-05-12 21:13:38', NULL, 1, 1, 2, 4),
(11, 'Diesel DZ7198', 'Diesel DZ7198', 'Digital Dial Red Rubber Strap Men''s Watch.', 'Montre en caoutchouc rouge à ruban rouge.', 100.00, '2017-08-19 18:22:11', NULL, 1, 1, 2, 5),
(12, 'Tissot T019.430.16.031.01', 'Tissot T019.430.16.031.01', 'Heritage Visodate Automatic Montre Homme.', 'Haute Sneaker - Noire.', 875.00, '2016-07-22 16:41:58', NULL, 1, 2, 2, 6),
(17, 'P. Name EN', 'P. Name FR', 'Desc. Name EN ...', 'Desc. Name FR ...', 10.50, '2017-05-04 11:59:07', NULL, 0, 1, 1, 1);

INSERT INTO bell.product_type (id, name_en, name_fr, created_date, modified_date) VALUES
(1, 'Shoes', 'Chaussures', '2017-05-05 12:00:00', NULL),
(2, 'Watches', 'Montres', '2017-05-03 19:43:00', NULL),
(3, 'Smart Phone', 'Smart Phone', '2017-05-20 00:28:00', NULL);

INSERT INTO bell.user (id, first_name, last_name, email, password, created_date, modified_date, active) VALUES
(1, 'Ryane', 'Alla', 'allaryane@gmail.com', '123456789#', '2017-05-02 06:14:24', NULL, 1),
(2, 'Steve', 'Jobs', 'steve.jobs@apple.com', '123456789S', '2017-05-02 06:14:24', NULL, 1);
