package com.spring.Energy.repository;

import com.spring.Energy.entity.StudentsMarks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
@Repository
public interface StudentMarkRepo extends JpaRepository<StudentsMarks,Long> {

    boolean existsByStudentRollNo(Long studentRegId);

    StudentsMarks findByStudentRollNo(Long studentRollNo);



     // @Query(value="SELECT * FROM student_mark_registry1  WHERE student_name=:name",nativeQuery = true)
     // StudentsMarks getStudentName(String name);




}
