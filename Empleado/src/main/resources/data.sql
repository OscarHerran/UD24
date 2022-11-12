CREATE TABLE EMPLEADO
	(
		id int AUTO_INCREMENT PRIMARY KEY,
        nombre varchar (20) NOT NULL,
        apellido varchar (20) NOT NULL,
        dni varchar (20) NOT NULL,
        cargo varchar(20),
        salario int
	);
    
INSERT INTO EMPLEADO (nombre, apellido, dni, cargo, salario) VALUES
	('Luisa', 'Moreno', '123A', 'directora', 2800),
    ('Mia', 'Hernandez', '123B', 'Ejecutiva', 3500),
    ('Paula', 'Castaño', '123D', 'junior', 1200),
    ('Andrea', 'Chaveverra', '123C', 'senior', 2400);