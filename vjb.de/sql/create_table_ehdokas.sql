CREATE TABLE ehdokas(
   ehdokas_id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
   ehdokas_sukupuoli varchar(50) NOT NULL DEFAULT 'nulli',
   ehdokas_ika int(4) NOT NULL DEFAULT '1984',
   ehdokas_suku varchar(255) NOT NULL DEFAULT 'Dinh',
   ehdokas_etu varchar(255) NOT NULL DEFAULT 'Duc',
   ehdokas_osoite varchar(255) NOT NULL DEFAULT 'Ansatie 2',
   ehdokas_kaupunki varchar(255) NOT NULL default 'vantaa',
   ehdokas_puh varchar(20) NOT NULL DEFAULT '+358445206766',
   ehdokas_sposti varchar(255) NOT NULL default 'duc.dinh@haaga-helia.fi',
   ehdokas_tutkinto varchar(255) NOT NULL DEFAULT 'lukio',
   ehdokas_kielitaito varchar(255) NOT NULL,
   ehdokas_itsetieto varchar(255),
   ehdokas_kokemus INTEGER(2) DEFAULT 0
   
 );
 
  ALTER TABLE ehdokas ADD FOREIGN KEY (kayttaja_id) REFERENCES kayttaja(kayttaja_id);
  alter table ehdokas add column ehdokas_kansalaisuus varchar(255) not null;