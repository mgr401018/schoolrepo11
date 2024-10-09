select * from about_joins.ingredient;

select	i.id, i.name as "Име", c.name as "Цвят",
	cat.name as "Тип продукт", t.name as "Вкус",
	it.intensity as "Сила на вкуса", u.name as "Мярка"
from about_joins.ingredient as i 
--left outer 
join about_joins.color as c 
              on c.id = i.color_id
 --left outer 
 join about_joins.category as cat 
              on cat.id = i.category_id 
 --left outer 
 join about_joins.taste as t 
              on t.id = i.taste_id 
 --left outer 
 join about_joins.intensity as it 
              on it.id = i.intensity_id 
 --left outer 
 join about_joins.unit as u 
              on u.id = i.unit_id
 order by "Тип продукт";
 
insert into about_joins.dish_recipe (id, name, instructions)
values
(100, 'Таратор', 'Нарежете, разбъркайте, сипете');

insert into about_joins.recipe_ingredient (dish_id, ingredient_id, quantity, notes)
values
(100, 10, 1, ''), --'' or null
(100, 3, 1, "Внимавай да не прекалиш"),
(100, 9, 1, null),
(100, 8, 1, null),
(100, 4, 2, null);

select * from about_joins.recipe_ingredient;
select i.name, u.name, ri.quantity from about_joins.dish_recipe as dr
	left join about_joins.recipe_ingredient ri
	on dr.id = ri.dish_id
	left join about_joins.ingredient i 
	on i.id = ri.ingredient_id 
	left join about_joins.unit as u
	on u.id = i.unit_id