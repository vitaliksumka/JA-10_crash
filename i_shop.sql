Drop database i_shop;
create database i_shop char set UTF8;
use i_shop;
select database();

create table user (
		id int not null primary key auto_increment,
		first_name varchar(80) not null,
        last_name varchar(80)  not null,
        email varchar(80) not null,
	    role varchar(80) not null,
        password varchar(80) not null
);

create table product (
		id int not null primary key auto_increment,
        name varchar(255) not null,
        description varchar(255) not null,
        price varchar(50) not null
);

create table bucket (
		id int not null primary key auto_increment,
        user_id int not null,
        product_id int not null,
        purchase_date timestamp,
        constraint user_id_FK foreign key (user_id) references i_shop.user (id) on delete cascade on update restrict,
		constraint product_id_FK foreign key (product_id) references i_shop.user (id) on delete cascade on update restrict
);

select *  from user;
select *  from product;




