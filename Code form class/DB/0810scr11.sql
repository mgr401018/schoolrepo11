--subqueries

select * from category c;

select * from
(select "Produkti", "Merna edinica", c."name",
		(select name from about_joins.unit where id = t.category_id) as demo
from 
(
	select product_name as "Produkti", unit as "Merna edinica", category_id 
	from public.products 
	where category_id --= 3
	in (select 3 union (select 5))
) as t 
join about_joins.category as c on c.id = t.category_id) as q 
order by demo desc
--limit 3;

--where exists (select from about_joins.unit where id = category_id)

--agregations

select sum(quantity) as total_pieces, count(*) as item_types_count, array_agg(p.product_name) --string_agg(p.product_name, E'\n')
from public.order_details od
inner join public.products p on od.product_id = p.product_id
where order_id = 10250; --count -> * means whatever