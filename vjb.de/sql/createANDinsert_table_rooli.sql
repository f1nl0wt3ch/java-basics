CREATE TABLE rooli(
      rooli_id INTEGER NOT NULL PRIMARY KEY,
      rooli_nimi varchar(255) NOT NULL
);

INSERT INTO rooli(rooli_id, rooli_nimi) VALUES(1,"yllapitaja");
INSERT INTO rooli(rooli_id, rooli_nimi) VALUES(2,"partneri");
INSERT INTO rooli(rooli_id, rooli_nimi) VALUES(3,"ehdokas");