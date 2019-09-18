package com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import java.util.List;

public interface WhiskyRepositoryCustom {
    List<Whisky> findAllWhiskiesFromDistilleryByAge(Long distilleryId, int age);
    List<Whisky> findAllWhiskiesByRegion(String region);
}
