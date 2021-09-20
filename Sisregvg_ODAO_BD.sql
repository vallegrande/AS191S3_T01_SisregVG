

CREATE TABLE PERSONAL (
	idper integer  NOT NULL,
	nomper VARCHAR2 (30) NOT NULL,
	apeper VARCHAR2 (30) NOT NULL,
	dniper CHAR (8) NOT NULL,
	celper CHAR (9) NOT NULL,
	emaper  VARCHAR2(50) NOT NULL,
	domper varchar2(80) NOT NULL,
	sexper  CHAR (1) NOT NULL,
	carper   VARCHAR2 (15) NOT NULL,
	estper char(1) NOT NULL,
	CONSTRAINT PERSONAL_pk PRIMARY KEY(IDPER)
);




CREATE TABLE DOCUMENTOS (
    IDDOC integer NOT NULL,
    IMPDOC DECIMAL(5,2)  NOT NULL,
    FECDOC date  NOT NULL,
    ASUDOC varchar2(200)  NOT NULL,
	ESTDOC char(1),
    CONSTRAINT DOCUMENTOS_pk PRIMARY KEY (IDDOC)
);




--  Create table ValeProvisional 
CREATE TABLE ValeProvisional (
	IDVAL integer  NOT NULL, 
	IMPVAL DECIMAL(5,2) NOT NULL,
	FECVAL DATE NOT NULL,
	CENVAL VARCHAR2(15) NOT NULL,
	PROVAL VARCHAR2(15) NOT NULL,
	ACTVAL VARCHAR2(200) NOT NULL,
	IDPER  integer NOT NULL,
	ESTVAL CHAR(1) NOT NULL,
    CONSTRAINT ValeProvisional_pk PRIMARY KEY (IDVAL)
);


-- Create Table: LiquidacionEntregasRendir
CREATE TABLE Liquidacion (
    IDLIQ integer NOT NULL,
    IDVAL integer NOT NULL, 
	MOTLIQ varchar2 (150) NOT NULL, 
    FECLIQ date NOT NULL,  
    ARELIQ varchar2 (150) NOT NULL,
    CENLIQ varchar2(10) NOT NULL,
    DESLIQ varchar2 (200) NOT NULL,
    FORLIQ varchar2 (30) NOT NULL,
    GASLIQ decimal(10,2)  NOT NULL,
    SALLIQ decimal(10,2) NOT NULL,
    ESTLIQ char(1) NOT NULL,
    CONSTRAINT Liquidacion_pk PRIMARY KEY (IDLIQ)
);


--  Create table REEMBOLSO
CREATE TABLE REEMBOLSO (
	IDREE integer  NOT NULL,
	IDLIQ integer NOT NULL,
    MOTREE varchar2(200) NOT NULL,
    FECREE DATE  NOT NULL ,
    AREREE VARCHAR2(80)  NOT NULL,
    CENREE CHAR(10)  NOT NULL,
    DESREE varchar2(200) NOT NULL,
	FORREE VARCHAR2(20)  NOT NULL,
	PAGREE varchar2(10) NOT NULL, 
    NAHREE VARCHAR2(25)  NOT NULL,
	NCUREE varchar2 (15)NOT NULL,
	SALREE decimal(10,2) NOT NULL,
	ESTREE CHAR(1)  NOT NULL,
   CONSTRAINT REEMBOLSO_pk PRIMARY KEY (IDREE)
);


-- RELACIONANDOLO 
--2 Relacionar la tabla Personal a ValeProvisional 
ALTER TABLE ValeProvisional
ADD CONSTRAINT FK_ValeProvisional_PERSONAL
FOREIGN KEY (IDPER) REFERENCES PERSONAL (IDPER);


--4 Relacionar la tabla Personal a LiquidacionEntregasRendir 
ALTER TABLE Liquidacion
ADD CONSTRAINT FK_Liquidacion_ValeProvisional
FOREIGN KEY (IDVAL) REFERENCES ValeProvisional (IDVAL);



