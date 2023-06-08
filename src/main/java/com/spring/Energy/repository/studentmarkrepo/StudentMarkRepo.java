package com.spring.Energy.repository.studentmarkrepo;

import com.spring.Energy.entity.StudentsMarks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
@Repository
public interface StudentMarkRepo extends JpaRepository<StudentsMarks,Long> {

    boolean existsByStudentRegId(Long studentRegId);

    StudentsMarks findByStudentRegId(Long studentRegId);




}
