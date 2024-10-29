-- (optional) view postgres create database documentation

create table category (
	category_id integer generated always as identity primary key,
	category_name text not null,
	category_description text,
	misc json default '{}'
);

create table product (
	product_id integer generated always as identity primary key,
	product_name text not null,
	product_description text,
	product_price numeric,
	product_category integer references category(category_id)
);

