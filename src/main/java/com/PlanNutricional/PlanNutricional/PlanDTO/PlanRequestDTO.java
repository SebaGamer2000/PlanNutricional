package com.PlanNutricional.PlanNutricional.PlanDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlanRequestDTO {
    @NotBlank(message = "El nombre no puede estar vacio")
    private String nombrePlan;

    @NotNull (message = "Ingrese el numero de calorias")
    @Positive(message = "El numero debe ser mayor a 0")
    private Integer calorias;

    @NotNull (message = "Ingrese el numero de proteinas")
    @Positive(message = "El numero debe ser mayor a 0")
    private Integer proteina;

    @NotNull (message = "Ingrese el numero de carbohidratos")
    @Positive(message = "El numero debe ser mayor a 0")
    private Integer carbohidratos;

    @NotNull (message = "Ingrese el numero de grasa")
    @Positive(message = "El numero debe ser mayor a 0")
    private Integer grasas;

    @NotBlank(message = "Ingrese en que momento del dia correspondiente al plan")
    private String momento;

    @NotBlank(message = "Ingrese los alimentos correspondientes al plan")
    private String alimentos;

}
