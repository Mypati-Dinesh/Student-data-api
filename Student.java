package com.example.student.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Student {
    private int StudentId;
    private String StudentName;
    private String Branch;
    private String StudentAddress;
    private long PhoneNo;
}
