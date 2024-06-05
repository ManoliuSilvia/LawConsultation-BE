CREATE DATABASE  IF NOT EXISTS `legal_consult` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `legal_consult`;
-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: legal_consult
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
-- Table structure for table `case_assigs`
--

DROP TABLE IF EXISTS `case_assigs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `case_assigs` (
  `ca_id` int NOT NULL AUTO_INCREMENT,
  `lc_id` int NOT NULL,
  `user_id` int NOT NULL,
  `price` double DEFAULT NULL,
  PRIMARY KEY (`ca_id`),
  KEY `lc_id` (`lc_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `case_assigs_ibfk_1` FOREIGN KEY (`lc_id`) REFERENCES `legal_cases` (`lc_id`),
  CONSTRAINT `case_assigs_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `case_assigs`
--

LOCK TABLES `case_assigs` WRITE;
/*!40000 ALTER TABLE `case_assigs` DISABLE KEYS */;
INSERT INTO `case_assigs` VALUES (1,3,5,50),(2,5,5,123);
/*!40000 ALTER TABLE `case_assigs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `legal_cases`
--

DROP TABLE IF EXISTS `legal_cases`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `legal_cases` (
  `lc_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `lc_type` varchar(100) NOT NULL,
  `lc_description` varchar(255) NOT NULL,
  `lc_status` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`lc_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `legal_cases_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`),
  CONSTRAINT `legal_cases_chk_1` CHECK ((`lc_status` in (_utf8mb4'PENDING',_utf8mb4'IN_PROGRESS',_utf8mb4'CLOSED')))
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `legal_cases`
--

LOCK TABLES `legal_cases` WRITE;
/*!40000 ALTER TABLE `legal_cases` DISABLE KEYS */;
INSERT INTO `legal_cases` VALUES (1,10,'penal','am omorat o familie de 4',NULL),(2,10,'penal','am intrat cu masina in casa vecinolor','IN_PROGRESS'),(3,10,'penal','test_penal2','PENDING'),(4,10,'penal','test_penal3','PENDING'),(5,11,'penal','am omorat 3 oameni','IN_PROGRESS');
/*!40000 ALTER TABLE `legal_cases` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `requests`
--

DROP TABLE IF EXISTS `requests`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `requests` (
  `request_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `specialization` varchar(100) NOT NULL,
  `r_description` varchar(255) NOT NULL,
  `r_status` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`request_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `requests_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`),
  CONSTRAINT `requests_chk_1` CHECK ((`r_status` in (_utf8mb4'PENDING',_utf8mb4'APPROVED',_utf8mb4'REJECTED')))
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `requests`
--

LOCK TABLES `requests` WRITE;
/*!40000 ALTER TABLE `requests` DISABLE KEYS */;
INSERT INTO `requests` VALUES (1,1,'penal','VREAU SA FIU AVOCAT!','REJECTED'),(2,4,'penal','is cel mai smecher pe penal','APPROVED'),(3,6,'penal','is cel mai smecher pe penal','APPROVED'),(4,6,'penal','sudyas','REJECTED'),(5,6,'penal','asdasd','REJECTED'),(6,7,'penal','asuiydgauiygdiu','APPROVED'),(7,1,'penal','asdasd','APPROVED'),(8,2,'penal','ad','REJECTED'),(9,3,'penal','asdwads','APPROVED'),(10,4,'penal','dwadsa','REJECTED'),(11,10,'penal','am luat biciclist pe capota',NULL),(12,11,'penal','vreau sa fiu avocat',NULL),(13,11,'penal','asdawd','APPROVED'),(14,11,'penal','asioduhaisd','APPROVED'),(15,12,'penal','is smecher pe penal','APPROVED');
/*!40000 ALTER TABLE `requests` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `user_name` varchar(200) NOT NULL,
  `user_password` varchar(200) NOT NULL,
  `user_email` varchar(200) NOT NULL,
  `user_type` varchar(200) DEFAULT NULL,
  `user_specialization` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  CONSTRAINT `users_chk_1` CHECK ((`user_type` in (_utf8mb4'CLIENT',_utf8mb4'LAWYER')))
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'testclient','$2a$10$HkQoLUGy5vKJC58J7e8KieCPB0fHzi4Pcntkvh7hU4tHf9kWp4Moa','testclient@gmail.com','LAWYER','penal'),(2,'testavocat','$2a$10$.sbtftS5Z8lZGqkZM2sGI.EZ.lxletn7YpTFgPugqgeRINzKTYGdy','testavocat@gmail.com','CLIENT','civil'),(3,'1234','$2a$10$sDxFRpKVgUrgL2XDnvOwn.sVwr8Uqv60nAiwxBFhiaYNLv.oEg/Xq','123@gmail.com','LAWYER','penal'),(4,'123','$2a$10$Kwr1elqfjLSX8Ox.qbImw.MPWVUYyj9tevM/U9yIzqrrFkSbnr2ku','1231','CLIENT','penal'),(5,'123','$2a$10$3NHP857.AWffAQW3bd5/w.u6/WDkBGcd8TBPK9U9ITTubnEC4R77e','1232','LAWYER','penal'),(6,'dada','$2a$10$FeQ1KPFB.fibzHtVeuNVDuxY3FE49lZB7Ygq18klvTyl1tE1touGi','da','CLIENT','penal'),(7,'123','$2a$10$E89A01A3gXHnzCHvZht0K.laX1TZKK7I5/0l.qP4SSZOtDHPjona2','1234','LAWYER','penal'),(8,'test_postman','test1','test_postman','CLIENT',NULL),(9,'test_fe','test1','test_fe','CLIENT',NULL),(10,'test_client','$2a$10$BMFRNSHehzHlaS4R0T0a0eZHqQ8H..efSBK/XaFymLm4Z6HmJTOpm','test_client','CLIENT',NULL),(11,'test','$2a$10$BCNWxwWPpOo7rFSvNi2Ec.r2G0D0kFuRojnGzED1La/D9NujxQDAG','test','LAWYER','penal'),(12,'adismecher','$2a$10$Qwjq17uGQPFqJ00.QImDDOgJumneKKuy1OwgR9HiAWHFsZP67S3xy','adismecher@gmail.com','LAWYER','penal');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-05 11:47:31
