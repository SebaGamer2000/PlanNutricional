package com.PlanNutricional.PlanNutricional.PlanDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {
    private Long idUsuario;
    private boolean pagoAlDia;
}
