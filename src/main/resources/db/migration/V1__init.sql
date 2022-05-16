CREATE TABLE IF NOT EXISTS Vehiculo(
  id SERIAL,
      Placa VARCHAR (7) NOT NULL,
      Marca VARCHAR (10) NOT NULL,
      Edad VARCHAR (100) NOT NULL,
      PRIMARY KEY (id)
);

