package com.sanity.nil.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor
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
    private Long id;

    @Column(length = 50, nullable = false)
    private Long petId;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "type_id", referencedColumnName = "id", nullable = false)
    private Long userId;

    private String description;

    private Integer difficulty;

    private Date date;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
//    private User user;
}
