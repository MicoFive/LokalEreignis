CREATE TABLE EREIGNIS (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  bezeichnung varchar(255) NOT NULL,
  zeitpunkt_id bigint(20) NOT NULL,
  treffpunkt_id bigint(20) NOT NULL,
  PRIMARY KEY (id),
  KEY FK_ZEITPUNKT (zeitpunkt_id),
  KEY FK_TREFFPUNKT (treffpunkt_id),
  CONSTRAINT FK_ZEITPUNKT FOREIGN KEY (zeitpunkt_id) REFERENCES ZEITPUNKT (id),
  CONSTRAINT FK_TREFFPUNKT FOREIGN KEY (treffpunkt_id) REFERENCES TREFFPUNKT (id)
)