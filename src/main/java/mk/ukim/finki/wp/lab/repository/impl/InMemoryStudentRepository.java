//package mk.ukim.finki.wp.lab.repository.impl;
//
//import mk.ukim.finki.wp.lab.model.Student;
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Objects;
//import java.util.stream.Collectors;
//
//import static mk.ukim.finki.wp.lab.bootstrap.DataHolder.students;
//
//@Repository
//public class InMemoryStudentRepository{
//
//    public List<Student> findAllStudents(){
//        return students;
//    }
//
//    public List<Student> findAllByNameOrSurname(String text){
//        return students.stream().filter(s->s.getName().contains(text) || s.getSurname().contains(text))
//                .collect(Collectors.toList());
//    }
//
//    public Student addStudent(Student student){
//        students.removeIf(r-> Objects.equals(r.getUsername(), student.getUsername()));
//        students.add(student);
//        return student;
//    }
//
//    public Student findByUsername(String username){
//        return students.stream().filter(s->s.getUsername().equals(username)).findFirst().orElse(null);
//    }
//}
