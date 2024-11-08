-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.51a-community-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema autostopowicz
--

CREATE DATABASE IF NOT EXISTS autostopowicz;
USE autostopowicz;

--
-- Definition of table `car`
--

DROP TABLE IF EXISTS `car`;
CREATE TABLE `car` (
  `idCar` int(10) unsigned NOT NULL auto_increment,
  `make` varchar(50) NOT NULL,
  `model` varchar(50) NOT NULL,
  `color` varchar(20) NOT NULL,
  `numberPlate` varchar(20) NOT NULL,
  PRIMARY KEY  (`idCar`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `car`
--

/*!40000 ALTER TABLE `car` DISABLE KEYS */;
/*!40000 ALTER TABLE `car` ENABLE KEYS */;


--
-- Definition of table `city`
--

DROP TABLE IF EXISTS `city`;
CREATE TABLE `city` (
  `idCity` int(10) unsigned NOT NULL auto_increment,
  `idCountry` int(10) unsigned NOT NULL,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY  (`idCity`),
  KEY `FK_city_idCountry` (`idCountry`),
  CONSTRAINT `FK_city_idCountry` FOREIGN KEY (`idCountry`) REFERENCES `country` (`idCountry`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `city`
--

/*!40000 ALTER TABLE `city` DISABLE KEYS */;
/*!40000 ALTER TABLE `city` ENABLE KEYS */;


--
-- Definition of table `country`
--

DROP TABLE IF EXISTS `country`;
CREATE TABLE `country` (
  `idCountry` int(10) unsigned NOT NULL auto_increment,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY  (`idCountry`),
  UNIQUE KEY `UQ_country_name` USING BTREE (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `country`
--

/*!40000 ALTER TABLE `country` DISABLE KEYS */;
/*!40000 ALTER TABLE `country` ENABLE KEYS */;


--
-- Definition of table `drive`
--

DROP TABLE IF EXISTS `drive`;
CREATE TABLE `drive` (
  `idDrive` int(10) unsigned NOT NULL auto_increment,
  `idUser` int(10) unsigned NOT NULL,
  `idCar` int(10) unsigned NOT NULL,
  `date` datetime NOT NULL,
  `placeNumber` int(10) unsigned NOT NULL,
  `smoke` tinyint(1) NOT NULL default '0',
  `price` float NOT NULL default '0',
  `idCountryFrom` int(10) unsigned NOT NULL,
  `idCityFrom` int(10) unsigned NOT NULL,
  `streetFrom` varchar(50) NOT NULL,
  `idCountryTo` int(10) unsigned NOT NULL,
  `idCityTo` int(10) unsigned NOT NULL,
  `streetTo` varchar(50) NOT NULL,
  PRIMARY KEY  USING BTREE (`idDrive`),
  KEY `FK_drive_idUser` (`idUser`),
  KEY `FK_drive_idCar` (`idCar`),
  KEY `FK_drive_idCountryFrom` (`idCountryFrom`),
  KEY `FK_drive_idCityFrom` (`idCityFrom`),
  KEY `FK_drive_idCountryTo` (`idCountryTo`),
  KEY `FK_drive_idCityTo` (`idCityTo`),
  CONSTRAINT `FK_drive_idCityTo` FOREIGN KEY (`idCityTo`) REFERENCES `city` (`idCity`),
  CONSTRAINT `FK_drive_idCar` FOREIGN KEY (`idCar`) REFERENCES `car` (`idCar`),
  CONSTRAINT `FK_drive_idCityFrom` FOREIGN KEY (`idCityFrom`) REFERENCES `city` (`idCity`),
  CONSTRAINT `FK_drive_idCountryFrom` FOREIGN KEY (`idCountryFrom`) REFERENCES `country` (`idCountry`),
  CONSTRAINT `FK_drive_idCountryTo` FOREIGN KEY (`idCountryTo`) REFERENCES `country` (`idCountry`),
  CONSTRAINT `FK_drive_idUser` FOREIGN KEY (`idUser`) REFERENCES `user` (`idUser`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `drive`
--

/*!40000 ALTER TABLE `drive` DISABLE KEYS */;
/*!40000 ALTER TABLE `drive` ENABLE KEYS */;


--
-- Definition of table `group`
--

DROP TABLE IF EXISTS `group`;
CREATE TABLE `group` (
  `idGroup` int(10) unsigned NOT NULL auto_increment,
  `name` varchar(50) NOT NULL,
  `logo` blob,
  `description` text,
  PRIMARY KEY  USING BTREE (`idGroup`),
  UNIQUE KEY `UQ_group_name` USING BTREE (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `group`
--

/*!40000 ALTER TABLE `group` DISABLE KEYS */;
/*!40000 ALTER TABLE `group` ENABLE KEYS */;


--
-- Definition of table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `idUser` int(10) unsigned NOT NULL auto_increment,
  `login` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `role` int(10) unsigned NOT NULL default '2',
  `rank` int(10) unsigned NOT NULL default '0',
  `name` varchar(50) default NULL,
  `surname` varchar(50) default NULL,
  `address` varchar(50) default NULL,
  `idCity` int(10) unsigned default NULL,
  `idCountry` int(10) unsigned default NULL,
  `phone` varchar(15) default NULL,
  `description` text,
  PRIMARY KEY  (`idUser`),
  UNIQUE KEY `UQ_user_login` (`login`),
  UNIQUE KEY `UQ_user_email` (`email`),
  KEY `FK_user_idCity` USING BTREE (`idCity`),
  KEY `FK_user_idCountry` USING BTREE (`idCountry`),
  CONSTRAINT `FK_user_idCity` FOREIGN KEY (`idCity`) REFERENCES `city` (`idCity`),
  CONSTRAINT `FK_user_idCountry` FOREIGN KEY (`idCountry`) REFERENCES `country` (`idCountry`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
