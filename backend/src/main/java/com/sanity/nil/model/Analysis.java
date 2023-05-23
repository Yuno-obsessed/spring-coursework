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
@Table(name = "pet_analysis", schema = "public")
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
    @Column(name = "analysis_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pet_id", referencedColumnName = "id", nullable = false)
    private Pet pet;

    @Column(name = "blood_rate")
    private Float bloodRate;

    @Column(name = "urine_rate")
    private Float urineRate;

    private LocalDate date;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Analysis analysis)) return false;
        return getId() != null &&
                Objects.equals(getId(), analysis.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
