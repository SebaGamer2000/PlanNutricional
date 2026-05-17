package com.PlanNutricional.PlanNutricional.PlanDTO;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlanResponseDTO {
    private Long id;
    private String nombrePlan;
    private Integer calorias;
    private Integer proteina;
    private Integer carbohidratos;
    private Integer grasas;
    private String momento;
    private String alimentos;
    private Long idUsuario;
}
