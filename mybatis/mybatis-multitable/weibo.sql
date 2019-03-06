/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 5.5.20 : Database - weibo
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`weibo` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `weibo`;

/*Table structure for table `diary` */

DROP TABLE IF EXISTS `diary`;

CREATE TABLE `diary` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `pub_time` datetime DEFAULT NULL,
  `user_id` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`_id`),
  KEY `fk_diary_users` (`user_id`),
  CONSTRAINT `fk_diary_users` FOREIGN KEY (`user_id`) REFERENCES `users` (`_id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `diary` */

insert  into `diary`(`_id`,`title`,`content`,`pub_time`,`user_id`) values (1,'标题一','content1','2019-02-18 00:32:39',1),(2,'ww','ww','2019-02-17 00:00:00',2),(3,'qqqqq','qqqqq','2019-02-17 00:00:00',1),(4,'titlejson','contentjson','2019-02-17 00:00:00',1),(5,'xxxxxx','xxxxxx','2019-02-17 00:00:00',1),(6,'xxxxxx','xxxxxx','2019-02-17 00:00:00',1),(7,'xxxxxx','xxxxxx','2019-02-17 00:00:00',1);

/*Table structure for table `diary_tags` */

DROP TABLE IF EXISTS `diary_tags`;

CREATE TABLE `diary_tags` (
  `diary_id` int(11) NOT NULL,
  `tag_id` int(11) NOT NULL,
  `extras` varchar(255) DEFAULT NULL,
  KEY `fk_diarytags_diary` (`diary_id`),
  KEY `fk_diarytags_tags` (`tag_id`),
  CONSTRAINT `fk_diarytags_diary` FOREIGN KEY (`diary_id`) REFERENCES `diary` (`_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_diarytags_tags` FOREIGN KEY (`tag_id`) REFERENCES `tags` (`_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `diary_tags` */

insert  into `diary_tags`(`diary_id`,`tag_id`,`extras`) values (1,1,'1'),(1,2,'2');

/*Table structure for table `tags` */

DROP TABLE IF EXISTS `tags`;

CREATE TABLE `tags` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `creator` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `tags` */

insert  into `tags`(`_id`,`name`,`creator`) values (1,'标签1',1),(2,'标签2',2);

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `psw` varchar(255) NOT NULL,
  `sex` varchar(2) DEFAULT NULL,
  `sign` varchar(255) DEFAULT NULL,
  `photo` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT '0',
  PRIMARY KEY (`_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `users` */

insert  into `users`(`_id`,`name`,`psw`,`sex`,`sign`,`photo`,`age`) values (1,'dgb','123','1','1','a',2),(2,'柳生剑影','321','2','4','去',5);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
