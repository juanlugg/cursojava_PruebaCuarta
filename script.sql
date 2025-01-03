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
  `id_vuelo` INT NOT NULL AUTO_INCREMENT,
  `company` VARCHAR(50) NULL,
  `fecha_vuelo` VARCHAR(10) NULL,
  `precio` DECIMAL(6,2) NULL,
  `plazas` INT NULL,
  PRIMARY KEY (`id_vuelo`));

INSERT INTO `agencia_viajes`.`vuelos` (`company`, `fecha_vuelo`, `precio`, `plazas`) VALUES ('Raynair', '22/10/2022', '56', '104');
INSERT INTO `agencia_viajes`.`vuelos` (`company`, `fecha_vuelo`, `precio`, `plazas`) VALUES ('Turkish Airlines', '12/01/2025', '849.50', '34');
INSERT INTO `agencia_viajes`.`vuelos` (`company`, `fecha_vuelo`, `precio`, `plazas`) VALUES ('Vueling', '01/02/2024', '150', '0');
INSERT INTO `agencia_viajes`.`vuelos` (`company`, `fecha_vuelo`, `precio`, `plazas`) VALUES ('Iberia', '13/04/2025', '223', '54');
INSERT INTO `agencia_viajes`.`vuelos` (`company`, `fecha_vuelo`, `precio`, `plazas`) VALUES ('Air Europa', '21/11/2023', '150', '22');
INSERT INTO `agencia_viajes`.`vuelos` (`company`, `fecha_vuelo`, `precio`, `plazas`) VALUES ('Lufthansa', '30/01/2024', '76.50', '0');

CREATE TABLE `agencia_viajes`.`reservas` (
  `id_reserva` INT NOT NULL AUTO_INCREMENT,
  `nombre_cliente` VARCHAR(100) NULL,
  `dni` VARCHAR(9) NOT NULL,
  `id_hotel` INT NOT NULL,
  `id_vuelo` INT NOT NULL,
  PRIMARY KEY (`id_reserva`),
  UNIQUE INDEX `dni_UNIQUE` (`dni` ASC) VISIBLE,
  INDEX `id_hotel_idx` (`id_hotel` ASC) VISIBLE,
  INDEX `id_vuelo_idx` (`id_vuelo` ASC) VISIBLE,
  CONSTRAINT `id_hotel`
    FOREIGN KEY (`id_hotel`)
    REFERENCES `agencia_viajes`.`hoteles` (`id_hotel`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `id_vuelo`
    FOREIGN KEY (`id_vuelo`)
    REFERENCES `agencia_viajes`.`vuelos` (`id_vuelo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

INSERT INTO `agencia_viajes`.`reservas` (`nombre_cliente`, `dni`, `id_hotel`, `id_vuelo`) VALUES ('Juan Luis Guerra Gennich', '790590xxX', '1', '2');
INSERT INTO `agencia_viajes`.`reservas` (`nombre_cliente`, `dni`, `id_hotel`, `id_vuelo`) VALUES ('Paco', '12345678Z', '4', '6');
INSERT INTO `agencia_viajes`.`reservas` (`nombre_cliente`, `dni`, `id_hotel`, `id_vuelo`) VALUES ('Zoe', '22102022E', '2', '2');
INSERT INTO `agencia_viajes`.`reservas` (`nombre_cliente`, `dni`, `id_hotel`, `id_vuelo`) VALUES ('Geronimo', '98765432A', '5', '1');
