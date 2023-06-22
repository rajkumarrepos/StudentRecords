package com.spring.Energy.controller.markregistrationcontroller;

import com.spring.Energy.controller.MarkController;
import com.spring.Energy.requestDTO.MarkAddDTO;
import com.spring.Energy.entity.StudentsMarks;
import com.spring.Energy.repository.StudentMarkRepo;
import com.spring.Energy.services.MarkListService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.http.RequestEntity.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebMvcTest(MarkController.class)
class MarkControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private MarkListService markListService;
    @MockBean
    private StudentMarkRepo studentMarkRepo;


    private StudentsMarks studentsMarks;

    @Autowired
    private MarkController markController;

    @BeforeEach
    void setUp() {
        studentsMarks =
                StudentsMarks.builder()
                        .studentId(1L)
                        .studentRollNo(922512110328L)
                        .tamil(55)
                        .english(34)
                        .maths(99)
                        .science(56)
                        .social(23)
                        .total(450)
                        .createdDateTime("23")
                        .updateDateTime("25")
                        .build();
        log.info("checking ------------------------------------------");
    }

    @Test
    void mark() throws Exception {
        MarkAddDTO markAddDTO=
                new MarkAddDTO().builder()
                        .studentRollNo(922512110328L)
                        .tamil(10)
                        .english(34)
                        .maths(99)
                        .science(56)
                        .social(23)
                        .build();
        Mockito.when(markController.mark( markAddDTO))
                        .thenReturn(studentsMarks);
       /* log.info("checking ------------------------------------------");
        Mockito.when((markAddDTO.getStudentRegId().toString().length()== 12) != (studentMarkRepo.existsByStudentRegId(markAddDTO.getStudentRegId())))
                .thenReturn(true);
        log.info("checking ------------------------------------------");
        Mockito.when((markAddDTO.getTamilMark() <= 100) && (markAddDTO.getEnglishMark() <= 100) && (markAddDTO.getMathsMark() <= 100) && (markAddDTO.getScienceMark() <= 100) && (markAddDTO.getSocialMark() <= 100))
                .thenReturn(true);
             log.info("checking ------------------------------------------");
        Mockito.when(markListService.markRegistering(markAddDTO))
                .thenReturn(studentsMarks);
        log.info("checking ------------------------------------------");    */

        mockMvc.perform(MockMvcRequestBuilders.post("http://localhost:8080/api/v1/students/mark/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "\t\"studentRegId\":922512110320,\n" +
                                "\t\"tamil\":55,\n" +
                                "\t\"english\":34,\n" +
                                "\t\"maths\":99,\n" +
                                "\t\"science\":56,\n" +
                                "\t\"social\":23 \n" +
                                "}"))
                             .andExpect(status().isOk());


    }
}