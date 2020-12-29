CREATE TABLE partneri(
   partneri_id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
   partneri_nimi varchar(255) NOT NULL DEFAULT 'Transval Oy',
   partneri_osoite varchar(255) NOT NULL DEFAULT 'Mikkola 2, Korso',
   partneri_puh varchar(255) NOT NULL DEFAULT '+358447652364',
   partneri_websivu varchar(255) DEFAULT 'www.google.fi',
   partneri_sposti varchar(255) NOT NULL DEFAULT 'transval@transval.fi'
);

ALTER TABLE partneri ADD FOREIGN KEY (kayttaja_id) REFERENCES kayttaja(kayttaja_id);

or

ALTER TABLE partneri ADD CONSTRAINT fk_kayttaja FOREIGN KEY (kayttaja_id) REFERENCES kayttaja(kayttaja_id);

insert into partneri(fk_kayttaja_id) values (11);