-- MySQL dump 10.12
--
-- Host: localhost    Database: pds
-- ------------------------------------------------------
-- Server version	6.0.0-alpha-community-nt-debug

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
-- Table structure for table `customerdetails`
--

DROP TABLE IF EXISTS `customerdetails`;
CREATE TABLE `customerdetails` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customerdetails`
--

LOCK TABLES `customerdetails` WRITE;
/*!40000 ALTER TABLE `customerdetails` DISABLE KEYS */;
INSERT INTO `customerdetails` VALUES (12,'ashu'),(1232,''),(1234521,'xyz');
/*!40000 ALTER TABLE `customerdetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `deal_custdetails`
--

DROP TABLE IF EXISTS `deal_custdetails`;
CREATE TABLE `deal_custdetails` (
  `cid` varchar(100) NOT NULL DEFAULT '',
  `cname` varchar(50) NOT NULL,
  `rice_amt` int(100) NOT NULL,
  `rice_qty` int(20) NOT NULL,
  `ragi_amt` int(20) NOT NULL,
  `ragi_qty` int(20) NOT NULL,
  `wheat_amt` int(20) NOT NULL,
  `wheat_qty` int(20) NOT NULL,
  `sugar_qty` int(20) NOT NULL,
  `sugar_amt` int(20) DEFAULT NULL,
  `dal_amt` int(20) NOT NULL,
  `dal_qty` int(20) NOT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `deal_custdetails`
--

LOCK TABLES `deal_custdetails` WRITE;
/*!40000 ALTER TABLE `deal_custdetails` DISABLE KEYS */;
INSERT INTO `deal_custdetails` VALUES ('123123','adsfdsf',5,5,5,5,5,5,5,5,5,5),('123445','dsgfdg',5,5,5,5,5,5,5,5,5,5),('123456789','king',4,5,4,3,4,2,20,4,7,10),('32534543436453','abc',5,5,5,3,5,2,20,4,5,10),('80976543','harish',3,6,7,4,6,4,5,5,8,3);
/*!40000 ALTER TABLE `deal_custdetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dealerdetails`
--

DROP TABLE IF EXISTS `dealerdetails`;
CREATE TABLE `dealerdetails` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `location` varchar(500) NOT NULL,
  `contact_Num` varchar(15) NOT NULL,
  `state` varchar(30) NOT NULL,
  `district` varchar(30) NOT NULL,
  `username` varchar(30) NOT NULL,
  `password` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `dealerdetails`
--

LOCK TABLES `dealerdetails` WRITE;
/*!40000 ALTER TABLE `dealerdetails` DISABLE KEYS */;
INSERT INTO `dealerdetails` VALUES (1,'ash','adsdasf','89045674321','Karnataka','bangalore','ashwini','ashwini'),(2,'Benjamin','#789, bdbjsd cdsvdsv dsfvdvdsv','9087654321','Karnataka','Bangalore','ben','ben'),(3,'abhi','#56, hjdfhld,jdhfjkhdjkf,jhfjdkf,dsjkhfjkds','8907654321','Goa','North Goa','abhi','abhi'),(4,'deepthi','#1232,jayanagar,xyz','789054321','Karnataka','Bangalore','deepthi','deepthi'),(5,'deepthi','#1232,jayanagar,xyz','789054321','Karnataka','Bangalore','deepthi','deepthi');
/*!40000 ALTER TABLE `dealerdetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grocerydetails`
--

DROP TABLE IF EXISTS `grocerydetails`;
CREATE TABLE `grocerydetails` (
  `groceryname` varchar(10) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `grocerydetails`
--

LOCK TABLES `grocerydetails` WRITE;
/*!40000 ALTER TABLE `grocerydetails` DISABLE KEYS */;
INSERT INTO `grocerydetails` VALUES ('rice',5),('ragi',3),('wheat',2),('sugar',20),('dal',10);
/*!40000 ALTER TABLE `grocerydetails` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2012-03-07  4:10:25
