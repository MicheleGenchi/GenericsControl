CREATE DATABASE  IF NOT EXISTS `password` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `password`;
-- MySQL dump 10.13  Distrib 5.7.21, for Win64 (x86_64)
--
-- Host: localhost    Database: password
-- ------------------------------------------------------
-- Server version	5.7.21

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
-- Table structure for table `password`
--

DROP TABLE IF EXISTS `password`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `password` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Tipo` varchar(20) NOT NULL,
  `Nome` varchar(25) NOT NULL,
  `Utente` varchar(30) DEFAULT NULL,
  `Password` varchar(15) DEFAULT NULL,
  `Sito` varchar(45) DEFAULT NULL,
  `Note` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=120 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `password`
--

LOCK TABLES `password` WRITE;
/*!40000 ALTER TABLE `password` DISABLE KEYS */;
INSERT INTO `password` VALUES (1,'Acquisti','AMAZON','*','*','',''),(2,'Acquisti','AUCHAN','*','*','',''),(3,'Acquisti','AUCHAN - LA TUA CARD','*','*','',''),(4,'Acquisti','AUTOSCOUT','*','*','',''),(5,'Acquisti','DECLATHON','*','*','',''),(6,'Acquisti','DECLATHON','**','*','',''),(7,'Acquisti','EBAY','*','*','',''),(8,'Acquisti','Eprice','*','*','',''),(9,'Acquisti','GROUPON','*','*','',''),(10,'Acquisti','IBS LIBRI','*','*','',''),(11,'Acquisti','ITUNES','*','*','',''),(12,'Acquisti','Kataweb Libro','*','*','',''),(13,'Acquisti','MediaWorld','*','*','',''),(14,'Acquisti','OBABALUBA','*','*','',''),(15,'Acquisti','Oviesse','*','*','',''),(16,'Acquisti','Quattroruote','*','*','',''),(17,'Acquisti','SCONTRINO SICURO','*','*','',''),(18,'Acquisti','SUBITO','*','*','',''),(19,'Acquisti','SUBITO','**','*','',''),(20,'Acquisti','YOUBUY','*','*','',''),(21,'Android','android world','*','*','',''),(22,'Android','hacklabproject (DRONIX)','*','*','',''),(23,'Android','tecno android','*','*','',''),(24,'Antivirus','antivir avira','*','*','',''),(25,'ASL','ASL Taranto','*','*','',''),(26,'ASL','ASL Taranto','**','*','',''),(27,'ASL','Gabriele','*','*','',''),(28,'Banca Multicanale','Marialaura','*','*','',''),(29,'Banca Multicanale','Michele','**','*','',''),(30,'Carta','Marialaura','*','*','',''),(31,'Carta','Michele','*','*','',''),(32,'Carta','Michele','**','*','',''),(33,'cloud','Dropbox','*','*','',''),(34,'cloud','Dropbox','**','*','',''),(35,'cloud','github','*','*','',''),(36,'cloud','Studio VIT','*','*','',''),(37,'cloud','TNT Village','*','*','',''),(38,'cloud','webstorage','*','*','',''),(39,'CODECADEMY','Codecademy','*','*','',''),(40,'COMUNE','Comune Taranto','*','*','',''),(41,'CPI','CPI Marialaura','*','*','',''),(42,'CPI','CPI Michele','**','*','',''),(43,'DNS','no-ip','*','*','',''),(44,'DNS','opendns','*','*','',''),(45,'DNS','retegenchi.ddns.net','*','*','',''),(46,'Email','Gabriele','*','*','',''),(47,'Email','Marialaura','*','*','',''),(48,'Email','Michele','*','*','',''),(49,'Email','Michele','**','*','',''),(50,'Email','Michele','***','*','',''),(51,'Email','Michele','****','*','',''),(52,'Email','Michele','*****','*','',''),(53,'Email','Michele','******','*','',''),(54,'Email','Michele','*******','*','',''),(55,'Email','Michele, Marialaura','*','*','',''),(56,'FIREFOX','Firefox','*','*','',''),(57,'Garanzie','ASUS','*','*','',''),(58,'Garanzie','Brother','*','*','',''),(59,'Garanzie','Brother','**','*','',''),(60,'Garanzie','HUAWEI','*','*','',''),(61,'Garanzie','LG','*','*','',''),(62,'Garanzie','LG','**','*','',''),(63,'Garanzie','Powerwalker','*','*','',''),(64,'Garanzie','Sammobile','*','*','',''),(65,'Garanzie','Samsung','*','*','',''),(66,'Garanzie','TRONY','*','*','',''),(67,'Giornale','CalcioMercato','*','*','',''),(69,'Giornale','Gazzetta dello sport','*','*','',''),(70,'Giornale','Repubblica','*','*','',''),(71,'Giornale','Sito Alex del Piero','*','*','',''),(72,'INPS','INPS MICHELE','*','*','',''),(73,'PAYPAL','Michele','*','*','',''),(74,'Prenotazioni','CINEPLEX','*','*','',''),(75,'Prenotazioni','Cisco Acclaim','*','*','',''),(76,'Prenotazioni','Cisco Esami','*','*','',''),(77,'Prenotazioni','CiscoForum','*','*','',''),(78,'Prenotazioni','EASYJET','*','*','',''),(79,'Prenotazioni','Laboratorio CentroE4','*','*','',''),(80,'Prenotazioni','Oracle','*','*','',''),(81,'Prenotazioni','Rayanair','*','*','',''),(82,'Salute','Medicitalia','*','*','',''),(83,'Siti lavoro','Adecco','*','*','',''),(84,'Siti lavoro','Freelancer','*','*','',''),(85,'Siti lavoro','Indeed','*','*','',''),(86,'Siti lavoro','Informatica lavoro','*','*','',''),(87,'Siti lavoro','iprogrammatori','*','*','',''),(89,'Siti lavoro','Linkedin','*','*','',''),(90,'Siti lavoro','Manpower','*','*','',''),(91,'Siti lavoro','Monster','*','*','',''),(92,'Siti lavoro','StackOverFlow','*','*','',''),(93,'Siti lavoro','trovit','*','*','',''),(94,'SKY','Sky','*','*','',''),(95,'TASSE','Agenzie delle Entrate','*','*','',''),(96,'TASSE','Agenzie delle Entrate','**','*','',''),(97,'TCT','Michele','*','*','',''),(98,'TCT','previlog','*','*','',''),(99,'TCT','Tct Payroll','*','*','',''),(100,'TEAMVIEWER','teamviewer','*','*','',''),(101,'TEAMVIEWER','teamviewer','**','*','',''),(102,'UNISALUTE','Unisalute','*','*','',''),(103,'Utenza','EnelEnergia - Michele','*','*','',''),(104,'Utenza','Tributi Comune','*','*','',''),(105,'VIDEO CHAT','Marialaura','*','*','',''),(106,'VIDEO CHAT','Michele','*','*','',''),(107,'VIDEO CHAT','Zoom Launcher','*','*','',''),(108,'WIND','Wind (Marialaura)','*','*','',''),(109,'WIND','Wind (Michele)','*','*','',''),(110,'Altro','between','*','*','',''),(111,'Altro','chapter','*','*','',''),(112,'Altro','es file Explorer','*','*','',''),(113,'Altro','Nexive','*','*','',''),(114,'Altro','pubblica.istruzione','*','*','',''),(115,'Altro','Windows','*','*','',''),(116,'Altro','Wot','*','*','',''),(117,'Altro','IPPREMIA','*','*','',''),(118,'siti lavoro','etjca','*','*','',''),(119,'siti lavoro','Dedalus','*','*','','');
/*!40000 ALTER TABLE `password` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-04-01 21:58:08
