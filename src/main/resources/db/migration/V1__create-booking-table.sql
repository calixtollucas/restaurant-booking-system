CREATE TABLE booking (
  id VARCHAR(255) NOT NULL PRIMARY KEY,
   reservante VARCHAR(255) NOT NULL,
   num_pessoas INT NOT NULL,
   data DATE NOT NULL,
   hora TIME NOT NULL,
);