--5 Relacionar la tabla LiquidacionEntregasRendir a Reembolso 
ALTER TABLE Reembolso
ADD CONSTRAINT FK_Rembolso_Liquidacion
FOREIGN KEY (IDLIQ) REFERENCES Liquidacion(IDLIQ);




CREATE SEQUENCE IDDOCUMENTOS
START WITH 1
INCREMENT BY 1
ORDER;

CREATE SEQUENCE IDPERSONAL
START WITH 1
INCREMENT BY 1
ORDER;

CREATE SEQUENCE IDVALEPROVISIONAl
START WITH 1
INCREMENT BY 1
ORDER;

CREATE SEQUENCE IDLIQUIDACION
START WITH 1
INCREMENT BY 1
ORDER;

CREATE SEQUENCE IDREEMBOLSO
START WITH 1
INCREMENT BY 1
ORDER;

CREATE OR REPLACE TRIGGER TGR_IDDOCUMENTOS
BEFORE INSERT ON DOCUMENTOS
FOR EACH ROW
BEGIN
SELECT IDDOCUMENTOS.NEXTVAL INTO :NEW.IDDOC FROM DUAL;
END;
/

CREATE OR REPLACE TRIGGER TGR_IDPERSONAL
BEFORE INSERT ON PERSONAL
FOR EACH ROW
BEGIN
SELECT IDPERSONAL.NEXTVAL INTO :NEW.IDPER FROM DUAL;
END;
/


CREATE OR REPLACE TRIGGER TGR_IDVALEPROVISIONAl
BEFORE INSERT ON ValeProvisional
FOR EACH ROW
BEGIN
SELECT IDVALEPROVISIONAl.NEXTVAL INTO :NEW.IDVAL FROM DUAL;
END;
/

CREATE OR REPLACE TRIGGER TGR_IDLIQUIDACION
BEFORE INSERT ON Liquidacion
FOR EACH ROW
BEGIN
SELECT IDLIQUIDACION.NEXTVAL INTO :NEW.IDLIQ FROM DUAL;
END;
/


CREATE OR REPLACE TRIGGER TGR_IDREEMBOLSO
BEFORE INSERT ON REEMBOLSO
FOR EACH ROW
BEGIN
SELECT IDREEMBOLSO.NEXTVAL INTO :NEW.IDREE FROM DUAL;
END;
/





-- Registro de DOCUMENTOS
INSERT INTO DOCUMENTOS (IMPDOC , FECDOC , ASUDOC,ESTDOC)
VALUES ('100,00', '11-02-2020', 'Realizar Vale Provisional','A');
INSERT INTO DOCUMENTOS (IMPDOC , FECDOC , ASUDOC,ESTDOC)
VALUES ('90,00', '12-03-2021', 'Realizar Reembolso','A');
INSERT INTO DOCUMENTOS (IMPDOC , FECDOC , ASUDOC,ESTDOC)
VALUES ('80,00', '04-04-2021', 'Realizar Vale DeclaracionJurada','A');
INSERT INTO DOCUMENTOS (IMPDOC , FECDOC , ASUDOC,ESTDOC)
VALUES ('70,00', '11-05-2021', 'Solicitar Entregas a Rendir','A');
INSERT INTO DOCUMENTOS (IMPDOC , FECDOC , ASUDOC,ESTDOC)
VALUES ('60,00', '18-01-2021', 'Solicitar Entregas a Rendir','A');
INSERT INTO DOCUMENTOS (IMPDOC , FECDOC , ASUDOC,ESTDOC)
VALUES ('50,00', '15-02-2021', 'Realizar Vale Provisional','A');
INSERT INTO DOCUMENTOS (IMPDOC , FECDOC , ASUDOC,ESTDOC)
VALUES ('40,00', '07-06-2021', 'Solicitar Entregas a Rendir','A');
INSERT INTO DOCUMENTOS (IMPDOC , FECDOC , ASUDOC,ESTDOC)
VALUES ('30,00', '02-05-2021', 'Realizar Vale Provisional','A');
INSERT INTO DOCUMENTOS (IMPDOC , FECDOC , ASUDOC,ESTDOC)
VALUES ('20,00', '22-04-2021', 'Solicitar Entregas a Rendir','A');
INSERT INTO DOCUMENTOS (IMPDOC , FECDOC , ASUDOC,ESTDOC)
VALUES ('20,00', '24-06-2021', 'Realizar Vale Provisional','A');



