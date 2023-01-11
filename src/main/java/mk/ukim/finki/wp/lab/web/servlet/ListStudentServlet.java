package mk.ukim.finki.wp.lab.web.servlet;

import mk.ukim.finki.wp.lab.service.CourseService;
import mk.ukim.finki.wp.lab.service.GradeService;
import mk.ukim.finki.wp.lab.service.StudentService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet(name="list-students-servlet", urlPatterns = "/addStudent")
public class ListStudentServlet extends HttpServlet{
    private final SpringTemplateEngine springTemplateEngine;
    private final StudentService studentService;
    private final CourseService courseService;
    private final GradeService gradeService;

    public ListStudentServlet(SpringTemplateEngine springTemplateEngine, StudentService studentService, CourseService courseService, GradeService gradeService){
        this.springTemplateEngine = springTemplateEngine;
        this.studentService = studentService;
        this.courseService = courseService;
        this.gradeService = gradeService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        WebContext context = new WebContext(req,resp,req.getServletContext());
        context.setVariable("students",this.studentService.listAll());
        Long courseId = (Long) req.getSession().getAttribute("courseId");
        context.setVariable("courseId",courseId);
        resp.setHeader("Content-Type", "text/html;charset=UTF-8");
        this.springTemplateEngine.process("listStudents.html",context,resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        String username = req.getParameter("username");
        String courseId = req.getSession().getAttribute("courseId").toString();
        String dt = req.getParameter("dateTime");
        String g = req.getParameter("grade");
        if(!g.isBlank() && !dt.isBlank()){
            gradeService.addGrade(g, username, courseId, dt);
        }
        courseService.addStudentInCourse(username, Long.valueOf(courseId));
        resp.sendRedirect("/enrollmentSummary");
    }
}
