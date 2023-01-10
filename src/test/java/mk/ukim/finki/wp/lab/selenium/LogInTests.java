package mk.ukim.finki.wp.lab.selenium;

import mk.ukim.finki.wp.lab.exceptions.CourseAlreadyExistsException;
import mk.ukim.finki.wp.lab.model.enumerations.Type;
import mk.ukim.finki.wp.lab.service.CourseService;
import mk.ukim.finki.wp.lab.service.StudentService;
import mk.ukim.finki.wp.lab.service.TeacherService;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class LogInTests {


    @Autowired
    CourseService courseService;

    @Autowired
    TeacherService teacherService;

    @Autowired
    StudentService studentService;


    private HtmlUnitDriver driver;

    private static String user = "admin";
    private static String pass = "admin";

    private static boolean dataInitialized = false;


    @BeforeEach
    private void setup() throws CourseAlreadyExistsException {
        this.driver = new HtmlUnitDriver(true);
        initData();
    }

    @AfterEach
    public void destroy() {
        if (this.driver != null) {
            this.driver.close();
        }
    }

    private void initData() throws CourseAlreadyExistsException {
        if (!dataInitialized) {
            courseService.addCourse("name1" ,"desc1", 0L, Type.ELECTIVE);
            dataInitialized = true;
        }
    }

    @Test
    public void testScenario() throws Exception {
        String url = System.getProperty("geb.build.baseUrl", "http://localhost:999/courses");
        driver.get(url);
        List<WebElement> elements = driver.findElements(By.className("del"));
        Assert.assertEquals(0, elements.size());
        url = System.getProperty("geb.build.baseUrl", "http://localhost:999/login");
        driver.get(url);
        driver.findElement(By.id("username")).sendKeys(user);
        driver.findElement(By.id("password")).sendKeys(pass);
        driver.findElement(By.className("btn")).click();
        elements = driver.findElements(By.name("Delete"));
        Assert.assertNotEquals(0, elements.size());

    }

}