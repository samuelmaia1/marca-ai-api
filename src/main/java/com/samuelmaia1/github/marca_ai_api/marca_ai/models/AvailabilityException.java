package com.samuelmaia1.github.marca_ai_api.marca_ai.models;

import com.samuelmaia1.github.marca_ai_api.marca_ai.enums.AvailabilityExceptionType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Entity
@Table(name = "availability_exception")
@Data
@NoArgsConstructor
public class AvailabilityException {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "start_time", nullable = false)
    private LocalTime start;

    @Column(name = "end_time", nullable = false)
    private LocalTime end;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", length = 30)
    private AvailabilityExceptionType type;

    @Override
    public String toString() {
        return start + " " + end + date.getDayOfWeek().toString();
    }
}