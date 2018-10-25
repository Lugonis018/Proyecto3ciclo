CREATE DATABASE BDCentroMedico ON PRIMARY
( NAME='BDCentroMedico',
FILENAME='C:\BD\BDCentroMedico.dmf',
SIZE=10MB,
FILEGROWTH=2MB)
LOG ON
( NAME='BDCentroMedicoD',
FILENAME='C:\BD\BDCentroMedicoD.ldf',
SIZE=5MB,
FILEGROWTH=10)

Use BDCentroMedico

create table Empleado
(
	cod_emple int identity(001,001) constraint PKEmpleado primary key,
	nom_emple varchar(20),
	ape_emple varchar(20),
	dir_emple varchar(30),
	suel_emple money,
	dni_emple char(8), 
	tel_emple char(9),
	fech_entra_emp datetime,
	fech_sali_emp datetime,
	usu_emple varchar(30),
	contra_emple varchar(30)
)

create table Medico
(
	cod_med int constraint PKMedico primary key,
	espec_medi varchar(25)
)
create table Recepcionista
(
	cod_recep int constraint PKRecepcionista primary key,
	sector_recep varchar(20)
)
create table Enfermera
(
	cod_enf int constraint PKEnfermera primary key,
	area_enf varchar(20)
)
create table Personal_mante
(
	cod_perman int constraint PKPersonal_mante primary key,
	diastrab_perman datetime
)
create table Paciente
(
	dni_pac char(8) constraint PKPaciente primary key,
	nom_pac varchar(20),
	ape_pac varchar(20),
	seg_pac varchar(20),
	estci_pac varchar(10),
	tel_pac char(9),
	sex_pac char(10),
	fechanac_pac date,
	dir_pac varchar(30),
	nhistmed_pac char(4)	
)
create table Atender
(
	num_aten int identity(1,1) constraint PKAnteder primary key,
	cod_med int,
	dni_pac char(8),
	diag_aten varchar(max),
)
create table Registrar
(
	num_reg int identity(1,1) constraint PKRegistrar primary key,
	dni_pac char(8),
	cod_recep int,
	fecha_reg date,
	talla_pac decimal(2),
	peso_pac decimal(2)
)
create table Comprar
(
	cod_comp int identity(1,1) constraint PKCompra primary key,
	dni_pac char(8),
	cod_meds int,
	fecha_comp date,
	cant_comp int,
	total_comp float,
)
create table Medicamentos
(
	cod_meds int identity(1,1) constraint PKMedicamentos primary key,
	cod_enf int,
	nom_meds varchar(20),
	preunit_meds money,
	desc_meds varchar(max),
	stock_meds int
)
create table Saca
(
	nro_mues int identity(1,1) constraint PKVisita primary key,
	cod_enf int,
	dni_pac char(8),
	fecha_ana date,
	fecha_entre date
)
create table Muestra
(
	nro_mues int identity(1,1) constraint PKMuestra primary key,
	cod_enf int,
	tip_mues char(18),
	desc_mues varchar(max)
)
create table Higienizar
(
	cod_perman int,
	n_amb int,
	dir_pos varchar(50),
	fecha_lim datetime
)
create table Ambiente
(
	n_amb int constraint PKAmbiente primary key,
	dir_pos varchar(50),
	nom_amb varchar(30)
)
create table Posta
(
	dir_pos varchar(50) constraint PKPosta primary key,
	tel_pos char(9)
)
--Alter table--
--alter table empleados--
alter table Medico add constraint FKMedico foreign key (cod_med) references Empleado(cod_emple)
alter table Recepcionista add constraint FKRecepcionista foreign key (cod_recep) references Empleado(cod_emple)
alter table Enfermera add constraint FKEnfermera foreign key (cod_enf) references Empleado(cod_emple)
alter table Personal_mante add constraint FKPersonal_mante foreign key (cod_perman) references Empleado(cod_emple)
--Terminado empleados
---alter table Atender--
alter table Atender
	add constraint FKAtender foreign key (cod_med) references Medico(cod_med)
alter table Atender
	add constraint FKAtender2 foreign key (dni_pac) references Paciente(dni_pac)
---alter table Registrar
alter table Registrar
	add constraint FKRegistrar foreign key (dni_pac) references Paciente(dni_pac)
alter table Registrar
	add constraint FKRegistrar2 foreign key (cod_recep) references Recepcionista(cod_recep)
---alter table Comprar--
alter table Comprar	
	add constraint FKComprar foreign key (dni_pac) references Paciente(dni_pac)
alter table Comprar
	add constraint FKComprar2 foreign key (cod_meds) references Medicamentos(cod_meds)
---alter table Medicamentos
alter table Medicamentos
	add constraint FKMedicamentos foreign key (cod_enf) references Enfermera(cod_enf)
---alter table Saca
alter table Saca
	add constraint FKSaca foreign key (dni_pac) references Paciente(dni_pac)
alter table Saca
	add constraint FKSaca2 foreign key (nro_mues) references Muestra(nro_mues)
