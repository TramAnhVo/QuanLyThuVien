-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: thuvien
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
-- Table structure for table `bophan`
--

DROP TABLE IF EXISTS `bophan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bophan` (
  `id` int NOT NULL AUTO_INCREMENT,
  `TenBoPhan` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bophan`
--

LOCK TABLES `bophan` WRITE;
/*!40000 ALTER TABLE `bophan` DISABLE KEYS */;
INSERT INTO `bophan` VALUES (1,'Khoa công nghệ thông tin'),(2,'Khoa công nghệ sinh học'),(3,'Khoa luật'),(4,'Khoa ngoại ngữ'),(5,'Khoa quản trị kinh doanh'),(6,'Khoa tài chính ngân hàng'),(7,'Khoa kế toán kiểm toán '),(8,'Khoa xây dựng');
/*!40000 ALTER TABLE `bophan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `docgia`
--

DROP TABLE IF EXISTS `docgia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `docgia` (
  `id` int NOT NULL AUTO_INCREMENT,
  `HoTen` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `GioiTinh` varchar(3) COLLATE utf8mb4_unicode_ci NOT NULL,
  `NgaySinh` date NOT NULL,
  `Email` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `SoDienThoai` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `DiaChi` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `NgayDangKi` date NOT NULL,
  `DoiTuong` int NOT NULL,
  `BoPhan` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `HoTen_UNIQUE` (`HoTen`),
  KEY `DoiTuong_idx` (`DoiTuong`),
  KEY `BoPhan_idx` (`BoPhan`),
  CONSTRAINT `BoPhan` FOREIGN KEY (`BoPhan`) REFERENCES `bophan` (`id`),
  CONSTRAINT `DoiTuong` FOREIGN KEY (`DoiTuong`) REFERENCES `doituong` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `docgia`
--

LOCK TABLES `docgia` WRITE;
/*!40000 ALTER TABLE `docgia` DISABLE KEYS */;
INSERT INTO `docgia` VALUES (2,'Nguyễn Văn B','Nam','2001-03-02','vanba@gmail.com','0798845845','123 Lê Lợi','2023-03-17',1,1),(5,'Nguyễn Văn Ba','Nam','2004-03-12','vanba@gmail.com','0789748447','123 Hoàng Văn Thụ','2023-03-17',3,2),(6,'Lê Thị Lan','Nữ','2001-08-27','lan@gmail.com','0795459884','123 Lê Lợi','2023-03-17',2,8),(7,'Nguyễn Xuân Phúc','Nữ ','2002-08-21','phuc123@gmail.com','0794185456','45 Nguyễn Bá Tòng','2023-03-18',1,6),(8,'Lê Hoàng Oanh','Nữ','2004-09-17','Oanh@gmail.com','0798504867','34 Tản Đà','2023-03-19',2,7),(9,'Trần Phú','Nam','2003-09-19','phu@gmail.com','0798413447','123 Nguyễn Văn Luông','2023-03-22',1,6);
/*!40000 ALTER TABLE `docgia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `doituong`
--

DROP TABLE IF EXISTS `doituong`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `doituong` (
  `id` int NOT NULL,
  `Ten` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doituong`
--

LOCK TABLES `doituong` WRITE;
/*!40000 ALTER TABLE `doituong` DISABLE KEYS */;
INSERT INTO `doituong` VALUES (1,'Sinh Viên'),(2,'Giảng viên'),(3,'Viên chức');
/*!40000 ALTER TABLE `doituong` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nguoidoc`
--

DROP TABLE IF EXISTS `nguoidoc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nguoidoc` (
  `id` int NOT NULL AUTO_INCREMENT,
  `Ten` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nguoidoc`
--

LOCK TABLES `nguoidoc` WRITE;
/*!40000 ALTER TABLE `nguoidoc` DISABLE KEYS */;
INSERT INTO `nguoidoc` VALUES (1,'Nguyễn Văn Ba'),(2,'Lý Tú Đào'),(3,'Trần Kim Ngọc'),(4,'Hồ Quý Ly');
/*!40000 ALTER TABLE `nguoidoc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phieumuon`
--

DROP TABLE IF EXISTS `phieumuon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `phieumuon` (
  `id` int NOT NULL AUTO_INCREMENT,
  `Ten` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `NgayMuon` date NOT NULL,
  `SoLuong` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phieumuon`
--

LOCK TABLES `phieumuon` WRITE;
/*!40000 ALTER TABLE `phieumuon` DISABLE KEYS */;
/*!40000 ALTER TABLE `phieumuon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phieumuonchitiet`
--

DROP TABLE IF EXISTS `phieumuonchitiet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `phieumuonchitiet` (
  `id` int NOT NULL AUTO_INCREMENT,
  `TenSach` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `idPhieuMuon` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phieumuonchitiet`
--

LOCK TABLES `phieumuonchitiet` WRITE;
/*!40000 ALTER TABLE `phieumuonchitiet` DISABLE KEYS */;
/*!40000 ALTER TABLE `phieumuonchitiet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sach`
--

DROP TABLE IF EXISTS `sach`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sach` (
  `id` int NOT NULL AUTO_INCREMENT,
  `Ten` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `MoTa` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `NXB` varchar(4) COLLATE utf8mb4_unicode_ci NOT NULL,
  `SoLuong` varchar(2) COLLATE utf8mb4_unicode_ci NOT NULL,
  `id_theloai` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_idx` (`id_theloai`),
  CONSTRAINT `id_theloai` FOREIGN KEY (`id_theloai`) REFERENCES `theloai` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sach`
--

LOCK TABLES `sach` WRITE;
/*!40000 ALTER TABLE `sach` DISABLE KEYS */;
INSERT INTO `sach` VALUES (5,'Doremon Tập 1','Chú mèo máy thông minh ','1980','2',1),(6,'Bên nhau trọn đời','câu chuyện về tình yêu học trò','1990','1',5),(7,'Doremon Tập 2','chú mèo máy thông minh ','1980','2',1),(8,'Truyện Kiều ','Cuộc đời của Thúy Kiều','1820','1',3),(9,'Cơ sở dữ liệu (Photo)','CSDL, MySQL...','2021','2',7);
/*!40000 ALTER TABLE `sach` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `theloai`
--

DROP TABLE IF EXISTS `theloai`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `theloai` (
  `id` int NOT NULL AUTO_INCREMENT,
  `Ten` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `theloai`
--

LOCK TABLES `theloai` WRITE;
/*!40000 ALTER TABLE `theloai` DISABLE KEYS */;
INSERT INTO `theloai` VALUES (1,'Thiếu nhi'),(2,'Khoa học công nghệ – Kinh tế'),(3,'Văn học nghệ thuật'),(4,'Truyện'),(5,'Tiểu thuyết'),(6,'Văn hóa xã hội – Lịch sử'),(7,'Giáo trình');
/*!40000 ALTER TABLE `theloai` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-03-23 17:43:35
