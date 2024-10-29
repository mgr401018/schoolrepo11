create table teachers (
	teacher_id integer,
	name text,
	email text,
	telephone text
);

create table subjects (
	subject_id integer,
	name text,
	type text
);

create table teachers_subjects (
	teacher_id integer,
	subject_id integer
);

create table school_years (
	year_id integer
);

create table 2024_2025 (
	j int
)