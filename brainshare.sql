-- MySQL dump 10.13  Distrib 5.5.16, for osx10.6 (i386)
--
-- Host: localhost    Database: brainshare
-- ------------------------------------------------------
-- Server version	5.5.16

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
-- Table structure for table `answer`
--

DROP TABLE IF EXISTS `answer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `answer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `answer` varchar(255) NOT NULL,
  `data_cadastro` datetime NOT NULL,
  `id_question` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKABCA3FBEC9DA5C4C` (`id_question`),
  KEY `FKABCA3FBE17229996` (`id_user`),
  CONSTRAINT `FKABCA3FBE17229996` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`),
  CONSTRAINT `FKABCA3FBEC9DA5C4C` FOREIGN KEY (`id_question`) REFERENCES `question` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `answer`
--

LOCK TABLES `answer` WRITE;
/*!40000 ALTER TABLE `answer` DISABLE KEYS */;
INSERT INTO `answer` VALUES (1,'O Hibernate é um framework para o mapeamento objeto-relacional escrito na linguagem Java, mas também é disponível em .Net como o nome NHibernate.','2013-05-28 16:43:55',2,2),(2,'O Hibernate é um framework para o mapeamento objeto-relacional escrito na linguagem Java, mas também é disponível em .Net como o nome NHibernate.','2013-05-28 16:44:19',2,2),(3,'sei não, acho que é alguma composição tipo asdfjaisdjf pasdj f','2013-05-28 17:15:20',2,1),(4,'teste','2013-05-28 17:17:02',2,3),(5,'de mais','2013-06-07 04:46:43',1,1),(6,'resposta 1','2013-06-07 04:52:01',3,1),(7,'resposta 2','2013-06-07 04:53:07',3,1),(8,'outra resp','2013-06-07 04:53:17',1,1),(9,'hehehehe','2013-06-07 04:53:25',1,1),(10,'teste texto grande!! aoshfoasifhaos haosifh aosfhi asofi hasof hiasofi hsofihasofi hso hsaofh aosfhi sofi hsofi hasofihasofhiasofi hasofi hsof idhsfo ihsdfosdifhaosfhi sdof hisofihsfodisfhdiosfh adsofi hadsofi hsdofi dsofi hdso hias dhisf ','2013-06-16 11:41:47',1,1);
/*!40000 ALTER TABLE `answer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `question`
--

DROP TABLE IF EXISTS `question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `question` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `countAnswer` int(11) DEFAULT NULL,
  `data_cadastro` datetime NOT NULL,
  `question` varchar(255) NOT NULL,
  `title` varchar(255) NOT NULL,
  `id_tag` int(11) NOT NULL,
  `id_user` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKBA823BE617229996` (`id_user`),
  KEY `FKBA823BE662D5DC54` (`id_tag`),
  CONSTRAINT `FKBA823BE617229996` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`),
  CONSTRAINT `FKBA823BE662D5DC54` FOREIGN KEY (`id_tag`) REFERENCES `tag` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question`
--

LOCK TABLES `question` WRITE;
/*!40000 ALTER TABLE `question` DISABLE KEYS */;
INSERT INTO `question` VALUES (1,4,'2013-05-28 16:41:36','HTML clipboard fragment displays well in Chrome but not in MSIE','HTML clipboard fragment displays well in Chrome but not in MSIE',2,1),(2,4,'2013-05-28 16:43:01','O que é hibernate?','Como funciona o framework Hibernate?',1,1),(3,2,'2013-06-07 04:51:45','I am trying to use my PC as a router so that one network can access another (not only PC),\n\nI have One NIC with IP 172.20.10.180 , Subnet 255.255.255.0\nI have another NIC with IP 172.20.110.70 , Subnet 255.255.255.0\nHere using my PC, I can access both net','Can I use windows 7 route command to use my pc as a network router?',5,1);
/*!40000 ALTER TABLE `question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tag`
--

DROP TABLE IF EXISTS `tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tag` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `qtd` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tag`
--

LOCK TABLES `tag` WRITE;
/*!40000 ALTER TABLE `tag` DISABLE KEYS */;
INSERT INTO `tag` VALUES (1,'computacao',1),(2,'diversos',1),(3,'diversas',0),(4,'portugues',0),(5,'nova tag',1),(6,'novatag',0);
/*!40000 ALTER TABLE `tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `data_cadastro` datetime DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'2013-05-28 16:35:18','thiago@brainshare.com','admin123','thiago'),(2,'2013-05-28 16:43:33','thaisa@brainshare.com','thaisa123','thaisa'),(3,'2013-05-28 17:16:43','renato@brainshare.com','admin123','renato');
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

-- Dump completed on 2013-06-19 15:51:08
