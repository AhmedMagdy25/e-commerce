-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: e-commerce
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `products` (
  `product_id` varchar(45) NOT NULL,
  `product_name` text,
  `product_details` text,
  `product_img` text,
  `product_price` float DEFAULT NULL,
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES ('6320d6d91ced64479ad0e5b3','ASUS ROG Strix Scar 15','Gaming Laptop, 15.6” 300Hz IPS FHD Display, NVIDIA GeForce RTX 3070 Ti…','p7.jpg',2000),('6320d6d91ced64479ad0e5b4','Lenovo Ideapad 3 Laptop','Laptop, 15.6 HD Touchscreen 11th Gen Intel Core i3-1115G4 Processor…','p6.jpg',950),('6320d6d91ced64479ad0e5b5','Apple MacBook Pro','(16-inch, Apple M1 Pro chip with 10‑core CPU and 16‑core GPU, 16GB RAM…','p8.jpg',2500),('6320d6d91ced64479ad0e5b6','MSI GV15','15.6 144Hz Gaming Laptop Intel Core i5-11400H GTX 1650 8GB 256GB NVM…','p2.jpg',750),('6320d6d91ced64479ad0e5b7','Apple iPad',' (10.2-Inch, Wi-Fi, 32GB) - Space Gray,...','p4.jpg',360),('6320d6d91ced64479ad0e5b8','SAMSUNG Galaxy Tab S7 FE','12.4” 64GB WiFi Android Tablet w/ S Pen Included, Large Screen, Multi …','p1.jpg',530),('6320d6d91ced64479ad0e5b9','Samsung Galaxy A12','(32GB, 3GB) 6.5 HD+ Quad Camera 5000mAh Battery Global 4G Volte…','p9.jpg',135),('6320d6d91ced64479ad0e5ba','Apple iPhone 11 Pro','US Version, 256GB, Gold - Unlocked,...','p10.jpg',520),('6320d6d91ced64479ad0e5bb','Google Pixel 6a','5G Android Phone - Unlocked Smartphone with 12 Megapixel Camera and 24…','p11.jpg',449),('6320d6d91ced64479ad0e5bc','SAMSUNG Galaxy Z Fold 4','Factory Unlocked Android Smartphone, 256GB, Flex Mode, Hands Free Vide…','p5.jpg',1800),('633876e729cbf2b2916b9aa1','Apple iPad Pro 12.9-inch','Apple M1 chip for next-level performance.Brilliant 12.9-inch Liquid Re…','p3.jpg',1300);
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-12 15:57:51
