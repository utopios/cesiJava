CREATE TABLE customer
(
    id int primary key auto_increment(),
    firstName varchar(100) not null,
    lastName varchar(100) not null,
    phone varchar(10) not null
);

CREATE TABLE hotel
(
    id int primary key auto_increment(),
    name varchar(100) not null,
);
CREATE TABLE reservation
(
    id int primary key auto_increment(),
    status varchar(100) not null,
    hotel_id int not null,
    customer_id int not null
);

CREATE TABLE reservation_room
(
    id int primary key auto_increment(),
    reservation_id int not null,
    room_id int not null,
);

CREATE TABLE room
(
    id int primary key auto_increment(),
    status varchar(100) not null,
    price decimal not null,
    capacity int not null,
    hotel_id int not null
);