---alter table Muesta
alter table Muestra
	add constraint FKMuestra foreign key (cod_enf) references Enfermera(cod_enf)
--alter table Higienizar
alter table Higienizar
	add constraint FKHigienizar foreign key (cod_perman) references Personal_mante(cod_perman)
alter table Higienizar
	add constraint FKHigienizar2 foreign key (n_amb) references Ambiente(n_amb)
---alter table Ambiente
alter table Ambiente
	add constraint FKAmbiente foreign key (dir_pos) references Posta(dir_pos)

-------Procesos Almacenados-------------------
---Procedure
create proc SP_AgregarAtencion
	@cod_med int,
	@dni char(8),
	@diag varchar(max) 
as begin insert into Atender([cod_med],[dni_pac],[diag_aten])
values (@cod_med,@dni,@diag)
select @@IDENTITY as num_aten
	end

create procedure SP_Agregarmedicamento
	@codemp int,
	@nom varchar(50),
	@precio money,
	@descrip varchar(max)
	as begin
insert into Medicamentos([cod_enf],[nom_meds],[preunit_meds],[desc_meds])
values(@codemp,@nom,@precio,@descrip)
select @@IDENTITY as cod_meds
	end

create proc SP_Comprar
	@dni char(8),
	@codemp	 int,
	@total	float,
	@fecha	date,
	@cantidad int
as begin
insert into Comprar([dni_pac],[cod_meds],[total_comp],[fecha_comp],[cant_comp])
values(@dni,@codemp,@total,@fecha,@cantidad)
select @@IDENTITY as cod_meds
end

create procedure proc_eliminarmodifcaragregar
	@dni_pac char(8),
	@nom_pac varchar(20),
	@ape_pac varchar(20),
	@seg_pac varchar(20),
	@estci_pac varchar(20),
	@tel_pac char(9),
	@sex_pac char(10),
	@fechanac_pac date,
	@dir_pac varchar(30),
	@nhistmed_pac char(4),
	@modo char(1)
as
	if @modo ='I'
		begin
		insert Paciente values (@dni_pac, 
								@nom_pac, @ape_pac, 
								@seg_pac, @estci_pac, 
								@tel_pac, @sex_pac, 
								@fechanac_pac, @dir_pac,
								@nhistmed_pac)
	End
	if @modo='U'
		begin
			update Paciente set nom_pac=@nom_pac, ape_pac=@ape_pac, seg_pac=@seg_pac, estci_pac=@estci_pac, tel_pac=@tel_pac, sex_pac=@sex_pac, fechanac_pac=@fechanac_pac, dir_pac=@dir_pac, nhistmed_pac=@nhistmed_pac where dni_pac=@dni_pac
		end
	if @modo='D'
		begin
			delete from Paciente where dni_pac=@dni_pac
		end
	go

create view vw_ListarEmpleado 
	as
	select Empleado.nom_emple as Nombre,
	Empleado.ape_emple as Apellido,
	Empleado.dni_emple as DNI,
	Empleado.tel_emple as Teléfono
	from Empleado inner join Enfermera on Empleado.cod_emple=
		Enfermera.cod_enf,Empleado inner join   
create view wm_ListaPacientes
	as
	select*
	from Pacientes
create view wm_listarPacienteM
	as
	select Paciente.nom_pac as Nombre,
	Paciente.ape_pac as Apellido,
	Paciente.dni_pac as DNI,
	Paciente.dir_pac as Dirección,
	Paciente.fechanac_pac as Nacimiento
	from Paciente
	where Paciente.sex_pac='Masculino'
create view wm_listarPacienteF
	as
	select Paciente.nom_pac as Nombre,
	Paciente.ape_pac as Apellido,
	Paciente.dni_pac as DNI,
	Paciente.dir_pac as Dirección,
	Paciente.fechanac_pac as Nacimiento
	from Paciente
	where Paciente.sex_pac='Femenino'

create view vw_Medicamento
	as
	select Medicamentos.nom_meds,
	Medicamentos.preunit_meds,
	Medicamentos.stock_meds 
	from Medicamentos inner join Enfermera on Medicamentos.cod_enf=
		Enfermera.cod_enf,Enfermera inner join Empleado on
		Enfermera.cod_enf=Empleado.cod_emple

create view vw_Muestra as
	select Muestra.nro_mues,Muestra.tip_mues,Muestra.desc_mues,
			Saca.fecha_ana,Paciente.nom_pac,Paciente.ape_pac,
			Empleado.nom_emple,Enfermera.area_enf
	from Muestra inner join Saca on Muestra.nro_mues=Saca.nro_mues,
		Saca inner join Paciente on Saca.dni_pac=Paciente.dni_pac,
		Muestra inner join Enfermera on Muestra.cod_enf=Enfermera.cod_enf,
		Enfermera inner join Empleado on Enfermera.cod_enf=Empleado.cod_emple



insert into Paciente values ('92839584','Luis','Perez','SIS',
'asd','asda','asd','11/11/1232','123','123'),
