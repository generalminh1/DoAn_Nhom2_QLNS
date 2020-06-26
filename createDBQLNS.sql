-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema qlns
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema qlns
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `qlns` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `qlns` ;

-- -----------------------------------------------------
-- Table `qlns`.`bacluong`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `qlns`.`bacluong` (
  `MaBL` VARCHAR(30) CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_0900_ai_ci' NOT NULL,
  `SoTien` FLOAT NULL DEFAULT NULL,
  PRIMARY KEY (`MaBL`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `qlns`.`chucvu`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `qlns`.`chucvu` (
  `MaCV` VARCHAR(45) CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_0900_ai_ci' NOT NULL,
  `TenChucVu` VARCHAR(45) CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_0900_ai_ci' NULL DEFAULT NULL,
  PRIMARY KEY (`MaCV`),
  UNIQUE INDEX `MaCV_UNIQUE` (`MaCV` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `qlns`.`phongban`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `qlns`.`phongban` (
  `MaPB` VARCHAR(30) CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_0900_ai_ci' NOT NULL,
  `TenPB` VARCHAR(45) CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_0900_ai_ci' NULL DEFAULT NULL,
  PRIMARY KEY (`MaPB`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `qlns`.`thongtinnv`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `qlns`.`thongtinnv` (
  `MaNV` VARCHAR(45) CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_0900_ai_ci' NOT NULL,
  `HoTen` VARCHAR(50) CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_0900_ai_ci' NULL DEFAULT NULL,
  `NgaySinh` VARCHAR(20) CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_0900_ai_ci' NULL DEFAULT NULL,
  `QueQuan` VARCHAR(45) CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_0900_ai_ci' NULL DEFAULT NULL,
  `GioiTinh` VARCHAR(20) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `DanToc` VARCHAR(45) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `SoDienThoai` VARCHAR(45) CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_0900_ai_ci' NULL DEFAULT NULL,
  `MaPB` VARCHAR(30) CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_0900_ai_ci' NULL DEFAULT NULL,
  `MaCV` VARCHAR(45) CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_0900_ai_ci' NULL DEFAULT NULL,
  `MaTDHV` VARCHAR(45) CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_0900_ai_ci' NULL DEFAULT NULL,
  `MucLuong` VARCHAR(30) CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_0900_ai_ci' NULL DEFAULT NULL,
  `SoCMND` VARCHAR(45) CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_0900_ai_ci' NULL DEFAULT NULL,
  PRIMARY KEY (`MaNV`),
  INDEX `fk_thongtinnv_chucvu_idx` (`MaCV` ASC) VISIBLE,
  INDEX `fk_thongtinnv_phongban_idx` (`MaPB` ASC) VISIBLE,
  INDEX `fk_thongtinnv_bacluong_idx` (`MucLuong` ASC) VISIBLE,
  CONSTRAINT `fk_thongtinnv_bacluong`
    FOREIGN KEY (`MucLuong`)
    REFERENCES `qlns`.`bacluong` (`MaBL`),
  CONSTRAINT `fk_thongtinnv_chucvu`
    FOREIGN KEY (`MaCV`)
    REFERENCES `qlns`.`chucvu` (`MaCV`),
  CONSTRAINT `fk_thongtinnv_phongban`
    FOREIGN KEY (`MaPB`)
    REFERENCES `qlns`.`phongban` (`MaPB`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `qlns`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `qlns`.`user` (
  `TaiKhoan` VARCHAR(45) NOT NULL,
  `MatKhau` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`TaiKhoan`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
