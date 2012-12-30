CREATE TABLE ZEITPUNKT (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  bezeichnung varchar(255) NOT NULL,
  datum date NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY (bezeichnung),
  UNIQUE KEY (datum)
)