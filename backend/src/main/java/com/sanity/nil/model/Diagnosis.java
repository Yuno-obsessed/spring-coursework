package com.sanity.nil.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pet_diagnosis", schema = "public")
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
    @Column(name = "diagnosis_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pet_id", referencedColumnName = "id", nullable = false)
    private Pet pet;

    @Column(length = 150)
    private String description;

    private LocalDate date;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Diagnosis diagnosis)) return false;
        return getId() != null &&
                Objects.equals(getId(), diagnosis.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
