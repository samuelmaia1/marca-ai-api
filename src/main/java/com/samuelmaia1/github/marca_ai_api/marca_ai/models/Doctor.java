package com.samuelmaia1.github.marca_ai_api.marca_ai.models;

import com.samuelmaia1.github.marca_ai_api.marca_ai.enums.Speciality;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "doctor")
@Data
@NoArgsConstructor
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "last_name", length = 100, nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "birth_day", nullable = false)
    private LocalDate birthDay;

    @Column(name = "description", nullable = false, length = 300)
    private String description;

    @Column(name = "password", nullable = false, length = 100)
    private String password;

    @Column(name = "cpf", nullable = false, length = 16)
    private String cpf;

    @Column(name = "crm", nullable = false)
    private String crm;

    @Enumerated(EnumType.STRING)
    @Column(name = "speciality", length = 30, nullable = false)
    private Speciality speciality;

    @CreatedDate
    @Column
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RecurringAvailability> recurringAvailabilities = new ArrayList<>();

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AvailabilityException> exceptionsAvailabilities = new ArrayList<>();

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Consultation> consultations = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "doctor_agreement",
            joinColumns = @JoinColumn(name = "doctor_id"),
            inverseJoinColumns = @JoinColumn(name = "agreement_id")
    )
    private List<Agreement> agreements = new ArrayList<>();
}