-- INSERTAR REGISTROS DE PERSONAL
INSERT INTO PERSONAL (nomper, apeper, dniper, celper, emaper,domper, sexper,carper, estper)
VALUES ( 'Juan Marcos', 'Rodriguez Quispe', '74143345','961270878','juan.rodrigues@vallegrande.edu.pe','Nuevo Imperial Mz:K Lt:3','M','Trabajador','A');
INSERT INTO PERSONAL (nomper, apeper, dniper, celper, emaper,domper, sexper,carper, estper)
VALUES ( 'Carl Sinól', 'Sanchez Pardo', '74153321','961243876','carl.sanchez@vallegrande.edu.pe', 'Santa Rosa Mz:J Lt:5','M', 'Trabajador','A');
INSERT INTO PERSONAL (nomper, apeper, dniper, celper, emaper,domper, sexper,carper, estper)
VALUES ( 'Frank Marmol', 'Beltrán Escalante', '76213421','961457980','frank@felipe@vallegrande.edu.pe','Imperial Mz:C Lt:9', 'M','Trabajador','A');
INSERT INTO PERSONAL (nomper, apeper, dniper, celper, emaper,domper, sexper,carper, estper)
VALUES ( 'Mateo Miklo', 'Vidal Burquéz', '76520534','961245767','mateo.vidal@vallegrande.edu.pe','Mala Mz:V Lt:2', 'M','Trabajador','A');
INSERT INTO PERSONAL (nomper, apeper, dniper, celper, emaper,domper, sexper,carper, estper)
VALUES ( 'Flavio Francisco', 'Huaman Zambrano', '76438332','961043532','flavio.huaman@vallegrande.edu.pe','San Vicente Mz:E Lt:4', 'M','Estudiante','A');
INSERT INTO PERSONAL (nomper, apeper, dniper, celper, emaper,domper, sexper,carper, estper)
VALUES ( 'Lenox Beltrán', 'Zuriaga Barton', '74153021','961243876','lenox.zuriaga@vallegrande.edu.pe', 'Santa Anita Mz:J Lt:5','M', 'Trabajador','A');
INSERT INTO PERSONAL (nomper, apeper, dniper, celper, emaper,domper, sexper,carper, estper)
VALUES ( 'Franklin Malla', 'Murieta Malcón', '76210121','961457980','franklin.murieta@vallegrande.edu.pe','Hualcalra Mz:C Lt:9', 'M','Trabajador','A');
INSERT INTO PERSONAL (nomper, apeper, dniper, celper, emaper,domper, sexper,carper, estper)
VALUES ( 'Martin Chiklo', 'Mollo Cardenaz', '76038534','961245767','martin.mollo@vallegrande.edu.pe','Mala Mz:V Lt:2', 'M','Trabajador','A');
INSERT INTO PERSONAL (nomper, apeper, dniper, celper, emaper,domper, sexper,carper, estper)
VALUES ( 'Ruben Dario ', 'Manco Capac', '76438308','961043532','ruben.manco@vallegrande.edu.pe','San Malecon Mz:E Lt:4', 'M','Estudiante','A');
INSERT INTO PERSONAL (nomper, apeper, dniper, celper, emaper,domper, sexper,carper, estper)
VALUES ( 'Renato Mendives', 'Hurtado Lozano', '76430532','961043532','renato.hurtado@vallegrande.edu.pe','San Bartolo Mz:E Lt:4', 'M','Estudiante','A');

