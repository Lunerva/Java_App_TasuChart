-- Luis Barranco Proyecto Topicos
-- 21130876
create database ChartProyecto;
use ChartProyecto;

create table poblacion2005 (
    pob05_id int primary key not null auto_increment,
    pob05_entidad varchar(50) not null,
    pob05_2005 int not null,
    pob05_EdadMedia int not null
);
create table poblacion2010 (
    pob10_id int primary key not null auto_increment,
    pob10_entidad varchar(50) not null,
    pob10_2010 int not null,
    pob10_EdadMedia int not null
);
create table poblacion2020 (
    pob20_id int primary key not null auto_increment,
    pob20_entidad varchar(50) not null,
    pob20_2020 int not null,
    pob20_EdadMedia int not null
);

INSERT INTO poblacion2005(pob05_entidad, pob05_2005, pob05_EdadMedia) VALUES
('Aguascalientes', 1065416 , 23),
('Baja California', 2844469 ,25),
('Baja California Sur', 512170 ,25),
('Campeche', 754730, 24),
('Coahuila de Zaragoza',2495200,25),
('Colima', 567996,25),
('Chiapas',4293459,20),
('Chihuahua', 3241444,25),
('Distrito Federal', 8720916,29),
('Durango', 1509117,23),
('Guanajuato', 4893812,23),
('Guerrero', 3115202,21),
('Hidalgo', 2345514,24),
('Jalisco', 6752113,24),
('México', 14007495,24),
('Michoacán de Ocampo', 3966073,23),
('Morelos',1612899, 25),
('Nayarit',949684, 24),
('Nuevo León',4199292, 26),
('Oaxaca',3506821,22),
('Puebla',5383133,23),
('Querétaro Arteaga',1598139, 23),
('Quintana Roo',1135309, 23),
('San Luis Potosí', 2410414, 23),
('Sinaloa', 2608442, 25),
('Sonora', 2394861, 25),
('Tabasco', 1989969, 23),
('Tamaulipas', 3024238, 25 ),
('Tlaxcala', 1068207, 23),
('Veracruz de Ignacio de la Llave', 7110214, 25),
('Yucatán', 1818948, 25),
('Zacatecas', 1367692, 23);


INSERT INTO poblacion2010(pob10_entidad, pob10_2010, pob10_EdadMedia) VALUES
('Aguascalientes', 1184996 ,24),
('Baja California', 3155070,26),
('Baja California Sur', 637026,26),
('Campeche', 822441,25),
('Coahuila de Zaragoza', 2748391, 26),
('Colima',650555,26),
('Chiapas',4796580,22),
('Chihuahua',3406465,26),
('Distrito Federal', 8851080,31),
('Durango',1632934,24),
('Guanajuato',5486372,24),
('Guerrero',3388768,23),
('Hidalgo',2665018, 25),
('Jalisco',7350682,25),
('México',15175862,26),
('Michoacán de Ocampo',4351037,25),
('Morelos', 1777227,26),
('Nayarit', 1084979,26),
('Nuevo León', 4653458,27),
('Oaxaca', 3801962,24),
('Puebla', 5779829,24),
('Querétaro Arteaga', 1827937,25),
('Quintana Roo', 1325578,25),
('San Luis Potosí', 2585518, 25 ),
('Sinaloa', 2767761, 26),
('Sonora', 2662480,26),
('Tabasco', 2238603,25),
('Tamaulipas', 3268554, 27),
('Tlaxcala',  1169936,25),
('Veracruz de Ignacio de la Llave',  7643194,27),
('Yucatán',1955577, 26),
('Zacatecas',1490668, 25);

INSERT INTO poblacion2020(pob20_entidad, pob20_2020, pob20_EdadMedia) VALUES
('Aguascalientes', 1425607, 27),
('Baja California', 3769020, 30),
('Baja California Sur', 798447,   29),
('Campeche', 928363,   29),
('Coahuila de Zaragoza',3146771,   29),
('Colima', 731391, 30),
('Chiapas',5543828, 24),
('Chihuahua', 3741869,    29),
('Distrito Federal', 9209944,    35),
('Durango', 1832650,   27),
('Guanajuato', 6166934,   28),
('Guerrero', 3540685,    27),
('Hidalgo', 3082841,   30),
('Jalisco', 8348151,   29),
('México', 16992418,   30),
('Michoacán de Ocampo', 4748846,   28),
('Morelos', 1971520,   30),
('Nayarit', 1235456,   29),
('Nuevo León', 5784442,   30),
('Oaxaca',4132148,   28),
('Puebla',6583278,   28),
('Querétaro Arteaga', 2368467,   29),
('Quintana Roo', 1857985,   28),
('San Luis Potosí', 2822255,   29),
('Sinaloa', 3026943,   30),
('Sonora', 2944840,   30),
('Tabasco',2402598,   29),
('Tamaulipas', 3527735, 30),
('Tlaxcala', 1342977, 28),
('Veracruz de Ignacio de la Llave',8062579,   31),
('Yucatán',2320898, 30),
('Zacatecas',1622138, 28);




