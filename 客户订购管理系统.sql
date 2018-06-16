-- MySQL dump 10.13  Distrib 8.0.11, for Win64 (x86_64)
--
-- Host: localhost    Database: 客户订购管理系统
-- ------------------------------------------------------
-- Server version	8.0.11

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `发票信息表`
--

DROP TABLE IF EXISTS `发票信息表`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `发票信息表` (
  `Iid` int(10) NOT NULL,
  `Oid` int(10) DEFAULT NULL,
  `Cid` int(10) DEFAULT NULL,
  `Iper` float NOT NULL,
  `Ipri` float NOT NULL,
  `Itot` float DEFAULT NULL,
  `Ipeo` varchar(15) NOT NULL,
  `Idat` date DEFAULT NULL,
  `Inot` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`Iid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `发票信息表`
--

LOCK TABLES `发票信息表` WRITE;
/*!40000 ALTER TABLE `发票信息表` DISABLE KEYS */;
INSERT INTO `发票信息表` VALUES (1,1,1,0.04,9615.38,250000,'江科成','2018-05-15','重要客户的发票，优先'),(2,2,2,0.04,5769.23,150000,'江科成','2018-05-31',NULL),(3,3,7,0.04,34615.4,900000,'江科成','2018-05-30',NULL),(5,5,5,0.2,154.21,4524,'萨达','2018-03-04','欠款，注意');
/*!40000 ALTER TABLE `发票信息表` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `商品信息表`
--

DROP TABLE IF EXISTS `商品信息表`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `商品信息表` (
  `Pid` int(10) NOT NULL,
  `Pnam` varchar(20) DEFAULT NULL,
  `Puni` varchar(10) DEFAULT NULL,
  `Ppri` float NOT NULL,
  `Pnum` int(10) NOT NULL,
  `Ptyp` varchar(15) DEFAULT NULL,
  `Pbir` varchar(15) DEFAULT NULL,
  `Ppro` varchar(20) DEFAULT NULL,
  `Pnot` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`Pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `商品信息表`
--

LOCK TABLES `商品信息表` WRITE;
/*!40000 ALTER TABLE `商品信息表` DISABLE KEYS */;
INSERT INTO `商品信息表` VALUES (1,'LCD显示屏','个',100,10255,'显示屏','中国','富士康',NULL),(2,'OLED显示屏','个',150,45185,'显示屏','韩国','三星',NULL),(3,'高通骁龙845','个',30,13158,'芯片','美国','高通',NULL),(4,'听筒','个',30,46551,'听筒','中国','富士康',NULL),(5,'GPS','个',80,98512,'芯片','美国','摩托罗拉',NULL),(6,'3000mha电池','块',50,84568,'电池','中国','富士康',NULL),(7,'玻璃后盖','个',200,21561,'后盖','中国','富士康',NULL),(8,'金属后盖','个',180,21854,'后盖','中国','富士康',NULL),(9,'2000w后置摄像头','个',250,21574,'摄像头','韩国','三星',NULL),(10,'800w前置摄像头','个',100,95462,'摄像头','日本','索尼',NULL);
/*!40000 ALTER TABLE `商品信息表` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `客户信息表`
--

DROP TABLE IF EXISTS `客户信息表`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `客户信息表` (
  `Cid` int(10) NOT NULL,
  `Cnam` char(20) DEFAULT NULL,
  `Cadd` varchar(40) DEFAULT NULL,
  `Cpeo` char(15) DEFAULT NULL,
  `Ctel` char(11) DEFAULT NULL,
  `Cmai` varchar(30) DEFAULT NULL,
  `Cnot` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`Cid`),
  UNIQUE KEY `Cnam` (`Cnam`),
  UNIQUE KEY `Ctel` (`Ctel`),
  UNIQUE KEY `Cmai` (`Cmai`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `客户信息表`
--

LOCK TABLES `客户信息表` WRITE;
/*!40000 ALTER TABLE `客户信息表` DISABLE KEYS */;
INSERT INTO `客户信息表` VALUES (1,'苹果公司','美国加利福尼亚州库比蒂诺市','库克','18328552197','timcook@icloud.com','重要客户'),(2,'华为技术有限公司','广东省深圳市龙岗区坂田街道华为基地','余承东','18328552170','yuchengdong@huawei.com',''),(3,'小米科技有限责任公司','北京市海淀区清河中街68号 华润五彩城写字楼','雷军','13730835952','leijun@mi.com',NULL),(4,'魅族科技有限公司','中国广东省珠海市科技创新海岸魅族科技楼','黄章','13730836021','huangzhang@163.com',NULL),(5,'万普拉斯科技有限公司','深圳市前海深港合作区前湾一路1号A栋','刘作虎','13730836136','liuzuohu@163.com',NULL),(6,'锤子科技有限公司','北京市朝阳区望京绿地中心A座','罗永浩','13730836215','luoyonghao@163.com',''),(7,'三星电子','韩国京畿道城南市盆唐区书岘洞263号三星广场大厦','李健熙','13730836278','lee@samsung.com',NULL);
/*!40000 ALTER TABLE `客户信息表` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `用户表`
--

DROP TABLE IF EXISTS `用户表`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `用户表` (
  `用户名` varchar(20) NOT NULL,
  `用户类型` varchar(20) DEFAULT NULL,
  `密码` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`用户名`),
  UNIQUE KEY `用户名_UNIQUE` (`用户名`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `用户表`
--

LOCK TABLES `用户表` WRITE;
/*!40000 ALTER TABLE `用户表` DISABLE KEYS */;
INSERT INTO `用户表` VALUES ('1','管理员','1'),('admin','管理员','123');
/*!40000 ALTER TABLE `用户表` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `订单信息表`
--

DROP TABLE IF EXISTS `订单信息表`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `订单信息表` (
  `Oid` int(11) NOT NULL,
  `Pid` char(40) DEFAULT NULL,
  `Cid` int(10) DEFAULT NULL,
  `Onum` int(10) NOT NULL,
  `Otot` int(10) NOT NULL,
  `Osta` varchar(10) NOT NULL,
  `Otim` datetime NOT NULL,
  `Onot` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`Oid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `订单信息表`
--

LOCK TABLES `订单信息表` WRITE;
/*!40000 ALTER TABLE `订单信息表` DISABLE KEYS */;
INSERT INTO `订单信息表` VALUES (1,'1',1,2500,250000,'已完成','2018-05-01 09:41:00','重要订单'),(2,'4',2,5000,150000,'未付款','2018-05-30 20:55:20',NULL),(3,'2',7,6000,900000,'已发货','2018-05-20 13:26:08',NULL),(4,'2',1,2500,250000,'已付款','2018-05-30 19:15:22',''),(5,'4',1,500,15000,'已完成','2018-05-15 20:55:06','');
/*!40000 ALTER TABLE `订单信息表` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-06-06 18:54:32
