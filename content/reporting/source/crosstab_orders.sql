select
	o.customer_id as orders_master_data@customer_id,
	month(o.date_) as orders_dynamic_header@header_id,
	sum(o.amount) as "amount"
from sales_order o
where o.date_ >= ${start_date} and o.date_ <= ${end_date}
and o.customer_id in (${orders_master_data@customer_id})
and month(o.date_) in (${orders_dynamic_header@header_id})
group by o.customer_id, month(o.date_)
order by o.customer_id, month(o.date_)