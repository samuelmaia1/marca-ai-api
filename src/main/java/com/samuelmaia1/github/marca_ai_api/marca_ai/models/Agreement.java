package com.samuelmaia1.github.marca_ai_api.marca_ai.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "agreement")
@Data
@NoArgsConstructor
public class Agreement {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "agreements")
    private List<Doctor> doctors;
}
