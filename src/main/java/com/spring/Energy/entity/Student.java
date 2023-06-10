package com.spring.Energy.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "student_details")
public class Student {

    @Id
    @GeneratedValue(generator ="stud_id",strategy =GenerationType.AUTO)
    @SequenceGenerator(name="stud_id",sequenceName = "stud_seq",initialValue = 1,allocationSize = 1)
    @Column(name="student_id")
    private Long studentId;

    @Column(name = "student_roll_id", length = 10)
    private Long studentRollNo;

    @Column(name = "student_name", length = 50)
    private String studentName;

    @Column(name = "student_standard", length = 10)
    private String studentStd;

    @Column(name="mobile_no",length = 10)
    private Long mobileNo;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private StudentsMarks studentsMarks;

}
