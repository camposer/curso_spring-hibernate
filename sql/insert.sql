DELETE FROM ofrece;
DELETE FROM compra;
DELETE FROM libro;
DELETE FROM libreria;
DELETE FROM lector;

INSERT INTO libro(id, titulo, autor, precio) VALUES(1, 'Libro #1', 'Autor #1', 200);
INSERT INTO libro(id, titulo, autor, precio) VALUES(2, 'Libro #2', 'Autor #2', 50);
INSERT INTO libro(id, titulo, autor, precio) VALUES(3, 'Libro #1', 'Autor #1', 100);

INSERT INTO lector(id, nombre, apellido, fecha_nacimiento, direccion) VALUES(1, 'Lector #1 Nombre', 'Lector #1 Apellido', '1980-01-03', 'Dirección #1');
INSERT INTO lector(id, nombre, apellido, fecha_nacimiento, direccion) VALUES(2, 'Lector #2 Nombre', 'Lector #2 Apellido', '1990-03-20', 'Dirección #2');
INSERT INTO lector(id, nombre, apellido, fecha_nacimiento, direccion) VALUES(3, 'Lector #3 Nombre', 'Lector #3 Apellido', '2000-11-15', 'Dirección #3');

INSERT INTO libreria(id, cif, direccion, nombre) VALUES(1, '12345678A', 'Dirección #1', 'Nombre #1');
INSERT INTO libreria(id, cif, direccion, nombre) VALUES(2, '90123456B', 'Dirección #2', 'Nombre #2');
INSERT INTO libreria(id, cif, direccion, nombre) VALUES(3, '78912345C', 'Dirección #3', 'Nombre #3');

INSERT INTO ofrece(libro_id, libreria_id, precio) VALUES(1, 1, 200);
INSERT INTO ofrece(libro_id, libreria_id, precio) VALUES(1, 2, 300);
INSERT INTO ofrece(libro_id, libreria_id, precio) VALUES(2, 2, 100);
INSERT INTO ofrece(libro_id, libreria_id, precio) VALUES(3, 3, 450);

INSERT INTO compra(libro_id, libreria_id, lector_id, montante, fecha) VALUES(1, 1, 1, 200, '2012-01-03');
INSERT INTO compra(libro_id, libreria_id, lector_id, montante, fecha) VALUES(1, 2, 2, 250, '2012-01-25');
INSERT INTO compra(libro_id, libreria_id, lector_id, montante, fecha) VALUES(2, 3, 3, 200, '2013-06-04');
INSERT INTO compra(libro_id, libreria_id, lector_id, montante, fecha) VALUES(3, 2, 1, 400, '2013-12-03');
INSERT INTO compra(libro_id, libreria_id, lector_id, montante, fecha) VALUES(3, 1, 2, 500, '2013-11-03');
