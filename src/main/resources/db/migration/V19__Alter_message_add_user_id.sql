alter table `message` add column `user_id` bigint not null; 
alter table `message` add foreign key (user_id) references user(id);