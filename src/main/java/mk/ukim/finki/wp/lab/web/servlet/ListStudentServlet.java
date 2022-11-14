package mk.ukim.finki.wp.lab.web.servlet;

import mk.ukim.finki.wp.lab.service.CourseService;
import mk.ukim.finki.wp.lab.service.StudentService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="list-students-servlet", urlPatterns = "/addStudent")
public class ListStudentServlet extends HttpServlet{
    private final SpringTemplateEngine springTemplateEngine;
    private final StudentService studentService;
    private final CourseService courseService;

    public ListStudentServlet(SpringTemplateEngine springTemplateEngine, StudentService studentService, CourseService courseService){
        this.springTemplateEngine = springTemplateEngine;
        this.studentService = studentService;
        this.courseService = courseService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        WebContext context = new WebContext(req,resp,req.getServletContext());
        context.setVariable("students",this.studentService.listAll());
        Long courseId = (Long) req.getSession().getAttribute("courseId");
        context.setVariable("courseId",courseId);
        this.springTemplateEngine.process("listStudents.html",context,resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        String username = req.getParameter("username");
        String courseId = req.getSession().getAttribute("courseId").toString();
        courseService.addStudentInCourse(username, Long.valueOf(courseId));
        resp.sendRedirect("/enrollmentSummary");
    }
}
