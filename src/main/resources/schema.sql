drop table if exists employee;

create table employee(
  employee_id int primary key not null auto_increment,
  employee_name varchar(50),
  age int
);