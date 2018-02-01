select name as name, id as customer_id
from SALES_CUSTOMER
where id in (${selected_customers})