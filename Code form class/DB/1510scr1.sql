--Grouping and Agregation

--select p.product_id, p.product_name, avg(p.price), c.category_name, c.category_id from public.products p
--select round(avg(p.price), 2) as average_price, c.category_name, count(*) as category_count from public.products p
--inner join public.categories c
--using (category_id) --on c.category_id = p.category_id;
--group by category_name;

----

--select sum(category_count) from
--(select round(avg(p.price), 2) as average_price, c.category_name, count(*) as category_count from public.products p
--inner join public.categories c
--using (category_id)
--group by category_name) as t

----

select * from
	(select 
		c.category_name, 
		round(avg(p.price), 2) as average_price, --
		count(*) as category_count, --
		max(p.price) as maxprice --Agregatni funkcii -> ot mnogo - edno
	from public.products p
	inner join public.categories c
	using (category_id)
	group by category_name) as t
where t.average_price >= 30;

--or

select --only agregates and those who appear in "group by" 
	c.category_name, 
	round(avg(p.price), 2) as average_price, --
	count(*) as category_count, --
	max(p.price) as maxprice, --Agregatni funkcii -> ot mnogo - edno
	p.unit
from public.products p
inner join public.categories c
using (category_id)
group by category_name, p.unit;
--having round(avg(p.price), 2) >= 30; --having average_price >= 30;

--agregatnite funkcii preskachat/ignorirat NULL-ovete
select 
	c.category_name, 
	round(avg(p.price), 2) as average_price,
	count(*) as category_count,
	--count(*) filter (where p.price > 10) as expensive_count,
	count(case when p.price > 10 then 1 else null end) as expensive_count,
	max(p.price) as maxprice
from public.products p
inner join public.categories c
using (category_id)
group by category_name;

