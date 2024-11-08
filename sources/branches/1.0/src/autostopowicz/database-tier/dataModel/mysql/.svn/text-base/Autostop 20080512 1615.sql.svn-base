-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.4-beta-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema `autostopowicz`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `autostopowicz`;
USE `autostopowicz`;

--
-- Table structure for table `autostopowicz`.`autostopowicz_users`
--

DROP TABLE IF EXISTS `autostopowicz_users`;
CREATE TABLE `autostopowicz_users` (
  `autostopowiczId` int(10) unsigned NOT NULL auto_increment,
  `autostopowiczName` varchar(45) NOT NULL,
  `autostopowiczLogin` varchar(45) NOT NULL,
  `autostopowiczPassword` varchar(45) NOT NULL,
  `autostopowiczEmail` varchar(45) NOT NULL,
  `autostopowiczRole` varchar(45) NOT NULL,
  PRIMARY KEY  (`autostopowiczId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `autostopowicz`.`autostopowicz_users`
--

/*!40000 ALTER TABLE `autostopowicz_users` DISABLE KEYS */;
INSERT INTO `autostopowicz_users` (`autostopowiczId`,`autostopowiczName`,`autostopowiczLogin`,`autostopowiczPassword`,`autostopowiczEmail`,`autostopowiczRole`) VALUES 
 (1,'toms','toms','toms123','tszornel@wp.pl','2'),
 (2,'__-1287992569','__-1287992569','__-1287992569','__-1287992569','2'),
 (3,'__1413346852','__1413346852','__1413346852','__1413346852','2'),
 (4,'__-1669602465','__-1669602465','__-1669602465','__-1669602465','2'),
 (5,'__-39261222','__-39261222','__-39261222','__-39261222','2'),
 (6,'__125500693','__125500693','__125500693','__125500693','2'),
 (7,'__-694279438','__-694279438','__-694279438','__-694279438','2'),
 (8,'__446623409','__446623409','__446623409','__446623409','2'),
 (9,'tester','tester','tester123','tester@wp.pl','2'),
 (10,'__1874956742','__1874956742','__1874956742','__1874956742','2');
/*!40000 ALTER TABLE `autostopowicz_users` ENABLE KEYS */;


--
-- Table structure for table `autostopowicz`.`car`
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
-- Dumping data for table `autostopowicz`.`car`
--

/*!40000 ALTER TABLE `car` DISABLE KEYS */;
/*!40000 ALTER TABLE `car` ENABLE KEYS */;


--
-- Table structure for table `autostopowicz`.`city`
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
-- Dumping data for table `autostopowicz`.`city`
--

/*!40000 ALTER TABLE `city` DISABLE KEYS */;
/*!40000 ALTER TABLE `city` ENABLE KEYS */;


--
-- Table structure for table `autostopowicz`.`country`
--

DROP TABLE IF EXISTS `country`;
CREATE TABLE `country` (
  `idCountry` int(10) unsigned NOT NULL auto_increment,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY  (`idCountry`),
  UNIQUE KEY `UQ_country_name` USING BTREE (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `autostopowicz`.`country`
--

/*!40000 ALTER TABLE `country` DISABLE KEYS */;
/*!40000 ALTER TABLE `country` ENABLE KEYS */;


--
-- Table structure for table `autostopowicz`.`drive`
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
  CONSTRAINT `FK_drive_idCar` FOREIGN KEY (`idCar`) REFERENCES `car` (`idCar`),
  CONSTRAINT `FK_drive_idCityFrom` FOREIGN KEY (`idCityFrom`) REFERENCES `city` (`idCity`),
  CONSTRAINT `FK_drive_idCityTo` FOREIGN KEY (`idCityTo`) REFERENCES `city` (`idCity`),
  CONSTRAINT `FK_drive_idCountryFrom` FOREIGN KEY (`idCountryFrom`) REFERENCES `country` (`idCountry`),
  CONSTRAINT `FK_drive_idCountryTo` FOREIGN KEY (`idCountryTo`) REFERENCES `country` (`idCountry`),
  CONSTRAINT `FK_drive_idUser` FOREIGN KEY (`idUser`) REFERENCES `user` (`idUser`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `autostopowicz`.`drive`
--

/*!40000 ALTER TABLE `drive` DISABLE KEYS */;
/*!40000 ALTER TABLE `drive` ENABLE KEYS */;


--
-- Table structure for table `autostopowicz`.`group`
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
-- Dumping data for table `autostopowicz`.`group`
--

/*!40000 ALTER TABLE `group` DISABLE KEYS */;
/*!40000 ALTER TABLE `group` ENABLE KEYS */;


--
-- Table structure for table `autostopowicz`.`user`
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
  `status` int(10) unsigned default '0',
  PRIMARY KEY  (`idUser`),
  UNIQUE KEY `UQ_user_login` (`login`),
  UNIQUE KEY `UQ_user_email` (`email`),
  KEY `FK_user_idCity` USING BTREE (`idCity`),
  KEY `FK_user_idCountry` USING BTREE (`idCountry`),
  CONSTRAINT `FK_user_idCity` FOREIGN KEY (`idCity`) REFERENCES `city` (`idCity`),
  CONSTRAINT `FK_user_idCountry` FOREIGN KEY (`idCountry`) REFERENCES `country` (`idCountry`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `autostopowicz`.`user`
--

/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`idUser`,`login`,`password`,`email`,`role`,`rank`,`name`,`surname`,`address`,`idCity`,`idCountry`,`phone`,`description`,`status`) VALUES 
 (1,'__-1856152989','__-1856152989','__-1856152989',2,1,'__-1856152989',NULL,NULL,NULL,NULL,NULL,NULL,0),
 (2,'__1579805822','__1579805822','__1579805822',2,1,'__1579805822',NULL,NULL,NULL,NULL,NULL,NULL,0),
 (3,'__211135964','__211135964','__211135964',2,1,'__211135964',NULL,NULL,NULL,NULL,NULL,NULL,0),
 (4,'__416653528','__416653528','__416653528',2,1,'__416653528',NULL,NULL,NULL,NULL,NULL,NULL,0),
 (5,'__-1141122088','__-1141122088','__-1141122088',2,1,'__-1141122088',NULL,NULL,NULL,NULL,NULL,NULL,0),
 (6,'__2134299701','__2134299701','__2134299701',2,1,'__2134299701',NULL,NULL,NULL,NULL,NULL,NULL,0),
 (7,'__-1694049022','__-1694049022','__-1694049022',2,1,'__-1694049022',NULL,NULL,NULL,NULL,NULL,NULL,0),
 (8,'__-1643399864','__-1643399864','__-1643399864',2,1,'__-1643399864',NULL,NULL,NULL,NULL,NULL,NULL,0),
 (9,'__-494787739','__-494787739','__-494787739',2,1,'__-494787739',NULL,NULL,NULL,NULL,NULL,NULL,0),
 (10,'__-1950280073','__-1950280073','__-1950280073',2,1,'__-1950280073',NULL,NULL,NULL,NULL,NULL,NULL,0);
INSERT INTO `user` (`idUser`,`login`,`password`,`email`,`role`,`rank`,`name`,`surname`,`address`,`idCity`,`idCountry`,`phone`,`description`,`status`) VALUES 
 (11,'__-854938701','__-854938701','__-854938701',2,1,'__-854938701',NULL,NULL,NULL,NULL,NULL,NULL,0),
 (12,'__2027090617','__2027090617','__2027090617',2,1,'__2027090617',NULL,NULL,NULL,NULL,NULL,NULL,0),
 (13,'__1690951132','__1690951132','__1690951132',2,1,'__1690951132',NULL,NULL,NULL,NULL,NULL,NULL,0),
 (14,'__135436197','__135436197','__135436197',2,1,'__135436197',NULL,NULL,NULL,NULL,NULL,NULL,0),
 (15,'__-1132589083','__-1132589083','__-1132589083',2,1,'__-1132589083',NULL,NULL,NULL,NULL,NULL,NULL,0);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;


--
-- Table structure for table `autostopowicz`.`usercar`
--

DROP TABLE IF EXISTS `usercar`;
CREATE TABLE `usercar` (
  `idUser` int(10) unsigned NOT NULL,
  `idCar` int(10) unsigned NOT NULL,
  `owner` tinyint(1) NOT NULL default '1',
  PRIMARY KEY  (`idUser`,`idCar`),
  KEY `FK_usercar_idCar` (`idCar`),
  CONSTRAINT `FK_usercar_idCar` FOREIGN KEY (`idCar`) REFERENCES `car` (`idCar`),
  CONSTRAINT `FK_usercar_idUser` FOREIGN KEY (`idUser`) REFERENCES `user` (`idUser`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `autostopowicz`.`usercar`
--

/*!40000 ALTER TABLE `usercar` DISABLE KEYS */;
/*!40000 ALTER TABLE `usercar` ENABLE KEYS */;


--
-- Table structure for table `autostopowicz`.`usergroup`
--

DROP TABLE IF EXISTS `usergroup`;
CREATE TABLE `usergroup` (
  `idUser` int(10) unsigned NOT NULL,
  `idGroup` int(10) unsigned NOT NULL,
  `owner` tinyint(1) NOT NULL default '0',
  PRIMARY KEY  (`idUser`,`idGroup`),
  KEY `FK_usergroup_idGroup` (`idGroup`),
  CONSTRAINT `FK_usergroup_idGroup` FOREIGN KEY (`idGroup`) REFERENCES `group` (`idGroup`),
  CONSTRAINT `FK_usergroup_idUser` FOREIGN KEY (`idUser`) REFERENCES `user` (`idUser`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `autostopowicz`.`usergroup`
--

/*!40000 ALTER TABLE `usergroup` DISABLE KEYS */;
/*!40000 ALTER TABLE `usergroup` ENABLE KEYS */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
