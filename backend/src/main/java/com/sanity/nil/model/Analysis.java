package com.sanity.nil.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Analysis {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "sequence-analysis"
    )
    @SequenceGenerator(
            name = "sequence-analysis",
            sequenceName = "sequence_analysis",
            allocationSize = 5
    )
    private Long id;

    @ManyToOne
    @JoinColumn(
            name = "pet_id",
            referencedColumnName = "id",
            insertable = false,
            updatable = false
    )
    private Pet pet;

    @Column(name = "blood_rate")
    private Float bloodRate;

    @Column(name = "urine_rate")
    private Float urineRate;

    private LocalDate date;

}
