--select "млечни продукти", "мерна единица", "цена",
--	"цена"/(select avg(price)::numeric(20, 2) from public.products) as "скъпо ли е"
--from about_joins.del_me
--as q
--order by "млечни продукти" desc
--limit 4;

--view vtable

--create or replace view about_joins.del_me as
--	select * from 
--	(
--	select product_id, product_name as "млечни продукти", unit as "мерна единица",
--		price as "цена", category_id as "категория"
--	from (select * from public.products) as p
--	--where category_id = 4
--	) as daip
--	join (select * from public.categories) as c on c.category_id = daip."категория";


--drop table public.categories; --err because del_me relies on categories
--drop table public.categories cascade; --NEVER RUN (with exceptions) DROPS ALL DEPENDANTS

with del_me_Local as( --common table expression
select * from 
	(
	select product_id, product_name as "млечни продукти", unit as "мерна единица",
		price as "цена", category_id as "категория"
	from (select * from public.products) as p
	--where category_id = 4
	) as daip
	join (select * from public.categories) as c on c.category_id = daip."категория"
),
avg_price(p) as (select avg(price)::numeric(20, 2) from public.products)

select "млечни продукти", "мерна единица", "цена",
	"цена"/(select p from avg_price) as "скъпо ли е"
	
from del_me_Local
as q
order by "млечни продукти" desc
limit 4;
