-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.4.17-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping structure for table my.manage_users
CREATE TABLE IF NOT EXISTS `manage_users` (
  `login` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`login`)
) ENGINE=InnoDB DEFAULT CHARSET=cp1251;

-- Dumping data for table my.manage_users: ~10 rows (approximately)
/*!40000 ALTER TABLE `manage_users` DISABLE KEYS */;
INSERT INTO `manage_users` (`login`, `password`) VALUES
	('uru', '1212'),
	('user01', '1111'),
	('user02', '228'),
	('user03', '3333'),
	('user04', '4444'),
	('user05', '5555'),
	('user06', '0123'),
	('user07', '0123'),
	('user08', '1234'),
	('user09', '9999');
/*!40000 ALTER TABLE `manage_users` ENABLE KEYS */;

-- Dumping structure for table my.manage_workers
CREATE TABLE IF NOT EXISTS `manage_workers` (
  `w_name` varchar(45) NOT NULL,
  `w_position` varchar(45) NOT NULL,
  `w_level` int(11) NOT NULL,
  `if_trade_union` varchar(45) NOT NULL,
  `Manage_users_login` varchar(45) NOT NULL,
  `w_id` int(11) NOT NULL AUTO_INCREMENT,
  `pay_pay_id` int(45) DEFAULT NULL,
  PRIMARY KEY (`w_id`),
  KEY `fk_Manage_workers_Manage_users_idx` (`Manage_users_login`),
  KEY `fk_Manage_workers_Pay_idx` (`pay_pay_id`),
  KEY `fk_Manage_workers_Pay_idx1` (`pay_pay_id`),
  KEY `fk_Manage_workers_Pay` (`pay_pay_id`),
  CONSTRAINT `fk_Manage_workers_Manage_users` FOREIGN KEY (`Manage_users_login`) REFERENCES `manage_users` (`login`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_pay_w` FOREIGN KEY (`pay_pay_id`) REFERENCES `pay` (`pay_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=cp1251;

-- Dumping data for table my.manage_workers: ~6 rows (approximately)
/*!40000 ALTER TABLE `manage_workers` DISABLE KEYS */;
INSERT INTO `manage_workers` (`w_name`, `w_position`, `w_level`, `if_trade_union`, `Manage_users_login`, `w_id`, `pay_pay_id`) VALUES
	('Victor Nikiforov', 'turner', 2, '1', 'user01', 1, 1),
	('Yuri Plisetsky', 'electrician', 2, '1', 'user02', 2, 2),
	('Otabek Altin', 'electrician', 2, '2', 'user03', 3, 3),
	('Yuuri Katsuki', 'machine operator', 3, '2', 'user04', 4, 4),
	('Stas Asket', 'turner', 2, '2', 'user06', 7, NULL),
	('tt', 'ttt', 2, '2', 'user08', 15, NULL);
/*!40000 ALTER TABLE `manage_workers` ENABLE KEYS */;

-- Dumping structure for table my.pay
CREATE TABLE IF NOT EXISTS `pay` (
  `pay_id` int(45) NOT NULL AUTO_INCREMENT,
  `worker1` varchar(45) NOT NULL,
  `payment` varchar(45) NOT NULL,
  `charge_pay` varchar(45) DEFAULT NULL,
  `hold_pay` varchar(45) DEFAULT NULL,
  `pay_off` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`pay_id`),
  UNIQUE KEY `pay_id_UNIQUE` (`pay_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=cp1251;

-- Dumping data for table my.pay: ~5 rows (approximately)
/*!40000 ALTER TABLE `pay` DISABLE KEYS */;
INSERT INTO `pay` (`pay_id`, `worker1`, `payment`, `charge_pay`, `hold_pay`, `pay_off`) VALUES
	(1, 'Victor Nikiforov', '20167', '20167', '2064', '50364'),
	(2, 'Yuri Plisetsky', '19659', '20000', '1064', '40364'),
	(3, 'Otabek Altin', '18596', '19600', '1100', '30364'),
	(4, 'Yuuri Katsuki', '28596', '28600', '2968', '78569'),
	(7, 'pup', '1', '2', '3', '4');
/*!40000 ALTER TABLE `pay` ENABLE KEYS */;

-- Dumping structure for table my.tariff
CREATE TABLE IF NOT EXISTS `tariff` (
  `Tar_id` int(11) NOT NULL AUTO_INCREMENT,
  `level` int(11) NOT NULL,
  `coef` varchar(45) NOT NULL,
  PRIMARY KEY (`Tar_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=cp1251;

-- Dumping data for table my.tariff: ~7 rows (approximately)
/*!40000 ALTER TABLE `tariff` DISABLE KEYS */;
INSERT INTO `tariff` (`Tar_id`, `level`, `coef`) VALUES
	(1, 1, '9'),
	(2, 2, '1.4'),
	(3, 3, '1.9'),
	(4, 4, '2.4'),
	(5, 5, '2.8'),
	(6, 6, '3.3'),
	(8, 1, '1,1');
/*!40000 ALTER TABLE `tariff` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
