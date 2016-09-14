-- MySQL dump 10.13  Distrib 5.7.15, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: iguana
-- ------------------------------------------------------
-- Server version	5.7.13-0ubuntu0.16.04.2

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
-- Table structure for table `detalhes_equipamento`
--

DROP TABLE IF EXISTS `detalhes_equipamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detalhes_equipamento` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `equipamento` int(11) NOT NULL,
  `mac` varchar(255) DEFAULT NULL,
  `sistema_operacional` varchar(45) DEFAULT NULL,
  `num_serie` varchar(45) DEFAULT NULL,
  `licenca_sist_operacional` varchar(45) DEFAULT NULL,
  `tipo_de_office` varchar(45) DEFAULT NULL,
  `licenca_office` varchar(45) DEFAULT NULL,
  `num_tombamento` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_detalhes_equipamento_id_equipamento_idx` (`equipamento`),
  CONSTRAINT `fk_detalhes_equipamento_equipamento` FOREIGN KEY (`equipamento`) REFERENCES `equipamentos` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalhes_equipamento`
--

LOCK TABLES `detalhes_equipamento` WRITE;
/*!40000 ALTER TABLE `detalhes_equipamento` DISABLE KEYS */;
/*!40000 ALTER TABLE `detalhes_equipamento` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-09-14 18:03:39
