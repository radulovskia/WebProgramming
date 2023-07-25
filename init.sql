create sequence if not exists hibernate_sequence;

alter sequence hibernate_sequence owner to postgres;

create table if not exists student
(
    username varchar(255) not null primary key,
    name varchar(255) not null,
    password varchar(255) not null,
    surname varchar(255) not null
);

alter table student owner to postgres;

create table if not exists teacher
(
    id bigserial not null primary key,
    date_of_employment date not null,
    full_name varchar(255) not null,
    name varchar(255) not null,
    surname varchar(255) not null
);

alter table teacher owner to postgres;

create table if not exists course
(
    id bigserial not null primary key,
    description varchar(255) not null,
    name varchar(255) not null,
    type varchar(255) not null,
    teacher_id bigint not null constraint fksybhlxoejr4j3teomm5u2bx1n references teacher(id)
);

alter table course owner to postgres;

create table if not exists course_students
(
    course_id bigint not null constraint fkgut5xj4l8sk6hg3l0t2su2pnc references course(id),
    students_username varchar(255) not null constraint fk4mv6re6i7tgxk3bpn4euubs44 references student(username)
);

alter table course_students owner to postgres;

create table if not exists grade
(
    id bigserial not null primary key,
    grade char not null,
    timestamp timestamp not null,
    course_id bigint not null constraint fk7e8ca7hfmrpruicqhocskjlf2 references course(id),
    student_username varchar(255) not null constraint fk71y9vqtfpm0knhxha8opnadss references student(username)
);

alter table grade owner to postgres;

delete from teacher;
insert into teacher(date_of_employment, full_name, name, surname) values
('2022-12-12', 'Teacher teacher1', 'Teacher', 'teacher1'),
('2022-12-01', 'Teacher teacher2', 'Teacher', 'teacher2'),
('2021-12-03', 'Teacher teacher3', 'Teacher', 'teacher3')
on conflict do nothing;

delete from student;
insert into student values
('ss', 'Stole', 'ss123', 'Stolevski'),
('jj', 'Jovan', 'jj123', 'Jovanov'),
('kk', 'Kole', 'kk123', 'Kolevski')
on conflict do nothing;

delete from course;
insert into course (description, name, type, teacher_id) values
('os description', 'Operating Systems', 'SUMMER', (select id from teacher where surname = 'teacher1')),
('cn description', 'Computer Networks', 'WINTER', (select id from teacher where surname = 'teacher2')),
('is description', 'Information Security', 'WINTER', (select id from teacher where surname = 'teacher3'))
on conflict do nothing;

delete from course_students;
insert into course_students values
((select id from course where name = 'Operating Systems'), 'ss'),
((select id from course where name = 'Operating Systems'), 'kk'),
((select id from course where name = 'Operating Systems'), 'jj'),
((select id from course where name = 'Computer Networks'), 'ss'),
((select id from course where name = 'Computer Networks'), 'kk'),
((select id from course where name = 'Information Security'), 'jj'),
((select id from course where name = 'Information Security'), 'kk')
on conflict do nothing;

delete from grade;
insert into grade (grade, timestamp, course_id, username) values
('B', '2022-12-04 23:32:55', (select id from course where name = 'Operating Systems'), 'ss'),
('A', '2022-12-04 23:33:12', (select id from course where name = 'Operating Systems'), 'jj'),
('B', '2022-12-04 23:34:55', (select id from course where name = 'Operating Systems'), 'kk'),
('A', '2022-12-05 23:42:55', (select id from course where name = 'Computer Networks'), 'kk'),
('A', '2022-12-05 23:36:55', (select id from course where name = 'Information Security'), 'kk')
on conflict do nothing;