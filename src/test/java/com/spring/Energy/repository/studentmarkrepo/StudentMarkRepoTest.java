package com.spring.Energy.repository.studentmarkrepo;

import com.spring.Energy.entity.StudentsMarks;
import com.spring.Energy.repository.StudentMarkRepo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j

class StudentMarkRepoTest {
    @Autowired
    private StudentMarkRepo studentMarkRepo;
     @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp() {
        log.info("checking ------------------------------------------");
        StudentsMarks studentsMarks=
                StudentsMarks.builder()
                        .studentId(1L)
                        .studentRollNo(922512110110L)
                        .tamil(55)
                        .english(34)
                        .science(56)
                        .social(23)
                        .total(450)
                        .createdDateTime("23")
                        .updateDateTime("null")
                        .build();
        log.info("checking ---------------------------------------------------------------------------------------------------------------------------");
        entityManager.persist(studentsMarks);
        log.info("checking ------------------------------------------");
    }
    @Test
    public void to_test_repository(){
     StudentsMarks studentsMarks=studentMarkRepo.findById(1L).get();
       assertEquals(studentsMarks.getStudentRollNo(),922512110110L);
    }
}