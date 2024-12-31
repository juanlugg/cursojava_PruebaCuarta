CREATE SCHEMA `agencia_viajes` ;

CREATE TABLE `agencia_viajes`.`hoteles` (
  `id_hotel` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(50) NOT NULL,
  `precio` DECIMAL(5,2) NOT NULL,
  `disponible` BOOLEAN NOT NULL,
  PRIMARY KEY (`id_hotel`),
  UNIQUE INDEX `nombre_UNIQUE` (`nombre` ASC) VISIBLE);

INSERT INTO `agencia_viajes`.`hoteles` (`nombre`, `precio`, `disponible`) VALUES ('Yaramar', '210', '1');
INSERT INTO `agencia_viajes`.`hoteles` (`nombre`, `precio`, `disponible`) VALUES ('Ibis', '145.50', '1');
INSERT INTO `agencia_viajes`.`hoteles` (`nombre`, `precio`, `disponible`) VALUES ('Larios', '52', '0');
INSERT INTO `agencia_viajes`.`hoteles` (`nombre`, `precio`, `disponible`) VALUES ('Las Rampas', '64.80', '1');
INSERT INTO `agencia_viajes`.`hoteles` (`nombre`, `precio`, `disponible`) VALUES ('Occidental', '112', '1');
INSERT INTO `agencia_viajes`.`hoteles` (`nombre`, `precio`, `disponible`) VALUES ('El Puerto', '67.88', '0');


CREATE TABLE `agencia_viajes`.`vuelos` (
  `id_vuelos` INT NOT NULL AUTO_INCREMENT,
  `company` VARCHAR(50) NULL,
  `fecha_vuelo` VARCHAR(10) NULL,
  `precio` DECIMAL(6,2) NULL,
  `plazas` INT NULL,
  PRIMARY KEY (`id_vuelos`));

INSERT INTO `agencia_viajes`.`vuelos` (`company`, `fecha_vuelo`, `precio`, `plazas`) VALUES ('Raynair', '22/10/2022', '56', '104');
INSERT INTO `agencia_viajes`.`vuelos` (`company`, `fecha_vuelo`, `precio`, `plazas`) VALUES ('Turkish Airlines', '12/01/2025', '849.50', '34');
INSERT INTO `agencia_viajes`.`vuelos` (`company`, `fecha_vuelo`, `precio`, `plazas`) VALUES ('Vueling', '01/02/2024', '150', '0');
INSERT INTO `agencia_viajes`.`vuelos` (`company`, `fecha_vuelo`, `precio`, `plazas`) VALUES ('Iberia', '13/04/2025', '223', '54');
INSERT INTO `agencia_viajes`.`vuelos` (`company`, `fecha_vuelo`, `precio`, `plazas`) VALUES ('Air Europa', '21/11/2023', '150', '22');
INSERT INTO `agencia_viajes`.`vuelos` (`company`, `fecha_vuelo`, `precio`, `plazas`) VALUES ('Lufthansa', '30/01/2024', '76.50', '0');
