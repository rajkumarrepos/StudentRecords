package com.spring.Energy.entity;

import jakarta.persistence.*;
import jakarta.validation.Constraint;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Locale;
@Data
@Entity
@Builder
@NoArgsConstructor(force = true)
@AllArgsConstructor
@ToString
@Setter
@Getter
@Table(name ="student_mark_registry")
public class StudentsMarks {
    @Id
    @GeneratedValue(generator = "studMark_id", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "studMark_id", sequenceName = "studMark_seq", initialValue = 1, allocationSize = 1)
    private Long studentId;

    @Column(name="student_roll_id")
    private Long studentRollNo;

    @Column(name = "tamil_mark", length = 3)
    private Integer tamil;

    @Column(name = "english_mark", length = 3)
    private Integer english;

    @Column(name = "maths_mark", length = 3)
    private Integer maths;

    @Column(name = "science_mark", length = 3)
    private Integer science;

    @Column(name = "social_mark", length = 3)
    private Integer social;

    @Column(name = "total_mark", length = 3)
    private Integer total;

    @Column(name = "created_date_time")
    private String createdDateTime;

    @Column(name = "updated_date_time")
    private String updateDateTime;


}

