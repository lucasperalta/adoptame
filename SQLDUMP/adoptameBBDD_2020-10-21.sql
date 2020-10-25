--
-- PostgreSQL database cluster dump
--

-- Started on 2020-10-21 01:05:46 -03

SET default_transaction_read_only = off;

SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;

--
-- Roles
--

CREATE ROLE lucas;
ALTER ROLE lucas WITH SUPERUSER INHERIT CREATEROLE CREATEDB LOGIN NOREPLICATION NOBYPASSRLS;
CREATE ROLE postgres;
ALTER ROLE postgres WITH SUPERUSER INHERIT CREATEROLE CREATEDB LOGIN REPLICATION BYPASSRLS;






--
-- Databases
--

--
-- Database "template1" dump
--

\connect template1

--
-- PostgreSQL database dump
--

-- Dumped from database version 12.3
-- Dumped by pg_dump version 12.2

-- Started on 2020-10-21 01:05:46 -03

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

-- Completed on 2020-10-21 01:05:47 -03

--
-- PostgreSQL database dump complete
--

--
-- Database "lucas" dump
--

--
-- PostgreSQL database dump
--

-- Dumped from database version 12.3
-- Dumped by pg_dump version 12.2

-- Started on 2020-10-21 01:05:47 -03

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 3305 (class 1262 OID 16385)
-- Name: lucas; Type: DATABASE; Schema: -; Owner: lucas
--

CREATE DATABASE lucas WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'en_US.UTF-8' LC_CTYPE = 'en_US.UTF-8';


ALTER DATABASE lucas OWNER TO lucas;

\connect lucas

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 203 (class 1259 OID 16388)
-- Name: coordenadas; Type: TABLE; Schema: public; Owner: lucas
--

CREATE TABLE public.coordenadas (
    id_coordenada integer NOT NULL,
    latitud double precision,
    longitud double precision
);


ALTER TABLE public.coordenadas OWNER TO lucas;

--
-- TOC entry 202 (class 1259 OID 16386)
-- Name: coordenadas_id_coordenada_seq; Type: SEQUENCE; Schema: public; Owner: lucas
--

CREATE SEQUENCE public.coordenadas_id_coordenada_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.coordenadas_id_coordenada_seq OWNER TO lucas;

--
-- TOC entry 3306 (class 0 OID 0)
-- Dependencies: 202
-- Name: coordenadas_id_coordenada_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: lucas
--

ALTER SEQUENCE public.coordenadas_id_coordenada_seq OWNED BY public.coordenadas.id_coordenada;


--
-- TOC entry 205 (class 1259 OID 16396)
-- Name: estados; Type: TABLE; Schema: public; Owner: lucas
--

CREATE TABLE public.estados (
    id_estado bigint NOT NULL,
    estado character varying(255)
);


ALTER TABLE public.estados OWNER TO lucas;

--
-- TOC entry 204 (class 1259 OID 16394)
-- Name: estados_id_estado_seq; Type: SEQUENCE; Schema: public; Owner: lucas
--

CREATE SEQUENCE public.estados_id_estado_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.estados_id_estado_seq OWNER TO lucas;

--
-- TOC entry 3307 (class 0 OID 0)
-- Dependencies: 204
-- Name: estados_id_estado_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: lucas
--

ALTER SEQUENCE public.estados_id_estado_seq OWNED BY public.estados.id_estado;


--
-- TOC entry 207 (class 1259 OID 16404)
-- Name: eventos; Type: TABLE; Schema: public; Owner: lucas
--

CREATE TABLE public.eventos (
    id bigint NOT NULL,
    barrio character varying(255),
    consultas character varying(255),
    dias date,
    direccion character varying(255),
    horarios character varying(255),
    lugar character varying(255)
);


ALTER TABLE public.eventos OWNER TO lucas;

--
-- TOC entry 206 (class 1259 OID 16402)
-- Name: eventos_id_seq; Type: SEQUENCE; Schema: public; Owner: lucas
--

CREATE SEQUENCE public.eventos_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.eventos_id_seq OWNER TO lucas;

--
-- TOC entry 3308 (class 0 OID 0)
-- Dependencies: 206
-- Name: eventos_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: lucas
--

ALTER SEQUENCE public.eventos_id_seq OWNED BY public.eventos.id;


--
-- TOC entry 209 (class 1259 OID 16415)
-- Name: mascotas; Type: TABLE; Schema: public; Owner: lucas
--

CREATE TABLE public.mascotas (
    id_mascota bigint NOT NULL,
    descripcion character varying(255),
    edad integer,
    estado character varying(255),
    foto_url character varying(255),
    nombre character varying(45) NOT NULL,
    raza character varying(45) NOT NULL,
    sexo character varying(45) NOT NULL,
    tamanio character varying(255),
    tipo_mascota character varying(45),
    id_coordenada integer,
    id integer
);


ALTER TABLE public.mascotas OWNER TO lucas;

--
-- TOC entry 208 (class 1259 OID 16413)
-- Name: mascotas_id_mascota_seq; Type: SEQUENCE; Schema: public; Owner: lucas
--

