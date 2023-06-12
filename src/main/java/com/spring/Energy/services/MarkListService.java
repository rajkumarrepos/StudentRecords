package com.spring.Energy.services;

import com.spring.Energy.requestDTO.MarkAddDTO;
import com.spring.Energy.responseDTO.StudentsMarkRecordDTO;
import com.spring.Energy.requestDTO.UpdateStudentsMarkDTO;
import com.spring.Energy.entity.StudentsMarks;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MarkListService {
    StudentsMarks markRegistering(MarkAddDTO markAddDTO);
    List<StudentsMarkRecordDTO> studentDetails();
    ResponseEntity<StudentsMarks> updateStudentsList(Long studentRegId, UpdateStudentsMarkDTO updateStudentsMarkDTO);
    Long deleteStd(Long studentRollNo);
    StudentsMarks getRollNo(Long studentDetail);
}
