package com.spring.Energy.repository;

import com.spring.Energy.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepo extends JpaRepository<Student,Long> {
    List<Student> findByStudentName(String name);
}
