drop table if exists `notice`;

create table `notice`(
id bigint auto_increment primary key,
test_id bigint not null,
reciver_type int not null,
create_time bigint not null,
status boolean default false,
foreign key(test_id) references test(id)
)engine=InnoDB default character set = utf8;
