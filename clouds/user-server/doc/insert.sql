CREATE TABLE user( 
	`id` INT NOT NULL AUTO_INCREMENT,
	`user_code` VARCHAR(20),
	`user_name` VARCHAR(100),
	`password` VARCHAR(20),
	`likes` VARCHAR(100),
	PRIMARY KEY (`id`) 
) ENGINE=INNODB CHARSET=utf8;