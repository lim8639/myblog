
create database if not exists myblog;

use myblog;

# create the table of user.
create table if not exists  t_user(
    id  int primary key auto_increment,
    username char(32) not null ,
    password char(64) not null ,
    email char(64) ,
    chatqq  char(64),
    cover text,
    petname char(64)
);

# drop table if exists t_node;
# create table if not exists t_node(
#                                      token char(128) primary key ,
#                                      host char(128) ,
#                                      agent nvarchar(500),
#                                      times int  default 1,
#                                      lastimes DATETIME,
#                                      address char(128),
#                                      mark char(250)
# );
# INSERT INTO t_node (token,mark) VALUES ('IUzI1NiJ9','广西-辉');
# INSERT INTO t_node (token,mark) VALUES ('eyJhdWQiO','海南-坚');
# INSERT INTO t_node (token,mark) VALUES ('NjEyMzIzO','山东-1');
# INSERT INTO t_node (token,mark) VALUES ('YXQiOjE2f','山东-2');
# INSERT INTO t_node (token,mark) VALUES ('JhbGciOiJ','广西-文');
# INSERT INTO t_node (token,mark) VALUES ('hbGciOiJI','我');
# INSERT INTO t_node (token,mark) VALUES ('wiZXhwIjo','备用');

# The table of markdown
create  table if not exists t_markdown(
                                          id int  primary key auto_increment,
                                          userId int references t_user(id),
                                          title char(64) not null,
                                          fristTime datetime not null,
                                          cover nvarchar(1000) not null ,
                                          updateTime datetime default null,
                                          authority int default 0,
                                          content  text not null
);