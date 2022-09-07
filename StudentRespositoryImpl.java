package com.example.student.respository.impl;

import com.example.student.model.Student;
import com.example.student.respository.StudentRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRespositoryImpl implements StudentRespository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public int saveStudent(Student student) {
        String sql = "INSERT INTO STUDENT_DETALIS(STUDENT_ID,STUDENT_NAME,BRANCH,STUDENT_ADDRESS,PHONE_NO) values(?,?,?,?,?)";
        Object[] studentDetails = {
                student.getStudentId(),
                student.getStudentName(),
                student.getBranch(),
                student.getStudentAddress(),
                student.getPhoneNo()
        };
        return jdbcTemplate.update(sql, studentDetails);
    }

    @Override
    public List<Student> retrieveAllStudent() {
        String sql = "SELECT * FROM STUDENT_DETALIS";
        return jdbcTemplate.query(sql, (rs, rowNum) ->
                Student.builder()
                        .StudentId(rs.getInt("STUDENT_ID"))
                        .StudentName(rs.getString("STUDENT_NAME"))
                        .Branch(rs.getString("BRANCH"))
                        .StudentAddress(rs.getString("STUDENT_ADDRESS"))
                        .PhoneNo(rs.getInt("PHONE_NO"))
                        .build()
        );
    }

    @Override
    public int  deleteStudentById(int StudentId) {
        String sql = "DELETE STUDENT_DETALIS WHERE STUDENT_ID=?";
        Object[] deletedStudent={
              StudentId
        };
        return jdbcTemplate.update(sql,StudentId);
    }

    @Override
    public List<Student> retrieveStudentByBranch(String Branch) {
        String sql = "SELECT * FROM STUDENT_DETALIS WHERE BRANCH=:Branch";
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("BRANCH", Branch);
        return namedParameterJdbcTemplate.query(sql, mapSqlParameterSource, ((rs, rowNum) -> Student.builder()
                .StudentId(rs.getInt("STUDENT_ID"))
                .StudentName(rs.getString("STUDENT_NAME"))
                .Branch(rs.getString("BRANCH"))
                .StudentAddress(rs.getString("STUDENT_ADDRESS"))
                .PhoneNo(rs.getInt("PHONE_NO"))
                .build()));

    }
}