-- INSERTAR REGISTROS DE VALEPROVISIONAL
INSERT INTO ValeProvisional (IMPVAL, FECVAL, CENVAL, PROVAL, ACTVAL, IDPER,ESTVAL)
VALUES ('100,00','01-09-2020','100203','Proyecto1','Compra de material para taller','1','A');
INSERT INTO ValeProvisional (IMPVAL, FECVAL, CENVAL, PROVAL, ACTVAL, IDPER,ESTVAL)
VALUES ('90,00','02-10-2020','100204','Proyecto2','Compra de artefacto para computo','2','A');
INSERT INTO ValeProvisional (IMPVAL, FECVAL, CENVAL, PROVAL, ACTVAL, IDPER,ESTVAL)
VALUES ('80,00','03-09-2020','100205','Proyecto3','Compra de monitores','3','A');
INSERT INTO ValeProvisional (IMPVAL, FECVAL, CENVAL, PROVAL, ACTVAL, IDPER,ESTVAL)
VALUES ('70,00','04-09-2020','100207','Proyecto4','Compra de teclados para computo','4','A');
INSERT INTO ValeProvisional (IMPVAL, FECVAL, CENVAL, PROVAL, ACTVAL, IDPER,ESTVAL)
VALUES ('60,00','05-07-2020','100203','Proyecto1','Compra de material para laboratorio','9','A');
INSERT INTO ValeProvisional (IMPVAL, FECVAL, CENVAL, PROVAL, ACTVAL, IDPER,ESTVAL)
VALUES ('50,00','06-06-2020','100207','Proyecto2','Compra de artefacto para sala de computo','6','A');
INSERT INTO ValeProvisional (IMPVAL, FECVAL, CENVAL, PROVAL, ACTVAL, IDPER,ESTVAL)
VALUES ('40,00','07-03-2020','100208','Proyecto3','Compra de monitores para laboratorio','7','A');
INSERT INTO ValeProvisional (IMPVAL, FECVAL, CENVAL, PROVAL, ACTVAL, IDPER,ESTVAL)
VALUES ('30,00','08-05-2020','100209','Proyecto4','Compra de teclados para computo','8','A');
INSERT INTO ValeProvisional (IMPVAL, FECVAL, CENVAL, PROVAL, ACTVAL, IDPER,ESTVAL)
VALUES ('20,00','09-04-2020','100210','Proyecto3','Compra de monitores y cpu para sala decomputo','9','A');
INSERT INTO ValeProvisional (IMPVAL, FECVAL, CENVAL, PROVAL, ACTVAL, IDPER,ESTVAL)
VALUES ('10,00','24-02-2020','100211','Proyecto4','Compra de teclados para computo','10','A');

