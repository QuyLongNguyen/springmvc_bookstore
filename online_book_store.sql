CREATE DATABASE  IF NOT EXISTS `online_book_store` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `online_book_store`;
-- MySQL dump 10.13  Distrib 8.0.25, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: online_book_store
-- ------------------------------------------------------
-- Server version	8.0.25

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
-- Table structure for table `bill`
--

DROP TABLE IF EXISTS `bill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bill` (
  `bill_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `date_created` datetime DEFAULT NULL,
  `status_id` int DEFAULT NULL,
  PRIMARY KEY (`bill_id`),
  KEY `fk_user_id_idx` (`user_id`),
  KEY `fk_status_id_bill` (`status_id`),
  CONSTRAINT `fk_status_id_bill` FOREIGN KEY (`status_id`) REFERENCES `status` (`status_id`),
  CONSTRAINT `fk_user_id_bill` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bill`
--

LOCK TABLES `bill` WRITE;
/*!40000 ALTER TABLE `bill` DISABLE KEYS */;
INSERT INTO `bill` VALUES (1,6,'2021-08-28 21:46:30',1);
/*!40000 ALTER TABLE `bill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bill_item`
--

DROP TABLE IF EXISTS `bill_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bill_item` (
  `bill_item_id` int NOT NULL AUTO_INCREMENT,
  `bill_id` int DEFAULT NULL,
  `book_id` int DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  PRIMARY KEY (`bill_item_id`),
  KEY `fk_bill_id` (`bill_id`),
  KEY `fk_book_bill_item` (`book_id`),
  CONSTRAINT `fk_bill_id` FOREIGN KEY (`bill_id`) REFERENCES `bill` (`bill_id`) ON DELETE CASCADE,
  CONSTRAINT `fk_book_bill_item` FOREIGN KEY (`book_id`) REFERENCES `book` (`book_id`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bill_item`
--

LOCK TABLES `bill_item` WRITE;
/*!40000 ALTER TABLE `bill_item` DISABLE KEYS */;
INSERT INTO `bill_item` VALUES (1,1,22,10.07,2);
/*!40000 ALTER TABLE `bill_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book` (
  `book_id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(64) NOT NULL,
  `author` varchar(32) DEFAULT NULL,
  `publish_year` int DEFAULT NULL,
  `cover` varchar(128) DEFAULT NULL,
  `description` text,
  `price` decimal(10,2) DEFAULT '0.00',
  `quantity` int DEFAULT '0',
  `category_id` int DEFAULT NULL,
  PRIMARY KEY (`book_id`),
  KEY `fk_category_id_idx` (`category_id`),
  CONSTRAINT `fk_category_id` FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (16,'The alchemist','Paulo Cello',1993,'book_cover_16.jpg','The story of the treasures Santiago finds along the way teaches us, as only a few stories can, about the essential wisdom of listening to our hearts, learning to read the omens strewn along life\'s path, and, above all, following our dreams.',18.01,24,7),(17,'The Godfather','Mario Puzo',1969,'book_cover_17.jpg','A tale of family and society, law and order, obedience and rebellion, it reveals the dark passions of human nature played out against a backdrop of the American dream.',9.99,31,7),(18,'Gone with the wind','Margaret Mitchell',1936,'book_cover_18.jpg','This is the tale of Scarlett OHara, the spoiled, manipulative daughter of a wealthy plantation owner, who arrives at young womanhood just in time to see the Civil War forever change her way of life. A sweeping story of tangled passion and courage, in the pages of Gone With the Wind, Margaret Mitchell brings to life the unforgettable characters that have captured readers for over seventy years.',11.79,41,7),(19,'To Kill a Mockingbird','Harper Lee',1962,'book_cover_19.jpg','One of the most cherished stories of all time, To Kill a Mockingbird has been translated into more than forty languages, sold more than forty million copies worldwide, served as the basis for an enormously popular motion picture, and was voted one of the best novels of the twentieth century by librarians across the country. A gripping, heart-wrenching, and wholly remarkable tale of coming-of-age in a South poisoned by virulent prejudice, it views a world of great beauty and savage inequities through the eyes of a young girl, as her fathera crusading local lawyerrisks everything to defend a black man unjustly accused of a terrible crime.',10.99,22,7),(20,'The Story Of A Seagull And The Cat Who Taught Her To Fly','Luis Sepulveda',2006,'book_cover_20.jpg','A worldwide bestseller and the subject of a feature film, THE STORY OF A SEAGULL... is finally out in paperback!\r\n\r\nHer wings burdened by an oil slick, a seagull struggles to the nearest port to lay her final egg. Exhausted, she lands on a balcony where Zorba the cat is sunning himself. She extracts three extraordinary promises from him: that he will watch over the egg, that he will not EAT the egg, and that, when it\'s time, he will teach the baby gull to fly. The first two promises are hard enough, but the third one is surely impossible. Isn\'t it?',5.35,38,7),(21,'A Brief History of Time','Stephen Hawking',1998,'book_cover_21.jpg','A landmark volume in science writing by one of the great minds of our time, Stephen Hawkings book explores such profound questions as: How did the universe beginand what made its start possible? Does time always flow forward? Is the universe unendingor are there boundaries? Are there other dimensions in space? What will happen when it all ends?\r\n\r\nTold in language we all can understand, A Brief History of Time plunges into the exotic realms of black holes and quarks, of antimatter and arrows of time, of the big bang and a bigger Godwhere the possibilities are wondrous and unexpected. With exciting images and profound imagination, Stephen Hawking brings us closer to the ultimate secrets at the very heart of creation.',9.95,32,8),(22,'Relativity','Albert Einstein',1915,'book_cover_22.jpg','In addition to the theories themselves, this book contains a final part presenting fascinating considerations on the universe as a whole. Appendices cover the simple derivation of the Lorentz transformation, Minkowski\'s four-dimensional space, and the experimental confirmation of the general theory of relativity. Students, teachers, and other scientifically minded readers will appreciate this inexpensive and accessible interpretation of one of the world\'s greatest intellectual accomplishments.',10.07,12,8),(23,'The world is flat','Thomas L. Friedman',2007,'book_cover_23.jpg','\"One mark of a great book is that it makes you see things in a new way, and Mr. Friedman certainly succeeds in that goal,\" the Nobel laureate Joseph E. Stiglitz wrote in The New York Times reviewing The World Is Flat in 2005. In this new edition, Thomas L. Friedman includes fresh stories and insights to help us understand the flattening of the world. Weaving new information into his overall thesis, and answering the questions he has been most frequently asked by parents across the country, this third edition also includes two new chapters--on how to be a political activist and social entrepreneur in a flat world; and on the more troubling question of how to manage our reputations and privacy in a world where we are all becoming publishers and public figures.',11.29,8,9),(24,'Think and grow rich','Napoleon Hill',0,'book_cover_24.jpg','Think and Grow Rich has been called the \"Granddaddy of All Motivational Literature.\" It was the first book to boldly ask, \"What makes a winner?\" The man who asked and listened for the answer, Napoleon Hill, is now counted in the top ranks of the world\'s winners himself.\r\nThe most famous of all teachers of success spent \"a fortune and the better part of a lifetime of effort\" to produce the \"Law of Success\" philosophy that forms the basis of his books and that is so powerfully summarized in this one.',1922.00,53,9),(25,'Good to great','Jim Collins',2003,'book_cover_25.jpg','Five years ago, Jim Collins asked the question, \"Can a good company become a great company and if so, how?\" In Good to Great Collins, the author of Built to Last, concludes that it is possible, but finds there are no silver bullets. Collins and his team of researchers began their quest by sorting through a list of 1,435 companies, looking for those that made substantial improvements in their performance over time. They finally settled on 11--including Fannie Mae, Gillette, Walgreens, and Wells Fargo--and discovered common traits that challenged many of the conventional notions of corporate success. Making the transition from good to great doesn\'t require a high-profile CEO, the latest technology, innovative change management, or even a fine-tuned business strategy. At the heart of those rare and truly great companies was a corporate culture that rigorously found and promoted disciplined people to think and act in a disciplined manner. Peppered with dozens of stories and examples from the great and not so great, the book offers a well-reasoned road map to excellence that any organization would do well to consider. Like Built to Last, Good to Great is one of those books that managers and CEOs will be reading and rereading for years to come',13.07,31,9),(26,'Becoming','Michelle Obama',0,'book_cover_26.jpg','In her memoir, a work of deep reflection and mesmerizing storytelling, Michelle Obama invites listeners into her world, chronicling the experiences that have shaped her - from her childhood on the South Side of Chicago to her years as an executive balancing the demands of motherhood and work to her time spent at the world\'s most famous address. With unerring honesty and lively wit, she describes her triumphs and her disappointments, both public and private, telling her full story as she has lived it - in her own words and on her own terms. Warm, wise, and revelatory, Becoming is the deeply personal reckoning of a woman of soul and substance who has steadily defied expectations - and whose story inspires us to do the same.',9.96,25,10);
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart` (
  `cart_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `date_created` datetime DEFAULT NULL,
  PRIMARY KEY (`cart_id`),
  KEY `fk_user_id_cart_idx` (`user_id`),
  CONSTRAINT `fk_user_id_cart` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
INSERT INTO `cart` VALUES (4,5,'2021-08-28 12:44:06'),(5,6,'2021-08-28 12:49:25');
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `category_id` int NOT NULL AUTO_INCREMENT,
  `category_name` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (7,'Novel'),(8,'Science'),(9,'Business'),(10,'Autobiography');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item`
--

DROP TABLE IF EXISTS `item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item` (
  `item_id` int NOT NULL AUTO_INCREMENT,
  `book_id` int DEFAULT NULL,
  `quantity` int DEFAULT '0',
  `cart_id` int DEFAULT NULL,
  PRIMARY KEY (`item_id`),
  KEY `fk_book_id_idx` (`book_id`),
  KEY `fk_cart_id_idx` (`cart_id`),
  CONSTRAINT `fk_book_id` FOREIGN KEY (`book_id`) REFERENCES `book` (`book_id`),
  CONSTRAINT `fk_cart_id` FOREIGN KEY (`cart_id`) REFERENCES `cart` (`cart_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item`
--

LOCK TABLES `item` WRITE;
/*!40000 ALTER TABLE `item` DISABLE KEYS */;
/*!40000 ALTER TABLE `item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (4,'ROLE_CUSTOMER'),(5,'ROLE_MANAGER'),(6,'ROLE_ADMIN');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `status`
--

DROP TABLE IF EXISTS `status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `status` (
  `status_id` int NOT NULL AUTO_INCREMENT,
  `status_detail` varchar(16) DEFAULT NULL,
  PRIMARY KEY (`status_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `status`
--

LOCK TABLES `status` WRITE;
/*!40000 ALTER TABLE `status` DISABLE KEYS */;
INSERT INTO `status` VALUES (1,'Pending'),(2,'Confirmed'),(3,'Cancelled'),(4,'Ready'),(5,'Shipping'),(6,'Received'),(7,'Refunded');
/*!40000 ALTER TABLE `status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` char(80) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `phone_number` varchar(13) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `reset_password_token` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (5,'admin_long','$2a$10$Hde4tG/CTzdB2s3NmftP/.ASymuikhnEfPk9jv2rhZIDYAvTJHXSW','Long','Nguyen','longk13haui@gmail.com','0365129897','Hanoi',NULL),(6,'user1','$2a$10$rU7kga5ZVSN6A.E8Xrk3O.l/vJLaOyBpoDWUrLhdMr5CivlqtHkny','User','test','linhdov97@gmail.com','036123456','Hanoi',NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users_roles`
--

DROP TABLE IF EXISTS `users_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users_roles` (
  `user_id` int NOT NULL,
  `role_id` int NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FK_ROLE_idx` (`role_id`),
  CONSTRAINT `FK_ROLE` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  CONSTRAINT `FK_USER_05` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users_roles`
--

LOCK TABLES `users_roles` WRITE;
/*!40000 ALTER TABLE `users_roles` DISABLE KEYS */;
INSERT INTO `users_roles` VALUES (5,4),(6,4),(5,5),(5,6);
/*!40000 ALTER TABLE `users_roles` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-09-14 16:35:27
