CREATE TABLE Banda(
  id serial,
  nome varchar(256) NOT NULL,
  localDeOrigem varchar(256) NOT NULL,
  PRIMARY KEY(id)
);

CREATE TABLE integrantes(
  id serial,
  nome varchar(256),
  banda int NOT NULL,
  PRIMARY KEY(id),
  FOREIGN KEY(banda) REFERENCES Banda(id)
);

CREATE TABLE Estilo(
  id serial,
  nome varchar(10) NOT NULL,
  PRIMARY KEY(id)
);

CREATE TABLE Album(
  id  serial,
  banda int NOT NULL,
  estilo int NOT NULL,
  anoDeLancamento date NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY(banda) REFERENCES Banda(id),
  FOREIGN KEY(estilo) REFERENCES Estilo(id)
);