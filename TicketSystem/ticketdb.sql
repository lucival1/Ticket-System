-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.1.26-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win32
-- HeidiSQL Version:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for ticketdb
CREATE DATABASE IF NOT EXISTS `ticketdb` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `ticketdb`;

-- Dumping structure for table ticketdb.test
CREATE TABLE IF NOT EXISTS `test` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` date DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Dumping data for table ticketdb.test: ~1 rows (approximately)
/*!40000 ALTER TABLE `test` DISABLE KEYS */;
INSERT INTO `test` (`id`, `date`, `name`) VALUES
	(1, '2017-11-09', 'roy');
/*!40000 ALTER TABLE `test` ENABLE KEYS */;

-- Dumping structure for table ticketdb.ticket
CREATE TABLE IF NOT EXISTS `ticket` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `technician` varchar(15) NOT NULL,
  `issue` varchar(15) NOT NULL,
  `status` varchar(15) NOT NULL,
  `open_date` varchar(50) NOT NULL,
  `close_date` varchar(50) DEFAULT NULL,
  `description` varchar(300) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=latin1;

-- Dumping data for table ticketdb.ticket: ~20 rows (approximately)
/*!40000 ALTER TABLE `ticket` DISABLE KEYS */;
INSERT INTO `ticket` (`id`, `technician`, `issue`, `status`, `open_date`, `close_date`, `description`) VALUES
	(1, 'James', 'Urgent', 'open', '09/11/2017', '', 'SystemFailure'),
	(7, 'James', 'Normal', 'open', '09/11/2017', '', 'Poor connection'),
	(14, 'John', 'Urgent', 'closed', '09/11/2017', '11/11/2017', 'Hardware failure'),
	(15, 'Johan', 'Normal', 'closed', '09/11/2017', '20/11/2017', 'Software failure'),
	(17, 'John', 'Longterm', 'closed', '10/11/2017', '09/12/2017', 'Hardware Failure'),
	(22, 'James', 'Urgent', 'closed', '09/11/2017', '11/09/2017', 'SystemFailure'),
	(24, 'John', 'Longterm', 'closed', '09/11/2017', '09/12/2017', 'Hardware Failure'),
	(26, 'James', 'Normal', 'closed', '09/11/2017', '09/11/2017', 'Poor connection'),
	(27, 'James', 'Urgent', 'closed', '09/11/2017', '09/12/2017', 'SystemFailure'),
	(29, 'John', 'Longterm', 'closed', '10/11/2017', '01/12/2017', 'Hardware Failure'),
	(31, 'James', 'Normal', 'closed', '09/11/2017', '09/12/2017', 'Hardware change'),
	(32, 'John', 'Longterm', 'open', '10/11/2017', '', 'Hardware Failure'),
	(34, 'John', 'Longterm', 'open', '10/11/2017', '', 'Hardware Failure'),
	(35, 'James', 'Normal', 'open', '10/11/2017', '', 'Hardware change'),
	(36, 'James', 'Normal', 'open', '10/11/2017', '', 'Poor connection'),
	(37, 'James', 'Normal', 'open', '10/11/2017', '', 'Software failure'),
	(38, 'Johan', 'Urgent', 'open', '11/12/2017', '', 'Software failure'),
	(39, 'John', 'Longterm', 'open', '11/12/2017', '', 'Software update'),
	(40, 'James', 'Urgent', 'open', '11/12/2017', '', 'Software update'),
	(41, 'Johan', 'Urgent', 'open', '11/12/2017', '', 'Software failure');
/*!40000 ALTER TABLE `ticket` ENABLE KEYS */;

-- Dumping structure for table ticketdb.users
CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `acc_type` varchar(10) NOT NULL DEFAULT '0',
  `username` varchar(20) NOT NULL DEFAULT '0',
  `password` varchar(30) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

-- Dumping data for table ticketdb.users: ~6 rows (approximately)
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`id`, `acc_type`, `username`, `password`) VALUES
	(1, 'admin', 'admin', '123'),
	(2, 'manager', 'Manager', '123'),
	(3, 'support', 'John', '123'),
	(4, 'support', 'James', '123'),
	(5, 'support', 'Johan', '123'),
	(6, 'support', 'test', '123');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
