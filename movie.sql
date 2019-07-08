-- MySQL dump 10.13  Distrib 8.0.16, for Linux (x86_64)
--
-- Host: localhost    Database: movie
-- ------------------------------------------------------
-- Server version	8.0.16

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8mb4 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `comment` (
  `commentId` varchar(40) NOT NULL,
  `movie` varchar(40) NOT NULL,
  `content` varchar(500) NOT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `toComment` varchar(40) DEFAULT NULL,
  `user` varchar(40) NOT NULL,
  PRIMARY KEY (`commentId`),
  KEY `comment_movie_movieId_fk` (`movie`),
  KEY `comment_user_userId_fk` (`user`),
  CONSTRAINT `comment_movie_movieId_fk` FOREIGN KEY (`movie`) REFERENCES `movie` (`movieId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `comment_user_userId_fk` FOREIGN KEY (`user`) REFERENCES `user` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grade_movie`
--

DROP TABLE IF EXISTS `grade_movie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `grade_movie` (
  `user` varchar(40) NOT NULL,
  `movie` varchar(40) NOT NULL,
  `grade` int(11) DEFAULT NULL,
  PRIMARY KEY (`user`,`movie`),
  KEY `grade_movie_movie_movieId_fk` (`movie`),
  CONSTRAINT `grade_movie_movie_movieId_fk` FOREIGN KEY (`movie`) REFERENCES `movie` (`movieId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `grade_movie_user_userId_fk` FOREIGN KEY (`user`) REFERENCES `user` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grade_movie`
--

LOCK TABLES `grade_movie` WRITE;
/*!40000 ALTER TABLE `grade_movie` DISABLE KEYS */;
/*!40000 ALTER TABLE `grade_movie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `invition`
--

DROP TABLE IF EXISTS `invition`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `invition` (
  `inviter` varchar(40) NOT NULL,
  `invitee` varchar(40) NOT NULL,
  `spaceId` varchar(40) NOT NULL,
  `status` int(11) NOT NULL DEFAULT '0',
  KEY `invition_user_userId_fk` (`inviter`),
  KEY `invition_user_userId_fk_2` (`invitee`),
  CONSTRAINT `invition_user_userId_fk` FOREIGN KEY (`inviter`) REFERENCES `user` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `invition_user_userId_fk_2` FOREIGN KEY (`invitee`) REFERENCES `user` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `invition`
--

LOCK TABLES `invition` WRITE;
/*!40000 ALTER TABLE `invition` DISABLE KEYS */;
/*!40000 ALTER TABLE `invition` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `like_comment`
--

DROP TABLE IF EXISTS `like_comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `like_comment` (
  `comment` varchar(40) NOT NULL,
  `user` varchar(40) NOT NULL,
  PRIMARY KEY (`comment`,`user`),
  KEY `like_user_userId_fk` (`user`),
  CONSTRAINT `like_comment_commentId_fk` FOREIGN KEY (`comment`) REFERENCES `comment` (`commentId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `like_user_userId_fk` FOREIGN KEY (`user`) REFERENCES `user` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `like_comment`
--

LOCK TABLES `like_comment` WRITE;
/*!40000 ALTER TABLE `like_comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `like_comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `love`
--

DROP TABLE IF EXISTS `love`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `love` (
  `loveId` varchar(40) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `movies` varchar(1024) DEFAULT NULL,
  `user` varchar(40) NOT NULL,
  PRIMARY KEY (`loveId`),
  KEY `love_user_userId_fk` (`user`),
  CONSTRAINT `love_user_userId_fk` FOREIGN KEY (`user`) REFERENCES `user` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `love`
--

LOCK TABLES `love` WRITE;
/*!40000 ALTER TABLE `love` DISABLE KEYS */;
/*!40000 ALTER TABLE `love` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movie`
--

DROP TABLE IF EXISTS `movie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `movie` (
  `movieId` varchar(40) NOT NULL,
  `name` varchar(20) NOT NULL,
  `leading_creator` varchar(1024) DEFAULT NULL,
  `cover` varchar(20) DEFAULT NULL,
  `stills` varchar(1024) DEFAULT NULL,
  `release_date` timestamp NULL DEFAULT NULL,
  `time` varchar(10) NOT NULL DEFAULT '未知',
  `grade` float DEFAULT NULL,
  `gradeNum` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`movieId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie`
--

LOCK TABLES `movie` WRITE;
/*!40000 ALTER TABLE `movie` DISABLE KEYS */;
INSERT INTO `movie` VALUES ('4a1989ed-81d4-41ff-a3cc-dfaa6be4a31b','WDNMD',NULL,NULL,NULL,NULL,'0',NULL,0),('5eb98255-570e-47f7-bf42-de6cc2a2f5c4','WDNMD',NULL,NULL,NULL,NULL,'0',NULL,0),('7d6aef74-520a-4ee1-b7c9-84d100d49fa9','WDNMD',NULL,NULL,NULL,NULL,'0',NULL,0),('a5384459-55e8-4644-8639-2fd6077983d7','WDNMD',NULL,NULL,NULL,NULL,'0',NULL,0),('c8b70036-b0ef-4d0a-b946-c8ca5b069cc7','WDNMD',NULL,NULL,NULL,NULL,'0',NULL,0),('e1bbbfbe-a976-4e01-8a24-474819fd299b','WDNMD',NULL,NULL,NULL,NULL,'0',NULL,0),('f766e8bf-b0e3-4351-8a02-cfe6659cb946','WDNMD',NULL,NULL,NULL,NULL,'0',NULL,0),('f7918d3b-cbf4-466f-85c4-144053f40636','WDNMD',NULL,NULL,NULL,NULL,'0',NULL,0);
/*!40000 ALTER TABLE `movie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `space`
--

DROP TABLE IF EXISTS `space`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `space` (
  `spaceId` varchar(40) NOT NULL,
  `name` varchar(40) NOT NULL,
  `owner` varchar(40) NOT NULL,
  `users` varchar(1024) DEFAULT NULL,
  `movies` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`spaceId`),
  KEY `space_user_userId_fk` (`owner`),
  CONSTRAINT `space_user_userId_fk` FOREIGN KEY (`owner`) REFERENCES `user` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `space`
--

LOCK TABLES `space` WRITE;
/*!40000 ALTER TABLE `space` DISABLE KEYS */;
/*!40000 ALTER TABLE `space` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user` (
  `userId` varchar(40) NOT NULL,
  `name` varchar(20) NOT NULL,
  `password` varchar(64) NOT NULL,
  `email` varchar(40) NOT NULL,
  `avatar` varchar(100) NOT NULL DEFAULT 'http://47.107.238.107/Music/avatar/default.jpg',
  `address` varchar(40) DEFAULT NULL,
  `type` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('7f89d351-dafd-4362-b538-f56f736b5d78','付一轩','123456','1120652730@qq.com','http://47.107.238.107/movie/upload/7f89d351-dafd-4362-b538-f56f736b5d78.jpg','{\"province\":\"广西壮族自治区\",\"city\":\"柳州市\"}',1),('af540eeb-71f0-48f5-8733-eee6630d2f81','袁博宇','123456','11206527301@qq.com','http://47.107.238.107/Music/avatar/default.jpg','{\"province\":\"湖北省\",\"city\":\"襄阳市\"}',1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-07-08  8:52:04
