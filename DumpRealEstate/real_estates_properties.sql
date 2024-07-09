CREATE DATABASE  IF NOT EXISTS `real_estates` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `real_estates`;
-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: real_estates
-- ------------------------------------------------------
-- Server version	8.0.36

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
-- Table structure for table `properties`
--

DROP TABLE IF EXISTS `properties`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `properties` (
  `id` int NOT NULL AUTO_INCREMENT,
  `status` varchar(50) NOT NULL,
  `create_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `address` varchar(255) NOT NULL,
  `size` double NOT NULL,
  `amenities` text NOT NULL,
  `type` varchar(50) NOT NULL,
  `rent` double NOT NULL,
  `image` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `properties`
--

LOCK TABLES `properties` WRITE;
/*!40000 ALTER TABLE `properties` DISABLE KEYS */;
INSERT INTO `properties` VALUES (1,'Available','2024-05-19 22:38:38','455 Linzer Straße, 1140 Wien',120.5,'3 bedrooms, 2 bathrooms, garden, garage','House',1500,'C:\\Users\\AliciS\\Desktop\\JAVA_WIFI\\InSchulung\\RealEstateManagementSystem\\src\\main\\java\\org\\example\\image\\House.jpg'),(2,'Rented','2024-05-19 22:38:38','5 Hebbelplatz, 1100 Wien',85,'2 bedrooms, 1 bathroom, balcony','Apartment',850,NULL),(5,'Available','2024-05-20 01:03:36','92 Albertschweitzergasse, 1140 Wien',140,'3 bedrooms, 2 bathrooms, 1 balcony, 1 swimming pool','House',2500,'C:\\Users\\AliciS\\Downloads\\HouseWithSwimmingPool.jpg'),(7,'Under Maintenance','2024-05-20 11:54:35','3 Mariahilferstraße, 1070 Wien',45,'2 bedrooms, 1 kitchen','Loft',820,'C:UsersAliciSDesktopJAVA WIFIInSchulungRealEstateManagementSystemsrcmainjavaorgexampleimageLoft.jpg'),(9,'Available','2024-06-17 23:27:55','37 Johnstraße, 1150 Wien',56,'2 bedrooms, 1 bathroom, 1 kitchen, 1 balcony','Apartment',655,'C:\\Users\\AliciS\\Desktop\\JAVA WIFI\\InSchulung\\RealEstateManagementSystem\\src\\main\\java\\org\\example\\image\\Apartment.jpg');
/*!40000 ALTER TABLE `properties` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-07-08 15:20:06
