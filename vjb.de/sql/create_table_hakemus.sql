CREATE TABLE hakemus(
 hakemus_id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
 fk_duuni_id INTEGER NOT NULL,
 fk_ehdokas_id INTEGER NOT NULL,
 hakemus_pv datetime default now(),
 FOREIGN KEY (fk_duuni_id) REFERENCES duuni(duuni_id),
 FOREIGN KEY (fk_ehdokas_id) REFERENCES ehdokas(ehdokas_id)
);

