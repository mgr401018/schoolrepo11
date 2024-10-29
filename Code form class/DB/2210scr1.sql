create temporary table the_table (
	person_id integer,
	department_id integer,
	salary numeric
)

insert into the_table values(1, 101, 1680),
(2, 102, 1678),
(3, 103, 1678),
(4, 104, 867),
(5, 103, 1000),
(6, 104, 1678),
(7, 102, 1678),
(8, 102, 3894),
(9, 109, 3676)

select * from the_table;

select person_id, department_id, salary, 
	avg(salary) over by_dept::numeric(12, 2) as depth_avg,
	(salary / avg(salary) over by_dept::numeric(12, 2) * 100)::numeric(3, 0) as pers_relative
from the_table
window by_dept as (partition by department_id); -- comes before oreder by