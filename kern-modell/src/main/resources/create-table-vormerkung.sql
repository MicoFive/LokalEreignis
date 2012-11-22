create table vormerkung (
         id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
         bezeichnung VARCHAR(100) NOT NULL,
         zeitpunkt DATETIME,
         treffpunkt VARCHAR(255)
       );