-- INSERTAR REGISTROS DE LIQUIDACION
INSERT INTO Liquidacion (IDVAL,MOTLIQ,FECLIQ,ARELIQ,CENLIQ,DESLIQ,FORLIQ, GASLIQ, SALLIQ,ESTLIQ)
VALUES ('1','Monitoreo a lugares SBS Chilca, Mala, Cañete y Yauyos','06-02-2021','Carrera Profesional de Análisis de Sistemas','200201','Monitorio y Evaluación de Prácticas-AS','Soles','200,00','50,00','A');
INSERT INTO Liquidacion (IDVAL,MOTLIQ,FECLIQ,ARELIQ,CENLIQ,DESLIQ,FORLIQ, GASLIQ, SALLIQ,ESTLIQ)
VALUES ('2','Monitoreo a lugares SBS Ica, Mala, Cañete y Yauyos','20-05-2021','Carrera Profesional de Análisis de Sistemas','200202','Monitorio y Evaluación de Prácticas-AS','USD','160,00','20,00','A');
INSERT INTO Liquidacion (IDVAL,MOTLIQ,FECLIQ,ARELIQ,CENLIQ,DESLIQ,FORLIQ, GASLIQ, SALLIQ,ESTLIQ)
VALUES ('3','Monitoreo a lugares SBS Chinca, Mala, Cañete y Yauyos','19-03-2021','Carrera Profesional de Análisis de Sistemas','200203','Monitorio y Evaluación de Prácticas-AS','Soles','150,00','30,00','A');
INSERT INTO Liquidacion (IDVAL,MOTLIQ,FECLIQ,ARELIQ,CENLIQ,DESLIQ,FORLIQ, GASLIQ, SALLIQ,ESTLIQ)
VALUES ('4','Monitoreo a lugares SBS Cañete, Mala, Cañete y Yauyos','12-05-2021','Carrera Profesional de Análisis de Sistemas','200204','Monitorio y Evaluación de Prácticas-AS','Soles','140,00','70,00','A');
INSERT INTO Liquidacion (IDVAL,MOTLIQ,FECLIQ,ARELIQ,CENLIQ,DESLIQ,FORLIQ, GASLIQ, SALLIQ,ESTLIQ)
VALUES ('5','Monitoreo a lugares SBS Chilcal, Mala, Cañete y Yauyos','26-04-2021','Carrera Profesional de Análisis de Sistemas','200201','Monitorio y Evaluación de Prácticas-AS','Soles','200,00','50,00','A');
INSERT INTO Liquidacion (IDVAL,MOTLIQ,FECLIQ,ARELIQ,CENLIQ,DESLIQ,FORLIQ, GASLIQ, SALLIQ,ESTLIQ)
VALUES ('6','Monitoreo a lugares SBS Ica, Mala, Cañete y Yauyos','25-07-2021','Carrera Profesional de Análisis de Sistemas','200202','Monitorio y Evaluación de Prácticas-AS','USD','160,00','20,00','A');
INSERT INTO Liquidacion (IDVAL,MOTLIQ,FECLIQ,ARELIQ,CENLIQ,DESLIQ,FORLIQ, GASLIQ, SALLIQ,ESTLIQ)
VALUES ('7','Monitoreo a lugares SBS Chinca, Mala, Cañete y Yauyos','29-07-2021','Carrera Profesional de Análisis de Sistemas','200203','Monitorio y Evaluación de Prácticas-AS','Soles','150,00','30,00','A');
INSERT INTO Liquidacion (IDVAL,MOTLIQ,FECLIQ,ARELIQ,CENLIQ,DESLIQ,FORLIQ, GASLIQ, SALLIQ,ESTLIQ)
VALUES ('8','Monitoreo a lugares SBS Hualcara, Mala, Cañete y Yauyos','12-08-2021','Carrera Profesional de Análisis de Sistemas','200204','Monitorio y Evaluación de Prácticas-AS','Soles','140,00','70,00','A');
INSERT INTO Liquidacion (IDVAL,MOTLIQ,FECLIQ,ARELIQ,CENLIQ,DESLIQ,FORLIQ, GASLIQ, SALLIQ,ESTLIQ)
VALUES ('9','Monitoreo a lugares SBS Chincha alta, Mala, Cañete y Yauyos','17-05-2021','Carrera Profesional de Análisis de Sistemas','200203','Monitorio y Evaluación de Prácticas-AS','Soles','150,00','30,00','A');
INSERT INTO Liquidacion (IDVAL,MOTLIQ,FECLIQ,ARELIQ,CENLIQ,DESLIQ,FORLIQ, GASLIQ, SALLIQ,ESTLIQ)
VALUES ('10','Monitoreo a lugares SBS Piura, Mala, Cañete y Yauyos','02-04-2021','Carrera Profesional de Análisis de Sistemas','200204','Monitorio y Evaluación de Prácticas-AS','Soles','140,00','70,00','A');



