package com.samuelmaia1.github.marca_ai_api.marca_ai.models;

import com.samuelmaia1.github.marca_ai_api.marca_ai.dto.request.RequestUserDto;
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
@Table(name = "users")
@Data
@NoArgsConstructor
public class User {
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

    @CreatedDate
    @Column
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Consultation> consultations = new ArrayList<>();

    public User(RequestUserDto dto) {
        this.name = dto.getName();
        this.cpf = dto.getCpf();
        this.lastName = dto.getLastName();
        this.birthDay = dto.getBirthDay();
        this.email = dto.getEmail();
        this.description = dto.getDescription();
    }
}
