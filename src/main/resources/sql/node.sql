create database if not exists myblog;

use myblog;

drop table  if exists t_node;

create table t_node(
    host char(128) primary key,
    agent char(128),
    times int,
    lastimes DATETIME,
    address char(128)
);

