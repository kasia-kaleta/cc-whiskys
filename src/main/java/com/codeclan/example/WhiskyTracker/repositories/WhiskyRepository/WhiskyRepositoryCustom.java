package com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import java.util.List;

public interface WhiskyRepositoryCustom {
    public List<Whisky> findAllWhiskysFromDistilleryByAge(Distillery distillery, int age);
}
