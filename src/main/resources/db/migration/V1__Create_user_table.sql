drop table if exists `user`;

create table `user`(
id bigint auto_increment primary key,
name varchar(20) not null,
password varchar(20) not null,
createT bigint not null,
modifiedT bigint not null
)engine=InnoDB default character set = utf8;