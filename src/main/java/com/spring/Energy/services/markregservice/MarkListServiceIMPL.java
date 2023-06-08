package com.spring.Energy.services.markregservice;

import com.spring.Energy.dto.studentmarklistDTO.MarkAddDTO;
import com.spring.Energy.dto.studentmarklistDTO.StudentsRecordDTO;
import com.spring.Energy.dto.studentmarklistDTO.UpdateStudentsDTO;
import com.spring.Energy.entity.StudentsMarks;
import com.spring.Energy.exceptionController.CustomException;
import com.spring.Energy.exception.ResourceNotFoundException;
import com.spring.Energy.repository.studentmarkrepo.StudentMarkRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class MarkListServiceIMPL implements MarkListService {
    @Autowired
    private StudentMarkRepo studentMarkRepo;
    @Override
    public StudentsMarks markRegistering(MarkAddDTO markAddDTO){
        Long reg =null;
        LocalDateTime now = LocalDateTime.now();
       DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formatDateTime = now.format(format);

                 StudentsMarks studentsMarks = new StudentsMarks(reg,
                         markAddDTO.getStudentRegId(),
                         markAddDTO.getStudentName(),
                         markAddDTO.getTamilMark(),
                         markAddDTO.getEnglishMark(),
                         markAddDTO.getMathsMark(),
                         markAddDTO.getScienceMark(),
                         markAddDTO.getSocialMark(),
                         (markAddDTO.getTamilMark() + markAddDTO.getEnglishMark() + markAddDTO.getMathsMark() + markAddDTO.getScienceMark() + markAddDTO.getSocialMark()),formatDateTime, null
                 );
                 studentMarkRepo.save(studentsMarks);
                 return studentsMarks;


    }

    @Override
    public List<StudentsRecordDTO> studentDetails(){
        List<StudentsMarks> list =studentMarkRepo.findAll();
        List <StudentsRecordDTO> fullList = new ArrayList<>() ;
        for(StudentsMarks a:list){
            StudentsRecordDTO studentsRecordDTO = new StudentsRecordDTO(
                    a.getStudentRegId(),a.getStudentName(),a.getTamilMark(),a.getEnglishMark(),
                    a.getMathsMark(),a.getScienceMark(),a.getSocialMark(),a.getCreatedDateTime()
            );
            fullList.add(studentsRecordDTO);

        }

         return fullList;
    }
    @Override
    public  ResponseEntity<StudentsMarks> updateStudentsList(Long studentRegId, UpdateStudentsDTO updateStudentsDTO){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formatDateTime = now.format(format);

        if(studentMarkRepo.existsByStudentRegId(studentRegId)){
          StudentsMarks studentsMarks =studentMarkRepo.findByStudentRegId(studentRegId);
             studentsMarks.setStudentName(updateStudentsDTO.getStudentName());
                studentsMarks.setTamilMark(updateStudentsDTO.getTamilMark());
            studentsMarks.setEnglishMark(updateStudentsDTO.getEnglishMark());
            studentsMarks.setScienceMark(updateStudentsDTO.getScienceMark());
            studentsMarks.setSocialMark(updateStudentsDTO.getSocialMark());
            studentsMarks.setTotalMark(updateStudentsDTO.getEnglishMark()+updateStudentsDTO.getEnglishMark()+updateStudentsDTO.getMathsMark()+updateStudentsDTO.getScienceMark()+updateStudentsDTO.getSocialMark());
            studentsMarks.setUpdateDateTime(formatDateTime);

                       studentMarkRepo.save(studentsMarks);
                       return ResponseEntity.ok(studentsMarks);
        }
        throw new CustomException("601","resource not found");
    }


    @Override
    public Long  deleteStd(Long studentRegId){
        if(studentMarkRepo.existsByStudentRegId(studentRegId)){
            StudentsMarks ms =studentMarkRepo.findByStudentRegId((studentRegId));
            studentMarkRepo.delete(ms);
            return studentRegId;

        }
        else{
            throw  new ResourceNotFoundException("the id record not found");
        }
    }
}
