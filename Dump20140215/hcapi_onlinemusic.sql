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
-- Table structure for table `onlinemusic`
--

DROP TABLE IF EXISTS `onlinemusic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `onlinemusic` (
  `musicId` varchar(255) NOT NULL,
  `musicPath` varchar(255) NOT NULL,
  `musicName` varchar(255) NOT NULL,
  `musicAuthor` varchar(255) NOT NULL,
  `musicSize` bigint(20) DEFAULT NULL COMMENT '????',
  `musicType` varchar(45) DEFAULT NULL,
  `musicDuration` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`musicId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `onlinemusic`
--

LOCK TABLES `onlinemusic` WRITE;
/*!40000 ALTER TABLE `onlinemusic` DISABLE KEYS */;
-- INSERT INTO `onlinemusic` VALUES ('f39d16194237123a014237123d150000','jiandandeliwu.mp3','简单的礼物','轻音乐',NULL,'MP3',NULL),('f39d16194237123a0142371eeaac0001','weiliantuier.mp3','威廉退尔','轻音乐',NULL,'MP3',NULL),('f39d16194237123a0142371eeaac0002','zhuimengchizixin.mp3','追梦赤子心','unkown',NULL,'MP3',NULL),('f39d16194237123a0142371eeaac0003','yihan.mp3','遗憾','李代沫',NULL,'mp3',NULL),('f39d16194237123a0142371eeaac0004','wenwendexingfu.mp3','稳稳的幸福','陈奕迅',NULL,'MP3',NULL),('f39d161942393378014239376a7b0000','dongxiaojie.mp3','董小姐','宋冬野',NULL,NULL,NULL),('f39d161942407a220142428ea5230021','chenzao.mp3','趁早','张惠妹',NULL,NULL,NULL),('f39d161942407a2201424293551b0022','shengxia.mp3','盛夏','陈势安',NULL,NULL,NULL),('f39d161942407a22014242963e8a0023','wudidong.mp3','无底洞','蔡健雅',NULL,NULL,NULL),('f39d161942407a2201424297246a0024','hongsegaogenxie.mp3','红色高跟鞋','蔡健雅',NULL,NULL,NULL),('f39d161942407a220142429bb19c0025','ComeBack.mp3','Come Back','Ahmir',NULL,NULL,NULL),('f39d161942407a22014242a1838c0026','My Life Would Suck Without You - Kelly Clarkson.mp3','My Life Would Suck With Out Of You','Kelly Clarkson',NULL,NULL,NULL),('f39d161942407a22014242ab564f0027','GottaHaveYou.mp3','Gotta Have You','The Weepies',NULL,NULL,NULL),('f39d161942407a22014242ad879c0028','beiduibeiyongbao.mp3','背对背拥抱','林俊杰',NULL,NULL,NULL),('f39d161942407a22014242b13c550029','woqidai.mp3','我期待','卓义峰',NULL,NULL,NULL),('f39d161942407a22014242bb7690002a','TheSaltwaterRoom.mp3','The Saltwater Room','Owl City',NULL,NULL,NULL),('f39d1619437b39df01437ffb30e4004d','mp3','爱','莫文蔚',NULL,NULL,NULL),('f39d16194390d01a014394d51b300071','mp3','','',NULL,NULL,NULL);
/*!40000 ALTER TABLE `onlinemusic` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-02-15 15:03:59
