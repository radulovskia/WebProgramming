CREATE SEQUENCE IF NOT EXISTS hibernate_sequence;

CREATE TABLE IF NOT EXISTS student
(
    username varchar(255) NOT NULL PRIMARY KEY,
    name varchar(255) NOT NULL,
    password varchar(255) NOT NULL,
    surname varchar(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS teacher
(
    id bigserial NOT NULL PRIMARY KEY,
    date_of_employment date NOT NULL,
    full_name varchar(255) NOT NULL,
    name varchar(255) NOT NULL,
    surname varchar(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS course
(
    id bigserial NOT NULL PRIMARY KEY,
    description varchar(255) NOT NULL,
    name varchar(255) NOT NULL,
    type varchar(255) NOT NULL,
    teacher_id bigint NOT NULL,
    CONSTRAINT fksybhlxoejr4j3teomm5u2bx1n FOREIGN KEY (teacher_id) REFERENCES teacher (id)
);

CREATE TABLE IF NOT EXISTS course_students
(
    course_id bigint NOT NULL,
    students_username varchar(255) NOT NULL,
    PRIMARY KEY (course_id, students_username),
    CONSTRAINT fkgut5xj4l8sk6hg3l0t2su2pnc FOREIGN KEY (course_id) REFERENCES course (id),
    CONSTRAINT fk4mv6re6i7tgxk3bpn4euubs44 FOREIGN KEY (students_username) REFERENCES student (username)
);

CREATE TABLE IF NOT EXISTS grade
(
    id bigserial NOT NULL PRIMARY KEY,
    grade char NOT NULL,
    timestamp timestamp NOT NULL,
    course_id bigint NOT NULL,
    student_username varchar(255) NOT NULL,
    CONSTRAINT fk7e8ca7hfmrpruicqhocskjlf2 FOREIGN KEY (course_id) REFERENCES course (id),
    CONSTRAINT fk71y9vqtfpm0knhxha8opnadss FOREIGN KEY (student_username) REFERENCES student (username)
);

DELETE FROM teacher WHERE 1;
INSERT INTO teacher VALUES
(1, '2022-12-12', 'Teacher teacher1', 'Teacher', 'teacher1'),
(2, '2022-12-01', 'Teacher teacher2', 'Teacher', 'teacher2'),
(3, '2021-12-03', 'Teacher teacher3', 'Teacher', 'teacher3');

DELETE FROM student WHERE 1;
INSERT INTO student VALUES
('ar', 'Aleksandar', 'ar123', 'Radulovski'),
('ss', 'Stole', 'ss123', 'Stolevski'),
('pp', 'Petre', 'pp123', 'Petreski'),
('mm', 'Mile', 'mm123', 'Mileski'),
('jj', 'Jovan', 'jj123', 'Jovanov'),
('kk', 'Kole', 'kk123', 'Kolevski'),
('dd', 'Doncho', 'dd123', 'Donchovski');

DELETE FROM course WHERE 1;
INSERT INTO course VALUES
(4, 'os description', 'Operating Systems', 'SUMMER', 2),
(5, 'is description', 'Information Security', 'WINTER', 3),
(6, 'data science desc', 'Data Science', 'WINTER', 3),
(1, 'ap description', 'Advanced Programming', 'WINTER', 1);

DELETE FROM course_students WHERE 1;
INSERT INTO course_students VALUES
(1, 'ss'), (1, 'mm'), (1, 'pp'), (1, 'jj'), (4, 'kk'),
(4, 'dd'), (4, 'ar'), (4, 'pp'), (4, 'jj'), (5, 'ss'),
(5, 'kk'), (5, 'dd'), (5, 'pp'), (5, 'ar'), (5, 'jj'),
(6, 'dd'), (6, 'kk'), (6, 'pp'), (6, 'ar'), (6, 'ss');

DELETE FROM grade WHERE 1;
INSERT INTO grade VALUES
(19, 'A', '2022-12-04 23:32:55', 1, 'ss'),
(42, 'A', '2023-06-08 20:05:00', 5, 'jj'),
(27, 'A', '2022-12-17 23:45:00', 6, 'ar'),
(28, 'A', '2022-12-01 23:47:00', 4, 'jj'),
(23, 'A', '2022-12-14 23:34:04', 6, 'kk'),
(29, 'A', '2022-12-08 23:48:00', 4, 'kk'),
(24, 'B', '2022-12-14 23:34:22', 6, 'ss'),
(21, 'A', '2022-12-09 23:33:30', 4, 'ar'),
(35, 'F', '2022-12-15 00:49:00', 1, 'pp'),
(36, 'C', '2022-12-02 19:15:00', 6, 'dd'),
(37, 'F', '2022-12-02 19:16:00', 6, 'pp'),
(33, 'B', '2022-12-09 19:50:00', 5, 'ss'),
(31, 'B', '2022-12-04 19:50:00', 5, 'ar'),
(39, 'A', '2022-12-01 13:29:00', 5, 'kk'),
(40, 'B', '2022-12-30 23:35:00', 4, 'dd'),
(41, 'A', '2023-01-05 23:38:00', 1, 'mm');