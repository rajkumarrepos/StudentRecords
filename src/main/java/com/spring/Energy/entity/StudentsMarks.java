package com.spring.Energy.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Locale;

@Entity
@Builder
@NoArgsConstructor(force = true)
@AllArgsConstructor
@ToString
@Setter
@Getter
@Table(name ="student_mark_registry1")
public class StudentsMarks {
    @Id
    @Column(name = "student_id", length = 5)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long studentId;

    @Column(name ="register_id",length =12 )
    private Long studentRegId;


    @Column(name="student_name",length = 50)
    private String studentName;

    @Column(name ="tamil_mark",length = 3)
    private Integer tamilMark;

    @Column(name ="english_mark",length = 3)
    private Integer englishMark;

    @Column(name="maths_mark",length = 3)
    private Integer mathsMark;

    @Column(name ="science_mark",length = 3)
    private Integer scienceMark;

    @Column(name="social_mark",length = 3)
    private Integer socialMark;

    @Column(name="total_mark",length = 3)
    private Integer totalMark;

    @Column (name="created_date_time")
    private String createdDateTime;

    @Column(name="updated_date_time")
    private String  updateDateTime;
}
