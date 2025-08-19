package com.samuelmaia1.github.marca_ai_api.marca_ai.repositories;

import com.samuelmaia1.github.marca_ai_api.marca_ai.models.RecurringAvailability;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RecurringAvailabilityRepository extends JpaRepository<RecurringAvailability, UUID> {
}