CREATE SEQUENCE public.mascotas_id_mascota_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.mascotas_id_mascota_seq OWNER TO lucas;

--
-- TOC entry 3309 (class 0 OID 0)
-- Dependencies: 208
-- Name: mascotas_id_mascota_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: lucas
--

ALTER SEQUENCE public.mascotas_id_mascota_seq OWNED BY public.mascotas.id_mascota;


--
-- TOC entry 211 (class 1259 OID 16426)
-- Name: permisos; Type: TABLE; Schema: public; Owner: lucas
--

CREATE TABLE public.permisos (
    id_permiso integer NOT NULL,
    nombre_permiso character varying(255)
);


ALTER TABLE public.permisos OWNER TO lucas;

--
-- TOC entry 210 (class 1259 OID 16424)
-- Name: permisos_id_permiso_seq; Type: SEQUENCE; Schema: public; Owner: lucas
--

CREATE SEQUENCE public.permisos_id_permiso_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.permisos_id_permiso_seq OWNER TO lucas;

--
-- TOC entry 3310 (class 0 OID 0)
-- Dependencies: 210
-- Name: permisos_id_permiso_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: lucas
--

ALTER SEQUENCE public.permisos_id_permiso_seq OWNED BY public.permisos.id_permiso;


--
-- TOC entry 213 (class 1259 OID 16434)
-- Name: personas; Type: TABLE; Schema: public; Owner: lucas
--

CREATE TABLE public.personas (
    tipo_persona character varying(31) NOT NULL,
    id integer NOT NULL,
    apellido character varying(45) NOT NULL,
    email character varying(45) NOT NULL,
    nombre character varying(45) NOT NULL,
    telefono character varying(45),
    ubicacion character varying(45)
);


ALTER TABLE public.personas OWNER TO lucas;

--
-- TOC entry 212 (class 1259 OID 16432)
-- Name: personas_id_seq; Type: SEQUENCE; Schema: public; Owner: lucas
--

CREATE SEQUENCE public.personas_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.personas_id_seq OWNER TO lucas;

--
-- TOC entry 3311 (class 0 OID 0)
-- Dependencies: 212
-- Name: personas_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: lucas
--

ALTER SEQUENCE public.personas_id_seq OWNED BY public.personas.id;


--
-- TOC entry 215 (class 1259 OID 16442)
-- Name: prestadores; Type: TABLE; Schema: public; Owner: lucas
--

CREATE TABLE public.prestadores (
    id integer NOT NULL,
    apellido character varying(45) NOT NULL,
    direccion character varying(255),
    email character varying(45) NOT NULL,
    fecha_vinculacion timestamp without time zone,
    nombre character varying(45) NOT NULL,
    telefono character varying(255),
    tipo_servicio character varying(255)
);


ALTER TABLE public.prestadores OWNER TO lucas;

--
-- TOC entry 214 (class 1259 OID 16440)
-- Name: prestadores_id_seq; Type: SEQUENCE; Schema: public; Owner: lucas
--

CREATE SEQUENCE public.prestadores_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.prestadores_id_seq OWNER TO lucas;

--
-- TOC entry 3312 (class 0 OID 0)
-- Dependencies: 214
-- Name: prestadores_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: lucas
--

ALTER SEQUENCE public.prestadores_id_seq OWNED BY public.prestadores.id;


--
-- TOC entry 216 (class 1259 OID 16451)
-- Name: rol_permiso; Type: TABLE; Schema: public; Owner: lucas
--

CREATE TABLE public.rol_permiso (
    id_rol bigint NOT NULL,
    id_permiso integer NOT NULL
);


ALTER TABLE public.rol_permiso OWNER TO lucas;

--
-- TOC entry 218 (class 1259 OID 16456)
-- Name: roles; Type: TABLE; Schema: public; Owner: lucas
--

CREATE TABLE public.roles (
    id_rol bigint NOT NULL,
    nombre_rol character varying(255)
);


ALTER TABLE public.roles OWNER TO lucas;

--
-- TOC entry 217 (class 1259 OID 16454)
-- Name: roles_id_rol_seq; Type: SEQUENCE; Schema: public; Owner: lucas
--

CREATE SEQUENCE public.roles_id_rol_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.roles_id_rol_seq OWNER TO lucas;

--
-- TOC entry 3313 (class 0 OID 0)
-- Dependencies: 217
-- Name: roles_id_rol_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: lucas
--

ALTER SEQUENCE public.roles_id_rol_seq OWNED BY public.roles.id_rol;


--
-- TOC entry 220 (class 1259 OID 16464)
-- Name: servicios; Type: TABLE; Schema: public; Owner: lucas
--

CREATE TABLE public.servicios (
    id_servicio integer NOT NULL,
    costo real,
    descripcion character varying(255),
    fecha_fin timestamp without time zone,
    fecha_inicio timestamp without time zone,
    tipo_servicio character varying(255),
    titulo character varying(255),
    url_pago character varying(255),
    vigencia character varying(255),
    id integer
);


ALTER TABLE public.servicios OWNER TO lucas;

--
-- TOC entry 219 (class 1259 OID 16462)
-- Name: servicios_id_servicio_seq; Type: SEQUENCE; Schema: public; Owner: lucas
--

