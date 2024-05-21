/*
Navicat MySQL Data Transfer

Source Server         : SERVER-3305
Source Server Version : 50620
Source Host           : localhost:3305
Source Database       : sample_db

Target Server Type    : MYSQL
Target Server Version : 50620
File Encoding         : 65001

Date: 2024-05-22 01:09:54
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `employee_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `employee_name` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `salary` float(10,2) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `positions_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`employee_id`),
  KEY `positions_id` (`positions_id`),
  CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`positions_id`) REFERENCES `positions` (`positions_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES ('1', 'test 1', '2', '2024-05-21', '10.00', 'ggg', '5');

-- ----------------------------
-- Table structure for positions
-- ----------------------------
DROP TABLE IF EXISTS `positions`;
CREATE TABLE `positions` (
  `positions_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `positions_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`positions_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of positions
-- ----------------------------
INSERT INTO `positions` VALUES ('1', 'Accountant');
INSERT INTO `positions` VALUES ('2', 'Business Analyst');
INSERT INTO `positions` VALUES ('3', 'Content Writer');
INSERT INTO `positions` VALUES ('4', 'Customer Service Representative');
INSERT INTO `positions` VALUES ('5', 'Data Analyst');
INSERT INTO `positions` VALUES ('6', 'Digital Marketing Specialist');
INSERT INTO `positions` VALUES ('7', 'Financial Analyst');
INSERT INTO `positions` VALUES ('8', 'Financial Planner');
INSERT INTO `positions` VALUES ('9', 'Graphic Designer');
INSERT INTO `positions` VALUES ('10', 'HR Manager');
