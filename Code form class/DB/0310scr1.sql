select order_date, order_id, customer_name from orders as o
inner join customers c --using (customer_id);
on o.customer_id = c.customer_id;

--select * from order_details od 
--where order_id = 10299;

--select * from products p
--where p.price > 3;

--select customer_name, order_id, product_name, quantity, price from orders as o
--inner join customers as c using (customer_id)
--inner join order_details as od using (order_id)
--inner join products as p using (product_id)
--where price > 3 and order_id = 10299;

select customer_name, o.order_id, product_name, quantity, price from orders as o
inner join customers as c on c.customer_id = o.customer_id
inner join order_details as od on od.order_id = o.order_id 
inner join products as pr on pr.product_id = od.product_id
where price > 3 and o.order_id = 10299;

insert into orders (order_id, customer_id, order_date) 
values (33000, 1001, current_date); 

insert into orders (order_id, customer_id, order_date)
values (33001, 1002, current_date - 1);
 
select o.order_date, o.customer_id, o.order_id from orders as o
left outer join customers as c on c.customer_id = o.customer_id
where customer_name is null;

delete from orders 
where order_id in (select o.order_id from orders as o
left outer join customers as c on c.customer_id = o.customer_id
where customer_name is null) --table valued expression ;; (qurey) -> table
returning *;