CREATE SEQUENCE public.servicios_id_servicio_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.servicios_id_servicio_seq OWNER TO lucas;

--
-- TOC entry 3314 (class 0 OID 0)
-- Dependencies: 219
-- Name: servicios_id_servicio_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: lucas
--

ALTER SEQUENCE public.servicios_id_servicio_seq OWNED BY public.servicios.id_servicio;


--
-- TOC entry 221 (class 1259 OID 16473)
-- Name: usuarios; Type: TABLE; Schema: public; Owner: lucas
--

CREATE TABLE public.usuarios (
    password character varying(255),
    id integer NOT NULL,
    id_estado bigint,
    id_rol bigint
);


ALTER TABLE public.usuarios OWNER TO lucas;

--
-- TOC entry 3117 (class 2604 OID 16391)
-- Name: coordenadas id_coordenada; Type: DEFAULT; Schema: public; Owner: lucas
--

ALTER TABLE ONLY public.coordenadas ALTER COLUMN id_coordenada SET DEFAULT nextval('public.coordenadas_id_coordenada_seq'::regclass);


--
-- TOC entry 3118 (class 2604 OID 16399)
-- Name: estados id_estado; Type: DEFAULT; Schema: public; Owner: lucas
--

ALTER TABLE ONLY public.estados ALTER COLUMN id_estado SET DEFAULT nextval('public.estados_id_estado_seq'::regclass);


--
-- TOC entry 3119 (class 2604 OID 16407)
-- Name: eventos id; Type: DEFAULT; Schema: public; Owner: lucas
--

ALTER TABLE ONLY public.eventos ALTER COLUMN id SET DEFAULT nextval('public.eventos_id_seq'::regclass);


--
-- TOC entry 3120 (class 2604 OID 16418)
-- Name: mascotas id_mascota; Type: DEFAULT; Schema: public; Owner: lucas
--

ALTER TABLE ONLY public.mascotas ALTER COLUMN id_mascota SET DEFAULT nextval('public.mascotas_id_mascota_seq'::regclass);


--
-- TOC entry 3121 (class 2604 OID 16429)
-- Name: permisos id_permiso; Type: DEFAULT; Schema: public; Owner: lucas
--

ALTER TABLE ONLY public.permisos ALTER COLUMN id_permiso SET DEFAULT nextval('public.permisos_id_permiso_seq'::regclass);


--
-- TOC entry 3122 (class 2604 OID 16437)
-- Name: personas id; Type: DEFAULT; Schema: public; Owner: lucas
--

ALTER TABLE ONLY public.personas ALTER COLUMN id SET DEFAULT nextval('public.personas_id_seq'::regclass);


--
-- TOC entry 3123 (class 2604 OID 16445)
-- Name: prestadores id; Type: DEFAULT; Schema: public; Owner: lucas
--

ALTER TABLE ONLY public.prestadores ALTER COLUMN id SET DEFAULT nextval('public.prestadores_id_seq'::regclass);


--
-- TOC entry 3124 (class 2604 OID 16459)
-- Name: roles id_rol; Type: DEFAULT; Schema: public; Owner: lucas
--

ALTER TABLE ONLY public.roles ALTER COLUMN id_rol SET DEFAULT nextval('public.roles_id_rol_seq'::regclass);


--
-- TOC entry 3125 (class 2604 OID 16467)
-- Name: servicios id_servicio; Type: DEFAULT; Schema: public; Owner: lucas
--

ALTER TABLE ONLY public.servicios ALTER COLUMN id_servicio SET DEFAULT nextval('public.servicios_id_servicio_seq'::regclass);


--
-- TOC entry 3281 (class 0 OID 16388)
-- Dependencies: 203
-- Data for Name: coordenadas; Type: TABLE DATA; Schema: public; Owner: lucas
--

INSERT INTO public.coordenadas VALUES (4, -34.61315, -58.37723);
INSERT INTO public.coordenadas VALUES (5, -34.61315, -58.37723);
INSERT INTO public.coordenadas VALUES (6, -34.61315, -58.37723);
INSERT INTO public.coordenadas VALUES (7, -34.61315, -58.37723);
INSERT INTO public.coordenadas VALUES (8, -34.61315, -58.37723);
INSERT INTO public.coordenadas VALUES (9, -34.61315, -58.37723);
INSERT INTO public.coordenadas VALUES (10, -34.61315, -58.37723);
INSERT INTO public.coordenadas VALUES (11, -34.61315, -58.37723);
INSERT INTO public.coordenadas VALUES (12, -34.61315, -58.37723);
INSERT INTO public.coordenadas VALUES (13, -34.61315, -58.37723);
INSERT INTO public.coordenadas VALUES (14, -34.61315, -58.37723);
INSERT INTO public.coordenadas VALUES (1, -34.61315, -58.37723);
INSERT INTO public.coordenadas VALUES (2, -34.61315, -58.37723);
INSERT INTO public.coordenadas VALUES (3, -34.61315, -58.37723);
INSERT INTO public.coordenadas VALUES (17, -34.61315, -58.37723);
INSERT INTO public.coordenadas VALUES (18, -34.68097441313738, -58.51949617266656);
INSERT INTO public.coordenadas VALUES (19, -34.62007943791735, -58.38982276618481);
INSERT INTO public.coordenadas VALUES (20, -34.61915788927307, -58.38887695223092);
INSERT INTO public.coordenadas VALUES (21, -34.60980055613087, -58.38677242398263);
INSERT INTO public.coordenadas VALUES (23, -34.60596261875251, -58.400745056569576);
INSERT INTO public.coordenadas VALUES (22, -39.611609082609505, -58.39496858417987);


