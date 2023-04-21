-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: thuvien1
-- ------------------------------------------------------
-- Server version	8.0.32

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
  `TenBoPhan` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
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
-- Table structure for table `datsach`
--

DROP TABLE IF EXISTS `datsach`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `datsach` (
  `id` int NOT NULL AUTO_INCREMENT,
  `Ten` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `GT` int NOT NULL,
  `SDT` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `Email` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `NgayDat` date NOT NULL,
  `SL` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_gt_idx` (`GT`),
  CONSTRAINT `fk_gt` FOREIGN KEY (`GT`) REFERENCES `gioitinh` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `datsach`
--

LOCK TABLES `datsach` WRITE;
/*!40000 ALTER TABLE `datsach` DISABLE KEYS */;
INSERT INTO `datsach` VALUES (1,'Nguyễn Văn A',1,'0798471867','a@gmail.com','2023-04-07','2'),(2,'Nguyễn Thị C',2,'0798422473','C@gmail.com','2023-04-12','3');
/*!40000 ALTER TABLE `datsach` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `docgia`
--

DROP TABLE IF EXISTS `docgia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `docgia` (
  `id` int NOT NULL AUTO_INCREMENT,
  `HoTen` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `GioiTinh` int NOT NULL,
  `NgaySinh` date DEFAULT NULL,
  `Email` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `SoDienThoai` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `DiaChi` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `NgayDangKi` date NOT NULL,
  `HanThe` date NOT NULL,
  `DoiTuong` int NOT NULL,
  `BoPhan` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `id_GT_idx` (`GioiTinh`),
  KEY `id_DT_idx` (`DoiTuong`),
  KEY `id_BP_idx` (`BoPhan`),
  CONSTRAINT `id_BP` FOREIGN KEY (`BoPhan`) REFERENCES `bophan` (`id`),
  CONSTRAINT `id_DT` FOREIGN KEY (`DoiTuong`) REFERENCES `doituong` (`id`),
  CONSTRAINT `id_GT` FOREIGN KEY (`GioiTinh`) REFERENCES `gioitinh` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `docgia`
--

LOCK TABLES `docgia` WRITE;
/*!40000 ALTER TABLE `docgia` DISABLE KEYS */;
INSERT INTO `docgia` VALUES (3,'Nguyễn Văn B',1,'2003-07-11','vanb@gmail.com','0798476917','371 Nguyễn Kiệm','2023-04-17','2024-04-17',1,3),(4,'Trần Vân Anh ',2,'2001-08-12','vananh@gmail.com','0798475974','12/4/5 Cách Mạng Tháng Tám','2023-04-17','2024-04-17',1,6),(5,'Trần Văn Ba',1,'1992-01-28','vanba@gmail.com','0798475997','123 Võ Văn Tần','2023-04-17','2024-04-17',2,4),(6,'Nguyễn Vân Anh',1,'2003-04-13','ngvannh@gmail.com','0798456128','45/1 Võ Văn Kiệt','2023-04-18','2024-04-18',1,1),(7,'Trần Bích Vân',2,'2003-08-12','bichvan@gmail.com','0981981479','134 Nguyễn Kiệm','2023-04-18','2024-04-18',1,1),(8,'Nguyễn Thị Ngọc Châu',2,'2023-04-13','chau@gmail.com','0798475471','45/1A An Dương Vương','2023-04-18','2024-04-18',1,1),(9,'Nguyễn Ngọc Huyền Trân',2,'2023-04-19','ngngochuyentran@gmail.com','0335624678','Bình Tân','2023-04-19','2024-04-19',1,2);
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
-- Table structure for table `gioitinh`
--

DROP TABLE IF EXISTS `gioitinh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gioitinh` (
  `id` int NOT NULL AUTO_INCREMENT,
  `Ten` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gioitinh`
--

LOCK TABLES `gioitinh` WRITE;
/*!40000 ALTER TABLE `gioitinh` DISABLE KEYS */;
INSERT INTO `gioitinh` VALUES (1,'Nam'),(2,'Nữ');
/*!40000 ALTER TABLE `gioitinh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phieumuon`
--

DROP TABLE IF EXISTS `phieumuon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `phieumuon` (
  `id` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `Ten` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `NgayMuon` date NOT NULL,
  `TrangThai` int NOT NULL,
  `id_docgia` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `id_docgia` (`id_docgia`),
  CONSTRAINT `pm_ibfk_1` FOREIGN KEY (`id_docgia`) REFERENCES `docgia` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phieumuon`
--

LOCK TABLES `phieumuon` WRITE;
/*!40000 ALTER TABLE `phieumuon` DISABLE KEYS */;
INSERT INTO `phieumuon` VALUES ('704f837d-c','Nguyễn Văn B','2023-04-05',0,3),('89638b10-c','Trần Vân Anh ','2023-04-21',1,4);
/*!40000 ALTER TABLE `phieumuon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phieumuonchitiet`
--

DROP TABLE IF EXISTS `phieumuonchitiet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `phieumuonchitiet` (
  `id` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `TenSach` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `SoLuongMuon` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `SoLuongChuaTra` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `idPhieuMuon` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `TrangThai` int NOT NULL,
  `id_sach` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `idPhieuMuon` (`idPhieuMuon`),
  KEY `id_sach_idx` (`id_sach`),
  CONSTRAINT `id_sach` FOREIGN KEY (`id_sach`) REFERENCES `sach` (`id`),
  CONSTRAINT `ppct_ibfk_1` FOREIGN KEY (`idPhieuMuon`) REFERENCES `phieumuon` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phieumuonchitiet`
--

LOCK TABLES `phieumuonchitiet` WRITE;
/*!40000 ALTER TABLE `phieumuonchitiet` DISABLE KEYS */;
INSERT INTO `phieumuonchitiet` VALUES ('cd932ea6-1','Truyện Kiều','5','5','704f837d-c',0,1),('f0d0a476-d','Truyện Kiều','5','0','89638b10-c',1,1);
/*!40000 ALTER TABLE `phieumuonchitiet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phieutra`
--

DROP TABLE IF EXISTS `phieutra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `phieutra` (
  `id` int NOT NULL AUTO_INCREMENT,
  `TenSach` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `SoLuong` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `NgayTra` date NOT NULL,
  `idPhieuMuonCT` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `TienPhat` float NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `idPhieuMuonCT` (`idPhieuMuonCT`),
  CONSTRAINT `pt_ibfk_1` FOREIGN KEY (`idPhieuMuonCT`) REFERENCES `phieumuonchitiet` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phieutra`
--

LOCK TABLES `phieutra` WRITE;
/*!40000 ALTER TABLE `phieutra` DISABLE KEYS */;
INSERT INTO `phieutra` VALUES (2,'Truyện Kiều','5','2023-04-21','f0d0a476-d',5000);
/*!40000 ALTER TABLE `phieutra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sach`
--

DROP TABLE IF EXISTS `sach`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sach` (
  `id` int NOT NULL AUTO_INCREMENT,
  `Ten` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `MoTa` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `NXB` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `SoLuong` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `id_theloai` int NOT NULL,
  `id_tacgia` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_TL_idx` (`id_theloai`),
  KEY `id_TG_idx` (`id_tacgia`),
  CONSTRAINT `id_TG` FOREIGN KEY (`id_tacgia`) REFERENCES `tacgia` (`id`),
  CONSTRAINT `id_TL` FOREIGN KEY (`id_theloai`) REFERENCES `theloai` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sach`
--

LOCK TABLES `sach` WRITE;
/*!40000 ALTER TABLE `sach` DISABLE KEYS */;
INSERT INTO `sach` VALUES (1,'Truyện Kiều','truyện dân gian','1920','3',4,5),(2,'Doremon Tập 1','chú mèo máy thông minh ','1980','4',1,4),(3,'Tôi thấy hoa vàng trên cỏ xanh ','tuổi thanh xuân ','2003','2',3,1),(4,'Doremon Tập 2','chú mèo máy thông minh','1980','4',1,4),(5,'Bên nhau trọn đời','câu chuyện tình yêu về Triệu Mạc Sênh','2008','2',4,6),(6,'Sách qq','Sách như qq','QQ','2',1,1),(7,'Sách ','Sách như ','tt','2',1,1),(8,'Sách ','Sách như ','tt','2',1,1);
/*!40000 ALTER TABLE `sach` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tacgia`
--

DROP TABLE IF EXISTS `tacgia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tacgia` (
  `id` int NOT NULL AUTO_INCREMENT,
  `Ten` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tacgia`
--

LOCK TABLES `tacgia` WRITE;
/*!40000 ALTER TABLE `tacgia` DISABLE KEYS */;
INSERT INTO `tacgia` VALUES (1,'Nguyễn Nhật Ánh'),(2,'Trịnh Công Sơn'),(3,'Dương Hữu Thành '),(4,'Fujiko F. Fujio'),(5,'Nguyễn Du'),(6,'Cố Mạn'),(7,'Hồ Quang Khải');
/*!40000 ALTER TABLE `tacgia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `theloai`
--

DROP TABLE IF EXISTS `theloai`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `theloai` (
  `id` int NOT NULL AUTO_INCREMENT,
  `Ten` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
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

-- Dump completed on 2023-04-21 10:02:49
