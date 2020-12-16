drop table if exists `user_topic`;

create table `user_topic`(
id bigint auto_increment primary key,
user_id bigint not null,
topic_name varchar(200),
create_time bigint not null,
foreign key(user_id) references user(id)
)engine=InnoDB default character set = utf8;
