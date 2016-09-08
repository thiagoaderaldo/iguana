CREATE DATABASE  IF NOT EXISTS `iguana` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `iguana`;
-- MySQL dump 10.13  Distrib 5.7.13, for Linux (x86_64)
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
-- Table structure for table `unidade_organizacional`
--

DROP TABLE IF EXISTS `unidade_organizacional`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `unidade_organizacional` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `descricao` varchar(250) DEFAULT NULL,
  `instituicao` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_unidade_organizacional_instituicao` (`instituicao`),
  CONSTRAINT `fk_unidade_organizacional_id_instituicao` FOREIGN KEY (`instituicao`) REFERENCES `instituicao` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `unidade_organizacional`
--

LOCK TABLES `unidade_organizacional` WRITE;
/*!40000 ALTER TABLE `unidade_organizacional` DISABLE KEYS */;
INSERT INTO `unidade_organizacional` VALUES (1,'CESUP','Célula de Suporte',1),(2,'CETIC','Célula de Tecnologia da Informação',2),(3,'COTEC','Coordenadoria de Tecnologia da Informação',1),(4,'COAFI','Coordenadoria Administrativo Financeira',1),(5,'COAFI','Coordenadoria Administrativo Financeira',2),(6,'CEGEP','Célula de Gestão de Pessoas',1),(7,'COPSEC','Coordenadoria de Políticas em Segurança Cidadã',1),(8,'IPAM','Inspetoria de Proteção Ambiental',2),(9,'ITERM','Inspetoria dos Terminais',2),(10,'GOE','Grupo de Operações Especiais',2);
/*!40000 ALTER TABLE `unidade_organizacional` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-09-08 13:51:15
