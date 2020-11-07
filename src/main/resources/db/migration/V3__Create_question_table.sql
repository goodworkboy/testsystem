drop table if exists `question`;

create table `question`(
id bigint auto_increment primary key,
head varchar(200) not null,
answerA varchar(200) not null,
answerB varchar(200) not null,
answerC varchar(200) not null,
answerD varchar(200) not null,
answer char(1) not null,
status boolean default false not null
)engine=InnoDB default character set = utf8;