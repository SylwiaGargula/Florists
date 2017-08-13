
drop table IF EXISTS Sposob_dostawy;
drop table IF EXISTS Sposob_zakupu;
drop table IF EXISTS Zakupy;
drop table IF EXISTS Pracownik;
drop table IF EXISTS Stanowisko;
drop table IF EXISTS Klient;
drop table IF EXISTS Dostawa;
drop table IF EXISTS Hurtownia;
drop table IF EXISTS Kwiat;


Create table Kwiat (
	Id_Rosliny Int NOT NULL,
	Nazwa_kwiatu Char(50),
	Cena_jednostkowa Char(50),
 Primary Key (Id_Rosliny)) ENGINE = MyISAM;

Create table Hurtownia (
	Id_Hurtowni Int NOT NULL,
	Nazwa_hurtowni Char(50),
	Miejscowosc Char(50),
	Ulica Char(50),
 Primary Key (Id_Hurtowni)) ENGINE = MyISAM;

Create table Dostawa (
	Id_Dostawy Int NOT NULL,
	Ilosc Smallint,
	Id_Hurtowni Int NOT NULL,
	Id_Rosliny Int NOT NULL,
 Primary Key (Id_Dostawy)) ENGINE = MyISAM;

Create table Klient (
	Id_Klienta Int NOT NULL,
	Imie Char(50),
	Nazwisko Char(50),
	Miejscowosc Char(50),
	Ulica Char(50),
	Telefon Char(50),
 Primary Key (Id_Klienta)) ENGINE = MyISAM;

Create table Stanowisko (
	Id_Stanowiska Int NOT NULL,
	Nazwa_stanowiska Char(50),
	Placa Smallint,
 Primary Key (Id_Stanowiska)) ENGINE = MyISAM;

Create table Pracownik (
	Id_Pracownika Int NOT NULL,
	Imie Char(50),
	Nazwisko Char(50),
	Miejscowosc Char(50),
	Ulica Char(50),
	Id_Stanowiska Int NOT NULL,
 Primary Key (Id_Pracownika)) ENGINE = MyISAM;

Create table Zakupy (
	Id_zakupu Int NOT NULL,
	Ilosc Smallint,
	Id_Pracownika Int NOT NULL,
	Id_Klienta Int NOT NULL,
	Id_Sposobu_Dostawy Int NOT NULL,
	Id_sposobu_zakupu Int NOT NULL,
	Id_Rosliny Int NOT NULL,
 Primary Key (Id_zakupu)) ENGINE = MyISAM;

Create table Sposob_zakupu (
	Id_sposobu_zakupu Int NOT NULL,
	Nazwa_sposobu_zakupu Char(50),
 Primary Key (Id_sposobu_zakupu)) ENGINE = MyISAM;

Create table Sposob_dostawy (
	Id_Sposobu_Dostawy Int NOT NULL,
	Nazwa_sposobu_dostawy Char(50),
 Primary Key (Id_Sposobu_Dostawy)) ENGINE = MyISAM;


Alter table Zakupy add Foreign Key (Id_Rosliny) references Kwiat (Id_Rosliny) on delete  restrict on update  restrict;
Alter table Dostawa add Foreign Key (Id_Rosliny) references Kwiat (Id_Rosliny) on delete  restrict on update  restrict;
Alter table Dostawa add Foreign Key (Id_Hurtowni) references Hurtownia (Id_Hurtowni) on delete  restrict on update  restrict;
Alter table Zakupy add Foreign Key (Id_Klienta) references Klient (Id_Klienta) on delete  restrict on update  restrict;
Alter table Pracownik add Foreign Key (Id_Stanowiska) references Stanowisko (Id_Stanowiska) on delete  restrict on update  restrict;
Alter table Zakupy add Foreign Key (Id_Pracownika) references Pracownik (Id_Pracownika) on delete  restrict on update  restrict;
Alter table Zakupy add Foreign Key (Id_sposobu_zakupu) references Sposob_zakupu (Id_sposobu_zakupu) on delete  restrict on update  restrict;
Alter table Zakupy add Foreign Key (Id_Sposobu_Dostawy) references Sposob_dostawy (Id_Sposobu_Dostawy) on delete  restrict on update  restrict;


/* Users permissions */


