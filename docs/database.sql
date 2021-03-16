DROP TABLE if EXISTS `reserva`;
DROP TABLE if EXISTS `horario`;
DROP TABLE if EXISTS `instalacion`;
DROP TABLE if EXISTS `usuario`;


CREATE TABLE `usuario` (
  `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `username` varchar(12) NOT NULL,
  `password` varchar(20) NOT NULL,
  `email` varchar(50) NOT NULL
) ENGINE='InnoDB';


CREATE TABLE `instalacion` (
  `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `nombre` varchar(50) NOT NULL
) ENGINE='InnoDB';


CREATE TABLE `horario` (
  `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `instalacion` int(11) NOT NULL,
  `inicio` time NOT NULL,
  `fin` time NOT NULL,
  FOREIGN KEY (`instalacion`) REFERENCES `instalacion` (`id`) ON DELETE CASCADE
) ENGINE='InnoDB';


CREATE TABLE `reserva` (
  `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `usuario` int(11) NOT NULL,
  `horario` int(11) NOT NULL,
  `fecha` date NOT NULL,
  FOREIGN KEY (`usuario`) REFERENCES `usuario` (`id`),
  FOREIGN KEY (`horario`) REFERENCES `horario` (`id`)
) ENGINE='InnoDB';
