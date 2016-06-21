-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: autorama
-- ------------------------------------------------------
-- Server version 5.7.11-log

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
-- Table structure for table `ar_advertisement`
--

CREATE DATABASE IF NOT EXISTS `autorama`;

DROP TABLE IF EXISTS `ar_advertisement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ar_advertisement` (
  `id` bigint(20) NOT NULL,
  `brand` varchar(255) DEFAULT NULL,
  `color` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `dateEnd` date DEFAULT NULL,
  `dateStart` date DEFAULT NULL,
  `kmDrivenMonthly` int(11) NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `advertiser_id` bigint(20) DEFAULT NULL,
  `city_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK45A6067718652BFD` (`city_id`),
  KEY `FK45A60677E1FCA29D` (`advertiser_id`),
  CONSTRAINT `FK45A6067718652BFD` FOREIGN KEY (`city_id`) REFERENCES `ar_city` (`id`),
  CONSTRAINT `FK45A60677E1FCA29D` FOREIGN KEY (`advertiser_id`) REFERENCES `ar_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ar_advertisement`
--

LOCK TABLES `ar_advertisement` WRITE;
/*!40000 ALTER TABLE `ar_advertisement` DISABLE KEYS */;
INSERT INTO `ar_advertisement` VALUES (1,'Mercedes','black','jazdim denne medzi bb a zv',NULL,NULL,609,'Mercedes denne jazdy',1,1),(2,'bmw','red','okolie detvy',NULL,NULL,12000,'Bmw obcasne jazdi v detve',1,2),(3,'audi','blue','kazdy piatok ba - ke',NULL,NULL,1000,'Audi s trasou po celom slovensku',2,3),(4,'Fiat','white','talianska raketa',NULL,NULL,1234,'italian car',3,4);
/*!40000 ALTER TABLE `ar_advertisement` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ar_city`
--

DROP TABLE IF EXISTS `ar_city`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ar_city` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `county_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKD32E3CB926B62EDD` (`county_id`),
  CONSTRAINT `FKD32E3CB926B62EDD` FOREIGN KEY (`county_id`) REFERENCES `ar_county` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ar_city`
--

LOCK TABLES `ar_city` WRITE;
/*!40000 ALTER TABLE `ar_city` DISABLE KEYS */;
INSERT INTO `ar_city` VALUES (1,'Zilina',1),(2,'Detva',2),(3,'Zvolen',2),(4,'Bratislava',3);
/*!40000 ALTER TABLE `ar_city` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ar_county`
--

DROP TABLE IF EXISTS `ar_county`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ar_county` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ar_county`
--

LOCK TABLES `ar_county` WRITE;
/*!40000 ALTER TABLE `ar_county` DISABLE KEYS */;
INSERT INTO `ar_county` VALUES (1,'Zilinsky kraj'),(2,'Banskobystricky kraj'),(3,'Bratislavsky kraj'),(4,'Nitriansky kraj'),(5,'Trenciansky kraj'),(6,'Kosicky kraj'),(7,'Presovsky kraj'),(8,'Trnavsky kraj');
/*!40000 ALTER TABLE `ar_county` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ar_user`
--

DROP TABLE IF EXISTS `ar_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ar_user` (
  `id` bigint(20) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `firstname` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `surname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ar_user`
--

LOCK TABLES `ar_user` WRITE;
/*!40000 ALTER TABLE `ar_user` DISABLE KEYS */;
INSERT INTO `ar_user` VALUES (1,'mail@mail.sk','Martin','pass','12312','Svonava'),(2,'mail2@mail2.sk','Martin','pass2','321434','Rumanovvsky'),(3,'partykiller@azet.sk','Party','asdf','0906 358 912','Killer'),(4,'jannovak@centrum.sk','Jan','heslo','5945495','Novak');
/*!40000 ALTER TABLE `ar_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (1);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-04-23 12:45:34
