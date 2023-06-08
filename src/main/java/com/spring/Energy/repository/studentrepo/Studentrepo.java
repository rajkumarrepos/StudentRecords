package com.spring.Energy.repository.studentrepo;

import com.spring.Energy.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
@Repository
public interface Studentrepo extends JpaRepository<Student, Long> {
     List<Student> findByStudentName(String name);

}
