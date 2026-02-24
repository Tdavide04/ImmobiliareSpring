-- MySQL dump 10.13  Distrib 8.0.45, for Linux (x86_64)
--
-- Host: localhost    Database: immobiliare
-- ------------------------------------------------------
-- Server version	8.0.45

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `immobile`
--

DROP TABLE IF EXISTS `immobile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `immobile` (
  `id_immobile` bigint NOT NULL AUTO_INCREMENT,
  `categoria_catastale` enum('A1','A10','A11','A2','A3','A4','A5','A6','A7','A8','A9','B1','B2','C1','C2','C3','D1','D2','D3','D4','D5','D6','D7','E1','E2','F1','F2') NOT NULL,
  `citta` varchar(100) NOT NULL,
  `disponibile` bit(1) NOT NULL,
  `indirizzo` varchar(255) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `prezzo` decimal(10,2) NOT NULL,
  `superficie` int NOT NULL,
  PRIMARY KEY (`id_immobile`),
  UNIQUE KEY `UKluqbykihra5h4hf21p92njmfm` (`nome`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `immobile`
--

LOCK TABLES `immobile` WRITE;
/*!40000 ALTER TABLE `immobile` DISABLE KEYS */;
INSERT INTO `immobile` VALUES (1,'A2','Roma',_binary '','Via Roma 1','Bilocale Via Roma 1',120000.00,80);
/*!40000 ALTER TABLE `immobile` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `immobile_tipologie`
--

DROP TABLE IF EXISTS `immobile_tipologie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `immobile_tipologie` (
  `id_immobile` bigint NOT NULL,
  `tipologia` enum('APPARTAMENTO','ATTICO','MONOLOCALE','NEGOZIO','UFFICIO','VILLA') DEFAULT NULL,
  KEY `FKk69dxkjhemd3l43v4rppcv9f` (`id_immobile`),
  CONSTRAINT `FKk69dxkjhemd3l43v4rppcv9f` FOREIGN KEY (`id_immobile`) REFERENCES `immobile` (`id_immobile`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `immobile_tipologie`
--

LOCK TABLES `immobile_tipologie` WRITE;
/*!40000 ALTER TABLE `immobile_tipologie` DISABLE KEYS */;
INSERT INTO `immobile_tipologie` VALUES (1,'APPARTAMENTO');
/*!40000 ALTER TABLE `immobile_tipologie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `utente`
--

DROP TABLE IF EXISTS `utente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `utente` (
  `id_utente` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `ruolo` enum('ADMIN','CLIENT') NOT NULL,
  `username` varchar(25) NOT NULL,
  PRIMARY KEY (`id_utente`),
  UNIQUE KEY `UKgxvq4mjswnupehxnp35vawmo2` (`email`),
  UNIQUE KEY `UK2vq82crxh3p7upassu0k1kmte` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utente`
--

LOCK TABLES `utente` WRITE;
/*!40000 ALTER TABLE `utente` DISABLE KEYS */;
INSERT INTO `utente` VALUES (1,'davide@example.it','$2a$10$bIXFsoKS9z6I9v9nVow7/O6qgApvvGlHEbD8JMBs6GgIoRtsH5d16','ADMIN','Davide');
/*!40000 ALTER TABLE `utente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vendita`
--

DROP TABLE IF EXISTS `vendita`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vendita` (
  `id_vendita` bigint NOT NULL AUTO_INCREMENT,
  `data_creazione` datetime(6) NOT NULL,
  `prezzo` decimal(38,2) NOT NULL,
  `id_immobile` bigint NOT NULL,
  `id_utente` bigint NOT NULL,
  PRIMARY KEY (`id_vendita`),
  KEY `FKk1104k40ly0bhkxab8my25nqt` (`id_immobile`),
  KEY `FK1thd16761xedmu44g55kd8x6o` (`id_utente`),
  CONSTRAINT `FK1thd16761xedmu44g55kd8x6o` FOREIGN KEY (`id_utente`) REFERENCES `utente` (`id_utente`),
  CONSTRAINT `FKk1104k40ly0bhkxab8my25nqt` FOREIGN KEY (`id_immobile`) REFERENCES `immobile` (`id_immobile`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vendita`
--

LOCK TABLES `vendita` WRITE;
/*!40000 ALTER TABLE `vendita` DISABLE KEYS */;
/*!40000 ALTER TABLE `vendita` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-02-23 10:00:08
