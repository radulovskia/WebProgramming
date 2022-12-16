package mk.ukim.finki.wp.lab.repository.jpa;

import mk.ukim.finki.wp.lab.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long>{
    boolean existsByName(String name);
    void deleteById(Long id);
    @Query(value = "select c from Course c join Teacher t on c.teacher.id = t.id where c.name like %:text% or c.description like %:text%" +
            " or t.fullName.name like %:text% or t.fullName.surname like %:text%")
    List<Course> findAllByNameContains(String text);
}