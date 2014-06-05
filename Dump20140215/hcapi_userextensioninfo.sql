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
-- Table structure for table `userextensioninfo`
--

DROP TABLE IF EXISTS `userextensioninfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userextensioninfo` (
  `extensionId` varchar(45) NOT NULL,
  `userId` int(11) NOT NULL,
  `coordinateLongitute` double DEFAULT NULL,
  `coordinateLatitude` double DEFAULT NULL,
  `streetName` varchar(80) DEFAULT NULL,
  `updateTime` timestamp NULL DEFAULT NULL,
  `locationInfo` varchar(45) DEFAULT NULL,
  `apiKey` varchar(45) DEFAULT NULL,
  `userCity` varchar(45) DEFAULT NULL,
  `userSex` int(11) DEFAULT NULL,
  `userAge` int(11) DEFAULT NULL,
  `userRealName` varchar(45) DEFAULT NULL,
  `userQQ` varchar(45) DEFAULT NULL,
  `userCellphone` varchar(45) DEFAULT NULL,
  `userIDCard` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`extensionId`),
  UNIQUE KEY `locId_UNIQUE` (`extensionId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userextensioninfo`
--

LOCK TABLES `userextensioninfo` WRITE;
/*!40000 ALTER TABLE `userextensioninfo` DISABLE KEYS */;
/*!40000 ALTER TABLE `userextensioninfo` ENABLE KEYS */;
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
