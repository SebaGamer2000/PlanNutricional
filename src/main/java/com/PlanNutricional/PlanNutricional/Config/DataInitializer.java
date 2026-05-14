package com.PlanNutricional.PlanNutricional.Config;

import com.PlanNutricional.PlanNutricional.PlanNutricional.PlanNutricional;
import com.PlanNutricional.PlanNutricional.PlanRepository.PlanRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {
    private final PlanRepository planRepository;

    @Override
    public void run(String... args){
        if (planRepository.count() > 0){
            log.info("Datos cargados");
            return;
        }
        log.info("No hay datos guardados");

        planRepository.save(
                new PlanNutricional(null, "Mantenimiento Saludable", 2000, 150, 200, 65, "Almuerzo", "Pechuga de pollo a la plancha (200g), taza de arroz integral y ensalada mixta de lechuga y tomate con una cucharada de aceite de oliva." )
        );

        planRepository.save(
                new PlanNutricional(null, "Volumen Limpio", 3200, 200, 450, 80,"Post-Entrenamiento", "Batido de proteina de suero de leche, dos platanos grandes, 100g de avena instantanea mezclada con yogur griego descremado")
        );
    }
}
