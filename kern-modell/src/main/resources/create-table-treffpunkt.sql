CREATE TABLE TREFFPUNKT (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  bezeichnung varchar(255) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY (bezeichnung)
)