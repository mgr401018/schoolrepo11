--select * from categories where category_name = 'Seafood'; 
-- TODO: look at collation

select *, 'The city of ' || city as "City ""as is""", customer_name 
from customers 
where country = 'USA' 
order by city, customer_name; -- Can be "City ""as is""", if repeating in order 1 do order 2

-- "City" -> City 
-- City -> city

update customers set postal_code = '999999', address = null 
where city = 'Portland'

select * from customers 
where address is null; -- is null !!! not = null 

begin transaction; --if not -> autotransaction mode -> no rollback

delete from customers
where address is null;

rollback;