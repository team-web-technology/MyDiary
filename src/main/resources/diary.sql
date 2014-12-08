CREATE DATABASE  IF NOT EXISTS `diary_v2` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `diary_v2`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win64 (x86_64)
--
-- Host: localhost    Database: diary_v2
-- ------------------------------------------------------
-- Server version	5.6.21

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
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `idCategory` int(11) NOT NULL,
  `AuthorId` int(11) NOT NULL,
  `Name` varchar(255) NOT NULL,
  `ParentId` int(11) DEFAULT NULL,
  `Create` datetime DEFAULT NULL,
  `Modified` datetime DEFAULT NULL,
  PRIMARY KEY (`idCategory`),
  KEY `category_user_idx` (`AuthorId`),
  CONSTRAINT `category_user` FOREIGN KEY (`AuthorId`) REFERENCES `userprofile` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comment` (
  `idComment` int(11) NOT NULL AUTO_INCREMENT,
  `IdDairy` int(11) NOT NULL,
  `IdAuthor` int(11) NOT NULL,
  `Text` longtext NOT NULL,
  `IsApproved` bit(1) NOT NULL,
  `ParentId` int(11) NOT NULL,
  `Create` datetime DEFAULT NULL,
  `Modified` datetime DEFAULT NULL,
  PRIMARY KEY (`idComment`),
  KEY `comment_user_idx` (`IdAuthor`),
  KEY `comment_diary_idx` (`IdDairy`),
  CONSTRAINT `comment_diary` FOREIGN KEY (`IdDairy`) REFERENCES `diary` (`IdDiary`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `comment_user` FOREIGN KEY (`IdAuthor`) REFERENCES `userprofile` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `diary`
--

DROP TABLE IF EXISTS `diary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `diary` (
  `IdDiary` int(11) NOT NULL AUTO_INCREMENT,
  `AuthorId` int(11) NOT NULL,
  `Title` varchar(255) DEFAULT NULL,
  `Body` longtext,
  `Excerpt` varchar(512) DEFAULT NULL,
  `IsCommentClosed` bit(1) DEFAULT NULL,
  `Privacy` int(11) DEFAULT NULL,
  `Created` datetime DEFAULT NULL,
  `Modified` datetime DEFAULT NULL,
  PRIMARY KEY (`IdDiary`),
  KEY `diary_user_idx` (`AuthorId`),
  CONSTRAINT `diary_user` FOREIGN KEY (`AuthorId`) REFERENCES `userprofile` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `diary`
--

LOCK TABLES `diary` WRITE;
/*!40000 ALTER TABLE `diary` DISABLE KEYS */;
/*!40000 ALTER TABLE `diary` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `diaryincategory`
--

DROP TABLE IF EXISTS `diaryincategory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `diaryincategory` (
  `DiaryId` int(11) NOT NULL,
  `CategoryId` int(11) NOT NULL,
  PRIMARY KEY (`DiaryId`,`CategoryId`),
  KEY `diary_category_idx` (`CategoryId`),
  CONSTRAINT `category_diary` FOREIGN KEY (`DiaryId`) REFERENCES `diary` (`IdDiary`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `diary_category` FOREIGN KEY (`CategoryId`) REFERENCES `category` (`idCategory`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `diaryincategory`
--

LOCK TABLES `diaryincategory` WRITE;
/*!40000 ALTER TABLE `diaryincategory` DISABLE KEYS */;
/*!40000 ALTER TABLE `diaryincategory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `diarypermission`
--

DROP TABLE IF EXISTS `diarypermission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `diarypermission` (
  `idDiaryPermission` int(11) NOT NULL AUTO_INCREMENT,
  `DiaryId` int(11) NOT NULL,
  `InvitedUserId` int(11) NOT NULL,
  `IsAllowed` bit(1) NOT NULL,
  PRIMARY KEY (`idDiaryPermission`),
  KEY `diary_idx` (`DiaryId`),
  KEY `user_idx` (`InvitedUserId`),
  CONSTRAINT `diary` FOREIGN KEY (`DiaryId`) REFERENCES `diary` (`IdDiary`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `user` FOREIGN KEY (`InvitedUserId`) REFERENCES `userprofile` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `diarypermission`
--

LOCK TABLES `diarypermission` WRITE;
/*!40000 ALTER TABLE `diarypermission` DISABLE KEYS */;
/*!40000 ALTER TABLE `diarypermission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `friend`
--

DROP TABLE IF EXISTS `friend`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `friend` (
  `UserId` int(11) NOT NULL,
  `FriendId` int(11) NOT NULL,
  PRIMARY KEY (`UserId`,`FriendId`),
  KEY `friend_user2_idx` (`FriendId`),
  CONSTRAINT `friend_user` FOREIGN KEY (`UserId`) REFERENCES `userprofile` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `friend_user2` FOREIGN KEY (`FriendId`) REFERENCES `userprofile` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `friend`
--

LOCK TABLES `friend` WRITE;
/*!40000 ALTER TABLE `friend` DISABLE KEYS */;
/*!40000 ALTER TABLE `friend` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `friendrequest`
--

DROP TABLE IF EXISTS `friendrequest`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `friendrequest` (
  `SenderId` int(11) NOT NULL,
  `ReceiverId` int(11) NOT NULL,
  `Created` datetime DEFAULT NULL,
  PRIMARY KEY (`SenderId`,`ReceiverId`),
  KEY `friendaccept_user_idx` (`ReceiverId`),
  CONSTRAINT `friendaccept_user` FOREIGN KEY (`ReceiverId`) REFERENCES `userprofile` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `friendrequest_user` FOREIGN KEY (`SenderId`) REFERENCES `userprofile` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `friendrequest`
--

LOCK TABLES `friendrequest` WRITE;
/*!40000 ALTER TABLE `friendrequest` DISABLE KEYS */;
/*!40000 ALTER TABLE `friendrequest` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `membership`
--

DROP TABLE IF EXISTS `membership`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `membership` (
  `idmembership` int(11) NOT NULL,
  `createdate` datetime DEFAULT NULL,
  `confirmationToken` varchar(125) DEFAULT NULL,
  `IsConfirmed` bit(1) DEFAULT NULL,
  `LastPasswordFailureDate` datetime DEFAULT NULL,
  `PasswordFailuresSinceLastSuccess` int(11) DEFAULT NULL,
  `PasswordChangedDate` datetime DEFAULT NULL,
  `PasswordVerificationToken` varchar(125) DEFAULT NULL,
  `PasswordVerificationTokenExpirationDate` datetime DEFAULT NULL,
  PRIMARY KEY (`idmembership`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `membership`
--

LOCK TABLES `membership` WRITE;
/*!40000 ALTER TABLE `membership` DISABLE KEYS */;
/*!40000 ALTER TABLE `membership` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `idauthority` int(11) NOT NULL,
  `role` varchar(45) NOT NULL,
  PRIMARY KEY (`idauthority`),
  UNIQUE KEY `role_UNIQUE` (`role`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (2,'ROLE_ADMIN'),(1,'ROLE_USER');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userprofile`
--

DROP TABLE IF EXISTS `userprofile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userprofile` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Username` varchar(100) NOT NULL,
  `Password` varchar(100) NOT NULL,
  `Email` varchar(255) NOT NULL,
  `AcountNonExpired` tinyint(1) DEFAULT NULL,
  `AcountNonLocked` tinyint(1) DEFAULT NULL,
  `CredentialsNonExpired` tinyint(1) DEFAULT NULL,
  `Enabled` bit(1) DEFAULT NULL,
  `IdRole` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`Email`),
  KEY `user_role_idx` (`IdRole`),
  CONSTRAINT `user_role` FOREIGN KEY (`IdRole`) REFERENCES `role` (`idauthority`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userprofile`
--

LOCK TABLES `userprofile` WRITE;
/*!40000 ALTER TABLE `userprofile` DISABLE KEYS */;
INSERT INTO `userprofile` VALUES (1,'dfdsfs','$2a$10$yfNMy6qE20nQp2XSlXUjH.qYv/H/hstHPyl3uagapkFFDPiVmZWUq','fsdfsdfsd@gmail.com',NULL,NULL,NULL,'',1),(2,'asdasd','$2a$10$hyOLWwtDKB8rqWUDB58MxObFbLYlX34ucg7.MS/i2naqoypIZ8fui','dasdada@gmail.com',NULL,NULL,NULL,'',1),(3,'sdasdas','$2a$10$KPtJnJPURBidECyeZj8bq.rS56unptRFHiCjqzI8zTNeGiGlcWM2G','dasdasdas@gmail.com',NULL,NULL,NULL,'',1),(4,'dfhfhghfgh','$2a$10$xQaWC0SSPHpMBETZMqJJHuZ2KbqUixocI.I7a.XCX5LwH9s7Vfys.','hfghfghfgh@gmail.com',NULL,NULL,NULL,'',1),(5,'dvddddddddddd','$2a$10$PPlMUVynHqhEb2dBGRKIF.5wby3HipOPQQbsCTRXOgCsWK0qYXJ0K','vdvvvvvvvvv@gmail.com',NULL,NULL,NULL,'',1),(6,'gggggggggggggg','$2a$10$SRs05n1vNx.ztmvxPvcarOfLWWrRs4MVAM2Ipm/pyBgVHLndcFmFi','ggggggggggggggg@gmail.com',NULL,NULL,NULL,'',1);
/*!40000 ALTER TABLE `userprofile` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-12-06 21:12:37