-- INSERTAR REGISTROS DE REEMBOLSO
INSERT INTO REEMBOLSO (IDLIQ, MOTREE,FECREE,AREREE,CENREE,DESREE,FORREE, PAGREE, NAHREE,NCUREE, SALREE, ESTREE)
VALUES ( '2', 'Compra de materiales para computo','20-02-2021','Carrera Profesional de Análisis de Sistemas','200201','ENERFIA ELÉCTRICA- AS','SOLES','E','A','103489782Y','126,00','A');
INSERT INTO REEMBOLSO (IDLIQ, MOTREE,FECREE,AREREE,CENREE,DESREE,FORREE, PAGREE, NAHREE,NCUREE, SALREE, ESTREE)
VALUES ( '2',  'Compra de materiales para laboratorio','10-05-2021','Carrera Profesional de Análisis de Sistemas','200202','RPM - AS','SOLES','E','A','103489782Y','106,00','A');
INSERT INTO REEMBOLSO (IDLIQ, MOTREE,FECREE,AREREE,CENREE,DESREE,FORREE, PAGREE, NAHREE,NCUREE, SALREE, ESTREE)
VALUES ( '3', 'Compra de materiales','22-02-2021','Carrera Profesional de Análisis de Sistemas','200203','SOFTWARE DE GESTION ACADÉMICA Q10- AS','SOLES','C','A','103489782Y','120,00','A');
INSERT INTO REEMBOLSO (IDLIQ, MOTREE,FECREE,AREREE,CENREE,DESREE,FORREE, PAGREE, NAHREE,NCUREE, SALREE, ESTREE)
VALUES ( '4',  'Compra de materiales','19-09-2021','Carrera Profesional de Análisis de Sistemas','200204','VISITAS DE ESTUDIOS(NT) - AS','SOLES','E','A','103489782Y','129,00','A');
INSERT INTO REEMBOLSO (IDLIQ, MOTREE,FECREE,AREREE,CENREE,DESREE,FORREE, PAGREE, NAHREE,NCUREE, SALREE, ESTREE)
VALUES ( '5', 'Compra de materiales para computo','29-04-2021','Carrera Profesional de Análisis de Sistemas','200205','ENERFIA ELÉCTRICA- AS','SOLES','E','A','103489782Y','126,00','A');
INSERT INTO REEMBOLSO (IDLIQ, MOTREE,FECREE,AREREE,CENREE,DESREE,FORREE, PAGREE, NAHREE,NCUREE, SALREE, ESTREE)
VALUES ( '6',  'Compra de materiales para laboratorio','15-05-2021','Carrera Profesional de Análisis de Sistemas','200202','RPM - AS','SOLES','E','A','103489782Y','106,00','A');
INSERT INTO REEMBOLSO (IDLIQ, MOTREE,FECREE,AREREE,CENREE,DESREE,FORREE, PAGREE, NAHREE,NCUREE, SALREE, ESTREE)
VALUES ( '7', 'Compra de materiales','22-02-2021','Carrera Profesional de Análisis de Sistemas','200206','SOFTWARE DE GESTION ACADÉMICA Q10- AS','SOLES','C','A','103489782Y','120,00','A');
INSERT INTO REEMBOLSO (IDLIQ, MOTREE,FECREE,AREREE,CENREE,DESREE,FORREE, PAGREE, NAHREE,NCUREE, SALREE, ESTREE)
VALUES ( '8',  'Compra de materiales','29-09-2021','Carrera Profesional de Análisis de Sistemas','200207','VISITAS DE ESTUDIOS(NT) - AS','SOLES','E','A','103489782Y','129,00','A');
INSERT INTO REEMBOLSO (IDLIQ, MOTREE,FECREE,AREREE,CENREE,DESREE,FORREE, PAGREE, NAHREE,NCUREE, SALREE, ESTREE)
VALUES ( '9', 'Compra de materiales','24-02-2021','Carrera Profesional de Análisis de Sistemas','200208','SOFTWARE DE GESTION ACADÉMICA Q10- AS','SOLES','C','A','103489782Y','120,00','A');
INSERT INTO REEMBOLSO (IDLIQ, MOTREE,FECREE,AREREE,CENREE,DESREE,FORREE, PAGREE, NAHREE,NCUREE, SALREE, ESTREE)
VALUES ( '10',  'Compra de materiales','09-09-2021','Carrera Profesional de Análisis de Sistemas','200209','VISITAS DE ESTUDIOS(NT) - AS','SOLES','E','A','103489782Y','129,00','A');



