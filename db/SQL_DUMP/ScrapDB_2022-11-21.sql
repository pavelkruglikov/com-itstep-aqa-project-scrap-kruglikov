# ************************************************************
# Sequel Ace SQL dump
# Версия 20042
#
# https://sequel-ace.com/
# https://github.com/Sequel-Ace/Sequel-Ace
#
# Хост: 127.0.0.1 (MySQL 8.0.31)
# База данных: ScrapDB
# Время формирования: 2022-11-21 12:27:29 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
SET NAMES utf8mb4;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE='NO_AUTO_VALUE_ON_ZERO', SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Дамп таблицы acceptanceScrap
# ------------------------------------------------------------

DROP TABLE IF EXISTS `acceptanceScrap`;

CREATE TABLE `acceptanceScrap` (
  `acceptance_id` int unsigned NOT NULL AUTO_INCREMENT,
  `supplier` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `gross_weight` int DEFAULT NULL,
  `container_weight` int DEFAULT NULL,
  `net_weight` int DEFAULT NULL,
  `price_per_kg` int DEFAULT NULL,
  `total_payment` int DEFAULT NULL,
  `acceptor` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `acceptance_date` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`acceptance_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `acceptanceScrap` WRITE;
/*!40000 ALTER TABLE `acceptanceScrap` DISABLE KEYS */;

INSERT INTO `acceptanceScrap` (`acceptance_id`, `supplier`, `gross_weight`, `container_weight`, `net_weight`, `price_per_kg`, `total_payment`, `acceptor`, `acceptance_date`)
VALUES
	(3,'ТверьМеталл',25000,15000,10000,15,150000,'Иванов','2022-11-17'),
	(4,'ЗаменаМеталл',15000,4000,11000,15,165000,'Заменкин','2022-11-17'),
	(5,'МеталлПрофиль',6000,3000,3000,14,42000,'Иванов','2022-11-17'),
	(6,'ТверьМеталл',18000,12000,6000,18,108000,'Иванов','2022-11-17'),
	(8,'Металлист',25500,14530,10970,16,175520,'Иванов','2022-11-17'),
	(9,'МеталлоБаза',60000,30000,30000,16,480000,'Петров','2022-11-18'),
	(10,'Металлист',12222,3443,8779,17,149243,'Иванов','2022-11-19'),
	(11,'ТверьМеталл',12244,7000,5244,17,89148,'Иванов','2022-11-19'),
	(12,'МеталлПрофиль',22030,17000,5030,17,85510,'Иванов','2022-11-19'),
	(13,'Металлист',60000,40000,20000,19,380000,'Сидоров','2022-11-20');

/*!40000 ALTER TABLE `acceptanceScrap` ENABLE KEYS */;
UNLOCK TABLES;


# Дамп таблицы user_list
# ------------------------------------------------------------

DROP TABLE IF EXISTS `user_list`;

CREATE TABLE `user_list` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `user_password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `access_type` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `user_list` WRITE;
/*!40000 ALTER TABLE `user_list` DISABLE KEYS */;

INSERT INTO `user_list` (`id`, `user_name`, `user_password`, `access_type`)
VALUES
	(2,'admin','admin',1),
	(3,'user','user',2);

/*!40000 ALTER TABLE `user_list` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
