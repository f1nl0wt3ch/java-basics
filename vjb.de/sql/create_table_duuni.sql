CREATE TABLE duuni (
duuni_id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
duuni_nimi varchar(255) NOT NULL,
duuni_julkaistupv TIMESTAMP NOT NULL DEFAULT now(),
duuni_erapv TIMESTAMP;
duuni_tiedot text not null,
duuni_vaatimus text not null,
duuni_paikka varchar(10) NOT NULL DEFAULT 'Suomi',
duuni_palkka varchar(255) NOT NULL DEFAULT 'suostua'
);

alter table duuni modify column duuni_julkaistupv timestamp  not null default now();

alter table duuni modify column duuni_julkaistupv date  not null default CURRENT_DATE();
