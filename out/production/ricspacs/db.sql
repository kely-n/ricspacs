
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `rispacs` DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
-- Schema rispacs
-- -----------------------------------------------------
USE `rispacs` ;

-- -----------------------------------------------------
-- Table `rispacs`.`patient`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `rispacs`.`patient` ;

CREATE TABLE IF NOT EXISTS `rispacs`.`patient` (
  `reg_no` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(70) NOT NULL,
  `billing_status` ENUM('paid', 'unpaid') NOT NULL,
  `diagnosis` VARCHAR(255) NULL,
  PRIMARY KEY (`reg_no`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `rispacs`.`clinician`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `rispacs`.`clinician` ;

CREATE TABLE IF NOT EXISTS `rispacs`.`clinician` (
  `staff_no` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(80) NOT NULL,
  `department` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`staff_no`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `rispacs`.`radiographer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `rispacs`.`radiographer` ;

CREATE TABLE IF NOT EXISTS `rispacs`.`radiographer` (
  `staff_no` INT NOT NULL,
  `name` VARCHAR(80) NOT NULL,
  `department` VARCHAR(45) NULL DEFAULT 'Radiology',
  PRIMARY KEY (`staff_no`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `rispacs`.`lab_result`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `rispacs`.`lab_result` ;

CREATE TABLE IF NOT EXISTS `rispacs`.`lab_result` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `image` VARCHAR(45) NOT NULL,
  `radiographer_staff_no` INT NOT NULL,
  PRIMARY KEY (`id`, `radiographer_staff_no`),
  INDEX `fk_lab_result_radiographer1_idx` (`radiographer_staff_no` ASC) ,
  CONSTRAINT `fk_lab_result_radiographer1`
    FOREIGN KEY (`radiographer_staff_no`)
    REFERENCES `rispacs`.`radiographer` (`staff_no`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `rispacs`.`appointment`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `rispacs`.`appointment` ;

CREATE TABLE IF NOT EXISTS `rispacs`.`appointment` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `status` ENUM('pending', 'processing', 'complete') NOT NULL DEFAULT 'pending',
  `title` VARCHAR(45) NOT NULL,
  `patient_reg_no` INT NOT NULL,
  `clinician_staff_no` INT NOT NULL,
  `lab_result_id` INT NOT NULL,
  PRIMARY KEY (`id`, `patient_reg_no`, `clinician_staff_no`, `lab_result_id`),
  INDEX `fk_appointment_patient_idx` (`patient_reg_no` ASC) ,
  INDEX `fk_appointment_clinician1_idx` (`clinician_staff_no` ASC) ,
  INDEX `fk_appointment_lab_result1_idx` (`lab_result_id` ASC) ,
  CONSTRAINT `fk_appointment_patient`
    FOREIGN KEY (`patient_reg_no`)
    REFERENCES `rispacs`.`patient` (`reg_no`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_appointment_clinician1`
    FOREIGN KEY (`clinician_staff_no`)
    REFERENCES `rispacs`.`clinician` (`staff_no`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_appointment_lab_result1`
    FOREIGN KEY (`lab_result_id`)
    REFERENCES `rispacs`.`lab_result` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `rispacs`.`radiologist`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `rispacs`.`radiologist` ;

CREATE TABLE IF NOT EXISTS `rispacs`.`radiologist` (
  `staff_no` INT NOT NULL,
  `name` VARCHAR(80) NOT NULL,
  `department` VARCHAR(45) NULL DEFAULT 'Radiology',
  PRIMARY KEY (`staff_no`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `rispacs`.`report`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `rispacs`.`report` ;

CREATE TABLE IF NOT EXISTS `rispacs`.`report` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `description` TEXT(1000) NOT NULL,
  `lab_result_id` INT NOT NULL,
  `radiologist_staff_no` INT NOT NULL,
  PRIMARY KEY (`id`, `lab_result_id`, `radiologist_staff_no`),
  INDEX `fk_report_lab_result1_idx` (`lab_result_id` ASC) ,
  INDEX `fk_report_radiologist1_idx` (`radiologist_staff_no` ASC) ,
  CONSTRAINT `fk_report_lab_result1`
    FOREIGN KEY (`lab_result_id`)
    REFERENCES `rispacs`.`lab_result` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_report_radiologist1`
    FOREIGN KEY (`radiologist_staff_no`)
    REFERENCES `rispacs`.`radiologist` (`staff_no`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

