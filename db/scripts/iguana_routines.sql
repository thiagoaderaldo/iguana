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

-- Dump completed on 2016-09-08 13:51:16
