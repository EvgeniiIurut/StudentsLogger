package com.aston.martin.service;

import com.aston.martin.domain.Student;
import com.aston.martin.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public List<Student> getAllStudents() {
        return studentRepository.getAll();
    }

    public void remove(int id) {
        studentRepository.remove(id);
    }

    public void addNewStudent(Student student) {
        studentRepository.save(student);
    }
}
