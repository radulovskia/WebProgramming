package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab.model.Student;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Repository
public class StudentRepository{

    public List<Student> findAllStudents(){
        return DataHolder.students;
    }

    public List<Student> findAllByNameOrSurname(String text){
        return DataHolder.students.stream().filter(s->s.getName().contains(text) || s.getSurname().contains(text))
                .collect(Collectors.toList());
    }

    public Student addStudent(Student student){
        DataHolder.students.removeIf(r-> Objects.equals(r.getUsername(), student.getUsername()));
        DataHolder.students.add(student);
        return student;
    }

    public Student findByUsername(String username){
        return DataHolder.students.stream().filter(s->s.getUsername().equals(username)).findFirst().orElse(null);
    }
}
