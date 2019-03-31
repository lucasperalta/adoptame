# ************************************************************
# Sequel Pro SQL dump
# Versión 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 5.7.20)
# Base de datos: adoptameBBDD
# Tiempo de Generación: 2019-03-31 07:09:44 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Volcado de tabla coordenadas
# ------------------------------------------------------------

DROP TABLE IF EXISTS `coordenadas`;

CREATE TABLE `coordenadas` (
  `id_coordenada` int(11) NOT NULL AUTO_INCREMENT,
  `latitud` bigint(20) DEFAULT NULL,
  `longitud` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_coordenada`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



# Volcado de tabla estados
# ------------------------------------------------------------

DROP TABLE IF EXISTS `estados`;

CREATE TABLE `estados` (
  `id_estado` bigint(20) NOT NULL AUTO_INCREMENT,
  `estado` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_estado`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `estados` WRITE;
/*!40000 ALTER TABLE `estados` DISABLE KEYS */;

INSERT INTO `estados` (`id_estado`, `estado`)
VALUES
	(1,'ACTIVO'),
	(2,'INACTIVO'),
	(3,'SUSPENDIDO');

/*!40000 ALTER TABLE `estados` ENABLE KEYS */;
UNLOCK TABLES;


# Volcado de tabla eventos
# ------------------------------------------------------------

DROP TABLE IF EXISTS `eventos`;

CREATE TABLE `eventos` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `barrio` varchar(255) DEFAULT NULL,
  `consultas` varchar(255) DEFAULT NULL,
  `dias` date DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `horarios` varchar(255) DEFAULT NULL,
  `lugar` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `eventos` WRITE;
/*!40000 ALTER TABLE `eventos` DISABLE KEYS */;

INSERT INTO `eventos` (`id`, `barrio`, `consultas`, `dias`, `direccion`, `horarios`, `lugar`)
VALUES
	(1,'palermo','atencion veterinaria basica, vacunacion , castracion','2019-03-29','alvarez thomas 345','12 a 16','plaza garay');

/*!40000 ALTER TABLE `eventos` ENABLE KEYS */;
UNLOCK TABLES;


# Volcado de tabla mascotas
# ------------------------------------------------------------

DROP TABLE IF EXISTS `mascotas`;

CREATE TABLE `mascotas` (
  `id_mascota` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) DEFAULT NULL,
  `edad` int(11) DEFAULT NULL,
  `estado` varchar(255) DEFAULT NULL,
  `foto_url` varchar(255) DEFAULT NULL,
  `nombre` varchar(45) NOT NULL,
  `raza` varchar(45) NOT NULL,
  `sexo` varchar(45) NOT NULL,
  `tamanio` varchar(255) DEFAULT NULL,
  `tipo_mascota` varchar(45) DEFAULT NULL,
  `id_coordenada` int(11) DEFAULT NULL,
  `id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_mascota`),
  KEY `FKti8sarwwnwfyc3xvqa8xk2tg1` (`id_coordenada`),
  KEY `FKh3w8gd1k3dyu962urbx4tf06i` (`id`),
  CONSTRAINT `FKh3w8gd1k3dyu962urbx4tf06i` FOREIGN KEY (`id`) REFERENCES `usuarios` (`id`),
  CONSTRAINT `FKti8sarwwnwfyc3xvqa8xk2tg1` FOREIGN KEY (`id_coordenada`) REFERENCES `coordenadas` (`id_coordenada`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



# Volcado de tabla permisos
# ------------------------------------------------------------

DROP TABLE IF EXISTS `permisos`;

CREATE TABLE `permisos` (
  `id_permiso` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_permiso` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_permiso`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



# Volcado de tabla personas
# ------------------------------------------------------------

DROP TABLE IF EXISTS `personas`;

CREATE TABLE `personas` (
  `tipo_persona` varchar(31) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `apellido` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `personas` WRITE;
/*!40000 ALTER TABLE `personas` DISABLE KEYS */;

INSERT INTO `personas` (`tipo_persona`, `id`, `apellido`, `email`, `nombre`)
VALUES
	('Usuario',1,'peralta','lucas.peralta@gmail.com','lucas'),
	('Usuario',2,'lop','loperalta@stefanini.com','lop');

/*!40000 ALTER TABLE `personas` ENABLE KEYS */;
UNLOCK TABLES;


# Volcado de tabla prestadores
# ------------------------------------------------------------

DROP TABLE IF EXISTS `prestadores`;

CREATE TABLE `prestadores` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `apellido` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `fecha_vinculacion` datetime DEFAULT NULL,
  `nombre` varchar(45) NOT NULL,
  `tipo_servicio` varchar(255) DEFAULT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `prestadores` WRITE;
/*!40000 ALTER TABLE `prestadores` DISABLE KEYS */;

INSERT INTO `prestadores` (`id`, `apellido`, `email`, `fecha_vinculacion`, `nombre`, `tipo_servicio`, `telefono`, `direccion`)
VALUES
	(1,'peralta','lucas.peralta@gmail.com','2019-03-31 04:03:07','lucas ','Guarderia','4652-4311','reconquista'),
	(2,'rodriguez','jorge.rodriguez@gmail.com','2019-03-29 23:43:56','jorge ','Veterinaria','4654-5678',NULL),
	(3,'','','2019-03-31 03:56:11','','Veterinaria','',''),
	(4,'as','lucas.peralta@gmail.c','2019-03-30 02:28:14','sasas','Guarderia','12121','as'),
	(6,'peralta','loperalta@stefanini.com','2019-03-31 03:57:21','loperalta','Guarderia','46524311','reconquista 34'),
	(7,'897','l@l','2019-03-31 03:59:40','8967','Guarderia','87','0897'),
	(8,'o','g@g','2019-03-31 04:01:18','o','Guarderia','o','o'),
	(9,'1','e@e','2019-03-31 04:05:12','1','Guarderia','1','1');

/*!40000 ALTER TABLE `prestadores` ENABLE KEYS */;
UNLOCK TABLES;


# Volcado de tabla rol_permiso
# ------------------------------------------------------------

DROP TABLE IF EXISTS `rol_permiso`;

CREATE TABLE `rol_permiso` (
  `id_rol` bigint(20) NOT NULL,
  `id_permiso` int(11) NOT NULL,
  KEY `FKb1ybebncburjvuednr35mtip8` (`id_permiso`),
  KEY `FKe9j8u1s3ivvp18oed07a2gnhc` (`id_rol`),
  CONSTRAINT `FKb1ybebncburjvuednr35mtip8` FOREIGN KEY (`id_permiso`) REFERENCES `permisos` (`id_permiso`),
  CONSTRAINT `FKe9j8u1s3ivvp18oed07a2gnhc` FOREIGN KEY (`id_rol`) REFERENCES `roles` (`id_rol`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



# Volcado de tabla roles
# ------------------------------------------------------------

DROP TABLE IF EXISTS `roles`;

CREATE TABLE `roles` (
  `id_rol` bigint(20) NOT NULL AUTO_INCREMENT,
  `nombre_rol` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_rol`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;

INSERT INTO `roles` (`id_rol`, `nombre_rol`)
VALUES
	(1,'ADMIN'),
	(2,'USER');

/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;


# Volcado de tabla servicios
# ------------------------------------------------------------

DROP TABLE IF EXISTS `servicios`;

CREATE TABLE `servicios` (
  `id_servicio` int(11) NOT NULL AUTO_INCREMENT,
  `costo` float DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `fecha_fin` datetime DEFAULT NULL,
  `fecha_inicio` datetime DEFAULT NULL,
  `tipo_servicio` varchar(255) DEFAULT NULL,
  `titulo` varchar(255) DEFAULT NULL,
  `url_pago` varchar(255) DEFAULT NULL,
  `vigencia` varchar(255) DEFAULT NULL,
  `id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_servicio`),
  KEY `FKie66hjtqthestpqatya91b0ov` (`id`),
  CONSTRAINT `FKie66hjtqthestpqatya91b0ov` FOREIGN KEY (`id`) REFERENCES `prestadores` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `servicios` WRITE;
/*!40000 ALTER TABLE `servicios` DISABLE KEYS */;

INSERT INTO `servicios` (`id_servicio`, `costo`, `descripcion`, `fecha_fin`, `fecha_inicio`, `tipo_servicio`, `titulo`, `url_pago`, `vigencia`, `id`)
VALUES
	(4,12,'vacunacion anti rabica','2019-04-30 00:00:00','2019-03-30 01:54:45','Guarderia','veterinaria','121212','12',2),
	(10,123,'servciio de guarderia en caniles','2019-04-03 00:00:00','2019-03-31 03:31:12','Guarderia','guarderia','http:mercadopago.com','3',1),
	(11,120,'desparasitacion de perros y gatos','2019-04-13 03:48:46','2019-03-31 03:48:46','Veterinaria','desparasitacion','http://mercadolibra.com.ar','13',6),
	(13,1212,'1212121','2019-04-12 03:56:36','2019-03-31 03:56:36','Guarderia','1212','121212','12',6),
	(14,12,'121','2019-04-01 03:57:46','2019-03-31 03:57:43','Guarderia','1212','121212','1',6),
	(15,7,'23','2021-09-13 03:59:40','2019-03-31 03:59:40','Guarderia','098','1212','897',7),
	(16,1,'1','2019-04-01 04:01:18','2019-03-31 04:01:18','Guarderia','o','1','1',8),
	(17,1,'1','2019-04-01 04:03:07','2019-03-31 04:03:07','Guarderia','1','1','1',1),
	(18,1,'1','2019-04-01 04:05:12','2019-03-31 04:05:12','Guarderia','1','1','1',9);

/*!40000 ALTER TABLE `servicios` ENABLE KEYS */;
UNLOCK TABLES;


# Volcado de tabla usuarios
# ------------------------------------------------------------

DROP TABLE IF EXISTS `usuarios`;

CREATE TABLE `usuarios` (
  `password` varchar(255) DEFAULT NULL,
  `id` int(11) NOT NULL,
  `id_estado` bigint(20) DEFAULT NULL,
  `id_rol` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2on43m0kldlaamvjodby74ruu` (`id_estado`),
  KEY `FK3kl77pehgupicftwfreqnjkll` (`id_rol`),
  CONSTRAINT `FK2on43m0kldlaamvjodby74ruu` FOREIGN KEY (`id_estado`) REFERENCES `estados` (`id_estado`),
  CONSTRAINT `FK3kl77pehgupicftwfreqnjkll` FOREIGN KEY (`id_rol`) REFERENCES `roles` (`id_rol`),
  CONSTRAINT `FKjdiqy1h3s5meigcqmjdcpt1ko` FOREIGN KEY (`id`) REFERENCES `personas` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;

INSERT INTO `usuarios` (`password`, `id`, `id_estado`, `id_rol`)
VALUES
	('12345678',1,1,1),
	('12345678',2,1,1);

/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
