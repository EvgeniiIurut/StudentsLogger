package com.aston.martin.resource;

import com.aston.martin.domain.Student;
import com.aston.martin.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentResource {

    private final StudentService studentService;

    @Autowired
    public StudentResource(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping()
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping()
    public void addNewStudent(@RequestParam(name = "name") String name) {
        Student student = new Student(name);
        studentService.addNewStudent(student);
    }

    @DeleteMapping("/{id}")
    public void removeStudent(@PathVariable("id") int id) {
        studentService.remove(id);
    }

    @GetMapping("/test")
    @ResponseBody
    public String newStudent() {
        return "test";
    }
}



