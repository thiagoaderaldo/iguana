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
-- Table structure for table `solicitacoes`
--

DROP TABLE IF EXISTS `solicitacoes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `solicitacoes` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `protocolo` varchar(45) DEFAULT NULL,
  `origem` int(11) NOT NULL,
  `protocolo_origem` varchar(45) DEFAULT NULL,
  `titulo_solicitacao` varchar(45) NOT NULL,
  `data_solicitacao` date NOT NULL,
  `hora_solicitacao` time NOT NULL,
  `assunto` int(11) DEFAULT NULL,
  `dispositivo` int(11) DEFAULT NULL,
  `localizacao` varchar(45) NOT NULL,
  `solicitante` int(11) NOT NULL,
  `descricao` mediumtext NOT NULL,
  `estatus` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UNQ_atendimentos_0` (`id`),
  KEY `FK_solicitacoes_assuntos` (`assunto`),
  KEY `FK_solicitacoes_dispositivos` (`dispositivo`),
  KEY `fk_atendimentos_idEstatus_idx` (`estatus`),
  KEY `fk_atendimentos_id_solicitante_idx` (`solicitante`),
  KEY `fk_solicitacoes_origem_idx` (`origem`),
  CONSTRAINT `FK_solicitacoes_assuntos` FOREIGN KEY (`assunto`) REFERENCES `assuntos` (`id`),
  CONSTRAINT `FK_solicitacoes_dispositivos` FOREIGN KEY (`dispositivo`) REFERENCES `dispositivos` (`id`),
  CONSTRAINT `fk_solicitacoes_estatus` FOREIGN KEY (`estatus`) REFERENCES `estatus` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_solicitacoes_origem` FOREIGN KEY (`origem`) REFERENCES `origem` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_solicitacoes_solicitante` FOREIGN KEY (`solicitante`) REFERENCES `solicitante` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=334 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `solicitacoes`
--

LOCK TABLES `solicitacoes` WRITE;
/*!40000 ALTER TABLE `solicitacoes` DISABLE KEYS */;
INSERT INTO `solicitacoes` VALUES (333,'20160914173543',1,'P097856/2016','Computador com defeito','0016-09-13','08:40:00',2,2,'Sala 10',2,'Teste.',2);
/*!40000 ALTER TABLE `solicitacoes` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-09-14 18:03:38
