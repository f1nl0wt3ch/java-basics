CREATE TABLE tutkinto(
tutkinto_id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
tutkinto_nimi varchar(255) NOT NULL DEFAULT 'none'
);

INSERT INTO tutkinto(tutkinto_nimi) VALUES('p�iv�koti'),('peruskoulu'),('lukio'),('ammattikoulu'),('AMK'),('yliopisto');
