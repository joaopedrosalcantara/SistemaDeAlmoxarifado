CREATE DATABASE  IF NOT EXISTS `trabalhopoo2` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `trabalhopoo2`;
-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: localhost    Database: trabalhopoo2
-- ------------------------------------------------------
-- Server version	8.0.26

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `ID_cliente` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) DEFAULT NULL,
  `telefone` varchar(100) DEFAULT NULL,
  `endereco` varchar(100) DEFAULT NULL,
  `cnpj` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID_cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estrado`
--

DROP TABLE IF EXISTS `estrado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estrado` (
  `ID_estrado` int NOT NULL AUTO_INCREMENT,
  `quantAtual` int NOT NULL,
  `quantMax` int NOT NULL,
  PRIMARY KEY (`ID_estrado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estrado`
--

LOCK TABLES `estrado` WRITE;
/*!40000 ALTER TABLE `estrado` DISABLE KEYS */;
/*!40000 ALTER TABLE `estrado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `itens_comprados`
--

DROP TABLE IF EXISTS `itens_comprados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `itens_comprados` (
  `ID_itens_comprados` int NOT NULL AUTO_INCREMENT,
  `ID_Peca` int NOT NULL,
  `quant_entregue_total` int DEFAULT NULL,
  `quant_compra` int DEFAULT NULL,
  `ID_OrdemCompra` int NOT NULL,
  PRIMARY KEY (`ID_itens_comprados`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `itens_comprados`
--

LOCK TABLES `itens_comprados` WRITE;
/*!40000 ALTER TABLE `itens_comprados` DISABLE KEYS */;
/*!40000 ALTER TABLE `itens_comprados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `itens_pedido`
--

DROP TABLE IF EXISTS `itens_pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `itens_pedido` (
  `ID_itens_pedido` int NOT NULL AUTO_INCREMENT,
  `ID_pedido` int NOT NULL,
  `quant` int NOT NULL,
  `ID_Peca` int NOT NULL,
  PRIMARY KEY (`ID_itens_pedido`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `itens_pedido`
--

LOCK TABLES `itens_pedido` WRITE;
/*!40000 ALTER TABLE `itens_pedido` DISABLE KEYS */;
/*!40000 ALTER TABLE `itens_pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ordem_compra`
--

DROP TABLE IF EXISTS `ordem_compra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ordem_compra` (
  `ID_Ordem_compra` int NOT NULL AUTO_INCREMENT,
  `status` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID_Ordem_compra`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ordem_compra`
--

LOCK TABLES `ordem_compra` WRITE;
/*!40000 ALTER TABLE `ordem_compra` DISABLE KEYS */;
/*!40000 ALTER TABLE `ordem_compra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `peca`
--

DROP TABLE IF EXISTS `peca`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `peca` (
  `ID_Peca` int NOT NULL AUTO_INCREMENT,
  `ValorPeca` float DEFAULT NULL,
  `Local` varchar(100) DEFAULT NULL,
  `UPC` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID_Peca`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `peca`
--

LOCK TABLES `peca` WRITE;
/*!40000 ALTER TABLE `peca` DISABLE KEYS */;
/*!40000 ALTER TABLE `peca` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pecas_estrados`
--

DROP TABLE IF EXISTS `pecas_estrados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pecas_estrados` (
  `ID_pecaEstrado` int NOT NULL AUTO_INCREMENT,
  `ID_estrado` int NOT NULL,
  `quantPeca` int NOT NULL,
  `ID_Peca` int NOT NULL,
  PRIMARY KEY (`ID_pecaEstrado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pecas_estrados`
--

LOCK TABLES `pecas_estrados` WRITE;
/*!40000 ALTER TABLE `pecas_estrados` DISABLE KEYS */;
/*!40000 ALTER TABLE `pecas_estrados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedido`
--

DROP TABLE IF EXISTS `pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pedido` (
  `ID_pedido` int NOT NULL AUTO_INCREMENT,
  `ID_cliente` int NOT NULL,
  PRIMARY KEY (`ID_pedido`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedido`
--

LOCK TABLES `pedido` WRITE;
/*!40000 ALTER TABLE `pedido` DISABLE KEYS */;
INSERT INTO `pedido` VALUES (3,1);
/*!40000 ALTER TABLE `pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `receptaculo`
--

DROP TABLE IF EXISTS `receptaculo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `receptaculo` (
  `ID_receptaculo` int NOT NULL AUTO_INCREMENT,
  `ID_Peca` int NOT NULL,
  `posicao` int NOT NULL,
  `corredor` int NOT NULL,
  `quantAtual` int NOT NULL,
  `quantMax` int NOT NULL,
  PRIMARY KEY (`ID_receptaculo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `receptaculo`
--

LOCK TABLES `receptaculo` WRITE;
/*!40000 ALTER TABLE `receptaculo` DISABLE KEYS */;
/*!40000 ALTER TABLE `receptaculo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-08-17 12:23:25
