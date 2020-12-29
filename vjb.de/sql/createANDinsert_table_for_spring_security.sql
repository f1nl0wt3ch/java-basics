CREATE TABLE rooli(
      rooli_id INTEGER NOT NULL PRIMARY KEY,
      rooli_nimi varchar(255) NOT NULL UNIQUE
);

INSERT INTO rooli(rooli_id, rooli_nimi) VALUES(1,"ROLE_YLLAPITAJA");
INSERT INTO rooli(rooli_id, rooli_nimi) VALUES(2,"ROLE_PARTNERI");
INSERT INTO rooli(rooli_id, rooli_nimi) VALUES(3,"ROLE_EHDOKAS");
 
 CREATE TABLE kayttaja (
  kayttaja_id integer NOT NULL auto_increment PRIMARY KEY,
  kayttaja_tunnus varchar(255) NOT NULL UNIQUE,
  kayttaja_salasana_encrypted varchar(255) NOT NULL,
  kayttaja_enabled tinyint NOT NULL,
  kayttaja_suku varchar(255) default NULL,
  kayttaja_etu varchar(255) default NULL,
  fk_rooli_id integer NOT NULL,
  FOREIGN KEY (fk_rooli_id) REFERENCES rooli(rooli_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE kayttaja_rooli (
  id integer NOT NULL auto_increment PRIMARY KEY,
  fk_kayttaja_id integer NOT NULL,
  fk_rooli_id integer NOT NULL,
  FOREIGN KEY (fk_kayttaja_id) REFERENCES kayttaja(kayttaja_id) ON DELETE NO ACTION ON UPDATE NO ACTION,
  FOREIGN KEY (fk_rooli_id) REFERENCES rooli(rooli_id) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO
	kayttaja (kayttaja_tunnus,kayttaja_salasana_encrypted,kayttaja_enabled, kayttaja_suku, kayttaja_etu, fk_rooli_id)
VALUES
	('admin','e6661f90b3bcb4ec0a83522352405fddbfb03cebce7c37d0e356f4097144613abdef5a0e0dc9ed17',1,'dinh','duc',1),
	('partneri','e6661f90b3bcb4ec0a83522352405fddbfb03cebce7c37d0e356f4097144613abdef5a0e0dc9ed17',1,'partner','test',2),
	('ehdokas','e6661f90b3bcb4ec0a83522352405fddbfb03cebce7c37d0e356f4097144613abdef5a0e0dc9ed17',1,'employee','test',3);

	
INSERT INTO
	kayttaja_rooli
VALUES
	(1,1,1),
	(2,2,2),
	(3,3,3);
