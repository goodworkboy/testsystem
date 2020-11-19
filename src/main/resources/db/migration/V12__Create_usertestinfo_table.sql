drop table if exists `usertestinfo`;

create table `usertestinfo`(
user_id bigint not null,
test_id bigint not null,
question_id bigint not null,
create_time bigint not null,
modify_time bigint not null,
status boolean default false,
user_answer char(1),
score int default 0,
primary key(user_id,test_id,question_id),
foreign key(user_id) references user(id),
foreign key(test_id) references test(id),
foreign key(question_id) references question(id)
)engine=InnoDB default character set = utf8;
