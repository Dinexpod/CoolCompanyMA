CREATE SCHEMA `coolcompany` DEFAULT CHARACTER SET utf8 ;

CREATE TABLE `coolcompany`.`developers` (
  `developer_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `age` INT(200) NOT NULL,
  `sex` VARCHAR(45) NULL,
  PRIMARY KEY (`developer_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE `coolcompany`.`skills` (
  `skill_id` INT NOT NULL AUTO_INCREMENT,
  `field` VARCHAR(255) NOT NULL,
  `degree` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`skill_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE `coolcompany`.`projects` (
  `project_id` INT NOT NULL AUTO_INCREMENT,
  `little` VARCHAR(255) NULL,
  `middle` VARCHAR(255) NULL,
  `big` VARCHAR(255) NULL,
  PRIMARY KEY (`project_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE `coolcompany`.`companies` (
  `company_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `people` INT NOT NULL,
  `type` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`company_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

ALTER TABLE `coolcompany`.`projects`
DROP COLUMN `big`,
DROP COLUMN `middle`,
DROP COLUMN `little`,
ADD COLUMN `type` VARCHAR(255) NOT NULL AFTER `project_id`,
ADD COLUMN `name` VARCHAR(255) NOT NULL AFTER `type`,
ADD COLUMN `count_people` INT NULL DEFAULT NULL AFTER `name`;

CREATE TABLE `coolcompany`.`customers` (
  `customer_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `age` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`customer_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE `coolcompany`.`developers_projects` (
  `developer` INT NOT NULL,
  `project` INT NOT NULL,
  PRIMARY KEY (`developer`, `project`),
  INDEX `project_fk_idx` (`project` ASC) VISIBLE,
  CONSTRAINT `developer_fk1`
    FOREIGN KEY (`developer`)
    REFERENCES `coolcompany`.`developers` (`developer_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `project_fk1`
    FOREIGN KEY (`project`)
    REFERENCES `coolcompany`.`projects` (`project_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE `coolcompany`.`developers_skills` (
  `developer` INT NOT NULL,
  `skill` INT NOT NULL,
  PRIMARY KEY (`developer`, `skill`),
  INDEX `skill_fk_idx` (`skill` ASC) VISIBLE,
  CONSTRAINT `developer_fk`
    FOREIGN KEY (`developer`)
    REFERENCES `coolcompany`.`developers` (`developer_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `skill_fk`
    FOREIGN KEY (`skill`)
    REFERENCES `coolcompany`.`skills` (`skill_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE `coolcompany`.`companies_projects` (
  `company` INT NOT NULL,
  `project` INT NOT NULL,
  PRIMARY KEY (`company`, `project`),
  INDEX `project_fk_idx` (`project` ASC) VISIBLE,
  CONSTRAINT `company_fk`
    FOREIGN KEY (`company`)
    REFERENCES `coolcompany`.`companies` (`company_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `project_fk`
    FOREIGN KEY (`project`)
    REFERENCES `coolcompany`.`projects` (`project_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE `coolcompany`.`customers_projects` (
  `customer` INT NOT NULL,
  `project` INT NOT NULL,
  PRIMARY KEY (`customer`, `project`),
  INDEX `project_fk_idx` (`project` ASC) VISIBLE,
  CONSTRAINT `project_fk2`
    FOREIGN KEY (`project`)
    REFERENCES `coolcompany`.`projects` (`project_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `customer_fk`
    FOREIGN KEY (`customer`)
    REFERENCES `coolcompany`.`customers` (`customer_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;
