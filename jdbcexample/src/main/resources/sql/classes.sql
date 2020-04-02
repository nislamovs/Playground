CREATE DATABASE IF NOT EXISTS school ;
use school ;

create table classes (
	id INT,
	type VARCHAR(12),
	class_head_id INT,
	name VARCHAR(5)
);
insert into classes (id, type, class_head_id, name) values (1, 'Mathematical', 1, '5A');
insert into classes (id, type, class_head_id, name) values (2, 'Mathematical', 2, '7E');
insert into classes (id, type, class_head_id, name) values (3, 'Lingual', 3, '9B');
insert into classes (id, type, class_head_id, name) values (4, 'Basic', 4, '10C');
insert into classes (id, type, class_head_id, name) values (5, 'Mathematical', 5, '4D');
