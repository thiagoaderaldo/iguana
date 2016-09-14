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
-- Table structure for table `assuntos`
--

DROP TABLE IF EXISTS `assuntos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `assuntos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UNQ_assuntos_0` (`id`),
  UNIQUE KEY `assunto_UNIQUE` (`nome`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assuntos`
--

LOCK TABLES `assuntos` WRITE;
/*!40000 ALTER TABLE `assuntos` DISABLE KEYS */;
INSERT INTO `assuntos` VALUES (5,'AUXILIO'),(1,'CONFIGURACAO'),(2,'CONSERTO'),(3,'INSTALACAO'),(4,'REMOCAO');
/*!40000 ALTER TABLE `assuntos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `atendimentos`
--

DROP TABLE IF EXISTS `atendimentos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `atendimentos` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `data_atendimento` date NOT NULL,
  `hora_atendimento` time NOT NULL,
  `observacao` varchar(45) DEFAULT NULL,
  `marcadores` varchar(45) DEFAULT NULL,
  `solucao` text,
  `responsavel` varchar(45) NOT NULL,
  `id_solicitacao` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_atendimentos_solicitacoes_idx` (`id_solicitacao`),
  CONSTRAINT `fk_atendimentos_solicitacoes` FOREIGN KEY (`id_solicitacao`) REFERENCES `solicitacoes` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `atendimentos`
--

LOCK TABLES `atendimentos` WRITE;
/*!40000 ALTER TABLE `atendimentos` DISABLE KEYS */;
INSERT INTO `atendimentos` VALUES (1,'0016-09-13','10:21:00','Teste','Teste','Teste','Iguana - xxxxx',333);
/*!40000 ALTER TABLE `atendimentos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `dashboard_diaria`
--

DROP TABLE IF EXISTS `dashboard_diaria`;
/*!50001 DROP VIEW IF EXISTS `dashboard_diaria`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `dashboard_diaria` AS SELECT 
 1 AS `qtd_atd_abertos`,
 1 AS `qtd_atd_pdtes`,
 1 AS `slc_atd_em_%`,
 1 AS `qtd_atd_espr`*/;
SET character_set_client = @saved_cs_client;

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

--
-- Table structure for table `dispositivos`
--

