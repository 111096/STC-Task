create table users(
id int primary key ,
username VARCHAR(50) not null
);

create table training(
id int primary key ,
username VARCHAR(50) not null
);

create table training_details(
id int primary key ,
user_id int not null,
training_id int not null,
training_date date
);

ALTER TABLE training_details
Add CONSTRAINT user_id_fk FOREIGN KEY (user_id) references users(id) ;

ALTER TABLE training_details
Add CONSTRAINT training_id_fk FOREIGN KEY (training_id) references training (id) ;

insert into users VALUES(1 ,'John Doe');
insert into users VALUES(2 ,'Jane Don');
insert into users VALUES(3 ,'Alice Jones');
insert into users VALUES(4 ,'Lisa Romero');

insert into training VALUES(1 ,'Training1');
insert into training VALUES(2 ,'Training2');
insert into training VALUES(3 ,'Training3');
insert into training VALUES(4 ,'Training4');

insert into training_details VALUES(1, 1, 1, '2015-08-02');
insert into training_details VALUES(2, 2 ,1 ,'2015-08-03');
insert into training_details VALUES(3 ,3 ,2, '2015-08-02');
insert into training_details VALUES(4, 4 ,2 ,'2015-08-04');
insert into training_details VALUES(5 ,2, 2 ,'2015-08-03');
insert into training_details VALUES(6, 1 ,1 ,'2015-08-02');
insert into training_details VALUES(7 ,3, 2 ,'2015-08-04');
insert into training_details VALUES(8 ,4 ,3 ,'2015-08-03');
insert into training_details VALUES(9 ,1, 4 ,'2015-08-03');
insert into training_details VALUES(10, 3, 1, '2015-08-02');
insert into training_details VALUES(11, 4 ,2, '2015-08-04');
insert into training_details VALUES(12, 3 ,2 ,'2015-08-02');
insert into training_details VALUES(13, 1 ,1 ,'2015-08-02');
insert into training_details VALUES(14, 4, 3 ,'2015-08-03');


//QUERY

SELECT user_id ,username ,training_id ,training_date ,COUNT(*) as count
FROM users u
         INNER JOIN training_details t ON(u.user_id = t.user_id)
GROUP BY user_id ,username ,training_id ,training_date
HAVING COUNT(*) > 1
ORDER BY training_date DESC
