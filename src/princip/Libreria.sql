drop database if exists libreria;
create database libreria;
use libreria;
/*Tablas*/

drop table if exists Genero;
create table if not exists Genero(
	id_Genero int unsigned auto_increment primary key,
	nombre varchar(20)
);

drop table if exists Editorial;
create table if not exists Editorial(
	id_Editorial int unsigned auto_increment primary key,
	nombre varchar(15)
);


drop table if exists Libros;
create table if not exists Libros(
	id_Libro char(6) primary key,
	titulo varchar(50) not null,
	autor varchar(50),
	ilustrador varchar(40),
	id_Genero int unsigned,
	numPaginas int unsigned,
	sipnosis text,
	firmado boolean,
	id_Editorial int unsigned,
	ISBN char(13) unique,
	precio decimal(7,2),
	portada varchar(50),
	fech_prim_public date,
	valoracion smallint,
	CONSTRAINT Valor_Valoracion check (valoracion between 0 and 5),
	CONSTRAINT fk_LibroEdit FOREIGN KEY (id_Editorial) REFERENCES Editorial (id_Editorial),
	CONSTRAINT fk_LibroGen FOREIGN KEY (id_Genero) REFERENCES Genero (id_Genero)
);



/*Insert*/
insert into Genero(nombre) values
('Terror'),
('Misterio'),
('Fantasía'),
('Romántico'),
('Bélico'),
('Aventuras'),
('Policíaco'),
('Novela'),
('Infantil'),
('Juvenil'),
('Cocina'),
('Psicología'),
('Poético'),
('Drama'),
('Manga'),
('Comic'),
('Erótico'),
('Otro');

insert into Editorial(nombre) values
('Shueisha'),
('Salamandra'),
('Tucán'),
('Circulo'),
('Circulo Rojo'),
('Anaya'),
('Planeta'),
('Minotauro'),
('Otro');


