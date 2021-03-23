package com.example.demosecurity.student;

import com.example.demosecurity.student.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * This controller is the service for get/put/update
 * information about students
 * {@link StudentController}
 *
 * @author Norman Sanchez Nolasco
 * @version 1.0.0
 */

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

    private static final List<Student> STUDENTS = Arrays.asList(
            new Student(1, "James Bond"),
            new Student(2, "Maria Jones"),
            new Student(3, "Ana Smith")
    );

    /**
     * Service for get information about student for id
     *
     * @param studentId is the identification for each student
     * @return an object of Student
     */
    @GetMapping(path = "{studentId}")
    public Student getStudent(@PathVariable("studentId") Integer studentId) {
        return STUDENTS.stream().filter(student -> studentId.equals(student.getStudentId()))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Student " + studentId + " does not exist."));
    }
}
