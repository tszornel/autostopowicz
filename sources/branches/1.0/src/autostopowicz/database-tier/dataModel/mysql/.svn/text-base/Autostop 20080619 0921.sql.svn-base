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
INSERT INTO `car` (`idCar`,`make`,`model`,`color`,`numberPlate`) VALUES 
 (1,'Renault','Megane','Blue','SE1234');
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
INSERT INTO `city` (`idCity`,`idCountry`,`name`) VALUES 
 (1,1,'Warszawa'),
 (2,1,'Kraków');
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
INSERT INTO `country` (`idCountry`,`name`) VALUES 
 (4,'Anglia'),
 (3,'Francja'),
 (2,'Niemcy'),
 (1,'Polska');
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
INSERT INTO `drive` (`idDrive`,`idUser`,`idCar`,`date`,`placeNumber`,`smoke`,`price`,`idCountryFrom`,`idCityFrom`,`streetFrom`,`idCountryTo`,`idCityTo`,`streetTo`) VALUES 
 (1,41,1,'2008-06-05 12:14:29',2,0,10,1,1,'Centralna',1,2,'Wo?oska'),
 (2,41,1,'2008-06-05 12:17:09',2,0,10,1,1,'Centralna',1,2,'Woloska'),
 (3,42,1,'2008-06-05 12:17:09',1,0,1,1,1,'łotwa',1,1,'dasd');
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
  `idDrive` int(10) unsigned default NULL,
  PRIMARY KEY  (`idUser`),
  UNIQUE KEY `UQ_user_login` (`login`),
  UNIQUE KEY `UQ_user_email` (`email`),
  KEY `FK_user_idCity` USING BTREE (`idCity`),
  KEY `FK_user_idCountry` USING BTREE (`idCountry`),
  KEY `FK_user_idDrive` (`idDrive`),
  CONSTRAINT `FK_user_idCity` FOREIGN KEY (`idCity`) REFERENCES `city` (`idCity`),
  CONSTRAINT `FK_user_idCountry` FOREIGN KEY (`idCountry`) REFERENCES `country` (`idCountry`),
  CONSTRAINT `FK_user_idDrive` FOREIGN KEY (`idDrive`) REFERENCES `drive` (`idDrive`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 DELAY_KEY_WRITE=1;

--
-- Dumping data for table `autostopowicz`.`user`
--

/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`idUser`,`login`,`password`,`email`,`role`,`rank`,`name`,`surname`,`address`,`idCity`,`idCountry`,`phone`,`description`,`status`,`idDrive`) VALUES 
 (41,'toms','toms','xxx@ericpol.pl',2,1,'toms','','',NULL,NULL,'','',1,NULL),
 (42,'login','password','email',2,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL),
 (43,'__1727764025','__1727764025','__1727764025',2,1,'__1727764025',NULL,NULL,NULL,NULL,NULL,NULL,0,NULL),
 (44,'__1549865398','__1549865398','__1549865398',2,1,'__1549865398',NULL,NULL,NULL,NULL,NULL,NULL,0,NULL),
 (45,'toms2','toms','45',2,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL),
 (46,'toms3','toms','4',2,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,NULL),
 (47,'toms4','toms','x',2,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL),
 (48,'__-1220385078','__-1220385078','__-1220385078',2,1,'__-1220385078',NULL,NULL,NULL,NULL,NULL,NULL,0,NULL),
 (49,'toms34','toms','5',2,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL),
 (50,'toms3423','halo','Tomsd@dasd.da',2,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL),
 (51,'toms30','toms','dd',2,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL);
INSERT INTO `user` (`idUser`,`login`,`password`,`email`,`role`,`rank`,`name`,`surname`,`address`,`idCity`,`idCountry`,`phone`,`description`,`status`,`idDrive`) VALUES 
 (52,'toms232','toms','7',2,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL),
 (53,'tomsdf','toms','34',2,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL),
 (54,'__-1321751771','__-1321751771','__-1321751771',2,1,'__-1321751771',NULL,NULL,NULL,NULL,NULL,NULL,0,NULL);
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
-- Table structure for table `autostopowicz`.`userdrive`
--

DROP TABLE IF EXISTS `userdrive`;
CREATE TABLE `userdrive` (
  `idUser` int(10) unsigned NOT NULL,
  `idDrive` int(10) unsigned NOT NULL,
  `owner` tinyint(3) unsigned NOT NULL default '0',
  `idUserDrive` int(10) unsigned NOT NULL auto_increment,
  PRIMARY KEY  (`idUserDrive`),
  KEY `FK_userdrive_1` (`idDrive`),
  KEY `FK_userdrive_2` (`idUser`),
  CONSTRAINT `FK_userdrive_1` FOREIGN KEY (`idDrive`) REFERENCES `drive` (`idDrive`),
  CONSTRAINT `FK_userdrive_2` FOREIGN KEY (`idUser`) REFERENCES `user` (`idUser`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `autostopowicz`.`userdrive`
--

/*!40000 ALTER TABLE `userdrive` DISABLE KEYS */;
INSERT INTO `userdrive` (`idUser`,`idDrive`,`owner`,`idUserDrive`) VALUES 
 (41,1,1,1),
 (41,2,1,2);
/*!40000 ALTER TABLE `userdrive` ENABLE KEYS */;


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
