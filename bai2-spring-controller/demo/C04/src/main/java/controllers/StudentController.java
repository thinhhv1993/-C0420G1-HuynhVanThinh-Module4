package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import service.StudentService;
import service.StudentServiceImpl;

@RequestMapping("/student")
@Controller
public class StudentController {
    StudentService studentService = new StudentServiceImpl();

    @GetMapping("")
    public ModelAndView getStudentPage(){
//        ModelAndView modelAndView = new ModelAndView("student-list");
//        List<Student> students = studentService.findAll();
//        modelAndView.addObject("students", students);
        return new ModelAndView("student", "students", studentService.findAll());
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Integer id){
        studentService.delete(id);
        return "redirect:/student";
    }

    @GetMapping("/edit")
    public String editStudent(@RequestParam("name") String name1, @RequestParam("age") Integer age1){
        System.out.println(name1);
        System.out.println(age1);
        return "redirect:/student";
    }
}