--
-- TOC entry 3283 (class 0 OID 16396)
-- Dependencies: 205
-- Data for Name: estados; Type: TABLE DATA; Schema: public; Owner: lucas
--

INSERT INTO public.estados VALUES (1, 'ACTIVO');
INSERT INTO public.estados VALUES (2, 'INACTIVO');
INSERT INTO public.estados VALUES (3, 'SUSPENDIDO');


--
-- TOC entry 3285 (class 0 OID 16404)
-- Dependencies: 207
-- Data for Name: eventos; Type: TABLE DATA; Schema: public; Owner: lucas
--

INSERT INTO public.eventos VALUES (1, 'palermo', 'atencion veterinaria basica, vacunacion , castracion', '2020-09-24', 'alvarez thomas 345', '12 a 16', 'plaza garay');
INSERT INTO public.eventos VALUES (2, '12', '12', '2019-08-30', '12', '12', '12');
INSERT INTO public.eventos VALUES (3, 'flores', 'castracion', '2020-09-22', 'Correa 2442', '12', 'c.a.b.a');
INSERT INTO public.eventos VALUES (5, 'flores', 'castracion gratuita', '2020-10-15', 'junal 345', '8 a 20', 'plaza flores');


--
-- TOC entry 3287 (class 0 OID 16415)
-- Dependencies: 209
-- Data for Name: mascotas; Type: TABLE DATA; Schema: public; Owner: lucas
--

INSERT INTO public.mascotas VALUES (20, '12', 12, 'ADOPTADA', 'http://10.0.2.2:8090/adoptame/mobile/downloadPet/image-c1055e06-40a9-414e-a082-1ada5437eb9a.jpg', 'pirincha', 'callejero', 'HEMBRA', 'CHICO', 'PERRO', 21, 1);
INSERT INTO public.mascotas VALUES (21, 'perrita viejita', 18, 'DISPONIBLE', 'http://10.0.2.2:8090/adoptame/mobile/downloadPet/image-d0954c5a-c62c-4a6c-bbd5-94ca5bee0afc.jpg', 'cachola', 'caniche', 'HEMBRA', 'CHICO', 'PERRO', 22, 1);
INSERT INTO public.mascotas VALUES (16, 'Perro vago', 4, 'ADOPTADA', 'http://10.0.2.2:8090/adoptame/mobile/downloadPet/image-b33342b0-8c72-44f5-9ac3-4e0cee05130e.jpg', 'Hugo', 'Mestizo,Mestizo', 'MACHO', 'MEDIANO', 'PERRO', 17, 1);
INSERT INTO public.mascotas VALUES (22, 'perrosky', 12, 'ADOPTADA', 'http://10.0.2.2:8090/adoptame/mobile/downloadPet/image-b565049b-4133-46a6-8b53-c845bf1e6254.jpg', 'ppe', 'mestizo', 'MACHO', 'CHICO', 'PERRO', 23, 1);
INSERT INTO public.mascotas VALUES (18, 'gato peleon', 1, 'DISPONIBLE', 'http://10.0.2.2:8090/adoptame/mobile/downloadPet/image-f3c1f4c2-224f-41b4-9805-195fdb19e0c4.jpg', 'lolo', 'callejero,callejero', 'MACHO', 'CHICO', 'GATO', 19, 1);
INSERT INTO public.mascotas VALUES (19, 'Perro bueno', 12, 'DISPONIBLE', 'http://10.0.2.2:8090/adoptame/mobile/downloadPet/image-eba96bb2-b528-47cb-a095-b014bd81c739.jpg', 'negro', 'Mestizo,Mestizo', 'MACHO', 'GRANDE', 'PERRO', 20, 1);
INSERT INTO public.mascotas VALUES (17, 'perro jugueton y atorrante', 8, 'ADOPTADA', 'http://10.0.2.2:8090/adoptame/mobile/downloadPet/image-cbb6c638-f5f5-4152-986e-10ec1124db00.jpg', 'pepo', 'Mestizo,Mestizo', 'HEMBRA', 'GRANDE', 'PERRO', 18, 1);


--
-- TOC entry 3289 (class 0 OID 16426)
-- Dependencies: 211
-- Data for Name: permisos; Type: TABLE DATA; Schema: public; Owner: lucas
--



--
-- TOC entry 3291 (class 0 OID 16434)
-- Dependencies: 213
-- Data for Name: personas; Type: TABLE DATA; Schema: public; Owner: lucas
--

