package com.spring.Energy.controller;

import com.spring.Energy.requestDTO.MarkAddDTO;
import com.spring.Energy.responseDTO.StudentsMarkRecordDTO;
import com.spring.Energy.requestDTO.UpdateStudentsMarkDTO;
import com.spring.Energy.entity.StudentsMarks;
import com.spring.Energy.repository.StudentMarkRepo;
import com.spring.Energy.services.MarkListService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/students/mark")
public class MarkController {
    @Autowired
    private MarkListService markListService;


    @PostMapping(value ="/register")
    public StudentsMarks mark(@Valid @RequestBody MarkAddDTO markAddDTO){
                StudentsMarks studentsMarks = markListService.markRegistering(markAddDTO);
                return studentsMarks;
    }
    @GetMapping(value ="/get")
    public List<StudentsMarkRecordDTO> studentDetails(){
        List<StudentsMarkRecordDTO> studenetMarkList =markListService.studentDetails();
        return studenetMarkList ;

    }

    @PutMapping(value="/update/{rollNo}")
    public ResponseEntity<StudentsMarks> update(@PathVariable (value = "rollNo") Long studentRollNo, @RequestBody UpdateStudentsMarkDTO updateStudentsMarkDTO){

           ResponseEntity<StudentsMarks> updatedStudentMarkDetails = markListService.updateStudentsList(studentRollNo, updateStudentsMarkDTO);
           return updatedStudentMarkDetails;

    }

    @DeleteMapping(value ="/delete/{rollNo}")
    public Long deleteStudent(@PathVariable(value = "rollNo") Long studentRollNo){
        Long deletedRollNo =markListService.deleteStd(studentRollNo);
        return deletedRollNo;

    }
    @GetMapping("/{rollNo}")
    public StudentsMarks getStudentName(@PathVariable(value="rollNo") Long studentRollNo){
        StudentsMarks stdDetail =markListService.getRollNo(studentRollNo);
        return stdDetail;
    }
}
