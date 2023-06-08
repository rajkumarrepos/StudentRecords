package com.spring.Energy.controller.markregistrationcontroller;

import com.spring.Energy.dto.studentmarklistDTO.MarkAddDTO;
import com.spring.Energy.dto.studentmarklistDTO.StudentsRecordDTO;
import com.spring.Energy.dto.studentmarklistDTO.UpdateStudentsDTO;
import com.spring.Energy.entity.StudentsMarks;
import com.spring.Energy.exception.InvalidInputs;
import com.spring.Energy.exceptionController.CustomException;
import com.spring.Energy.repository.studentmarkrepo.StudentMarkRepo;
import com.spring.Energy.services.markregservice.MarkListService;
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
      if((markAddDTO.getStudentRegId().toString().length()== 12) != (studentMarkRepo.existsByStudentRegId(markAddDTO.getStudentRegId())))
       {
        if ( (markAddDTO.getTamilMark() <= 100) && (markAddDTO.getEnglishMark() <= 100) && (markAddDTO.getMathsMark() <= 100) && (markAddDTO.getScienceMark() <= 100) && (markAddDTO.getSocialMark() <= 100) ) {
                StudentsMarks studentsMarks = markListService.markRegistering(markAddDTO);
                return studentsMarks;
            } else {
                throw new CustomException("603","invalid marks have send by front end");
            }
       } else {
           throw new CustomException("602","Given id exists / wrong id /you can do only update for this id ");
       }


    }
    @GetMapping(value ="/getallstudents")
    public List<StudentsRecordDTO> studentDetails(){
        List<StudentsRecordDTO> w =markListService.studentDetails();
        return w;

    }

    @PutMapping(value="/update/{id}")
    public ResponseEntity<StudentsMarks> update(@PathVariable (value = "id") Long studentRegId, @RequestBody UpdateStudentsDTO updateStudentsDTO){

           ResponseEntity<StudentsMarks> gv = markListService.updateStudentsList(studentRegId, updateStudentsDTO);
           return gv;

    }

    @DeleteMapping(value ="/delete/{id}")
    public Long deleteStudent(@PathVariable(value = "id") Long studentRegId){
        Long ty =markListService.deleteStd(studentRegId);
        return ty;

    }
}