INSERT INTO public.personas VALUES ('Usuario', 1, 'peralta', 'lucas.peralta@gmail.com', 'lucas', NULL, NULL);
INSERT INTO public.personas VALUES ('Usuario', 5, 'admin', 'admin@admin', 'admin', NULL, NULL);
INSERT INTO public.personas VALUES ('Usuario', 6, '12', '45@23', '12', NULL, NULL);
INSERT INTO public.personas VALUES ('Usuario', 7, 'maranga', 'gustavo.maranga@gmail.com', 'gustavo', NULL, NULL);
INSERT INTO public.personas VALUES ('Usuario', 8, 'Raulosky', 'testing@stefanini.com', 'RAul', '156666666', 'Lomas del mirador');
INSERT INTO public.personas VALUES ('Usuario', 9, 'Calabrese', 'rica@gmail.com', 'Ricardo', '156754542', 'flores');
INSERT INTO public.personas VALUES ('Usuario', 10, 'perex', 'lucas.pperex@gmail.com', 'lucas omar', NULL, NULL);
INSERT INTO public.personas VALUES ('Usuario', 4, 'Calabrese', 'ricardocalabrese@gmail.com', 'Ricardo', '156754542', 'flores');
INSERT INTO public.personas VALUES ('Usuario', 12, 'peralta', 'pochi_peluca@gmail.com', 'matias', '156754542', 'flores');
INSERT INTO public.personas VALUES ('Usuario', 13, 'reuben', 'ricardoruben@gmail.com', 'richard', '156754542', 'flores');
INSERT INTO public.personas VALUES ('Usuario', 14, 'reuben', 'riruben@gmail.com', 'richard', '156754542', 'flores');
INSERT INTO public.personas VALUES ('Usuario', 16, 'lopez', 'edgardoperalta@yahoo.com', 'pocho', ' ', ' ');
INSERT INTO public.personas VALUES ('Usuario', 17, 'lopez', 'ucas.peralta@gmail.com', 'pocho', ' ', ' ');
INSERT INTO public.personas VALUES ('Usuario', 18, 'peralta', 'joel@gmail.com', 'edgardo', NULL, NULL);
INSERT INTO public.personas VALUES ('Usuario', 19, 'Passodomo', 'lucas.passdomo@gmail.com', 'lucas', '11111', '');
INSERT INTO public.personas VALUES ('Usuario', 20, 'lorin', 'loro@gmail.com', 'loro', NULL, '');
INSERT INTO public.personas VALUES ('Usuario', 21, 'cavvadias', 'gise@gmail.com', 'gisela', NULL, NULL);


--
-- TOC entry 3293 (class 0 OID 16442)
-- Dependencies: 215
-- Data for Name: prestadores; Type: TABLE DATA; Schema: public; Owner: lucas
--

INSERT INTO public.prestadores VALUES (1, 'peralta', 'reconquista', 'lucas.peralta@gmail.com', '2019-03-31 04:03:07', 'lucas ', '4652-4311', 'Guarderia');
INSERT INTO public.prestadores VALUES (2, 'rodriguez', NULL, 'jorge.rodriguez@gmail.com', '2019-03-29 23:43:56', 'jorge ', '4654-5678', 'Veterinaria');
INSERT INTO public.prestadores VALUES (3, '', '', '', '2019-03-31 03:56:11', '', '', 'Veterinaria');
INSERT INTO public.prestadores VALUES (4, 'as', 'as', 'lucas.peralta@gmail.c', '2019-03-30 02:28:14', 'sasas', '12121', 'Guarderia');
INSERT INTO public.prestadores VALUES (6, 'peralta', 'reconquista 34', 'loperalta@stefanini.com', '2019-03-31 03:57:21', 'loperalta', '46524311', 'Guarderia');
INSERT INTO public.prestadores VALUES (7, '897', '0897', 'l@l', '2019-03-31 03:59:40', '8967', '87', 'Guarderia');
INSERT INTO public.prestadores VALUES (8, 'o', 'o', 'g@g', '2019-03-31 04:01:18', 'o', 'o', 'Guarderia');
INSERT INTO public.prestadores VALUES (9, '1', '1', 'e@e', '2019-03-31 04:05:12', '1', '1', 'Guarderia');
INSERT INTO public.prestadores VALUES (10, 'peralta', 'reconquista 39 lomas del mirador', 'pepeVet@gmail.com', '2020-08-31 22:36:31', 'lucas', '12312311', 'Veterinaria');


--
-- TOC entry 3294 (class 0 OID 16451)
-- Dependencies: 216
-- Data for Name: rol_permiso; Type: TABLE DATA; Schema: public; Owner: lucas
--



--
-- TOC entry 3296 (class 0 OID 16456)
-- Dependencies: 218
-- Data for Name: roles; Type: TABLE DATA; Schema: public; Owner: lucas
--

INSERT INTO public.roles VALUES (1, 'ROLE_ADMIN');
INSERT INTO public.roles VALUES (2, 'ROLE_USER');


--
-- TOC entry 3298 (class 0 OID 16464)
-- Dependencies: 220
-- Data for Name: servicios; Type: TABLE DATA; Schema: public; Owner: lucas
--

