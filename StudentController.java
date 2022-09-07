package com.example.student;

import com.example.student.model.Student;
import com.example.student.service.StudentService;
import com.example.student.wed.model.RetrieveStudentDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "app/jdbc-app")
public class StudentController {

    @Autowired
    StudentService studentServiceImpl;

    @PostMapping("ADD_STUDENT")
    public ResponseEntity<Object> saveStudent(@RequestBody Student student) {
        int savedStudent = studentServiceImpl.saveStudent(student);
        return ResponseEntity.ok().body(savedStudent);
    }

    @GetMapping("RETRIEVE_ALL_STUDENT")
    public ResponseEntity<Object> retrieveAllStudent() {
        List<Student> Studentlist = studentServiceImpl.retrieveAllStudent();
        RetrieveStudentDetails retrieveStudentDetails = RetrieveStudentDetails.builder()
                .Student(Studentlist)
                .build();
        return ResponseEntity.ok().body(retrieveStudentDetails);
    }

    @GetMapping("DELETE_STUDENT_BY_ID")
    public ResponseEntity<Object> deleteStudentById(int StudentId) {
        int deletedStudent = studentServiceImpl.deleteStudentById(StudentId);
        return ResponseEntity.ok().body(deletedStudent);
    }

    @GetMapping("RETRIEVE_STUDENT_BY_BRANCH")
    public ResponseEntity<Object> retrieveStudentByBranch(String Branch) {
        List<Student> StudentList = studentServiceImpl.retrieveStudentByBranch(Branch);
        RetrieveStudentDetails retrieveStudentDetails = RetrieveStudentDetails.builder()
                .Student(StudentList)
                .build();
        return ResponseEntity.ok().body(retrieveStudentDetails);
    }

}
