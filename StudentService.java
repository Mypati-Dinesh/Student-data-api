package com.example.student.service;

import com.example.student.model.Student;

import java.util.List;

public interface StudentService {

    int saveStudent(Student student);

    List<Student> retrieveAllStudent();

    int deleteStudentById(int StudentId);

    List<Student> retrieveStudentByBranch(String Branch);

}