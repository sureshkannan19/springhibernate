delete from person;
delete from license;

insert into person (id, age, first_name, last_name) values (1, 24, 'Suresh', 'K');
insert into license (id, person_id, type, valid_from, valid_to) values (1, 1, 'Car', '2022-01-01','2030-01-01');