drop database if exists mp2;

create database mp2;

use mp2;

create table account(
    username VARCHAR(30) primary key,
    password VARCHAR(30),
    user_role text check (user_role in ('admin','super_admin', 'guest'))
);

create table post(
    title VARCHAR(30),
    content text(200),
    id int auto_increment primary key
);

create table posts(
    user_name VARCHAR(30),
    post1 int,
    post2 int,
    post3 int,
    post4 int,
    post5 int,
    foreign key (user_name) references account(username),
    foreign key (post1) references post(id),
    foreign key (post2) references post(id),
    foreign key (post3) references post(id),
    foreign key (post4) references post(id),
    foreign key (post5) references post(id)
);


