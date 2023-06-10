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
    private StudentMarkRepo studentMarkRepo;
    @Autowired
    private MarkListService markListService;


    @PostMapping(value ="/register")
    public StudentsMarks mark(@Valid @RequestBody MarkAddDTO markAddDTO){
                StudentsMarks studentsMarks = markListService.markRegistering(markAddDTO);
                return studentsMarks;
    }
    @GetMapping(value ="/getallstudents")
    public List<StudentsMarkRecordDTO> studentDetails(){
        List<StudentsMarkRecordDTO> w =markListService.studentDetails();
        return w;

    }

    @PutMapping(value="/update/{id}")
    public ResponseEntity<StudentsMarks> update(@PathVariable (value = "id") Long studentRegId, @RequestBody UpdateStudentsMarkDTO updateStudentsMarkDTO){

           ResponseEntity<StudentsMarks> gv = markListService.updateStudentsList(studentRegId, updateStudentsMarkDTO);
           return gv;

    }

    @DeleteMapping(value ="/delete/{id}")
    public Long deleteStudent(@PathVariable(value = "id") Long studentRollNo){
        Long ty =markListService.deleteStd(studentRollNo);
        return ty;

    }
    @GetMapping("/{name}")
    public StudentsMarks getStudentName(@PathVariable(value="name") String name){
        StudentsMarks stdName =markListService.getName(name);
        return stdName;
    }
}
