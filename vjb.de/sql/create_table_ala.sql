CREATE TABLE ala(
ala_id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
ala_nimi varchar(255) NOT NULL DEFAULT 'none'
);

INSERT INTO ala(ala_nimi) VALUES('varasto'),('IT'),('talous'),('kauppa');