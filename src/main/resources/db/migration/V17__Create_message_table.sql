drop table if exists `message`;

create table `message`(
id bigint auto_increment primary key,
test_id bigint not null,
message varchar(200),
create_time bigint not null,
status boolean default false,
foreign key(test_id) references test(id)
)engine=InnoDB default character set = utf8;
