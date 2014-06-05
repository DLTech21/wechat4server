CREATE DATABASE  IF NOT EXISTS `hcapi` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `hcapi`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: localhost    Database: hcapi
-- ------------------------------------------------------
-- Server version	5.6.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `usertable`
--

DROP TABLE IF EXISTS `usertable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usertable` (
  `userId` varchar(255) NOT NULL,
  `userName` varchar(45) CHARACTER SET latin1 NOT NULL,
  `userPassword` varchar(45) CHARACTER SET latin1 NOT NULL,
  `userNickname` varchar(45) DEFAULT '这个用户居然没有名字',
  `userBirthday` timestamp NULL DEFAULT NULL,
  `userDescription` varchar(45) DEFAULT '这个用户很拽，什么也不想说',
  `userHead` text CHARACTER SET utf8 COLLATE utf8_bin,
  `registerDate` timestamp NULL DEFAULT NULL,
  `longitude` double DEFAULT '0',
  `latitude` double DEFAULT '0',
  `city` varchar(45) DEFAULT '保密',
  `province` varchar(45) DEFAULT '保密',
  `userSex` int(11) DEFAULT '0',
  `userAge` int(11) DEFAULT '0',
  `userQQ` varchar(45) DEFAULT '保密',
  `userPhone` varchar(45) DEFAULT '保密',
  `apiKey` varchar(255) DEFAULT NULL,
  `userState` int(11) DEFAULT '1',
  PRIMARY KEY (`userId`),
  UNIQUE KEY `userId_UNIQUE` (`userId`),
  UNIQUE KEY `userName_UNIQUE` (`userName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usertable`
--

LOCK TABLES `usertable` WRITE;
/*!40000 ALTER TABLE `usertable` DISABLE KEYS */;
INSERT INTO `usertable` VALUES ('10000','admin','admin','墨半成霜',NULL,'我是管理员，qq109327402',null,'2013-11-04 17:56:37',106.560267,29.567919,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `usertable` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-02-15 15:03:58
