package com.spring.Energy.serviceImpl;

import com.spring.Energy.requestDTO.MarkAddDTO;
import com.spring.Energy.responseDTO.StudentsMarkRecordDTO;
import com.spring.Energy.requestDTO.UpdateStudentsMarkDTO;
import com.spring.Energy.entity.StudentsMarks;
import com.spring.Energy.exceptionController.CustomException;
import com.spring.Energy.exception.ResourceNotFoundException;
import com.spring.Energy.repository.StudentMarkRepo;
import com.spring.Energy.services.MarkListService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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
    public StudentsMarks markRegistering(MarkAddDTO markAddDTO) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formatDateTime = now.format(format);
        if ((markAddDTO.getStudentRollNo().toString().length() == 12) != (studentMarkRepo.existsByStudentRollNo(markAddDTO.getStudentRollNo()))) {
            if ((markAddDTO.getTamil() <= 100) && (markAddDTO.getEnglish() <= 100) && (markAddDTO.getMaths() <= 100) && (markAddDTO.getScience() <= 100) && (markAddDTO.getSocial() <= 100)) {
                StudentsMarks studentsMarks = new StudentsMarks();
                studentsMarks.setStudentRollNo(markAddDTO.getStudentRollNo());
                studentsMarks.setTamil(markAddDTO.getTamil());
                studentsMarks.setEnglish(markAddDTO.getEnglish());
                studentsMarks.setMaths(markAddDTO.getMaths());
                studentsMarks.setScience(markAddDTO.getScience());
                studentsMarks.setSocial(markAddDTO.getSocial());
                studentsMarks.setCreatedDateTime(formatDateTime);

                studentMarkRepo.save(studentsMarks);
                return studentsMarks;

            }
            else {
                throw new CustomException("602", "your are giving invalid input");
            }
        }
        else {
            throw new CustomException("602", "Given id exists / wrong id /you can do only update for this id ");
        }
    }




    @Override
    public List<StudentsMarkRecordDTO> studentDetails(){
        List<StudentsMarks> list =studentMarkRepo.findAll();
        List <StudentsMarkRecordDTO> fullList = new ArrayList<>() ;
        for(StudentsMarks a:list){
            StudentsMarkRecordDTO studentsRecordDTO = new StudentsMarkRecordDTO(
                    a.getStudentRollNo(),a.getTamil(),a.getEnglish(),
                    a.getMaths(),a.getScience(),a.getSocial(),a.getCreatedDateTime()
            );
            fullList.add(studentsRecordDTO);

        }

         return fullList;
    }
    @Override
    public  ResponseEntity<StudentsMarks> updateStudentsList(Long studentRegId, UpdateStudentsMarkDTO updateStudentsMarkDTO){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formatDateTime = now.format(format);

        if(studentMarkRepo.existsByStudentRollNo(studentRegId)){
          StudentsMarks studentsMarks =studentMarkRepo.findByStudentRollNo(studentRegId);
            //BeanUtils.copyProperties(updateStudentsDTO, studentsMarks);

                studentsMarks.setTamil(updateStudentsMarkDTO.getTamil());
            studentsMarks.setEnglish(updateStudentsMarkDTO.getEnglish());
            studentsMarks.setScience(updateStudentsMarkDTO.getScience());
            studentsMarks.setSocial(updateStudentsMarkDTO.getSocial());
            studentsMarks.setTotal(updateStudentsMarkDTO.getEnglish()+ updateStudentsMarkDTO.getEnglish()+ updateStudentsMarkDTO.getMaths()+ updateStudentsMarkDTO.getScience()+ updateStudentsMarkDTO.getSocial());
            studentsMarks.setUpdateDateTime(formatDateTime);

                       studentMarkRepo.save(studentsMarks);
                       return ResponseEntity.ok(studentsMarks);
        }
        throw new CustomException("601","resource not found");
    }


    @Override
    public Long  deleteStd(Long studentRegId){
        if(studentMarkRepo.existsByStudentRollNo(studentRegId)){
            StudentsMarks ms =studentMarkRepo.findByStudentRollNo((studentRegId));
            studentMarkRepo.delete(ms);
            return studentRegId;

        }
        else{
            throw  new ResourceNotFoundException("the id record not found");
        }
    }
    @Override
    public StudentsMarks getName(String name){
        StudentsMarks studentsMarks =studentMarkRepo.getStudentName(name);
        return studentsMarks;
    }
}
