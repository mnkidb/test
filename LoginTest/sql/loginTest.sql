drop database if exists logindb;
create database logindb;
use logindb;

create table user_info(
	user_id int primary key auto_increment,
	user_name varchar(255),
	user_pass varchar(255)
);

insert into user_info values(1,"taro","123");
insert into user_info values(2,"jiro","456");
insert into user_info values(3,"hanako","789");

create table inquiry(
	name varchar(255),
	qtype varchar(255),
	body varchar(255)
);

