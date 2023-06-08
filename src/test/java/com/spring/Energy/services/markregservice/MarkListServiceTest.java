package com.spring.Energy.services.markregservice;

import com.spring.Energy.entity.StudentsMarks;
import com.spring.Energy.repository.studentmarkrepo.StudentMarkRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

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
                .studentRegId(922512110328L)
                .studentName("rajkumar")
                .tamilMark(55)
                .englishMark(34)
                .scienceMark(56)
                .socialMark(23)
                .totalMark(450)
                .build();
        Mockito.when(studentMarkRepo.existsByStudentRegId(922512110328L))
                .thenReturn(true);
        Mockito.when(studentMarkRepo.findByStudentRegId(922512110328L))
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