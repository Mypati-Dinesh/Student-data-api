package com.example.student.wed.model;

import com.example.student.model.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class RetrieveStudentDetails {
    List<Student> Student;
}
