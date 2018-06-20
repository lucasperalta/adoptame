# ************************************************************
# Sequel Pro SQL dump
# Versi�n 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
  #
# Host: 127.0.0.1 (MySQL 5.7.20)
# Base de datos: adoptameBBDD
# Tiempo de Generaci�n: 2018-06-02 00:31:51 +0000
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
  `id_estado` int(11) NOT NULL AUTO_INCREMENT,
  `estado` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_estado`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

LOCK TABLES `estados` WRITE;
/*!40000 ALTER TABLE `estados` DISABLE KEYS */;

INSERT INTO `estados` (`id_estado`, `estado`)
VALUES
	(1,'ACTIVO'),
	(2,'INACTIVO'),
	(3,'SUSPENDIDO');

/*!40000 ALTER TABLE `estados` ENABLE KEYS */;
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
  `telefono` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

LOCK TABLES `personas` WRITE;
/*!40000 ALTER TABLE `personas` DISABLE KEYS */;

INSERT INTO `personas` (`tipo_persona`, `id`, `apellido`, `email`, `nombre`)
VALUES
	('USUARIO',1,'peralta','lucas.peralta@gmail.com','lucas');

/*!40000 ALTER TABLE `personas` ENABLE KEYS */;
UNLOCK TABLES;


# Volcado de tabla prestadores
# ------------------------------------------------------------

DROP TABLE IF EXISTS `prestadores`;

CREATE TABLE `prestadores` (
  `fecha_vinculacion` datetime DEFAULT NULL,
  `tipo_servicio` varchar(255) DEFAULT NULL,
  `url_pago` varchar(255) DEFAULT NULL,
  `vigencia` int(11) DEFAULT NULL,
  `id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK5tgtimfaawt4oa7gvxlg91olx` FOREIGN KEY (`id`) REFERENCES `personas` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



# Volcado de tabla rol_permiso
# ------------------------------------------------------------

DROP TABLE IF EXISTS `rol_permiso`;

CREATE TABLE `rol_permiso` (
  `id_rol` int(11) NOT NULL,
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
  `id_rol` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_rol` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_rol`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;

INSERT INTO `roles` (`id_rol`, `nombre_rol`)
VALUES
	(1,'ADMIN'),
	(2,'USER');

/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;


# Volcado de tabla usuarios
# ------------------------------------------------------------

DROP TABLE IF EXISTS `usuarios`;

CREATE TABLE `usuarios` (
  `password` varchar(255) DEFAULT NULL,
  `id` int(11) NOT NULL,
  `id_estado` int(11) DEFAULT NULL,
  `id_rol` int(11) DEFAULT NULL,
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
	('',1,1,1);

/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
