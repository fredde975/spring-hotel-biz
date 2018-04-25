DROP TABLE IF EXISTS hotels;
CREATE TABLE hotels (
  id              INT         NOT NULL AUTO_INCREMENT,
  name            VARCHAR(20) NOT NULL,
  classification  VARCHAR(20) NOT NULL,
  open            BIT(1)      NOT NULL,
  PRIMARY KEY (id)
);
