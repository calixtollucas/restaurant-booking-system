CREATE TABLE tbl_table (
  id VARCHAR(255) NOT NULL,
   numero VARCHAR(255) NOT NULL,
   num_cadeiras INT NOT NULL,
   booking_id VARCHAR(255),
   CONSTRAINT pk_tbl_table PRIMARY KEY (id),
   CONSTRAINT FK_TBL_TABLE_ON_BOOKING FOREIGN KEY (booking_id) REFERENCES booking (id)
);