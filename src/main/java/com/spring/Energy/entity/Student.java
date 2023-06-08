package com.spring.Energy.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "student_details")
public class Student {

    @Id
    @Column(name = "student_id", length = 10)
    private Long studentId;
    @Column(name = "student_name", length = 50)
    private String studentName;
    @Column(name = "student_standard", length = 10)
    private String studentStd;
    @Column(name = "mobile_no", length = 10)
    private Long mobileNo;

    public Student() {
    }


    public Student(Long studentID, String studentName, String studentStd, Long mobileNo) {
        this.studentId = studentID;
        this.studentName = studentName;
        this.studentStd = studentStd;
        this.mobileNo = mobileNo;
    }

    public Student(String studentName, String studentStd, Long mobileNo) {
        this.studentName = studentName;
        this.studentStd = studentStd;
        this.mobileNo = mobileNo;
    }

    public void setID(Long ID) {
        this.studentId = ID;
    }

    public Long getID() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentStd() {
        return studentStd;
    }

    public void setStudentStd(String studentStd) {

        this.studentStd = studentStd;

    }

    public Long getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(Long mobileNo) {
        this.mobileNo = mobileNo;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentID=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", studentStd=" + studentStd +
                ", mobileNo=" + mobileNo +
                '}';
    }


}