INSERT INTO public.servicios VALUES (10, 123, 'servciio de guarderia en caniles', '2019-09-03 00:00:00', '2019-08-23 03:31:12', 'Guarderia', 'guarderia', 'http:mercadopago.com', '3', 1);
INSERT INTO public.servicios VALUES (11, 120, 'desparasitacion de perros y gatos', '2019-09-13 03:48:46', '2019-03-31 03:48:46', 'Veterinaria', 'desparasitacion', 'http://mercadolibra.com.ar', '13', 6);
INSERT INTO public.servicios VALUES (13, 1212, '1212121', '2019-04-12 03:56:36', '2019-03-31 03:56:36', 'Guarderia', '1212', '121212', '12', 6);
INSERT INTO public.servicios VALUES (14, 12, '121', '2019-04-01 03:57:46', '2019-03-31 03:57:43', 'Guarderia', '1212', '121212', '1', 6);
INSERT INTO public.servicios VALUES (15, 7, '23', '2021-09-13 03:59:40', '2019-03-31 03:59:40', 'Guarderia', '098', '1212', '897', 7);
INSERT INTO public.servicios VALUES (16, 1, '1', '2019-09-01 04:01:18', '2019-03-31 04:01:18', 'Guarderia', 'o', '1', '1', 8);
INSERT INTO public.servicios VALUES (17, 1, '1', '2019-04-01 04:03:07', '2019-03-31 04:03:07', 'Guarderia', '1', '1', '1', 1);
INSERT INTO public.servicios VALUES (18, 1, '1', '2019-04-01 04:05:12', '2019-03-31 04:05:12', 'Guarderia', '1', '1', '1', 9);
INSERT INTO public.servicios VALUES (19, 100, 'servicio de peluqueria canina', '2020-09-03 22:36:32', '2020-08-31 22:36:32', 'Veterinaria', 'peluqueria canina', 'www.mercadopago.com', '3', 10);


--
-- TOC entry 3299 (class 0 OID 16473)
-- Dependencies: 221
-- Data for Name: usuarios; Type: TABLE DATA; Schema: public; Owner: lucas
--

INSERT INTO public.usuarios VALUES ('$2a$10$u6i5mjYoeN7RJdifc3dw9e3G81IA1mNlqbDYfx9KBaVwHyjGfTnR.', 5, 1, 1);
INSERT INTO public.usuarios VALUES ('$2a$10$QvxrqBarzyM/NQ01gXzVZemRTaINCnsN3mRZeWBfrGi457XlRt1EO', 6, 1, 1);
INSERT INTO public.usuarios VALUES ('$2a$10$XNAer4Lmswb3q6wqnLjmNOpGaSZl5JZ.qaPOGMtpMaCprty3eoAvS', 7, 1, 2);
INSERT INTO public.usuarios VALUES ('$2a$10$M.4tPFnzcZ1CdipahYeE.OAc.NYImPGzl5Bdq0rb0vOzUXzw66Ipy', 8, 1, 1);
INSERT INTO public.usuarios VALUES ('$2a$10$jyOMXoiNFGqoNh3lQNp8ju3BDKkoVYeyBw5AuZPTN1XZXxwgsTeWq', 9, 1, 2);
INSERT INTO public.usuarios VALUES ('$2a$10$yXFa4RSRQPqa38FF/KZslOyyAlWTnhQYWSgZb1S1UBGAtnE5GuxPq', 10, 1, 2);
INSERT INTO public.usuarios VALUES ('$2a$10$jY1fcXFQT6auoJEIGDTrtuTyl4q154T5IXtaxX1t4z7PtHDmz1/Ly', 4, 1, 2);
INSERT INTO public.usuarios VALUES ('$2a$10$l1ehtLtpDL0/2CyemJTyce49FkkSgmvyEnTNFY6q7GVHXKiyW4A4S', 12, 1, 2);
INSERT INTO public.usuarios VALUES ('$2a$10$.0meruLItnaO9gdCTCAW2OzbP4iWZ0zAhAS7iUKEXd4r6LCJ1dc1.', 13, 1, 2);
INSERT INTO public.usuarios VALUES ('$2a$10$mOB3JjoU.TQ/bYJq5HihCO0eOvhXcnCWa9Mpfgj7nW1ISH9gCphGS', 14, 1, 2);
INSERT INTO public.usuarios VALUES ('$2a$10$iBvq0ddCitv7FsmnjK79n.tYBB8RePBggRomL/5LG01.E2.kip4yy', 16, 1, 2);
INSERT INTO public.usuarios VALUES ('$2a$10$XuL4vPcIFi9lT4/Z0reivO7y0o4ZCIE.ricAOw.4SGw8uM/zb4p.q', 17, 1, 2);
INSERT INTO public.usuarios VALUES ('$2a$10$VhPI2K4kZtM0exWP8eEXvexUV6iLbTLYoC4IPe2.56YjFpCXU3842', 18, 1, 2);
INSERT INTO public.usuarios VALUES ('$2a$10$u6i5mjYoeN7RJdifc3dw9e3G81IA1mNlqbDYfx9KBaVwHyjGfTnR.', 1, 1, 1);
INSERT INTO public.usuarios VALUES ('$2a$10$r/XJ9HWjj4wghcMkK07yye0lJ5bJeynDYtoPGn0iRrAbgXWRCucXm', 19, NULL, 2);
INSERT INTO public.usuarios VALUES ('$2a$10$aTTXwV9qZROwQXW4TWJv4.RTjQ3ScSU4ZOPfdYD8TnDQ.J6zLwl0O', 20, NULL, 2);
INSERT INTO public.usuarios VALUES ('$2a$04$SIh4F7rrOJ9OS5teXhxQW.p0nJYiKI8T42HmWzi/KtrBiHhVDHejK', 21, NULL, 1);


