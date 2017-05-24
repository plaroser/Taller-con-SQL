 create table Cliente(
DNI varchar2(9)primary key not null,
Nombre varchar2(20) not null,
Apellido varchar2(20) not null,
Teléfono int not null,
Email varchar2(30) not null,
direccion varchar2(30) not null
)

create table Vehículo(
Matricula varchar2(15)primary key not null,
Marca varchar2(20),
Modelo varcahr2(20),
Puertas int,
Color varchar2(15),
Combustiblevarchar2(15),
Año_Matriculacion date,
CV int,
DNI_Cliente varchar2(9) references Cliente 
)
CREATE TABLE MECANICO(
Usuario varchar2(20) primary Key NOT NULL,
Contraseña varchar2(20) NOT NULL,
Nombre varchar2(25) NOT NULL,
Apellidos varchar2(50) NOT NULL,
Dias_Vacaciones int NOT NULL,
Sueldo float NOT NULL,
Fecha_Contratacion date NOT NULL
)
CREATE TABLE REPARACIÓN(
Matricula varchar2(15) references vehículo not null,
Cod_Reparación varchar2(10) primary key not null,
detalles varchar2(100),
fecha_Entrada date,
fecha_Salida date,
Precio float,
usuario_mecanico varchar2(20) references MECANICO NOT NULL,
estado varchar2(20) not null


)