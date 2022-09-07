package com.example.student.service.Impl;

import com.example.student.model.Student;
import com.example.student.respository.StudentRespository;
import com.example.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRespository studentRespositoryImpl;

    @Override
    public int saveStudent(Student student) {
        return studentRespositoryImpl.saveStudent(student);
    }

    @Override
    public List<Student> retrieveAllStudent() {
        return studentRespositoryImpl.retrieveAllStudent();
    }

    @Override
    public int deleteStudentById(int StudentId) {
        return studentRespositoryImpl.deleteStudentById(StudentId);
    }

    @Override
    public List<Student> retrieveStudentByBranch(String Branch) {
        return studentRespositoryImpl.retrieveStudentByBranch(Branch);
    }
}