--
-- TOC entry 3315 (class 0 OID 0)
-- Dependencies: 202
-- Name: coordenadas_id_coordenada_seq; Type: SEQUENCE SET; Schema: public; Owner: lucas
--

SELECT pg_catalog.setval('public.coordenadas_id_coordenada_seq', 23, true);


--
-- TOC entry 3316 (class 0 OID 0)
-- Dependencies: 204
-- Name: estados_id_estado_seq; Type: SEQUENCE SET; Schema: public; Owner: lucas
--

SELECT pg_catalog.setval('public.estados_id_estado_seq', 5, true);


--
-- TOC entry 3317 (class 0 OID 0)
-- Dependencies: 206
-- Name: eventos_id_seq; Type: SEQUENCE SET; Schema: public; Owner: lucas
--

SELECT pg_catalog.setval('public.eventos_id_seq', 5, true);


--
-- TOC entry 3318 (class 0 OID 0)
-- Dependencies: 208
-- Name: mascotas_id_mascota_seq; Type: SEQUENCE SET; Schema: public; Owner: lucas
--

SELECT pg_catalog.setval('public.mascotas_id_mascota_seq', 22, true);


--
-- TOC entry 3319 (class 0 OID 0)
-- Dependencies: 210
-- Name: permisos_id_permiso_seq; Type: SEQUENCE SET; Schema: public; Owner: lucas
--

SELECT pg_catalog.setval('public.permisos_id_permiso_seq', 1, false);


--
-- TOC entry 3320 (class 0 OID 0)
-- Dependencies: 212
-- Name: personas_id_seq; Type: SEQUENCE SET; Schema: public; Owner: lucas
--

SELECT pg_catalog.setval('public.personas_id_seq', 21, true);


--
-- TOC entry 3321 (class 0 OID 0)
-- Dependencies: 214
-- Name: prestadores_id_seq; Type: SEQUENCE SET; Schema: public; Owner: lucas
--

SELECT pg_catalog.setval('public.prestadores_id_seq', 11, true);


--
-- TOC entry 3322 (class 0 OID 0)
-- Dependencies: 217
-- Name: roles_id_rol_seq; Type: SEQUENCE SET; Schema: public; Owner: lucas
--

SELECT pg_catalog.setval('public.roles_id_rol_seq', 5, true);


--
-- TOC entry 3323 (class 0 OID 0)
-- Dependencies: 219
-- Name: servicios_id_servicio_seq; Type: SEQUENCE SET; Schema: public; Owner: lucas
--

SELECT pg_catalog.setval('public.servicios_id_servicio_seq', 21, true);


--
-- TOC entry 3127 (class 2606 OID 16393)
-- Name: coordenadas coordenadas_pkey; Type: CONSTRAINT; Schema: public; Owner: lucas
--

ALTER TABLE ONLY public.coordenadas
    ADD CONSTRAINT coordenadas_pkey PRIMARY KEY (id_coordenada);


--
-- TOC entry 3129 (class 2606 OID 16401)
-- Name: estados estados_pkey; Type: CONSTRAINT; Schema: public; Owner: lucas
--

ALTER TABLE ONLY public.estados
    ADD CONSTRAINT estados_pkey PRIMARY KEY (id_estado);


--
-- TOC entry 3131 (class 2606 OID 16412)
-- Name: eventos eventos_pkey; Type: CONSTRAINT; Schema: public; Owner: lucas
--

ALTER TABLE ONLY public.eventos
    ADD CONSTRAINT eventos_pkey PRIMARY KEY (id);


--
-- TOC entry 3133 (class 2606 OID 16423)
-- Name: mascotas mascotas_pkey; Type: CONSTRAINT; Schema: public; Owner: lucas
--

ALTER TABLE ONLY public.mascotas
    ADD CONSTRAINT mascotas_pkey PRIMARY KEY (id_mascota);


--
-- TOC entry 3135 (class 2606 OID 16431)
-- Name: permisos permisos_pkey; Type: CONSTRAINT; Schema: public; Owner: lucas
--

ALTER TABLE ONLY public.permisos
    ADD CONSTRAINT permisos_pkey PRIMARY KEY (id_permiso);


--
-- TOC entry 3137 (class 2606 OID 16439)
-- Name: personas personas_pkey; Type: CONSTRAINT; Schema: public; Owner: lucas
--

ALTER TABLE ONLY public.personas
    ADD CONSTRAINT personas_pkey PRIMARY KEY (id);


--
-- TOC entry 3139 (class 2606 OID 16450)
-- Name: prestadores prestadores_pkey; Type: CONSTRAINT; Schema: public; Owner: lucas
--

