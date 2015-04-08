create database struts;
use struts;
create table user(
	id varchar(100) primary key,
	username varchar(100) not null unique,
	nick varchar(100),
	password varchar(100),
	sex varchar(10),#0 女 1 男
	birthday date,
	education varchar(100),#研究生 本科 专科
	telephone varchar(100),
	hobby varchar(100),#体育，旅游，吃饭
	path varchar(100),#长传文件存储路径
	filename varchar(100),#uuid_oldfilename.jpeg
	remark varchar(255)
);