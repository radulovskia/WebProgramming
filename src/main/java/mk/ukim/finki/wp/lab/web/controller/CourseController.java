package mk.ukim.finki.wp.lab.web.controller;

import mk.ukim.finki.wp.lab.exceptions.CourseAlreadyExistsException;
import mk.ukim.finki.wp.lab.exceptions.CourseNotFoundException;
import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Teacher;
import mk.ukim.finki.wp.lab.service.CourseService;
import mk.ukim.finki.wp.lab.service.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/courses")
public class CourseController{

    private final CourseService courseService;
    private final TeacherService teacherService;

    public CourseController(CourseService courseService, TeacherService teacherService){
        this.courseService = courseService;
        this.teacherService = teacherService;
    }

    @GetMapping
    public String getCoursesPage(@RequestParam(required = false) String error, Model model){
        List<Course> courses = this.courseService.listAll();
        model.addAttribute("courses", courses);
        model.addAttribute("error", error);
        return "listCourses";
    }

    @PostMapping
    public String pickCourse(@RequestParam Long courseId, HttpSession session){
        session.setAttribute("courseId", courseId);
        return "redirect:/addStudent";
    }

    @GetMapping("/add-form")
    public String addNewCoursePage(Model model, @RequestParam(required = false) String error){
        List<Teacher> teachers = this.teacherService.findAll();
        model.addAttribute("teachers", teachers);
        model.addAttribute("error", error);
        return "add-course";
    }

    @GetMapping("/edit-form/{id}")
    public String getEditCoursePage(Model model, @PathVariable(required = false) Long id){
        List<Teacher> teachers = this.teacherService.findAll();
        Course c = this.courseService.findById(id);
        if(c == null){
            return "redirect:/courses?error=Course not found";
        }
        model.addAttribute("course",c);
        model.addAttribute("teachers",teachers);
        return "add-course";
    }

    @PostMapping({"add"})
    public String saveCourse(@RequestParam String name, @RequestParam String description,
                             @RequestParam Long teacherId, @RequestParam(required = false) Long editCourseId)
            throws CourseAlreadyExistsException, CourseNotFoundException{
        if(editCourseId == null)
            try{
                this.courseService.addCourse(name, description, teacherId);
            }
            catch(CourseAlreadyExistsException e){
                return "redirect:/courses/add-form?error=" + e.getMessage();
            }
        else
            this.courseService.editCourse(name, description, teacherId, editCourseId);
        return "redirect:/listCourses";
    }

    @PostMapping("/delete/{id}")
    public String deleteCourse(@PathVariable Long id){
        this.courseService.deleteCourse(id);
        return "redirect:/courses";
    }
}
