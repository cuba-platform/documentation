select c from ref_Colour c
where c.name like :(?i)custom$searchString or c.description like :(?i)custom$searchString escape '\'