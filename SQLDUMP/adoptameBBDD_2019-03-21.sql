# ************************************************************
# Sequel Pro SQL dump
# Versi�n 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 5.7.20)
# Base de datos: adoptameBBDD
# Tiempo de Generaci�n: 2019-03-21 06:41:45 +0000
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
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `long` decimal(8,6) DEFAULT NULL,
  `lat` decimal(8,6) DEFAULT NULL,
  `tipo_atencion` varchar(10) DEFAULT NULL,
  `dias` date DEFAULT NULL,
  `horarios` varchar(50) DEFAULT NULL,
  `direccion` varchar(100) DEFAULT NULL,
  `lugar` varchar(100) DEFAULT NULL,
  `barrio` varchar(50) DEFAULT NULL,
  `comuna` varchar(50) DEFAULT NULL,
  `consultas` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `eventos` WRITE;
/*!40000 ALTER TABLE `eventos` DISABLE KEYS */;

INSERT INTO `eventos` (`id`, `long`, `lat`, `tipo_atencion`, `dias`, `horarios`, `direccion`, `lugar`, `barrio`, `comuna`, `consultas`)
VALUES
	(1,-58.496986,-34.668574,'MOVIL','2018-08-07','9 a 14:30 hs','Monte y Amancay','Contededor','Mataderos','COMUNA 9 ','Atenciones clínicas y turnos de castración                                                          '),
	(2,-58.388311,-34.626081,'MOVIL','2018-08-10','8:15 a 14:30 hs ','Pavon y Virrey Cevallos','Plaza Garay','Constitución','COMUNA 1','Atenciones clínicas y turnos de castración'),
	(3,-58.406886,-34.625913,'MOVIL','2018-08-10','8:15 a 14:30 hs ','La Rioja y Cochabamba  ','Plaza Martin Fierro','San Cristobal','COMUNA 3','Atenciones clínicas y turnos de castración'),
	(4,-58.474991,-34.645153,'MOVIL','2018-08-10','8:15 a 14:30 hs ','Fco. Bilbao y Lacarra  ','Parque Avellaneda','Parque Avellaneda','COMUNA 9 ','Atenciones clínicas y turnos de castración'),
	(5,-58.492992,-34.605509,'MOVIL','2019-06-20','10:30 a 17:30 hs','Cuenca 2500','Plaza Aristobulo del Valle','Villa del Parque','COMUNA 11','Atenciones clínicas y turnos de castración                                                         '),
	(6,-58.419934,-34.592039,'MOVIL','2019-05-20','10:30 a 17:30 hs','Costa Rica 3500 ','Plaza Unidad Latinoamericana ','Palermo','COMUNA 14','Atenciones clínicas y turnos de castración                                                         '),
	(7,-58.492992,-34.605509,'MOVIL','2019-05-20','10:30 a 17:30 hs','Cuenca 2500','Plaza Aristobulo del Valle ','Villa del Parque','COMUNA 11','Atenciones clínicas y turnos de castración                                                         '),
	(8,-58.419934,-34.592039,'MOVIL','2019-05-20','10:30 a 17:30 hs','Costa Rica 3500','Plaza Unidad Latinoamericana ','Palermo','COMUNA 14','Atenciones clínicas y turnos de castración                                                         '),
	(9,-58.397291,-34.588025,'MOVIL','2019-03-20','8:15 a 14:30 hs','Av. Las Heras y Av. Pueyrredon    ','Plaza Tte. Gral. Emilio Mitre','Recoleta','COMUNA 2','Atenciones clínicas y turnos de castración'),
	(10,-58.456678,-34.621817,'MOVIL','2019-03-22','8:15 a 14:30 hs','Av. Avellaneda y Donato Alvarez','Plaza Angel Gris','Flores','COMUNA 7','Atenciones clínicas y turnos de castración'),
	(11,-58.479826,-34.550748,'MOVIL','2019-03-22','8:15 a 14:30 hs','García del Río y Melian','Parque Saavedra','Saavedra','COMUNA 12','Atenciones clínicas y turnos de castración'),
	(12,-58.475098,-34.688271,'MOVIL','2019-04-19','10:30 a 17:30 hs ','Av. Fernandez de la Cruz y Guamaní               ','Plaza Sudamericana ','Villa Riachuelo','COMUNA 8','Atenciones clínicas y turnos de castración                                                         '),
	(13,-58.445468,-34.604649,'MOVIL','2019-04-19','10:30 a 17:30 hs ','Olaya y Antesana','Plaza Benito Nazar ','Villa Crespo','COMUNA 15','Atenciones clínicas y turnos de castración                                                         '),
	(14,-58.475098,-34.688271,'MOVIL','2019-04-19','10:30 a 17:30 hs ','Av. Fernandez de la Cruz y Guamaní','Plaza Sudamericana ','Villa Riachuelo','COMUNA 8','Atenciones clínicas y turnos de castración                                                         '),
	(15,-58.445468,-34.604649,'MOVIL','2019-04-19','10:30 a 17:30 hs ','Olaya y Antesana','Plaza Benito Nazar','Villa Crespo','COMUNA 15','Atenciones clínicas y turnos de castración                                                         '),
	(16,-58.369577,-34.626455,'MOVIL','2019-06-20','10:30 a 17:30 hs ','Defensa y Brasil','Parque Lezama','San Telmo','COMUNA 1','Atenciones clínicas y desparasitaciones '),
	(17,-58.407732,-34.625827,'MOVIL','2019-06-20','10:30 a 17:30 hs ','La Rioja y Cochabamba','Plaza Martin Fierro','San Cristobal','COMUNA 3','Atenciones clínicas y desparasitaciones '),
	(18,-58.506506,-34.655400,'MOVIL','2019-06-20','10:30 a 17:30 hs ','Av. Juan B. Alberti y Cafayate','Plaza Salaberry','Mataderos','COMUNA 9 ','Atenciones clínicas y desparasitaciones '),
	(19,-58.487768,-34.559583,'MOVIL','2019-06-20','10:30 a 17:30 hs ','Crisólogo Larralde e/ Machain y Mariano Acha','Plaza Alberdi','Saavedra','COMUNA 12','Atenciones clínicas y desparasitaciones ');

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

