//package mk.ukim.finki.wp.lab.repository.impl;
//
//import mk.ukim.finki.wp.lab.model.Teacher;
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static mk.ukim.finki.wp.lab.bootstrap.DataHolder.teachers;
//
//@Repository
//public class InMemoryTeacherRepository{
//    public List<Teacher> findAll() {
//        return teachers;
//    }
//    public Teacher findById(long id) {
//        return teachers.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
//    }
//}
