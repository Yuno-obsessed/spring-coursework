package com.sanity.nil.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "surgery", schema = "public")
public class Surgery {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "sequence-surgery"
    )
    @SequenceGenerator(
            name = "sequence-surgery",
            sequenceName = "sequence_surgery",
            allocationSize = 5
    )
    @Column(name = "surgery_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pet_id", referencedColumnName = "id", nullable = false)
    private Pet pet;

    @Column(length = 75, nullable = false)
    private String description;

    @Min(value = 1)
    @Max(value = 10)
    @Column(nullable = false)
    private Integer difficulty;

    private LocalDate date;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Surgery surgery)) return false;
        return getId() != null &&
                Objects.equals(getId(), surgery.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
