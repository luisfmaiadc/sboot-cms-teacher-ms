CREATE TABLE instrutor (
  id INT GENERATED ALWAYS AS IDENTITY,
  nome VARCHAR(50) NOT NULL,
  sobrenome VARCHAR(50) NOT NULL,
  genero CHAR(1) NOT NULL,
  email VARCHAR(75) NOT NULL,
  data_cadastro TIMESTAMP NOT NULL,
  ativo BOOLEAN NOT NULL,
  PRIMARY KEY (id)
  );