CREATE TABLE Banda(
  id serial,
  nome varchar[256] NOT NULL,
  localDeOrigem varchar[256] NOT NULL,
  PRIMARY KEY(id)
);

CREATE TABLE integrantes(
  id serial,
  integrante varchar[256],
  PRIMARY KEY(id)
);

CREATE TABLE Estilo(
  id serial,
  nome varchar[10] NOT NULL,
  PRIMARY KEY(id)
);

CREATE TABLE Album(
  id  serial,
  banda serial NOT NULL,
  estilo serial NOT NULL,
  anoDeLancamento date NOT NULL,
  PRIMARY KEY (id),
  FOREGEIN KEY(banda) FROM Banda(id),
  FOREGEIN KEY(estilo) FROM Estilo(id)
);