ALTER TABLE ONLY public.prestadores
    ADD CONSTRAINT prestadores_pkey PRIMARY KEY (id);


--
-- TOC entry 3141 (class 2606 OID 16461)
-- Name: roles roles_pkey; Type: CONSTRAINT; Schema: public; Owner: lucas
--

ALTER TABLE ONLY public.roles
    ADD CONSTRAINT roles_pkey PRIMARY KEY (id_rol);


--
-- TOC entry 3143 (class 2606 OID 16472)
-- Name: servicios servicios_pkey; Type: CONSTRAINT; Schema: public; Owner: lucas
--

ALTER TABLE ONLY public.servicios
    ADD CONSTRAINT servicios_pkey PRIMARY KEY (id_servicio);


--
-- TOC entry 3145 (class 2606 OID 16477)
-- Name: usuarios usuarios_pkey; Type: CONSTRAINT; Schema: public; Owner: lucas
--

ALTER TABLE ONLY public.usuarios
    ADD CONSTRAINT usuarios_pkey PRIMARY KEY (id);


--
-- TOC entry 3151 (class 2606 OID 16503)
-- Name: usuarios fk2on43m0kldlaamvjodby74ruu; Type: FK CONSTRAINT; Schema: public; Owner: lucas
--

ALTER TABLE ONLY public.usuarios
    ADD CONSTRAINT fk2on43m0kldlaamvjodby74ruu FOREIGN KEY (id_estado) REFERENCES public.estados(id_estado);


--
-- TOC entry 3152 (class 2606 OID 16508)
-- Name: usuarios fk3kl77pehgupicftwfreqnjkll; Type: FK CONSTRAINT; Schema: public; Owner: lucas
--

ALTER TABLE ONLY public.usuarios
    ADD CONSTRAINT fk3kl77pehgupicftwfreqnjkll FOREIGN KEY (id_rol) REFERENCES public.roles(id_rol);


--
-- TOC entry 3148 (class 2606 OID 16488)
-- Name: rol_permiso fkb1ybebncburjvuednr35mtip8; Type: FK CONSTRAINT; Schema: public; Owner: lucas
--

ALTER TABLE ONLY public.rol_permiso
    ADD CONSTRAINT fkb1ybebncburjvuednr35mtip8 FOREIGN KEY (id_permiso) REFERENCES public.permisos(id_permiso);


--
-- TOC entry 3149 (class 2606 OID 16493)
-- Name: rol_permiso fke9j8u1s3ivvp18oed07a2gnhc; Type: FK CONSTRAINT; Schema: public; Owner: lucas
--

ALTER TABLE ONLY public.rol_permiso
    ADD CONSTRAINT fke9j8u1s3ivvp18oed07a2gnhc FOREIGN KEY (id_rol) REFERENCES public.roles(id_rol);


--
-- TOC entry 3147 (class 2606 OID 16518)
-- Name: mascotas fkh3w8gd1k3dyu962urbx4tf06i; Type: FK CONSTRAINT; Schema: public; Owner: lucas
--

ALTER TABLE ONLY public.mascotas
    ADD CONSTRAINT fkh3w8gd1k3dyu962urbx4tf06i FOREIGN KEY (id) REFERENCES public.usuarios(id) ON DELETE CASCADE;


--
-- TOC entry 3150 (class 2606 OID 16498)
-- Name: servicios fkie66hjtqthestpqatya91b0ov; Type: FK CONSTRAINT; Schema: public; Owner: lucas
--

ALTER TABLE ONLY public.servicios
    ADD CONSTRAINT fkie66hjtqthestpqatya91b0ov FOREIGN KEY (id) REFERENCES public.prestadores(id);


--
-- TOC entry 3153 (class 2606 OID 16513)
-- Name: usuarios fkjdiqy1h3s5meigcqmjdcpt1ko; Type: FK CONSTRAINT; Schema: public; Owner: lucas
--

ALTER TABLE ONLY public.usuarios
    ADD CONSTRAINT fkjdiqy1h3s5meigcqmjdcpt1ko FOREIGN KEY (id) REFERENCES public.personas(id);


--
-- TOC entry 3146 (class 2606 OID 16478)
-- Name: mascotas fkti8sarwwnwfyc3xvqa8xk2tg1; Type: FK CONSTRAINT; Schema: public; Owner: lucas
--

ALTER TABLE ONLY public.mascotas
    ADD CONSTRAINT fkti8sarwwnwfyc3xvqa8xk2tg1 FOREIGN KEY (id_coordenada) REFERENCES public.coordenadas(id_coordenada);


-- Completed on 2020-10-21 01:05:48 -03

--
-- PostgreSQL database dump complete
--

--
-- Database "postgres" dump
--

\connect postgres

--
-- PostgreSQL database dump
--

-- Dumped from database version 12.3
-- Dumped by pg_dump version 12.2

-- Started on 2020-10-21 01:05:48 -03

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

-- Completed on 2020-10-21 01:05:48 -03

--
-- PostgreSQL database dump complete
--

-- Completed on 2020-10-21 01:05:48 -03

--
-- PostgreSQL database cluster dump complete
--

