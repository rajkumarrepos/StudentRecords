package com.spring.Energy.services.markregservice;

import com.spring.Energy.entity.StudentsMarks;
import com.spring.Energy.repository.StudentMarkRepo;
import com.spring.Energy.services.MarkListService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MarkListServiceTest {
    @Autowired
    private MarkListService markListService;
    @MockBean
    private StudentMarkRepo studentMarkRepo;

    @BeforeEach
    void setUp() {
        StudentsMarks studentsMarks=
        StudentsMarks.builder()
                .studentRollNo(922512110328L)
                .tamil(55)
                .english(34)
                .science(56)
                .social(23)
                .total(450)
                .build();
        Mockito.when(studentMarkRepo.existsByStudentRollNo(922512110328L))
                .thenReturn(true);
        Mockito.when(studentMarkRepo.findByStudentRollNo(922512110328L))
                .thenReturn(studentsMarks);
    }
    @Test
    @DisplayName("given data deleted")
    public void markList_Service_For_test_case(){
       Long studentRegId= 922512110328L;
       Long id =markListService.deleteStd(studentRegId);
       assertEquals(studentRegId,id);

    }
}