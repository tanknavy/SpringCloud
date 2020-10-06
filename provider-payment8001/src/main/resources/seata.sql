------------distributed transaction -------------
--CREATE DATABASE t_order;
--CREATE DATABASE t_storage;
--CREATE DATABASE t_account;

----------------------------
USE SEATA_ORDER;
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order`(
`id` BIGINT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
`user_id` BIGINT(11) DEFAULT NULL COMMENT 'USER ID',
`product_id` BIGINT(11) DEFAULT NULL COMMENT 'PRODUCT ID',
`count` INT(11) DEFAULT NULL COMMENT 'QUANTITY',
`money` DECIMAL(11,0) DEFAULT NULL COMMENT 'AMOUNT',
`status` INT(1) DEFAULT NULL COMMENT '0:CREATING; 1:FINISHED'
)ENGINE=INNODB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

SELECT * FROM t_order;


-------------------
USE SEATA_STORAGE;
DROP TABLE IF EXISTS `t_storage`;
CREATE TABLE `t_storage`(
`id` BIGINT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
`product_id` BIGINT(11) DEFAULT NULL COMMENT 'PRODUCT ID',
`total` INT(11) DEFAULT NULL COMMENT 'total stock',
`used` INT(11) DEFAULT NULL COMMENT 'used stock',
`residue` INT(11) DEFAULT NULL COMMENT 'remaining stock'
)ENGINE=INNODB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

INSERT INTO seata_storage.t_storage(`id`,`product_id`,`total`,`used`,`residue`) VALUES('1','1','100','0','100');

SELECT * FROM t_storage;

-------------------------------
USE SEATA_ACCOUNT;
DROP TABLE IF EXISTS `t_account`;
CREATE TABLE `t_account`(
`id` BIGINT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
`user_id` BIGINT(11) DEFAULT NULL COMMENT 'USER ID',
`total` DECIMAL(10,0) DEFAULT NULL COMMENT 'total stock',
`used` DECIMAL(10,0) DEFAULT NULL COMMENT 'used stock',
`residue` DECIMAL(10,0) DEFAULT '0' COMMENT 'remaining stock'
)ENGINE=INNODB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

INSERT INTO SEATA_ACCOUNT.t_account(`id`,`user_id`,`total`,`used`,`residue`) VALUES('1','1','1000','0','1000');

SELECT * FROM t_account;