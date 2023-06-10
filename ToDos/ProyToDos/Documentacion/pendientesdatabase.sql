--
-- File generated with SQLiteStudio v3.2.1 on dom. oct. 11 13:13:46 2020
--
-- Text encoding used: UTF-8
--
PRAGMA foreign_keys = off;
BEGIN TRANSACTION;


-- Table: tipo_pendiente
-- Ejemplos de valores: personal, trabajo, estudios, casa, deportes, etc.
DROP TABLE IF EXISTS tipo_pendiente;

CREATE TABLE tipo_pendiente (
    id     INTEGER   PRIMARY KEY,
    nombre TEXT (50) UNIQUE
                     NOT NULL
);
-- Table: tipo_usuario
-- Ejemplos de tipos de usuarios: administrador, cliente, reportes
DROP TABLE IF EXISTS tipo_usuario;

CREATE TABLE tipo_usuario (
    id     INTEGER   PRIMARY KEY,
    nombre TEXT (50) UNIQUE
                     NOT NULL
);


-- Table: pendiente
DROP TABLE IF EXISTS pendiente;

CREATE TABLE pendiente (
    id          INTEGER    PRIMARY KEY,
    descripcion TEXT (128) NOT NULL
);


-- Table: pendiente_usuario
DROP TABLE IF EXISTS pendiente_usuario;

CREATE TABLE pendiente_usuario (
    pendiente INTEGER REFERENCES pendiente (id) 
                      NOT NULL,
    usuario   INTEGER REFERENCES usuario (id) 
                      NOT NULL,
    tipo_pendiente INTEGER   REFERENCES tipo_pendiente (id) 
                      NOT NULL
);



-- Table: usuario
DROP TABLE IF EXISTS usuario;

CREATE TABLE usuario (
    id           INTEGER   PRIMARY KEY AUTOINCREMENT,
    nombre       TEXT (50) UNIQUE
                           NOT NULL,
    tipo_usuario INTEGER   REFERENCES tipo_usuario (id) 
                           NOT NULL
);


COMMIT TRANSACTION;
PRAGMA foreign_keys = on;