--Vistas Vale Provisional
CREATE VIEW vValeProvisional
AS
SELECT
	 V.IDVAL AS IDVAL,
	 V.IMPVAL AS IMPVAL,
	 V.FECVAL AS FECVAL,
	 V.CENVAL AS CENVAL,
	 V.PROVAL AS PROVAL,
	 V.ACTVAL AS ACTVAL,
     INITCAP(P.nomper) AS NOMPER,
	 ROW_NUMBER() OVER (ORDER BY V.IDVAL DESC) AS ORDEN
FROM 
     ValeProvisional V
	 INNER JOIN PERSONAL  P ON
	 V.IDPER = P.idper
WHERE 
     ESTVAL = 'A';


-- Vale Provisional Activos
CREATE VIEW vValeProvisionalA
AS
SELECT
	 V.IDVAL AS IDVAL,
	 V.IMPVAL AS IMPVAL,
	 V.FECVAL AS FECVAL,
	 V.CENVAL AS CENVAL,
	 V.PROVAL AS PROVAL,
	 V.ACTVAL AS ACTVAL,
    INITCAP(P.nomper) AS NOMPER,
	 ROW_NUMBER() OVER (ORDER BY V.IDVAL DESC) AS ORDEN
FROM 
     ValeProvisional  V
	 INNER JOIN PERSONAL P ON
	 V.IDPER = P.idper
WHERE 
     ESTVAL = 'A';



-- Vale Provisional Inactivos
CREATE VIEW vValeProvisionalI
AS
SELECT
	 V.IDVAL AS IDVAL,
	 V.IMPVAL AS IMPVAL,
	 V.FECVAL AS FECVAL,
	 V.CENVAL AS CENVAL,
	 V.PROVAL AS PROVAL,
	 V.ACTVAL AS ACTVAL,
    INITCAP(P.nomper) AS NOMPER,
	 ROW_NUMBER() OVER (ORDER BY V.IDVAL DESC) AS ORDEN
FROM 
     ValeProvisional  V
	 INNER JOIN PERSONAL P ON
	 V.IDPER = P.idper
WHERE 
     ESTVAL = 'I';



-- Vale Provisional Todos
CREATE VIEW vValeProvisionalT
AS
SELECT
	 V.IDVAL AS IDVAL,
	 V.IMPVAL AS IMPVAL,
	 V.FECVAL AS FECVAL,
	 V.CENVAL AS CENVAL,
	 V.PROVAL AS PROVAL,
	 V.ACTVAL AS ACTVAL,
    INITCAP(P.nomper) AS NOMPER,
	 ROW_NUMBER() OVER (ORDER BY V.IDVAL DESC) AS ORDEN
FROM 
     ValeProvisional  V
	 INNER JOIN PERSONAL P ON
	 V.IDPER = P.idper ;




--Creación de Vistas Personal
--Personal Activos
CREATE VIEW vPersonalA
AS
SELECT
	 P.IDPER AS IDPER,
     INITCAP(P.nomper) AS NOMPER,
     INITCAP(P.apeper) AS APEPER, 
	 P.dniper AS DNIPER,
	 P.celper AS CELPER,
	 P.emaper AS EMAPER,
	 P.domper AS DOMPER,
	 P.sexper AS SEXPER,
	 P.carper AS CARPER,
	 ROW_NUMBER() OVER (ORDER BY P.IDPER DESC) AS ORDEN
FROM 
     Personal P
WHERE 
     ESTPER = 'A' ;




--PersonalInactivos
CREATE VIEW vPersonalI
AS
SELECT
	 P.IDPER AS IDPER,
     INITCAP(P.nomper) AS NOMPER,
     INITCAP(P.apeper) AS APEPER, 
	 P.dniper AS DNIPER,
	 P.celper AS CELPER,
	 P.emaper AS EMAPER,
	 P.domper AS DOMPER,
	 P.sexper AS SEXPER,
	 P.carper AS CARPER,
	 ROW_NUMBER() OVER (ORDER BY P.IDPER DESC) AS ORDEN
FROM 
     Personal P
WHERE 
     ESTPER = 'I' ;



