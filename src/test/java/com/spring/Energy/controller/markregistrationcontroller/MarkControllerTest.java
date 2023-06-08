package com.spring.Energy.controller.markregistrationcontroller;

import com.spring.Energy.dto.studentmarklistDTO.MarkAddDTO;
import com.spring.Energy.entity.StudentsMarks;
import com.spring.Energy.repository.studentmarkrepo.StudentMarkRepo;
import com.spring.Energy.services.markregservice.MarkListService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.http.RequestEntity.post;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
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
                        .studentRegId(922512110328L)
                        .studentName("rajkumar")
                        .tamilMark(55)
                        .englishMark(34)
                        .mathsMark(99)
                        .scienceMark(56)
                        .socialMark(23)
                        .totalMark(450)
                        .createdDateTime("23")
                        .updateDateTime("25")
                        .build();
        log.info("checking ------------------------------------------");
    }

    @Test
    void mark() throws Exception {
        MarkAddDTO markAddDTO=
                new MarkAddDTO().builder()
                        .studentRegId(922512110328L)
                        .studentName("rajkumar")
                        .tamilMark(10)
                        .englishMark(34)
                        .mathsMark(99)
                        .scienceMark(56)
                        .socialMark(23)
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
                                "\t\"studentName\":\"rajkumar\",\n" +
                                "\t\"tamilMark\":55,\n" +
                                "\t\"englishMark\":34,\n" +
                                "\t\"mathsMark\":99,\n" +
                                "\t\"scienceMark\":56,\n" +
                                "\t\"socialMark\":23 \n" +
                                "}"))
                             .andExpect(status().isOk());


    }
}