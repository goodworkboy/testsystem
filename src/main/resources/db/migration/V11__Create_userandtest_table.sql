drop table if exists `userandtest`;

create table `userandtest`(
id bigint auto_increment primary key,
user_id bigint not null,
test_id bigint not null,
create_time bigint not null,
modify_time bigint not null,
status boolean default false,
start_time bigint,
end_time bigint,
score int,
foreign key(user_id) references user(id),
foreign key(test_id) references test(id)
)engine=InnoDB default character set = utf8;