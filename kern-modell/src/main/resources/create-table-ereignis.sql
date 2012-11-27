create table ereignis (
         id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
         treffpunkt_id BIGINT,
         bezeichnung VARCHAR(120) NOT NULL
);