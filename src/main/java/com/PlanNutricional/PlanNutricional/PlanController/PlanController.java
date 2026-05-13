package com.PlanNutricional.PlanNutricional.PlanController;

import com.PlanNutricional.PlanNutricional.PlanDTO.PlanRequestDTO;
import com.PlanNutricional.PlanNutricional.PlanDTO.PlanResponseDTO;
import com.PlanNutricional.PlanNutricional.PlanService.PlanService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Planes")
@RequiredArgsConstructor
public class PlanController {
    private final PlanService planService;

    @GetMapping
    public ResponseEntity<List<PlanResponseDTO>> findAll(){
        return ResponseEntity.ok(planService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<PlanResponseDTO> findbyId(@PathVariable Long id){
        return planService.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PlanResponseDTO> crear(
            @Valid @RequestBody PlanRequestDTO dto
            ){
        return ResponseEntity.status(201).body(planService.guardar(dto));
    }

    @PutMapping("{id}")
    public ResponseEntity<PlanResponseDTO> actualizar(
            @PathVariable Long id, @Valid @RequestBody PlanRequestDTO dto
    ){
        return planService.actualizar(id,dto).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Void> eliminar (@PathVariable Long id){
        if (planService.findById(id).isEmpty()){
            return ResponseEntity.notFound().build();
        }
        planService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
