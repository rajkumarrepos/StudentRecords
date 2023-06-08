package com.spring.Energy.repository.studentmarkrepo;

import com.spring.Energy.entity.StudentsMarks;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


import static org.junit.jupiter.api.Assertions.*;

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
                        .studentRegId(922512110110L)
                        .studentName("raj")
                        .tamilMark(55)
                        .englishMark(34)
                        .scienceMark(56)
                        .socialMark(23)
                        .totalMark(450)
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
       assertEquals(studentsMarks.getStudentName(),"raj");
    }
}