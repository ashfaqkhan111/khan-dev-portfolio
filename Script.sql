USE basis_data_2;
show table prodi;

CREATE TABLE prodi (
		prodi_id int unsigned auto_increment,
		prodi_code varchar(10) not null,
		prodi_name varchar (225) not null,
		
		primary key (prodi_id),
		unique key unique_prodi (prodi_code)
		) engine=InnoDB default CHARSET=utf8mb4;