--Personal  Todos
CREATE VIEW vPersonalT
AS
SELECT
	 P.IDPER AS IDPER,
     INITCAP(P.nomper) AS NOMPER,
     INITCAP(P.apeper) AS APEPER, 
	 P.dniper AS DNIPER,
	 P.celper AS CELPER,
	 P.emaper AS EMAPER,
	 P.domper AS DOMPER,
	 P.sexper AS SEXPER,
	 P.carper AS CARPER,
	 ROW_NUMBER() OVER (ORDER BY P.IDPER DESC) AS ORDEN
FROM 
     Personal P ;
     
     
     

--Creación de la Vista LiquidacionEntregasRendir
---- LiquidacionEntregasRendir Activos
CREATE VIEW vLiquidacionA
AS
SELECT
	 L.IDLIQ AS IDLIQ,
     INITCAP(P.nomper) AS NOMPER,
	 P.dniper AS dniper,
	 V.FECVAL AS FECVAL,
	 V.IDVAL AS IDVAL,
	 L.MOTLIQ AS MOTLIQ,
	 L.FECLIQ AS FECLIQ,
	 L.ARELIQ AS ARELIQ,
	 L.CENLIQ AS CENLIQ,
	 L.DESLIQ AS DESLIQ,
	 L.FORLIQ AS FORLIQ,
	 V.IMPVAL AS IMPVAL,
	 L.GASLIQ AS GASLIQ,
	 (V.IMPVAL - L.GASLIQ) AS SALLIQ,
     ROW_NUMBER() OVER (ORDER BY L.IDLIQ DESC) AS ORDEN
FROM 
     Liquidacion  L
	  INNER JOIN ValeProvisional  V ON
	 L.IDVAL = V.IDVAL
	  INNER JOIN PERSONAL  P ON
	 V.IDPER = P.idper
WHERE 
  ESTLIQ = 'A' ;
     
     
CREATE VIEW vLiquidacionI
AS
SELECT
	 L.IDLIQ AS IDLIQ,
     INITCAP(P.nomper) AS NOMPER,
	 P.dniper AS dniper,
	 V.FECVAL AS FECVAL,
	 V.IDVAL AS IDVAL,
	 L.MOTLIQ AS MOTLIQ,
	 L.FECLIQ AS FECLIQ,
	 L.ARELIQ AS ARELIQ,
	 L.CENLIQ AS CENLIQ,
	 L.DESLIQ AS DESLIQ,
	 L.FORLIQ AS FORLIQ,
	 V.IMPVAL AS IMPVAL,
	 L.GASLIQ AS GASLIQ,
	 (V.IMPVAL - L.GASLIQ) AS SALLIQ,
     ROW_NUMBER() OVER (ORDER BY L.IDLIQ DESC) AS ORDEN
FROM 
     Liquidacion  L
	  INNER JOIN ValeProvisional  V ON
	 L.IDVAL = V.IDVAL
	  INNER JOIN PERSONAL  P ON
	 V.IDPER = P.idper
WHERE 
  ESTLIQ = 'I' ;
     
     
     
CREATE VIEW vLiquidacionT
AS
SELECT
	 L.IDLIQ AS IDLIQ,
     INITCAP(P.nomper) AS NOMPER,
	 P.dniper AS dniper,
	 V.FECVAL AS FECVAL,
	 V.IDVAL AS IDVAL,
	 L.MOTLIQ AS MOTLIQ,
	 L.FECLIQ AS FECLIQ,
	 L.ARELIQ AS ARELIQ,
	 L.CENLIQ AS CENLIQ,
	 L.DESLIQ AS DESLIQ,
	 L.FORLIQ AS FORLIQ,
	 V.IMPVAL AS IMPVAL,
	 L.GASLIQ AS GASLIQ,
	 (V.IMPVAL - L.GASLIQ) AS SALLIQ,
     ROW_NUMBER() OVER (ORDER BY L.IDLIQ DESC) AS ORDEN
FROM 
     Liquidacion  L
	  INNER JOIN ValeProvisional  V ON
	 L.IDVAL = V.IDVAL
	  INNER JOIN PERSONAL  P ON
	 V.IDPER = P.idper ;

