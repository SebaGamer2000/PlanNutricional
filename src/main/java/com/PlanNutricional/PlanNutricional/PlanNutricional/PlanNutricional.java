package com.PlanNutricional.PlanNutricional.PlanNutricional;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "Planes Nutricionales")
public class PlanNutricional {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String nombrePlan;

    @Column
    private Integer calorias;

    @Column
    private Integer proteina;

    @Column
    private Integer carbohidratos;

    @Column
    private Integer grasas;

    @Column (nullable = false)
    private String momento;

    @Column (nullable = false)
    private String alimentos;

}
