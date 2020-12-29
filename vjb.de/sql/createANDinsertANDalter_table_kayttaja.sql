CREATE TABLE kayttaja(
    kayttaja_id INTEGER NOT NULL AUTO_INCREMENT,
    kayttaja_suku varchar(50) NOT NULL,
    kayttaja_etu varchar(50) NOT NULL,
    kayttaja_sposti varchar(255) NOT NULL,
    kayttaja_tunnus varchar(255) NOT NULL,
    kayttaja_salasana varchar(255) NOT NULL,
    PRIMARY KEY(kayttaja_id)
    );
    
ALTER TABLE kayttaja ADD CONSTRAINT fk_rooli_id FOREIGN KEY (fk_rooli_id) REFERENCES rooli(rooli_id);

ALTER TABLE kayttaja AUTO_INCREMENT = 10;

INSERT INTO kayttaja(kayttaja_tunnus, kayttaja_salasana, fk_rooli_id) VALUES ('admin','123456',1);
INSERT INTO kayttaja(kayttaja_tunnus, kayttaja_salasana, fk_rooli_id) VALUES ('partneri','123456',2);
INSERT INTO kayttaja(kayttaja_tunnus, kayttaja_salasana, fk_rooli_id) VALUES ('ehdokas','123456',3);