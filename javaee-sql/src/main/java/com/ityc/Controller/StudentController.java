package com.ityc.Controller;

import com.ityc.Pojo.Student;
import com.ityc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    public void findall(){
        List<Student> all =
                studentService.findAll();
        System.out.println("学员数据为"+all);

    }
}
