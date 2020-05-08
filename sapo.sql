-- --------------------------------------------------------
-- Host:                         localhost
-- Server version:               5.6.41 - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for sapo
DROP DATABASE IF EXISTS `sapo`;
CREATE DATABASE IF NOT EXISTS `sapo` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `sapo`;

-- Dumping structure for table sapo.config
DROP TABLE IF EXISTS `config`;
CREATE TABLE IF NOT EXISTS `config` (
  `name` varchar(255) NOT NULL,
  `value` int(11) DEFAULT '0',
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.
-- Dumping structure for table sapo.loyalty_card
DROP TABLE IF EXISTS `loyalty_card`;
CREATE TABLE IF NOT EXISTS `loyalty_card` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(20) NOT NULL,
  `phone` varchar(25) NOT NULL,
  `loyalty_cart_type_id` int(11) DEFAULT NULL,
  `point` double DEFAULT NULL,
  `total_spent` double DEFAULT NULL,
  `start_date` datetime DEFAULT NULL,
  `end_date` datetime DEFAULT NULL,
  `create_on` datetime DEFAULT NULL,
  `modified_on` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_i5vy59afjk8j1xuw6nqoc9ic8` (`code`),
  UNIQUE KEY `UK_ienpxf2ajyv9e8g7bum55ts4f` (`phone`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.
-- Dumping structure for table sapo.loyalty_card_type
DROP TABLE IF EXISTS `loyalty_card_type`;
CREATE TABLE IF NOT EXISTS `loyalty_card_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 NOT NULL,
  `spent_threshold` double DEFAULT NULL,
  `duration` int(11) DEFAULT NULL,
  `discount_percent` double DEFAULT NULL,
  `create_on` datetime DEFAULT NULL,
  `modified_on` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.
-- Dumping structure for table sapo.transaction
DROP TABLE IF EXISTS `transaction`;
CREATE TABLE IF NOT EXISTS `transaction` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `loyalty_card_id` int(11) NOT NULL,
  `point_adjust` double DEFAULT NULL,
  `spent_adjust` double DEFAULT NULL,
  `create_on` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
