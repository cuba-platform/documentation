-- add column for "address" attribute
alter table SEC_USER add column ADDRESS varchar(100)
^
-- add discriminator column required for entity inheritance
alter table SEC_USER add column DTYPE varchar(100)
^
-- set discriminator value for existing records
update SEC_USER set DTYPE = 'sales_ExtUser' where DTYPE is null
^