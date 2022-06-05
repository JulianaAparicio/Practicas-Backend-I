create table if not exists pacientes (
    id int auto_increment primary key,
    apellido varchar(255),
    nombre varchar(255),
    dni varchar (255),
    fecha_ingreso varchar(255),
    id_domicilio int);

create table if not exists domicilios (
    id int auto_increment primary key,
    calle varchar(255),
    numero int,
    localidad varchar (255),
    provincia varchar(255));

-- Creamos tabla de odontólogos:
create table if not exists odontologos (
    id int auto_increment primary key,
    numero_matricula varchar (255),
    nombre varchar(255),
    apellido varchar(255));

-- Pueden agregar acá sentencias Insert para precargar datos.
INSERT INTO domicilios(calle, numero, localidad, provincia) VALUES('Test1', 1, 'Localidad Test1', 'Provincia Test1');
INSERT INTO pacientes(apellido, nombre, dni, fecha_ingreso, id_domicilio) VALUES('Apellido1', 'Nombre1', '101', '2022-05-31', 1);

-- Inserts de odontólogos para prueba:
INSERT INTO odontologos(numero_matricula, nombre, apellido) VALUES('Matricula1', 'NombreOdol1', 'ApellidoOdol1');
INSERT INTO odontologos(numero_matricula, nombre, apellido) VALUES('Matricula2', 'NombreOdol2', 'ApellidoOdol2');
INSERT INTO odontologos(numero_matricula, nombre, apellido) VALUES('Matricula3', 'NombreOdol3', 'ApellidoOdol3');