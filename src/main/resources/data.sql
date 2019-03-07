insert into user (id, first_name, last_name, password, username) values
  (1, 'vikas','verma','$2a$04$lZj8KgBFkcPwgRWjH8DwBeCIR7HE6AsIZqTXu2VyeEw5sYLySNAGe', 'vikas');
insert into user (id, first_name, last_name, password, username) values
  (2, 'james','james','$2a$04$P2GbxPDh1MYNYyNn/bj.4.QxwDC2jze0xPQF4u6/cNpdkrPq3OdPy', 'james');
insert into role (id, description, role_name) values (1,  'admin role', 'ADMIN');
insert into role (id, description, role_name) values (2, 'user role', 'USER');
insert into user_role(user_id, role_id) values (1, 1);
insert into user_role(user_id, role_id) values (2, 1);
insert into user_role(user_id, role_id) values (2, 2);
