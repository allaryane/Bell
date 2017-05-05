DROP SCHEMA IF EXISTS bell;
CREATE SCHEMA bell;

DROP TABLE IF EXISTS bell.cart;
CREATE TABLE bell.cart (
  id int(10) unsigned NOT NULL AUTO_INCREMENT,
  user_id smallint(6) NOT NULL,
  product_id smallint(6) NOT NULL,
  quantity int(11) NOT NULL,
  created_date datetime NOT NULL,
  modified_date datetime DEFAULT NULL,
  PRIMARY KEY (id)
);

DROP TABLE IF EXISTS bell.catalog;
CREATE TABLE bell.catalog (
  id smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  name_en varchar(100) NOT NULL,
  name_fr varchar(100) NOT NULL,
  description_en varchar(500) NOT NULL,
  description_fr varchar(500) NOT NULL,
  created_date datetime NOT NULL,
  modified_date datetime DEFAULT NULL,
  PRIMARY KEY (id)
);

DROP TABLE IF EXISTS bell.mark;
CREATE TABLE bell.mark (
  id smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  name varchar(100) NOT NULL,
  description_en varchar(500) NOT NULL,
  description_fr varchar(500) NOT NULL,
  product_type_id smallint(5) unsigned NOT NULL,
  created_date datetime NOT NULL,
  modified_date datetime DEFAULT NULL,
  PRIMARY KEY (id)
);

DROP TABLE IF EXISTS bell.product;
CREATE TABLE bell.product (
  id smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  name_en varchar(100) NOT NULL,
  name_fr varchar(100) NOT NULL,
  description_en text NOT NULL,
  description_fr text NOT NULL,
  price decimal(10,2) NOT NULL,
  created_date datetime NOT NULL,
  modified_date datetime DEFAULT NULL,
  active tinyint(1) unsigned NOT NULL DEFAULT '1',
  catalog_id smallint(6) unsigned NOT NULL,
  product_type_id smallint(6) unsigned NOT NULL,
  mark_id smallint(6) NOT NULL,
  PRIMARY KEY (id)
);

DROP TABLE IF EXISTS bell.product_type;
CREATE TABLE bell.product_type (
  id smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  name_en varchar(100) NOT NULL,
  name_fr varchar(100) NOT NULL,
  created_date datetime NOT NULL,
  modified_date datetime DEFAULT NULL,
  PRIMARY KEY (id)
);

DROP TABLE IF EXISTS bell.user;
CREATE TABLE bell.user (
  id smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  first_name varchar(100) NOT NULL,
  last_name varchar(100) NOT NULL,
  email varchar(250) NOT NULL,
  password varchar(100) NOT NULL,
  created_date datetime NOT NULL,
  modified_date datetime DEFAULT NULL,
  active tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (id)
);

