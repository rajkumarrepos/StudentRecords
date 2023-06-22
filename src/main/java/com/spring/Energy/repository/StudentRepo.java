package com.spring.Energy.repository;

import com.spring.Energy.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface StudentRepo extends JpaRepository<Student,Long> {
    List<Student> findByStudentName(String name);
    @Query(value = "SELECT * FROM student_details WHERE student_roll_no=:studentRollNo",nativeQuery = true )
    Optional<Student> getStudentRollNo(Long studentRollNo);
}
