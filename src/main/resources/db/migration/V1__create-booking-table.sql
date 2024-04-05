CREATE TABLE booking (
  id VARCHAR(255) NOT NULL,
   reservante VARCHAR(255) UNIQUE NOT NULL,
   num_pessoas INT NOT NULL,
   data date NOT NULL,
   hora time NOT NULL,
   CONSTRAINT pk_booking PRIMARY KEY (id)
);