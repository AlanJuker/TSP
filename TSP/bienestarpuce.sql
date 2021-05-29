-- MySQL dump 10.13  Distrib 5.6.28, for Win64 (x86_64)
--
-- Host: localhost    Database: bienestarpuce
-- ------------------------------------------------------
-- Server version	5.6.28-log

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
-- Table structure for table `alimento`
--

DROP TABLE IF EXISTS `alimento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `alimento` (
  `NOMBRE_ALIMENTO` varchar(20) NOT NULL,
  `CODIGO_PLAN_NUTRICION` varchar(4) DEFAULT NULL,
  `TIPO_ALIMENTO` varchar(10) DEFAULT NULL,
  `CANTIDAD` float DEFAULT NULL,
  `UNIDADMEDIDA` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`NOMBRE_ALIMENTO`),
  KEY `FK_ALIMENTO_ALIMENTO__PLANNUTR` (`CODIGO_PLAN_NUTRICION`),
  CONSTRAINT `FK_ALIMENTO_ALIMENTO__PLANNUTR` FOREIGN KEY (`CODIGO_PLAN_NUTRICION`) REFERENCES `plannutricion` (`CODIGO_PLAN_NUTRICION`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alimento`
--

LOCK TABLES `alimento` WRITE;
/*!40000 ALTER TABLE `alimento` DISABLE KEYS */;
/*!40000 ALTER TABLE `alimento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `citamedica`
--

DROP TABLE IF EXISTS `citamedica`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `citamedica` (
  `IDCITA` varchar(4) NOT NULL,
  `ID_MEDICO` varchar(10) NOT NULL,
  `ID_PACIENTE` varchar(10) NOT NULL,
  `FECHA` datetime DEFAULT NULL,
  `COMENTARIOS` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`IDCITA`),
  KEY `FK_CITAMEDI_MEDICO_TI_MEDICO` (`ID_MEDICO`),
  KEY `FK_CITAMEDI_PACIENTE__PACIENTE` (`ID_PACIENTE`),
  CONSTRAINT `FK_CITAMEDI_MEDICO_TI_MEDICO` FOREIGN KEY (`ID_MEDICO`) REFERENCES `medico` (`ID_MEDICO`),
  CONSTRAINT `FK_CITAMEDI_PACIENTE__PACIENTE` FOREIGN KEY (`ID_PACIENTE`) REFERENCES `paciente` (`ID_PACIENTE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `citamedica`
--

LOCK TABLES `citamedica` WRITE;
/*!40000 ALTER TABLE `citamedica` DISABLE KEYS */;
/*!40000 ALTER TABLE `citamedica` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ejercicio`
--

DROP TABLE IF EXISTS `ejercicio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ejercicio` (
  `NOMBRE_EJERCICIO` varchar(20) NOT NULL,
  `CODIGO_RUTINA` varchar(4) DEFAULT NULL,
  `TIPO_EJERCICIO` varchar(10) DEFAULT NULL,
  `REPETICIONES` int(11) DEFAULT NULL,
  `COMENTARIO_EJERCICIO` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`NOMBRE_EJERCICIO`),
  KEY `FK_EJERCICI_RUTINA_TI_RUTINA` (`CODIGO_RUTINA`),
  CONSTRAINT `FK_EJERCICI_RUTINA_TI_RUTINA` FOREIGN KEY (`CODIGO_RUTINA`) REFERENCES `rutina` (`CODIGO_RUTINA`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ejercicio`
--

LOCK TABLES `ejercicio` WRITE;
/*!40000 ALTER TABLE `ejercicio` DISABLE KEYS */;
/*!40000 ALTER TABLE `ejercicio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `imc`
--

DROP TABLE IF EXISTS `imc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `imc` (
  `CODIGO_IMC` varchar(4) NOT NULL,
  `ID_PACIENTE` varchar(10) NOT NULL,
  `INDICE_MASA` float DEFAULT NULL,
  PRIMARY KEY (`CODIGO_IMC`),
  KEY `FK_IMC_PACIENTE__PACIENTE` (`ID_PACIENTE`),
  CONSTRAINT `FK_IMC_PACIENTE__PACIENTE` FOREIGN KEY (`ID_PACIENTE`) REFERENCES `paciente` (`ID_PACIENTE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `imc`
--

LOCK TABLES `imc` WRITE;
/*!40000 ALTER TABLE `imc` DISABLE KEYS */;
/*!40000 ALTER TABLE `imc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medico`
--

DROP TABLE IF EXISTS `medico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `medico` (
  `ID_MEDICO` varchar(10) NOT NULL,
  `NOMBRE_MEDICO` varchar(50) DEFAULT NULL,
  `GENERO_MEDICO` char(1) DEFAULT NULL,
  `USUARIO_MEDICO` varchar(15) DEFAULT NULL,
  `CONTRASENIA_MEDICO` varchar(16) DEFAULT NULL,
  `ESPECIALIDAD` varchar(50) DEFAULT NULL,
  `DEPARTAMENTO` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`ID_MEDICO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medico`
--

LOCK TABLES `medico` WRITE;
/*!40000 ALTER TABLE `medico` DISABLE KEYS */;
/*!40000 ALTER TABLE `medico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paciente`
--

DROP TABLE IF EXISTS `paciente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paciente` (
  `ID_PACIENTE` varchar(10) NOT NULL,
  `NOMBRE_PACIENTE` varchar(50) DEFAULT NULL,
  `GENERO_PACIENTE` char(1) DEFAULT NULL,
  `USUARIO_PACIENTE` varchar(15) DEFAULT NULL,
  `CONTRASENIA_PACIENTE` varchar(16) DEFAULT NULL,
  `ALTURA` float DEFAULT NULL,
  `PESO` float DEFAULT NULL,
  `EDAD` float DEFAULT NULL,
  PRIMARY KEY (`ID_PACIENTE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paciente`
--

LOCK TABLES `paciente` WRITE;
/*!40000 ALTER TABLE `paciente` DISABLE KEYS */;
/*!40000 ALTER TABLE `paciente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `plannutricion`
--

DROP TABLE IF EXISTS `plannutricion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `plannutricion` (
  `CODIGO_PLAN_NUTRICION` varchar(4) NOT NULL,
  `IDCITA` varchar(4) NOT NULL,
  PRIMARY KEY (`CODIGO_PLAN_NUTRICION`),
  KEY `FK_PLANNUTR_CITA_MEDI_CITAMEDI` (`IDCITA`),
  CONSTRAINT `FK_PLANNUTR_CITA_MEDI_CITAMEDI` FOREIGN KEY (`IDCITA`) REFERENCES `citamedica` (`IDCITA`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plannutricion`
--

LOCK TABLES `plannutricion` WRITE;
/*!40000 ALTER TABLE `plannutricion` DISABLE KEYS */;
/*!40000 ALTER TABLE `plannutricion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rutina`
--

DROP TABLE IF EXISTS `rutina`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rutina` (
  `CODIGO_RUTINA` varchar(4) NOT NULL,
  `IDCITA` varchar(4) NOT NULL,
  PRIMARY KEY (`CODIGO_RUTINA`),
  KEY `FK_RUTINA_CITA_MEDI_CITAMEDI` (`IDCITA`),
  CONSTRAINT `FK_RUTINA_CITA_MEDI_CITAMEDI` FOREIGN KEY (`IDCITA`) REFERENCES `citamedica` (`IDCITA`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rutina`
--

LOCK TABLES `rutina` WRITE;
/*!40000 ALTER TABLE `rutina` DISABLE KEYS */;
/*!40000 ALTER TABLE `rutina` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-28 19:12:20
