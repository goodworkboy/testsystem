drop table if exists `test`;

create table `test`(
	id bigint auto_increment primary key,
	name varchar(20) not null,
	create_time bigint not null,
	modify_time bigint not null,
	start_time bigint not null,
	end_time bigint not null,
	status boolean default false not null,
	paper_id bigint not null,
	foreign key(paper_id) references paper(id)
)engine=InnoDB default character set = utf8;

