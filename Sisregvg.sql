Use dbsisregvg;
select * from  dbsisregvg;

CREATE TABLE PERSONA
(
codper int  IDENTITY(1,1) PRIMARY KEY ,
nomper VARCHAR (30) ,
apeper VARCHAR (30) ,
dniper CHAR (8) ,
celper CHAR (9) ,
emaper  VARCHAR(50) ,
sexper  CHAR (1) ,
carper   VARCHAR (30) 
);


INSERT INTO PERSONA
(nomper, apeper, dniper, celper, emaper, sexper,carper)
VALUES
( 'JUAN', 'RODRIGUEZ', '74143345','961270878','juan.rodrigues@vallegrande.edu.pe','M','Estudiante'),
( 'CARL', 'SANCHEZ', '74153321','961243876','carl.sanchez@vallegrande.edu.pe','M','Analista'),
( 'FRANK', 'FELIPE', '76213421','961457980','frank@felipe@vallegrande.edu.pe','M','Analista'),
( 'Peter', 'huayay','74140385', '976389702','peter.huayanay@vallegrande.edu.pe','M','Estudiante'),
( 'Mateo', 'vidal', '76528534','961245767','mateo.vidal@vallegrande.edu.pe','M','Analista'),
( 'Flavio', 'huaman', '76438332','961043532','flavio.huaman@vallegrande.edu.pe','M','Estudiante'),
( 'Lucas', 'lopez', '74287655','961728940','lucas.lopez@vallegrande.edu.pe','M','Estudiante'),
( 'Drang', 'guzman', '74159876','961289707','drang.guzman@vallegrande.edu.pe','M','Analista'),
( 'Saft', 'aliaga', '73145672','965127464','saft.aliaga@vallegrande.edu.pe','M','Estudiante'),
( 'Erik', 'falcon', '74173672','961508959','erick.falcon@vallegrande.edu.pe','M','Analista');