DROP TABLE IF EXISTS `dispositivos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dispositivos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UNQ_dispositivos_0` (`id`),
  UNIQUE KEY `nome_UNIQUE` (`nome`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dispositivos`
--

LOCK TABLES `dispositivos` WRITE;
/*!40000 ALTER TABLE `dispositivos` DISABLE KEYS */;
INSERT INTO `dispositivos` VALUES (14,'CABO DE FORCA'),(1,'CAIXA DE SOM'),(9,'CELULAR'),(2,'CPU'),(7,'FONE DE OUVIDO'),(15,'FONTE DE ALIMENTACAO'),(11,'IMPRESSORA'),(5,'MONITOR'),(3,'MOUSE'),(8,'NOTEBOOK'),(12,'ROTEADOR'),(13,'SWITCH'),(10,'TABLET'),(4,'TECLADO'),(6,'WEB CAM');
/*!40000 ALTER TABLE `dispositivos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `equipamentos`
--

DROP TABLE IF EXISTS `equipamentos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `equipamentos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `tipo_dispositivo` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_equipamentos_id_dispositivo_idx` (`tipo_dispositivo`),
  CONSTRAINT `fk_equipamentos_id_dispositivo` FOREIGN KEY (`tipo_dispositivo`) REFERENCES `dispositivos` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipamentos`
--

LOCK TABLES `equipamentos` WRITE;
/*!40000 ALTER TABLE `equipamentos` DISABLE KEYS */;
/*!40000 ALTER TABLE `equipamentos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estatus`
--

DROP TABLE IF EXISTS `estatus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estatus` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `estatus_UNIQUE` (`nome`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estatus`
--

LOCK TABLES `estatus` WRITE;
/*!40000 ALTER TABLE `estatus` DISABLE KEYS */;
INSERT INTO `estatus` VALUES (1,'EXECUTANDO',NULL),(2,'PENDENTE',NULL),(3,'PARADO',NULL),(4,'ANALISANDO',NULL),(5,'CONCLUIDO',NULL);
/*!40000 ALTER TABLE `estatus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grupo_do_usuario`
--

DROP TABLE IF EXISTS `grupo_do_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `grupo_do_usuario` (
  `login` varchar(45) NOT NULL,
  `nome_grupo` varchar(100) NOT NULL,
  PRIMARY KEY (`login`,`nome_grupo`),
  KEY `fk_grupoDoUsuario_1` (`login`),
  KEY `fk_grupoDoUsuario_2` (`nome_grupo`),
  CONSTRAINT `fk_grupoDoUsuario_1` FOREIGN KEY (`login`) REFERENCES `usuarios` (`login`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_grupoDoUsuario_2` FOREIGN KEY (`nome_grupo`) REFERENCES `grupos` (`nome`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grupo_do_usuario`
--

LOCK TABLES `grupo_do_usuario` WRITE;
/*!40000 ALTER TABLE `grupo_do_usuario` DISABLE KEYS */;
INSERT INTO `grupo_do_usuario` VALUES ('iguana','admin');
/*!40000 ALTER TABLE `grupo_do_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grupos`
--

DROP TABLE IF EXISTS `grupos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `grupos` (
  `nome` varchar(100) NOT NULL,
  `descricao` varchar(255) NOT NULL,
  PRIMARY KEY (`nome`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grupos`
--

LOCK TABLES `grupos` WRITE;
/*!40000 ALTER TABLE `grupos` DISABLE KEYS */;
INSERT INTO `grupos` VALUES ('admin','Grupo de Administradores do Sistema');
/*!40000 ALTER TABLE `grupos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `instituicao`
--

DROP TABLE IF EXISTS `instituicao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `instituicao` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nome_UNIQUE` (`nome`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `instituicao`
--

LOCK TABLES `instituicao` WRITE;
/*!40000 ALTER TABLE `instituicao` DISABLE KEYS */;
INSERT INTO `instituicao` VALUES (1,'SESEC','Secretaria Municipal de Segurança Cidadã'),(2,'GMF','Guarda Municipal de Fortaleza');
/*!40000 ALTER TABLE `instituicao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `linguagem`
--

DROP TABLE IF EXISTS `linguagem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `linguagem` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `descricao` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `linguagem`
--

LOCK TABLES `linguagem` WRITE;
/*!40000 ALTER TABLE `linguagem` DISABLE KEYS */;
INSERT INTO `linguagem` VALUES (1,'pt_BR','Português do Brasil'),(2,'en_US','English');
/*!40000 ALTER TABLE `linguagem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `origem`
--

DROP TABLE IF EXISTS `origem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `origem` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `descricao` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nome_UNIQUE` (`nome`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `origem`
--

LOCK TABLES `origem` WRITE;
/*!40000 ALTER TABLE `origem` DISABLE KEYS */;
INSERT INTO `origem` VALUES (1,'SPU','Sistema de Protocolo Único'),(2,'TELEFONE',''),(3,'EMAIL',NULL),(4,'PRESENCIAL',NULL),(5,'WEB CHAMADO',NULL);
/*!40000 ALTER TABLE `origem` ENABLE KEYS */;
UNLOCK TABLES;

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

--
-- Table structure for table `solicitante`
--

DROP TABLE IF EXISTS `solicitante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `solicitante` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `email` varchar(150) NOT NULL,
  `telefone` varchar(45) DEFAULT NULL,
  `unidade_organizacional` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_solicitante_id_unidade_organizacional_idx` (`unidade_organizacional`),
  CONSTRAINT `fk_solicitante_unidade_organizacional` FOREIGN KEY (`unidade_organizacional`) REFERENCES `unidade_organizacional` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `solicitante`
--

LOCK TABLES `solicitante` WRITE;
/*!40000 ALTER TABLE `solicitante` DISABLE KEYS */;
INSERT INTO `solicitante` VALUES (1,'Thiago Aderaldo Lessa','thiago.aderaldo@fortaleza.ce.gov.br','(85)988776655',1),(2,'Fulano dos Santos','fulano.santos@fortaleza.ce.gov.br','',3),(3,'Cicrano da Silva','cicrano.silva@fortaleza.ce.gov.br','',2);
/*!40000 ALTER TABLE `solicitante` ENABLE KEYS */;
UNLOCK TABLES;

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

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuarios` (
  `matricula` varchar(100) NOT NULL,
  `nome` varchar(250) NOT NULL,
  `telefone` varchar(45) DEFAULT NULL,
  `celular` varchar(45) DEFAULT NULL,
  `login` varchar(45) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `imagem` varchar(255) DEFAULT NULL,
  `senha` varchar(100) NOT NULL,
  `habilitado` tinyint(1) NOT NULL DEFAULT '1',
  `linguagem` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`matricula`),
  UNIQUE KEY `UNQ_usuarios_1` (`matricula`),
  UNIQUE KEY `login_UNIQUE` (`login`),
  UNIQUE KEY `UNQ_usuarios_0` (`email`),
  KEY `fk_usuarios_linguagem` (`linguagem`),
  CONSTRAINT `fk_usuarios_linguagem` FOREIGN KEY (`linguagem`) REFERENCES `linguagem` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES ('xxxxx','Iguana','','','iguana','iguana@codigof.com.br','','6b86b273ff34fce19d6b804eff5a3f5747ada4eaa22f1d49c01e52ddb7875b4b',1,1);
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Final view structure for view `dashboard_diaria`
--

/*!50001 DROP VIEW IF EXISTS `dashboard_diaria`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `dashboard_diaria` AS select (select count(`solicitacoes`.`data_solicitacao`) from `solicitacoes` where (`solicitacoes`.`data_solicitacao` = curdate())) AS `qtd_atd_abertos`,(select count(`solicitacoes`.`estatus`) from `solicitacoes` where ((`solicitacoes`.`estatus` = 1) and (`solicitacoes`.`data_solicitacao` = curdate()))) AS `qtd_atd_pdtes`,(select (((select count(`solicitacoes`.`estatus`) from `solicitacoes` where ((`solicitacoes`.`estatus` = 3) and (`solicitacoes`.`data_solicitacao` = curdate()))) / (select count(`solicitacoes`.`estatus`) from `solicitacoes` where ((`solicitacoes`.`estatus` <> 3) and (`solicitacoes`.`data_solicitacao` = curdate())))) * 100)) AS `slc_atd_em_%`,(select count(`solicitacoes`.`estatus`) from `solicitacoes` where ((`solicitacoes`.`estatus` = 2) and (`solicitacoes`.`data_solicitacao` = curdate()))) AS `qtd_atd_espr` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-09-14 18:02:23
