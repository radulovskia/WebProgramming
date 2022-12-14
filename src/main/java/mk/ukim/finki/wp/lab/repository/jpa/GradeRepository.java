package mk.ukim.finki.wp.lab.repository.jpa;

import mk.ukim.finki.wp.lab.model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface GradeRepository extends JpaRepository<Grade,Long>{
    List<Grade> findByCourse_Id(Long id);
    List<Grade> findAllByTimestampBetween(LocalDateTime from, LocalDateTime to);
}