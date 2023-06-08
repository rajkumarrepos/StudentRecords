package com.spring.Energy.services.markregservice;

import com.spring.Energy.dto.studentmarklistDTO.MarkAddDTO;
import com.spring.Energy.dto.studentmarklistDTO.StudentsRecordDTO;
import com.spring.Energy.dto.studentmarklistDTO.UpdateStudentsDTO;
import com.spring.Energy.entity.StudentsMarks;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MarkListService {
    StudentsMarks markRegistering(MarkAddDTO markAddDTO);
    List<StudentsRecordDTO> studentDetails();
    ResponseEntity<StudentsMarks> updateStudentsList(Long studentRegId, UpdateStudentsDTO updateStudentsDTO);
    Long deleteStd(Long studentRegId);
}
