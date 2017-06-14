create table Cliente(
DNI varchar(9)primary key not null,
Nombre varchar(20),
Apellido varchar(20),
Telefono int,
Email varchar(30),
direccion varchar(30)
)

create table Vehiculo(
Matricula varchar(15)primary key not null,
Marca varchar(20),
Modelo varchar(20),
Puertas int,
Color varchar(15),
Combustible varchar(15),
Anio_Matriculacion date,
CV int,
DNI_Cliente varchar(9) references Cliente ,
tipo_vehiculo varchar(15)
)
CREATE TABLE MECANICO(
Usuario varchar(20) primary Key NOT NULL,
Contrasenia varchar(20) NOT NULL,
Nombre varchar(25),
Apellidos varchar(50),
Dias_Vacaciones int,
Sueldo float,
Fecha_Contratacion date
)
CREATE TABLE REPARACION(
Matricula varchar(15) references vehiculo not null,
Cod_Reparacion uniqueidentifier primary key not null,
piezas varchar(100),
fecha_entrada datetime,
fecha_salida datetime,
Precio float,
Precio_reparacion float,
usuario_mecanico varchar(20) references MECANICO,
estado varchar(20),
comentarios varchar(100)
)