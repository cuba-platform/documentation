create table SALES_CUSTOMER (
  ID varchar(36) not null,
  CREATE_TS timestamp,
  CREATED_BY varchar(50),
  NAME varchar(100),
  ADDRESS varchar(200), -- added column
  primary key (ID)
)