LOCK TABLES `mascotas` WRITE;
/*!40000 ALTER TABLE `mascotas` DISABLE KEYS */;

INSERT INTO `mascotas` (`id_mascota`, `descripcion`, `edad`, `estado`, `foto_url`, `nombre`, `raza`, `sexo`, `tamanio`, `tipo_mascota`, `id_coordenada`, `id`)
VALUES
	(1,'perritem muy lindo',12,'DISPONIBLE','/img/pochito.jpg','pochito','Labrador','macho','mediano','perro',NULL,1),
	(2,' gatita muy juguetona',2,'DISPONIBLE','https://misanimales.com/wp-content/uploads/2014/12/gato-enfermo.jpg','Gatalina','Mestiza','Hembra','chico','gato',NULL,1),
	(3,'Muy miedoso, se lleva bien con otros perros',3,'DISPONIBLE','https://e.rpp-noticias.io/normal/2011/09/26/720919.jpg','Sultan','Ovejero','Macho','grande','perro',NULL,1),
	(4,'Gatito tranqiuilo',2,'DISPONIBLE','https://t1.ea.ltmcdn.com/es/images/5/9/3/img_enfermedades_que_puede_transmitir_un_gato_callejero_22395_600.jpg','Silvestre','Mestizo','Macho','chico','gato',NULL,1);

/*!40000 ALTER TABLE `mascotas` ENABLE KEYS */;
UNLOCK TABLES;


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
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `personas` WRITE;
/*!40000 ALTER TABLE `personas` DISABLE KEYS */;

INSERT INTO `personas` (`tipo_persona`, `id`, `apellido`, `email`, `nombre`, `telefono`)
VALUES
	('USUARIO',1,'peralta','lucas.peralta@gmail.com','lucas',NULL),
	('USUARIO',26,'jesus','camila.jesus@gmail.com','camila',NULL),
	('USUARIO',27,'maranga','lucas.pe@gmail.com','gustavo',NULL),
	('USUARIO',28,'pizarro','javier.pizarro@gmail.com','javier',NULL),
	('USUARIO',29,'pepeti','pp@pp.com','pepe',NULL);

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

LOCK TABLES `prestadores` WRITE;
/*!40000 ALTER TABLE `prestadores` DISABLE KEYS */;

INSERT INTO `prestadores` (`fecha_vinculacion`, `tipo_servicio`, `url_pago`, `vigencia`, `id`)
VALUES
	('2018-06-26 19:37:26','Veterinaria','http://pagame.com',NULL,27),
	('2018-06-26 19:47:24','Guarderia','http://mercadopago.com',NULL,28);

/*!40000 ALTER TABLE `prestadores` ENABLE KEYS */;
UNLOCK TABLES;


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
  `vigencia` varchar(255) DEFAULT NULL,
  `id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_servicio`),
  KEY `FKie66hjtqthestpqatya91b0ov` (`id`),
  CONSTRAINT `FKie66hjtqthestpqatya91b0ov` FOREIGN KEY (`id`) REFERENCES `prestadores` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `servicios` WRITE;
/*!40000 ALTER TABLE `servicios` DISABLE KEYS */;

INSERT INTO `servicios` (`id_servicio`, `costo`, `descripcion`, `fecha_fin`, `fecha_inicio`, `tipo_servicio`, `titulo`, `vigencia`, `id`)
VALUES
	(1,12,'servicio de veterianria 24hs','2018-07-30 19:37:26','2018-06-26 19:37:26','Veterinaria','servicio1','34',27),
	(2,32,'guarderia para perritos','2018-07-08 19:47:24','2018-06-26 19:47:24','Guarderia','guarderia ','12',28);

/*!40000 ALTER TABLE `servicios` ENABLE KEYS */;
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
	('12345',1,1,1),
	('12345',26,1,2),
	('12345',29,1,2);

/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
