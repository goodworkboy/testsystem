drop table if exists `paperandques`;

create table `paperandques`(
paperid bigint not null,
questionid bigint not null,
foreign key(paperid) references paper(id),
foreign key(questionid) references question(id)
)engine=InnoDB default character set = utf8;