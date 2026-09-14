create table university (
	university_id serial primary key,
	university_name varchar(150) not null,
	email varchar(150),
	phone varchar(30),
	address text,
	country varchar(100),
	website varchar(255)
);

create table company(
	company_id serial primary key,
	company_name varchar(150) not null,
	description text,
	industry varchar(100),
	email varchar(150),
	phone varchar(30),
	website varchar(255),
	address text
);

create table location (
	location_id serial primary key,
	country varchar(100) not null,
	city varchar(100) not null,
	address text
);

create table skill (
skill_id serial primary key,
skill_name varchar(100) not null,
description text
);

create table "user" (
	user_id serial primary key,
	email varchar(150) not null unique,
	password varchar(255) not null,
	role varchar(30) not null,
	created_at timestamp default current_timestamp
);

create table student (
	student_id serial primary key,
	user_id int not null unique,
	student_number varchar(50),
	full_name varchar(150) not null,
	phone varchar(30),
	university_id int not null,
	major varchar(100),
	semester int,
	gpa decimal(3,2),
	cv_url varchar(225),

	constraint fk_student_user foreign key (user_id) references "user"(user_id),
	constraint fk_student_uiversity foreign key (university_id) references university(university_id)
);

create table internship (
	internship_id serial primary key,
	company_id int not null,
	title varchar(150) not null,
	description text,
	work_type varchar(50),
	start_date date,
	end_date date,
	application_deadline date,
	number_of_position int,
	status varchar(30),
	created_at timestamp default current_timestamp,
	location_id int,

	constraint fk_internship_company foreign key (company_id) references company(company_id),
	constraint fk_internship_location foreign key (location_id) references location(location_id)
);

create table student_skill (
	student_id int not null,
	skill_id int not null,
	skill_level varchar(50),
	
	primary key (student_id, skill_id),
	constraint fk_student_skill_student foreign key (student_id) references student(student_id) on delete cascade,
	constraint fk_student_skill_skill foreign key (skill_id) references skill(skill_id) on delete cascade
);

create table internship_skill (
	internship_id int not null,
	skill_id int not null,
	required_level varchar(50),
	id_required boolean default false,
	
	primary key (internship_id, skill_id),

	constraint fk_internship_skill_internship foreign key (internship_id) references internship(internship_id) on delete cascade,
	constraint fk_internship_skill_skill foreign key (skill_id) references skill(skill_id) on delete cascade
);

create table application (
	application_id serial primary key,
	student_id int not null,
	internship_id int not null,
	applied_at timestamp default current_timestamp,
	status varchar(30),
	cover_latter text,

	constraint fk_application_student foreign key (student_id) references student(student_id) on delete cascade,
	constraint fk_application_internship foreign key (internship_id) references internship(internship_id) on delete cascade,

	constraint unique_student_internship unique (student_id, internship_id)
);
