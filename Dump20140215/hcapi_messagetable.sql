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
-- Table structure for table `messagetable`
--

DROP TABLE IF EXISTS `messagetable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `messagetable` (
  `messageId` int(11) NOT NULL AUTO_INCREMENT,
  `messageTitle` varchar(45) NOT NULL,
  `messageContent` text NOT NULL,
  `senderId` varchar(45) NOT NULL,
  PRIMARY KEY (`messageId`),
  UNIQUE KEY `messageId_UNIQUE` (`messageId`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `messagetable`
--

LOCK TABLES `messagetable` WRITE;
/*!40000 ALTER TABLE `messagetable` DISABLE KEYS */;
-- INSERT INTO `messagetable` VALUES (1,'æå¡å¨æ¬è¿å¦|发送者IP:106.84.70.186','æå¡å¨æ¬è¿å¦','1510'),(2,'hello|发送者IP:106.84.76.165','hello','f39d161942395eee0142395f960a0000'),(3,'wx|发送者IP:110.96.249.225','æççè¨åå','f39d16194251b4350142557093420004'),(4,'wx|发送者IP:110.96.249.225','æççè¨åå','f39d161942567ca00142567ca74e0000'),(5,'1|发送者IP:112.2.23.146','1','f39d1619426a8a4201426a8e408c0000'),(6,'zst|发送者IP:112.2.23.146','zst','f39d1619426a8a4201426a8e408c0000'),(7,'1231231|发送者IP:183.3.244.31','23123','f39d16194284294401428a9e585d0013'),(8,'asdfasdf|发送者IP:114.241.208.211','asdasdf','f39d1619437b39df014389c7379b009d'),(9,'å¥½ç|发送者IP:171.216.24.162','å¥½å¥½å¥½å¥½å','f39d161943a4a96b0143cd902a8101c3'),(10,'è¨æ³|发送者IP:171.216.24.162','é¿åæåé¿','f39d161943a4a96b0143cd902a8101c3'),(11,'è¨æ³|发送者IP:171.216.24.162','é¿åæåé¿','f39d161943a4a96b0143cf307bdc01e0');
/*!40000 ALTER TABLE `messagetable` ENABLE KEYS */;
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
