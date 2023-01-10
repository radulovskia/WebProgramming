package mk.ukim.finki.wp.lab;

import mk.ukim.finki.wp.lab.exceptions.CourseAlreadyExistsException;
import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Teacher;
import mk.ukim.finki.wp.lab.model.enumerations.Type;
import mk.ukim.finki.wp.lab.repository.jpa.CourseRepository;
import mk.ukim.finki.wp.lab.repository.jpa.TeacherRepository;
import mk.ukim.finki.wp.lab.service.impl.CourseServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class AddCourseTest {
    @Mock
    private CourseRepository courseRepository;
    @Mock
    private TeacherRepository teacherRepository;

    private CourseServiceImpl courseService;


    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        Mockito.when(courseRepository.existsByName("example")).thenReturn(true);
        Mockito.when(teacherRepository.findById(Mockito.any())).thenReturn(Optional.of(new Teacher("dsa", "sd")));
        this.courseService = Mockito.spy(new CourseServiceImpl(courseRepository,null, teacherRepository, null));
    }

    @Test
    public void testAddCourse_courseWithNameExists(){
        Assert.assertThrows(CourseAlreadyExistsException.class,()->this.courseService.addCourse("example","asd",1L, Type.MANDATORY));
    }
    @Test
    public void testAddCourse_successfully() throws CourseAlreadyExistsException {
        Course crs = this.courseService.addCourse("example1","asd",1L, Type.MANDATORY);
        Assert.assertNotNull(crs);
    }
}