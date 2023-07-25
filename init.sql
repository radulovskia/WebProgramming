create sequence if not exists hibernate_sequence;

alter sequence hibernate_sequence owner to postgres;

create table if not exists student
(
    username varchar(255) not null primary key default nextval('hibernate_sequence'),
    name varchar(255) not null,
    password varchar(255) not null,
    surname varchar(255) not null
);

alter table student owner to postgres;

create table if not exists teacher
(
    id bigserial not null primary key default nextval('hibernate_sequence'),
    date_of_employment date not null,
    full_name varchar(255) not null,
    name varchar(255) not null,
    surname varchar(255) not null
);

alter table teacher owner to postgres;

create table if not exists course
(
    id bigserial not null primary key default nextval('hibernate_sequence'),
    description varchar(255) not null,
    name varchar(255) not null,
    type varchar(255) not null,
    teacher_id bigint not null constraint fksybhlxoejr4j3teomm5u2bx1n references teacher
);

alter table course owner to postgres;

create table if not exists course_students
(
    course_id bigint not null constraint fkgut5xj4l8sk6hg3l0t2su2pnc references course,
    students_username varchar(255) not null constraint fk4mv6re6i7tgxk3bpn4euubs44 references student
);

alter table course_students owner to postgres;

create table if not exists grade
(
    id bigserial not null primary key default nextval('hibernate_sequence'),
    grade char not null,
    timestamp timestamp not null,
    course_id bigint not null constraint fk7e8ca7hfmrpruicqhocskjlf2 references course,
    student_username varchar(255) not null constraint fk71y9vqtfpm0knhxha8opnadss references student
);

alter table grade owner to postgres;

delete from teacher;
insert into teacher values
('2022-12-12', 'Teacher teacher1', 'Teacher', 'teacher1'),
('2022-12-01', 'Teacher teacher2', 'Teacher', 'teacher2'),
('2021-12-03', 'Teacher teacher3', 'Teacher', 'teacher3');

delete from student;
insert into student values
('ar', 'Aleksandar', 'ar123', 'Radulovski'),
('ss', 'Stole', 'ss123', 'Stolevski'),
('pp', 'Petre', 'pp123', 'Petreski'),
('mm', 'Mile', 'mm123', 'Mileski'),
('jj', 'Jovan', 'jj123', 'Jovanov'),
('kk', 'Kole', 'kk123', 'Kolevski'),
('dd', 'Doncho', 'dd123', 'Donchovski');

delete from course;
insert into course values
('os description', 'Operating Systems', 'SUMMER', 2),
('is description', 'Information Security', 'WINTER', 3),
('data science desc', 'Data Science', 'WINTER', 3),
('ap description', 'Advanced Programming', 'WINTER', 1);

delete from course_students;
insert into course_students values
(7, 'ss'), (7, 'mm'), (7, 'pp'), (7, 'jj'), (4, 'kk'),
(4, 'dd'), (4, 'ar'), (4, 'pp'), (4, 'jj'), (5, 'ss'),
(5, 'kk'), (5, 'dd'), (5, 'pp'), (5, 'ar'), (5, 'jj'),
(6, 'dd'), (6, 'kk'), (6, 'pp'), (6, 'ar'), (6, 'ss');

delete from grade;
insert into grade values
('A', '2022-12-04 23:32:55', 7, 'ss'),
('A', '2023-06-08 20:05:00', 5, 'jj'),
('A', '2022-12-17 23:45:00', 6, 'ar'),
('A', '2022-12-01 23:47:00', 4, 'jj'),
('A', '2022-12-14 23:34:04', 6, 'kk'),
('A', '2022-12-08 23:48:00', 4, 'kk'),
('B', '2022-12-14 23:34:22', 6, 'ss'),
('A', '2022-12-09 23:33:30', 4, 'ar'),
('F', '2022-12-15 00:49:00', 7, 'pp'),
('C', '2022-12-02 19:15:00', 6, 'dd'),
('F', '2022-12-02 19:16:00', 6, 'pp'),
('B', '2022-12-09 19:50:00', 5, 'ss'),
('B', '2022-12-04 19:50:00', 5, 'ar'),
('A', '2022-12-01 13:29:00', 5, 'kk'),
('B', '2022-12-30 23:35:00', 4, 'dd'),
('A', '2023-01-05 23:38:00', 7, 'mm');