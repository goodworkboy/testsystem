drop table if exists `paper`;

create table `paper`(
id bigint auto_increment primary key,
name varchar(20) not null,
create_time bigint not null,
modify_time bigint not null,
status boolean default false not null
)engine=InnoDB default character set = utf8;