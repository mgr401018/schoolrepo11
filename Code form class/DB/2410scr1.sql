create table unit (
	unit_id int primary key, unit_name text not null, misc jsonb default '{}' not null
);

insert into unit(unit_id, unit_name) values
	(1, 'broi'),
	(2, 'gram'),
	(3, 'liter'),
	(4, 'meter');

alter table product add column unit_id int not null references unit(unit_id);

create table inventory (inv_id int primary key, product_id int references product(product_id),
quantity numeric, inv_date date, misc jsonb default '{}' not null);


create table transactions (
	transaction_id int primary key,
	transaction_type int,
	transaction_date date,
	transaction_product_id int references product(product_id),
	transaction_quantity numeric,
	misc jsonb default '{}' not null
);

create table write_off (
	 write_off_id int primary key,
	 write_off_date date,
	 write_off_product_id int references product(product_id),
	 write_off_quantity numeric,
	 misc jsonb default '{}' not null
	
);

alter table transactions alter column transaction_type type boolean using transaction_type is not null;

