create table LIBRARY_COUNTRY (
  ID varchar(36) not null,
  CREATE_TS time,
  CREATED_BY varchar(50),
  NAME varchar(100) not null,
  primary key (ID)
)^

alter table LIBRARY_TOWN add column COUNTRY_ID varchar(36) ^
alter table LIBRARY_TOWN add constraint FK_LIBRARY_TOWN_COUNTRY_ID foreign key (COUNTRY_ID) references LIBRARY_COUNTRY(ID)^
create index IDX_LIBRARY_TOWN_COUNTRY on LIBRARY_TOWN (COUNTRY_ID)^