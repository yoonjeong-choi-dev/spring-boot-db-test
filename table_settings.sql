# create database user
create database SpringBootDBTest default character set utf8;
CREATE USER 'springBootDBTestUser'@'localhost' IDENTIFIED BY 'springBootDBTestPassword';
grant all privileges on SpringBootDBTest.* to 'springBootDBTestUser'@'localhost';
flush privileges;

# create tables
create table user
(
    id          int auto_increment primary key,
    name        varchar(20) not null,
    description varchar(100),
    created_at  datetime default current_timestamp,
    modified_at datetime default current_timestamp on update current_timestamp
) engine = InnoDB
  default character set = utf8;

create table message
(
    id          int auto_increment primary key,
    user_id     int not null,
    content     varchar(100),
    created_at  datetime default current_timestamp,
    modified_at datetime default current_timestamp on update current_timestamp,
    constraint fk_user_id foreign key (user_id) references user (id) on delete restrict on update cascade
) engine = InnoDB
  default character set = utf8;

create table user_relation
(
    follower_id  int not null,
    following_id int not null,
    created_at  datetime default current_timestamp,
    modified_at datetime default current_timestamp on update current_timestamp,
    foreign key (follower_id) references user (id) on delete restrict on update cascade,
    foreign key (following_id) references user (id) on delete restrict on update cascade,
    primary key (follower_id, following_id)
) engine = InnoDB
  default character set = utf8;

# dummy date
insert into user (name, description) value ('admin', 'admin user(for test)');
insert into user (name, description) value ('user1', 'user1 desc');
insert into user (name) value ('user2');

insert into message (user_id, content) value (1, 'admin first message');
insert into message (user_id, content) value (2, 'message from user1');
insert into message (user_id, content) value (3, 'message from user2');

insert into user_relation (follower_id, following_id) value (1,2);
insert into user_relation (follower_id, following_id) value (1,3);
insert into user_relation (follower_id, following_id) value (2,3);