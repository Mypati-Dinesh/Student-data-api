package com.example.student.respository;


import com.example.student.model.Student;

import java.util.List;

public interface StudentRespository {

    int saveStudent(Student student);

    List<Student> retrieveAllStudent();

    int deleteStudentById(int StudentId);

    List<Student> retrieveStudentByBranch(String Branch);
}
