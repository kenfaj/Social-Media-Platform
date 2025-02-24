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

create table follows(
    user_name VARCHAR(30),
    follow1 VARCHAR(30),
    follow2 VARCHAR(30),
    follow3 VARCHAR(30),
    foreign key (user_name) references account(username),
    foreign key (follow1) references account(username),
    foreign key (follow2) references account(username),
    foreign key (follow3) references account(username)
);

-- Insert sample values into the account table
INSERT INTO account (username, password, user_role) VALUES 
('superadmin', 'superpassword', 'super_admin'),
('admin1', 'password1', 'admin'),
('admin2', 'password2', 'admin'),
('guest1', 'password3', 'guest'),
('guest2', 'password4', 'guest'),
('guest3', 'password5', 'guest');

-- Insert sample follows, e.g.:
-- Guest1 is followed by Guest2 and Guest3
-- Guest2 is followed by Guest1 and Guest3
-- Guest3 is followed by Guest1 and Guest2
INSERT INTO follows (user_name, follow1, follow2, follow3) VALUES 
('guest1', 'guest2', 'guest3', null),
('guest2', 'guest1', 'guest3', null),
('guest3', 'guest1', 'guest2', null);

-- Insert sample posts for each guest
INSERT INTO post (title, content) VALUES 
('First Post - Guest1', 'This is the first post of guest1'),
('Second Post - Guest1', 'This is the second post of guest1'),
('Third Post - Guest1', 'This is the third post of guest1'),
('First Post - Guest2', 'This is the first post of guest2'),
('Second Post - Guest2', 'This is the second post of guest2'),
('Third Post - Guest2', 'This is the third post of guest2'),
('First Post - Guest3', 'This is the first post of guest3');

-- Map the posts to the guests
INSERT INTO posts (user_name, post1, post2, post3) VALUES 
('guest1', 1, 2, 3),
('guest2', 4, 5, null),
('guest3', 7, null, null);

