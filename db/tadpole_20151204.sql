/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50624
Source Host           : 127.0.0.1:3306
Source Database       : tadpole

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2015-12-04 20:41:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for classroom_info
-- ----------------------------
DROP TABLE IF EXISTS `classroom_info`;
CREATE TABLE `classroom_info` (
  `cr_id` varchar(32) NOT NULL COMMENT '??id',
  `cr_num` varchar(16) NOT NULL COMMENT '????',
  `cr_device` varchar(32) NOT NULL COMMENT '????',
  PRIMARY KEY (`cr_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of classroom_info
-- ----------------------------
INSERT INTO `classroom_info` VALUES ('', '', '');
INSERT INTO `classroom_info` VALUES ('cr01', '7c102', '');
INSERT INTO `classroom_info` VALUES ('cr02', '3b306', '');
INSERT INTO `classroom_info` VALUES ('cr03', '7a303', '');

-- ----------------------------
-- Table structure for course_info
-- ----------------------------
DROP TABLE IF EXISTS `course_info`;
CREATE TABLE `course_info` (
  `cs_id` varchar(32) NOT NULL,
  `cs_name` varchar(32) DEFAULT NULL,
  `cs_nature` varchar(8) DEFAULT NULL,
  `cs_time` varchar(32) DEFAULT NULL COMMENT '????',
  PRIMARY KEY (`cs_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_info
-- ----------------------------
INSERT INTO `course_info` VALUES ('', null, null, null);
INSERT INTO `course_info` VALUES ('cs01', '乒乓球', '选修', '周三第7,8节{第2-17周}');
INSERT INTO `course_info` VALUES ('cs02', '排球', '选修', '周二第1,2节{第2-17周}');
INSERT INTO `course_info` VALUES ('cs03', '健康街舞', '必修', '周一第7,8节{第4-18周}');

-- ----------------------------
-- Table structure for main
-- ----------------------------
DROP TABLE IF EXISTS `main`;
CREATE TABLE `main` (
  `id` varchar(32) NOT NULL,
  `stu_attend_id` varchar(32) DEFAULT NULL COMMENT '????',
  `course_info_id` varchar(32) DEFAULT NULL COMMENT '????',
  `teacher_info_info` varchar(32) DEFAULT NULL COMMENT '????',
  `classroom_info_id` varchar(32) DEFAULT NULL COMMENT '??id',
  `stu_info_id` varchar(32) DEFAULT NULL COMMENT '??id',
  PRIMARY KEY (`id`),
  KEY `classroom_info_id` (`classroom_info_id`),
  KEY `course_info_id` (`course_info_id`),
  KEY `stu_info_id` (`stu_info_id`),
  KEY `stu_attend_id` (`stu_attend_id`),
  KEY `teacher_info_info` (`teacher_info_info`),
  CONSTRAINT `main_ibfk_1` FOREIGN KEY (`classroom_info_id`) REFERENCES `classroom_info` (`cr_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `main_ibfk_2` FOREIGN KEY (`course_info_id`) REFERENCES `course_info` (`cs_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `main_ibfk_3` FOREIGN KEY (`stu_info_id`) REFERENCES `student_info` (`stu_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `main_ibfk_4` FOREIGN KEY (`stu_attend_id`) REFERENCES `stu_attend_info` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `main_ibfk_5` FOREIGN KEY (`teacher_info_info`) REFERENCES `teacher_info` (`teacher_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of main
-- ----------------------------
INSERT INTO `main` VALUES ('', null, null, null, null, null);
INSERT INTO `main` VALUES ('0001', 'att01', 'cs01', 'tc02', 'cr02', 'stu2');

-- ----------------------------
-- Table structure for student_info
-- ----------------------------
DROP TABLE IF EXISTS `student_info`;
CREATE TABLE `student_info` (
  `stu_id` varchar(32) NOT NULL COMMENT '??id',
  `stu_sex` varchar(4) DEFAULT NULL COMMENT '??',
  `stu_num` varchar(16) DEFAULT NULL COMMENT '??',
  `stu_name` varchar(16) DEFAULT NULL COMMENT '????',
  `stu_device_address` varchar(32) NOT NULL,
  PRIMARY KEY (`stu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student_info
-- ----------------------------
INSERT INTO `student_info` VALUES ('', null, null, null, '');
INSERT INTO `student_info` VALUES ('stu1', '男', '201530050405\r\n', '陈巧怡', '');
INSERT INTO `student_info` VALUES ('stu10', '男', '201530050416', '孔伦宙', '');
INSERT INTO `student_info` VALUES ('stu2', '女', '201530050406', '陈淑如', '');
INSERT INTO `student_info` VALUES ('stu3', '女', '201530050407', '陈燕玲', '');
INSERT INTO `student_info` VALUES ('stu4', '女', '201530050408', '陈怡璇', '');
INSERT INTO `student_info` VALUES ('stu6', '女', '201530050414', '黄嘉敏', '');
INSERT INTO `student_info` VALUES ('stu7', '女', '201530050412', '符娜莉', '');
INSERT INTO `student_info` VALUES ('stu8', '女', '201530050424', '李子彤', '');
INSERT INTO `student_info` VALUES ('stu9', '女', '201530050417', '邝玉双', '');

-- ----------------------------
-- Table structure for stu_attend_info
-- ----------------------------
DROP TABLE IF EXISTS `stu_attend_info`;
CREATE TABLE `stu_attend_info` (
  `id` varchar(32) NOT NULL,
  `attend_term` varchar(16) NOT NULL COMMENT '??',
  `abs_flag` varchar(2) DEFAULT NULL COMMENT '????',
  `sick_flag` varchar(2) DEFAULT NULL COMMENT '????',
  `attend_time` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of stu_attend_info
-- ----------------------------
INSERT INTO `stu_attend_info` VALUES ('', '', null, null, '0000-00-00');
INSERT INTO `stu_attend_info` VALUES ('att01', '上学期', '是', null, '2015-12-10');
INSERT INTO `stu_attend_info` VALUES ('att02', '上学期', null, '是', '2015-12-23');

-- ----------------------------
-- Table structure for teacher_info
-- ----------------------------
DROP TABLE IF EXISTS `teacher_info`;
CREATE TABLE `teacher_info` (
  `teacher_id` varchar(32) NOT NULL COMMENT 'id',
  `tc_name` varchar(16) NOT NULL COMMENT '????',
  `teacher_num` varchar(32) DEFAULT NULL COMMENT '????',
  PRIMARY KEY (`teacher_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher_info
-- ----------------------------
INSERT INTO `teacher_info` VALUES ('', '', null);
INSERT INTO `teacher_info` VALUES ('tc01', '张莉', '00000975');
INSERT INTO `teacher_info` VALUES ('tc02', '李素玲', '00000978');
INSERT INTO `teacher_info` VALUES ('tc03', '吕旭', '00000979');
