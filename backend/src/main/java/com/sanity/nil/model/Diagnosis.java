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
public class Diagnosis {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "sequence-diagnosis"
    )
    @SequenceGenerator(
            name = "sequence-diagnosis",
            sequenceName = "sequence_diagnosis",
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

    @Column(length = 150)
    private String description;

    private LocalDate date;
}