insert into Libros(id_Libro,titulo,autor,ilustrador,id_Genero,numPaginas,sipnosis,firmado,id_Editorial,ISBN,precio,portada,fech_prim_public,valoracion) values
('001LJH','Los juegos del hambre','Suzanne Collins','Tim O,Brien',3,399,'Los juegos del hambre (en inglés: The Hunger Games), sigue la vida de Katniss Everdeen de 16 años, 
una chica del Distrito 12, que se ofrece voluntaria para los Septuagésimo Cuartos Juegos del Hambre en 
el lugar de su hermana menor, Primrose. Donde también participa, Peeta Mellark, el tributo varón del Distrito 
12, un chico que ama a Katniss desde el primer momento que la vio. Katniss y Peeta lucharán contra los otros
 tributos en conjunto, fingiendo que se aman para ganar el favor del público.',false,2,'1253654879541',17.90,'../Recursos/LosJuegosHambre.png','2008-09-14',5),

('002LJH','Los juegos del hambre.En llamas','Suzanne Collins','Tim O,Brien',3,391,'En llamas (en inglés: Catching Fire), Katniss se entera de que el Capitolio está enojado con ella por su desafío en
 la novela anterior, y que se inició una reacción en cadena que inspiró la rebelión en los distritos. Para una edición
 especial por el 75 aniversario de los Juegos del Hambre, ella y Peeta se ven obligados a competir por segunda vez 
con otros vencedores de ediciones pasadas. Ellos en equipo con otros tributos logran destruir la arena y escapar de los 
Juegos. Katniss es transportada al Distrito 13, un lugar que se pensaba que ya no existía, pero Peeta es capturado por el
 Capitolio, y el Distrito 12 es destruido.',false,2,'1253654895232',17.80,'../Recursos/EnLlamas.png','2009-09-01',5),

('003LJH','Los juegos del hambre.Sinsajo','Suzanne Collins','Tim O,Brien',3,422,'Sinsajo (en inglés: Mockingjay), el tercer y último libro, que gira en torno a Katniss y la rebelión de los distritos
 contra el Capitolio. Katniss, ahora refugiada en el Distrito 13, y bastante deteriorada de sus experiencias, 
es utilizada por los rebeldes como una herramienta de propaganda para unir a los distritos en el levantamiento 
contra el Capitolio y el presidente Snow. Peeta y los otros que fueron capturados por el Capitolio son rescatados.
 Por último, un grupo que incluye a Katniss, Gale, y el todavía algo inestable, Peeta, van de renegados al Capitolio
 en una misión para asesinar al Presidente Snow. Antes de que Katniss puede completar su objetivo, Prim es asesinada
 en un atentado dirigido por equipos de rescate rebeldes. Más tarde, Snow en cautiverio le dice a Katniss que Coin,
 la presidente del Distrito 13, estaba detrás del atentado, por lo cual Katniss la mata. Katniss, Peeta y Haymitch 
finalmente vuelven a un distrito 12 en ruinas. Katniss poco a poco comienza a recuperarse de sus muchas cicatrices 
mentales. La madre de Katniss y Gale aceptan empleos en los diferentes distritos. Katniss finalmente llega a amar 
genuinamente a Peeta, se casa con él, y después de muchos años de dudas, tienen dos hijos.',false,2,'1253654215635',17.75,'../Recursos/Sinsajo.png','2010-08-24',5),

('004SIL','El silencio de los corderos','Thomas Harris','Desconocido',1,352,'A Clarice Starling, joven y ambiciosa estudiante de la academia del FBI, le encomiendan que entreviste a Hannibal Lecter, brillante psiquiatra
 y despiadado asesino, para conseguir su colaboración en la resolución de un caso de asesinatos en serie. 
El asombroso conocimiento de Lecter del comportamiento humano y su poderosa personalidad cautivarán de inmediato 
a Clarice, quien, incapaz de dominarla, establecerá con él una ambigua, inquientante y peligrosa relación.',false,3,'2356987415236',18.90,'../Recursos/Silen.png','1981-04-02',4),

('005HAN','Hannibal','Thomas Harris','Desconocido',1,490,'La agente especial  Clarice Starling ya no persigue asesinos en serie desde la unidad de
 Ciencias del Comportamiento del FBI. Tras capturar al temible psicópata Buffalo Bill, su incapacidad para ascender
 dentro del cuerpo la ha condenado a las brigadas de choque. Un trabajo peligroso, pues dar con tus huesos bajo 
tierra o, aun peor, ante la oficina de Responsabilidades Profesionales del FBI. La investigación interna abierta 
tras la muerte de cinco personas en un calamitoso tiroteo parece el principio del fin de la brillante carrera de
 Clarice. Pero entonces vuelve a dar señales de vida el aterrador doctor Hannibal Lecter, el único que parece 
dispuesto a echarle una mano.',false,2,'84-226-8233-8',19.90,'../Recursos/Hannib.png','1989-02-03',4),

('006DGR','El dragón rojo','Thomas Harris','Desconocido',1,480,'Will Graham es sacado del retiro por el FBI para 
ayudar a rastrear a un asesino en serie conocido como Tooth Fairy ("Hada de los dientes" o en otras ediciones 
"Duende Dientudo", nombre dado en Estados Unidos al Ratoncito Pérez), quien ha asesinado a dos familias. Graham 
se retiró después de casi ser asesinado por Hannibal Lecter, quien, subsecuentemente, fue capturado en el proceso.
 Graham busca ayuda de Lecter para atrapar al asesino. Sin embargo, Graham descubre que Lecter lo está manipulando 
a él y al hombre que está tratando de aprender.La relación entre Lecter y Graham es paralela a la relación
 entre Lecter y Clarice Starling en las secuelas, pero hay tonos diferentes. Lecter trata a Starling como
 una simple estudiante y a Graham como un colega (aunque no como su igual). La aceptación de Graham por 
Lecter no se detiene al nivel "profesional", sino que se extiende a un traslape entre la psique de Graham
 y la de Lecter.',false,2,'1235698475623',17.80,'../Recursos/DragR.png','1981-03-01',3),

('007DRC','Drácula','Bram Stoker','Desconocido',1,688,'Jonathan Harker, un joven abogado inglés de Londres prometido
 con la joven y bellísima institutriz Wilhemina Murray (Mina) se encuentra en la ciudad de Bistritz y debe viajar a 
través del desfiladero del Borgo hasta el remoto castillo del conde Drácula, en los Montes Cárpatos de Transilvania,
 una de las regiones más lejanas de la Hungría de esa época, para cerrar unas ventas con él. Convirtiéndose durante 
un breve período de tiempo en huésped del conde, el joven inglés va descubriendo que la personalidad de Drácula es,
 cuanto menos, extraña: no se refleja en los espejos, no come nunca en su presencia y hace vida nocturna. Poco a 
poco va descubriendo que es un ser despreciable, ruin y despiadado que acabará convirtiéndole en un rehén en el 
propio castillo. En el mismo también viven tres jóvenes y bellas vampiresas que una noche seducen a Jonathan y 
están a punto de chuparle la sangre para convertirle en vampiro, cosa que evita la interrupción del conde. Para
 evitarlo, Drácula les entrega un niño que ha secuestrado para que se beban su sangre. La madre del bebé no tarda 
en llegar al castillo para reclamarlo, pero el conde ordena a los lobos que la devoren.',true,3,'2135468796541',11650.30,'../Recursos/Drac.png','1897-01-01',5),

('008DN1','Death Note Tomo1','Tsugumi Oba','Takeshi Obata',13,384,'Death Note supuso toda una revolución en el 
manga: el protagonista, tras encontrar un objeto mágico de inmenso poder, lo utiliza no para hacer el bien… sino
 para convertirse en el gobernante supremo del mundo. Esta historia atípica, un verdadero thriller en viñetas, 
es un clásico moderno del manga, y como tal, ¡merece una edición a su altura!',false,1,'1235698422263',14.95,'../Recursos/Death1.png','2006-10-03',3),

('009DN2','Death Note Tomo2','Tsugumi Oba','Takeshi Obata',13,384,'Death Note supuso toda una revolución en el 
manga: el protagonista, tras encontrar un objeto mágico de inmenso poder, lo utiliza no para hacer el bien… sino
 para convertirse en el gobernante supremo del mundo. Esta historia atípica, un verdadero thriller en viñetas, 
es un clásico moderno del manga, y como tal, ¡merece una edición a su altura!',false,1,'1235698242263',14.95,'../Recursos/Death2.png','2006-12-03',3),

('010HDS','El honor del samurai','Takashi Matsuoka','Desconocido',6,528,'En 1861 Japón se ha visto forzado a abrir 
las puertas a Occidente, con el consecuente choque entre ambas culturas. En el puerto de Edo se reúnen barzos 
extranjeros en busca de oportunidades en esas tierras; uno de ellos transporta a un grupo de americanos cuyo 
objetivo es llevar la palabra de Dios al pueblo nipón. Para dos de estos misioneros, sin embargo, el viaje supone 
algo más: la joven Emily Gibson desea dejar atrás un pasado incómodo e iniciar una nueva vida; Matthew Stark tiene
 algo que ocultar bajo su pacífica apariencia. El destino de ambos se cruza con el de Genji, un joven samurái
 heredero del clan Akaoka. Su amistad con los foráneos despierta el recelo de otros clanes, que declararán la 
guerra abierta a Genji. Ayudado por sus dos nuevos amigos y su amante, la geisha Heiko, éste defenderá su posición
 sorteando intrigas y traiciones.',false,7,'12356-9874521',12.00,'../Recursos/HDS.png','2003-05-03',2),

('011EDD','Espía de Dios','Juan Gomez Jurado','Desconocido',2,320,'Roma, 2 de abril de 2005. El Papa Juan Pablo II 
acaba de morir y la plaza de San Pedro se llena de fieles dispuestos a darle el último adiós. Al mismo tiempo, 
se inician los preparativos para el cónclave del que ha de salir el nombre del nuevo Sumo Pontifice. Pero justo 
entonces los dos cardenales mejor situados del ala lib eral de la Iglesia, Enrico Portini y Emilio Robayra, 
aparecen asesinados siguiendo un mismo y macabro ritual que incluye la mutilación de miembros y mensajes escritos 
con simbología religiosa. Un asesino en serie anda suelto por las calles de Roma, y la encargada de perseguirlo 
será la inspectora y psiquiatra criminalista Paola Dicanti. Durante la investigación, la joven detective se 
adentrará en los más oscuros secretos del Vaticano, aquellos que hablan de conspiraciones nada decorosas y de
 la existencia de un centro donde se rehabilita a sacerdotes católicos con historial de abusos sexuales. A la
 cruel astucia del psicópata se unen las trabas que los servicios de seguridad del Vaticano ponen a la investigación:
 oficialmente las muertes de los cardenales no están ocurriendo y el cónclave debe celebrarse con normalidad. 
La aparición del padre Fowler, un ex militar norteamericano, supondrá un nuevo desafío para Dicanti, reacia a
 confiar en el misterioso sacerdote. Pero Fowler conoce el nombre del asesino y guarda un secreto aún más temible:
 su propio pasado.',false,4,'123-89-98-526',17.00,'../Recursos/espia.png','2007-03-26',4),

('012SLA','El Hobbit','J.R.R. Tolkien','Desconocido',6,288,'Las inesperadas aventuras de un pacífico hombre del campo
 no parecieran tener mucha relación con las vastas y oscuras mitologías de la Tierra Media. El estilo 
directo y lineal, con alusiones (que el autor deploró más tarde) a un público infantil, no impide la poderosa
 irrupción -- unas pocas veces en términos de comedia -- de los grandes temas tolkienianos (el poder, la 
codicia, la guerra, la muerte) que reaparecerían en una dimensión a menudo obviamente épica en El Señor 
de los Anillos. Todos los que aman esos libros para niños que pueden ser leídos y releídos por adultos--
 escribió C. S. Lewis a propósito de la aparición de The Hobbit en 1937-- han de tomar buena cuenta 
que una nueva estrella ha aparecido en esa constelación. Para el ojo entrenado algunos de los caracteres
 han de parecer casi mitopoieicos. Uno de los libros más influyentes de nuestro tiempo... Una impecable 
obra maestra. -- The Times Una saga espléndidamente escrita de enanos y elfos, duendes y trasgos terribles...
 una excitante épica de viajes y aventuras mágicas que alcanza al fin un clímax devastador.',false,8,'9788445073803',20.95,'../Recursos/HBB.png','1937-09-21',5),

('013SLA','El Silmarillon','J.R.R. Tolkien','Desconocido',6,448,'El Silmarillion cuenta la historia de la Primera Edad,
 el antiguo drama del que hablan los personajes de El Señor de los Anillos, y en cuyos acontecimientos algunos tomaron
 parte, como Elrond y Galadriel...',false,8,'23-23-2254896',14.95,'../Recursos/silm.png','1977-09-03',0),

('014SLA','El señor de los anillos I: La comunidad del anillo','J.R.R. Tolkien','Desconocido',6,544,'Con el objetivo
 de poner al alcance de todos la gran obra de Tolkien, presentamos La trilogía de El Señor de los Anillos en una
 edición más amable y atractiva. Sin duda, el nuevo formato, la encuadernación en cartoné y las innovadoras 
cubiertas harán las delicias tanto de los coleccionistas como de aquellos que se acerquen a Tolkien y a El
 Señor de los Anillos por primera vez.',false,8,'22-23-2258496',17.95,'../Recursos/ESLAI.png.png','1954-07-24',4),

('015SLA','El señor de los anillos II: Las dos torres','J.R.R. Tolkien','Desconocido',6,480,'La Compañía se ha 
disuelto y sus integrantes emprenden caminos separados. Frodo y Sam continúan solos su viaje a lo largo del río
 Anduin, perseguidos por la sombra misteriosa de un ser extraño que también ambiciona la posesión del Anillo. 
Mientras, hombres, elfos y enanos se preparan para la batalla final contra las fuerzas del Señor del Mal.',false,8,'22-23-2258497',17.95,'../Recursos/ESLAII.png','1956-07-24',4),

('016SLA','El señor de los anillos III: El retorno del rey','J.R.R. Tolkien','Desconocido',6,520,'Ningún escritor del 
género ha aprovechado tanto como Tolkien las propiedades características de la Misión, el viaje heroico, el Objeto
 Numinoso, satisfaciendo nuestro sentido de la realidad histórica y social... Tolkien ha triunfado donde fracasó 
Milton. -- W. H. Auden Ecologista avant-la-lettre, Tolkien adora los árboles, los cielos, los ríos, la luz. 
-- Marie Claude de Brunhoff',false,8,'22-23-2258498',16.95,'../Recursos/ESLAIII.png','1958-07-24',5),

('017HPP','Harry Potter y la piedra filosofal','J.K. Rowling','Desconocido',3,256,'Harry Potter se ha quedado 
huérfano y vive en casa de sus abominables tíos y el insoportable primo Dudley. Harry se siente muy triste y solo,
 hasta que un buen día recibe una carta que cambiará su vida para siempre. En ella le comunican que ha sido aceptado
 como alumno en el Colegio Hogwarts de Magia. A partir de ese moment o, la suerte de Harry da un vuelco espectacular.
 En esa escuela tan especial aprenderá encantamientos, trucos fabulosos y tácticas de defensa contra las malas artes.
 Se convertirá en el campeón escolar de quidditch, especie de fútbol aéreo que se juega montado sobre escobas, y hará
 un puñado de buenos amigos... aunque también algunos temibles enemigos. Pero, sobre todo, conocerá los secretos
 que le permitirán cumplir con su destino. Pues, aunque no lo parezca a primera vista, Harry no es un chico normal
 y corriente: ¡es un verdadero mago!',false,2,'51-23-2258490',18.95,'../Recursos/HPPI.png','1997-06-26',5),

('018HPP','Harry Potter y la cámara secreta','J.K. Rowling','Desconocido',3,288,'Tras derrotar una vez más a lord 
Voldemort, su siniestro enemigo en Harry Potter y la piedra filosofal, Harry espera impaciente en casa de sus 
insoportables tíos el inicio del segundo curso del Colegio Hogwarts de Magia. Sin embargo, la espera dura poco,
 pues un elfo aparece en su habitación y le advierte que una amenaza mo rtal se cierne sobre la escuela. Así pues,
 Harry no se lo piensa dos veces y, acompañado de Ron, su mejor amigo, se dirige a Hogwarts en un coche volador. 
Pero ¿puede un aprendiz de mago defender la escuela de los malvados que pretenden destruirla? Sin saber que alguien
 ha abierto la Cámara de los Secretos, dejando escapar una serie de monstruos peligrosos, Harry y sus amigos Ron y
 Hermione tendrán que enfrentarse con arañas gigantes, serpientes encantadas, fantasmas enfurecidos y, sobre todo,
 con la mismísima reencarnación de su más temible adversario.',false,2,'51-23-2258491',18.95,'../Recursos/HPPII.png','1998-07-02',5),

('019HPP','Harry Potter y el prisionero de Azkaban','J.K. Rowling','Desconocido',3,360,'Igual que en las dos primeras
 partes de la serie, Harry aguarda con impaciencia el inicio del tercer curso en el Colegio Hogwarts de Magia. 
Tras haber cumplido los trece años, solo y lejos de sus amigos, Harry se pelea con su bigotuda tía Marge, a la
 que convierte en globo, y debe huir en un autobús mágico. Mientras tanto, de la prisión de Azkaban se ha escapado
 un terrible villano, Sirius Black, un asesino en serie con poderes mágicos que fue cómplice de lord Voldemort y
 que parece dispuesto a borrar a Harry del mapa. Y por si esto fuera poco, Harry deberá enfrentarse también a unos
 terribles monstruos, los dementores, seres abominables capaces de robarles la felicidad a los magos y de eliminar
 todo recuerdo hermoso de aquellos que osan mirarlos. Lo que ninguno de estos malvados personajes sabe es que Harry,
 con la ayuda de sus fieles amigos Ron y Hermione, es capaz de todo y mucho más.',false,2,'51-23-2258492',18.95,'../Recursos/HPPIII.png','1999-07-08',5),

('020HPP','Harry Potter y el cáliz de fuego','J.K. Rowling','Desconocido',3,640,'Tras otro abominable verano con los 
Dursley, Harry se dispone a iniciar el cuarto curso en Hogwarts, la famosa escuela de magia y hechicería. 
A sus catorce años, a Harry le gustaría ser un joven mago como los demás y dedicarse a aprender nuevos sortilegios,
 encontrarse con sus amigos Ron y Hermione y asistir con ellos a los Mundiales de quidditch. Sin embargo, al llegar
 al colegio le espera una gran sorpresa que lo obligará a enfrentarse a los desafíos más temibles de toda su vida. 
Si logra superarlos, habrá demostrado que ya no es un niño y que está preparado para vivir las nuevas y emocionantes
 experiencias que el futuro le depara.',false,2,'51-23-2258493',18.95,'../Recursos/HPPIV.png','2000-07-08',5),

('021HPP','Harry Potter y la orden del Fénix','J.K. Rowling','Desconocido',3,896,'Las tediosas vacaciones en casa de 
sus tíos todavía no han acabado y Harry Potter se encuentra más inquieto que nunca. Apenas ha tenido nocitias de Ron
 y Hermiones, y presiente que algo extraño está sucediendo en Hogwarts. En efecto, cuando por fin comienza otro curso
 en el famoso colegio de magia y hechicería, sus temores se vuelven realidad. El Ministerio de Magia niega que 
Voldemort haya regresado y ha iniciado una campaña de desprestigio contra Harry Potter y Dumbledore, para lo cual
 ha asignado a la horrible profesora Dolores Umbridge la tarea de vigilar todos sus movimientos. Así pues, además
 de sentirse solo e incomprendido, Harry sospecha que Voldemort puede adivinar sus pensamientos, e intuye que el 
temible mago trata de apoderarse de un objeto secreto que le permitiría recuperar su poder destructivo.',false,2,'51-23-2258494',18.95,'../Recursos/HPPV.png','2003-06-21',5),

('022HPP','Harry Potter y el misterio del príncipe','J.K. Rowling','Desconocido',3,608,'Con dieciséis años cumplidos, 
Harry Potter inicia el sexto curso en Hogwarts en medio de terribles acontecimientos que asolan Inglaterra. Elegido
 capitán del equipo de Quidditch, los entrenamientos, los exámenes y las chicas ocupan todo su tiempo, pero la 
tranquilidad dura poco. A pesar de los férreos controles de seguridad que protegen la escuela, dos alumnos son 
brutalmente atacados. Dumbledore sabe que se acerca el momento, anunciado por la Profecía, en que Harry Potter 
y Voldemort se enfrentarán a muerte: «El único con poder para vencer al Señor Tenebroso se acerca... Uno de los
 dos debe morir a manos del otro, pues ninguno de los dos podrá vivir mientras siga el otro con vida.». El anciano
 director solicitará la ayuda de Harry y juntos emprenderán peligrosos viajes para intentar debilitar al enemigo,
 para lo cual el joven mago contará con la ayuda de un viejo libro de pociones perteneciente a un misterioso príncipe,
 alguien que se hace llamar Príncipe Mestizo.',false,2,'51-23-2258495',18.95,'../Recursos/HPPVI.png','2005-07-16',5),

('023HPP','Harry Potter y las reliquias de la muerte','J.K. Rowling','Desconocido',3,640,'Harry Potter tiene que 
realizar una tarea siniestra, peligrosa y aparentemente imposible: el de localizar y de destruir a Horcruxes. 
Harry nunca se sintió tan sólo ni se enfrentó a un futuro tan incierto. Pero Harry Potter debe encontrar la 
fuerza necesaria para terminar la tarea que le han dado. Él debe dejar el calor, la seguridad y el compañerismo
 de La Madriguera y seguir sin miedo el camino inexorable marcado para él. En este final, la séptima entrega de
 la serie Harry Potter, J.K. Rowling revela de manera espectacular las respuestas a las muchas preguntas que se
 han estado esperando con tanta impaciencia. Su rica prosa y su narrativa, llena de giros inesperados, han hecho
 que estos libros sean libro para leer y releer una y otra vez.',false,2,'51-23-2258496',18.95,'../Recursos/HPPVII.png','2007-07-21',5);
