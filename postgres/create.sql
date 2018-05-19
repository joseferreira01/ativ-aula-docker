
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

CREATE TABLE Album(
  id  serial,
  nome VARCHAR(100),
  banda int NOT NULL,
  estilo VARCHAR(100 ) NOT NULL,
  anoDeLancamento date NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY(banda) REFERENCES Banda(id)
  
)