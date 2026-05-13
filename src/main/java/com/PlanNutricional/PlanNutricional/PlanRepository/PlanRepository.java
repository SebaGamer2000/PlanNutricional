package com.PlanNutricional.PlanNutricional.PlanRepository;

import com.PlanNutricional.PlanNutricional.PlanNutricional.PlanNutricional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanRepository extends JpaRepository<PlanNutricional, Long> {
}
