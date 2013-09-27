/*
SQLyog Ultimate v8.71 
MySQL - 5.1.53-community : Database - frame
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`frame` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `frame`;

/*Table structure for table `sys_resource_info` */

DROP TABLE IF EXISTS `sys_resource_info`;

CREATE TABLE `sys_resource_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(36) DEFAULT NULL,
  `title` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `sys_resource_info` */

insert  into `sys_resource_info`(`id`,`name`,`title`) values (1,'system','系统管理'),(2,'system_resource','资源管理');

/*Table structure for table `sys_role_info` */

DROP TABLE IF EXISTS `sys_role_info`;

CREATE TABLE `sys_role_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(18) DEFAULT NULL COMMENT '英文名称',
  `title` varchar(36) DEFAULT NULL COMMENT '中文名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

/*Data for the table `sys_role_info` */

insert  into `sys_role_info`(`id`,`name`,`title`) values (1,'admin','管理员'),(2,'user','普通用户'),(5,'personManager','人事经理');

/*Table structure for table `sys_role_resource_info` */

DROP TABLE IF EXISTS `sys_role_resource_info`;

CREATE TABLE `sys_role_resource_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(18) DEFAULT NULL,
  `resource` varchar(18) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `sys_role_resource_info` */

insert  into `sys_role_resource_info`(`id`,`role`,`resource`) values (1,'1','1'),(2,'1','2');

/*Table structure for table `sys_slog_info` */

DROP TABLE IF EXISTS `sys_slog_info`;

CREATE TABLE `sys_slog_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `operator` varchar(36) DEFAULT NULL,
  `action` varchar(180) DEFAULT NULL,
  `time` varchar(21) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_slog_info` */

/*Table structure for table `sys_user_info` */

DROP TABLE IF EXISTS `sys_user_info`;

CREATE TABLE `sys_user_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(36) DEFAULT NULL,
  `login_name` varchar(36) DEFAULT NULL,
  `login_pass` varchar(45) DEFAULT NULL,
  `create_time` varchar(36) DEFAULT NULL,
  `used` int(1) DEFAULT '0' COMMENT '是否启用：0否，1是',
  `email` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `sys_user_info` */

insert  into `sys_user_info`(`id`,`user_name`,`login_name`,`login_pass`,`create_time`,`used`,`email`) values (1,'管理员','admin','su','2013-09-11 15:25:00',1,'gandilong@yeah.net'),(2,'测试员','test','000000','2013-09-17 09:50:00',1,NULL),(9,'王天龙','abcd','000000','2013-09-25 18:00:10',0,'gandilong@yeah.net');

/*Table structure for table `sys_user_role_info` */

DROP TABLE IF EXISTS `sys_user_role_info`;

CREATE TABLE `sys_user_role_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user` varchar(18) DEFAULT NULL,
  `role` varchar(18) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `sys_user_role_info` */

insert  into `sys_user_role_info`(`id`,`user`,`role`) values (1,'1','1'),(2,'2','2');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
