DROP TABLE ofrece;
DROP TABLE compra;
DROP TABLE libro;
DROP TABLE libreria;
DROP TABLE lector;

CREATE TABLE libro
(
	id INTEGER NOT NULL GENERATED 
		BY DEFAULT AS IDENTITY (START WITH 1, INCREMENT BY 1) PRIMARY KEY,
	titulo VARCHAR(100) NOT NULL,
	autor VARCHAR(100) NOT NULL,
	precio	FLOAT NOT NULL
);

CREATE TABLE libreria
(
	id INTEGER NOT NULL GENERATED 
		BY DEFAULT AS IDENTITY (START WITH 1, INCREMENT BY 1) PRIMARY KEY,
	cif CHAR(9) NOT NULL,
	direccion VARCHAR(250),
	nombre VARCHAR(50)
);

CREATE TABLE lector
(
	id INTEGER NOT NULL GENERATED 
		BY DEFAULT AS IDENTITY (START WITH 1, INCREMENT BY 1) PRIMARY KEY,
	nombre VARCHAR(50) NOT NULL,
	apellido VARCHAR(50) NOT NULL,
	fecha_nacimiento DATE,  
	direccion VARCHAR(250)
);

CREATE TABLE ofrece
(
	id INTEGER NOT NULL GENERATED 
		BY DEFAULT AS IDENTITY (START WITH 1, INCREMENT BY 1) PRIMARY KEY,
	libro_id INT NOT NULL,
	libreria_id INT NOT NULL,
	precio FLOAT,
	FOREIGN KEY (libro_id) REFERENCES libro(id),
	FOREIGN KEY (libreria_id) REFERENCES libreria(id)
);

CREATE TABLE compra
(
	id INTEGER NOT NULL GENERATED 
		BY DEFAULT AS IDENTITY (START WITH 1, INCREMENT BY 1) PRIMARY KEY,
	libro_id INT NOT NULL,
	libreria_id INT NOT NULL,
	lector_id INT NOT NULL,
	fecha DATE NOT NULL,
	montante FLOAT NOT NULL,
	FOREIGN KEY (libro_id) REFERENCES libro(id),
	FOREIGN KEY (lector_id) REFERENCES lector(id),
	FOREIGN KEY (libreria_id) REFERENCES libreria(id)
);

