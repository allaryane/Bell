-- phpMyAdmin SQL Dump
-- version 3.5.7
-- http://www.phpmyadmin.net
--
-- Client: localhost
-- Généré le: Ven 05 Mai 2017 à 15:02
-- Version du serveur: 5.5.29
-- Version de PHP: 5.4.10

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Base de données: `bell`
--

-- --------------------------------------------------------

--
-- Structure de la table `cart`
--

CREATE TABLE `cart` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` smallint(6) NOT NULL,
  `product_id` smallint(6) NOT NULL,
  `quantity` int(11) NOT NULL,
  `created_date` datetime NOT NULL,
  `modified_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=18 ;

--
-- Contenu de la table `cart`
--

INSERT INTO `cart` (`id`, `user_id`, `product_id`, `quantity`, `created_date`, `modified_date`) VALUES
(1, 1, 2, 1, '2017-05-05 03:36:29', NULL),
(2, 1, 2, 3, '2017-05-05 03:36:29', NULL),
(3, 2, 9, 4, '2017-05-05 03:37:27', NULL),
(4, 2, 5, 11, '2017-05-05 03:37:27', NULL),
(14, 1, 6, 4, '2017-05-05 07:40:01', NULL),
(16, 1, 9, 2, '2017-05-05 07:40:27', NULL),
(17, 1, 11, 19, '2017-05-05 07:46:14', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `catalog`
--

CREATE TABLE `catalog` (
  `id` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `name_en` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `name_fr` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `description_en` varchar(500) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `description_fr` varchar(500) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `created_date` datetime NOT NULL,
  `modified_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=11 ;

--
-- Contenu de la table `catalog`
--

INSERT INTO `catalog` (`id`, `name_en`, `name_fr`, `description_en`, `description_fr`, `created_date`, `modified_date`) VALUES
(1, 'Winter Catalog', 'Catalogue Hiver', '...', '...', '2017-05-01 05:26:50', NULL),
(2, 'Summer Catalog', 'Catalogue Été', '...', '...', '2017-05-01 05:25:49', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `mark`
--

CREATE TABLE `mark` (
  `id` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `description_en` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `description_fr` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  `product_type_id` smallint(5) unsigned NOT NULL,
  `created_date` datetime NOT NULL,
  `modified_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=8 ;

--
-- Contenu de la table `mark`
--

INSERT INTO `mark` (`id`, `name`, `description_en`, `description_fr`, `product_type_id`, `created_date`, `modified_date`) VALUES
(1, 'Nike', '1st Sport Mark ...', '1ère Marque De Sport ...', 1, '2017-05-02 06:05:40', NULL),
(2, 'Adidas', '2nd Sport Mark ...', '2ème Marque De Sport ...', 1, '2017-05-02 06:05:40', NULL),
(3, 'Converse', 'Street Shoes Mark (Chuck Taylor) ...', 'Marque De Chaussures De Ville (Chuck Taylor) ...', 1, '2017-05-02 06:08:01', NULL),
(4, 'U-Boat', 'Luxury Watches ...', 'Montres De Luxe ...', 2, '2017-05-02 06:08:01', NULL),
(5, 'Diesel', 'Jeans, Clothing, Shoes, Bags & Watches ...', 'Jeans, Vêtements, Chaussures, Sacs & Montres ...', 2, '2017-05-02 06:12:26', NULL),
(6, 'Tissot', 'Switzerland Luxury Watches ...', 'Montres De Luxe Suisse ...', 2, '2017-05-02 06:12:26', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `product`
--

CREATE TABLE `product` (
  `id` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `name_en` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `name_fr` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `description_en` text CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `description_fr` text CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `price` decimal(10,2) NOT NULL,
  `created_date` datetime NOT NULL,
  `modified_date` datetime DEFAULT NULL,
  `active` tinyint(1) unsigned NOT NULL DEFAULT '1',
  `catalog_id` smallint(6) unsigned NOT NULL,
  `product_type_id` smallint(6) unsigned NOT NULL,
  `mark_id` smallint(6) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=29 ;

--
-- Contenu de la table `product`
--

INSERT INTO `product` (`id`, `name_en`, `name_fr`, `description_en`, `description_fr`, `price`, `created_date`, `modified_date`, `active`, `catalog_id`, `product_type_id`, `mark_id`) VALUES
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

-- --------------------------------------------------------

--
-- Structure de la table `product_type`
--

CREATE TABLE `product_type` (
  `id` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `name_en` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `name_fr` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `created_date` datetime NOT NULL,
  `modified_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=7 ;

--
-- Contenu de la table `product_type`
--

INSERT INTO `product_type` (`id`, `name_en`, `name_fr`, `created_date`, `modified_date`) VALUES
(1, 'Shoes', 'Chaussures', '2017-05-05 12:00:00', NULL),
(2, 'Watches', 'Montres', '2017-05-03 19:43:00', NULL),
(3, 'Smart Phone', 'Smart Phone', '2017-05-20 00:28:00', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `id` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `first_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `last_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(250) COLLATE utf8_bin NOT NULL,
  `password` varchar(100) COLLATE utf8_bin NOT NULL,
  `created_date` datetime NOT NULL,
  `modified_date` datetime DEFAULT NULL,
  `active` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=6 ;

--
-- Contenu de la table `user`
--

INSERT INTO `user` (`id`, `first_name`, `last_name`, `email`, `password`, `created_date`, `modified_date`, `active`) VALUES
(1, 'Ryane', 'Alla', 'allaryane@gmail.com', '123456789#', '2017-05-02 06:14:24', NULL, 1),
(2, 'Steve', 'Jobs', 'steve.jobs@apple.com', '123456789S', '2017-05-02 06:14:24', NULL, 1);
