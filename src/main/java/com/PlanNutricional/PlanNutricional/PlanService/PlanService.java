package com.PlanNutricional.PlanNutricional.PlanService;

import com.PlanNutricional.PlanNutricional.PlanDTO.PlanRequestDTO;
import com.PlanNutricional.PlanNutricional.PlanDTO.PlanResponseDTO;
import com.PlanNutricional.PlanNutricional.PlanDTO.UsuarioDTO;
import com.PlanNutricional.PlanNutricional.PlanNutricional.PlanNutricional;
import com.PlanNutricional.PlanNutricional.PlanRepository.PlanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
@RequiredArgsConstructor

public class PlanService {
    private final PlanRepository planRepository;

    @Autowired
    private WebClient.Builder webClientBuilder;

    private PlanResponseDTO maptoDTO(PlanNutricional planNutricional){
        return new PlanResponseDTO(
                planNutricional.getId(),
                planNutricional.getNombrePlan(),
                planNutricional.getCalorias(),
                planNutricional.getProteina(),
                planNutricional.getCarbohidratos(),
                planNutricional.getGrasas(),
                planNutricional.getMomento(),
                planNutricional.getAlimentos(),
                planNutricional.getIdUsuario()
        );
    }
    public List<PlanResponseDTO> findAll(){
        return planRepository.findAll().stream().map(this::maptoDTO).collect(Collectors.toList());
    }

    public Optional<PlanResponseDTO> findById(Long id){
        return planRepository.findById(id).map(this::maptoDTO);
    }

    public PlanResponseDTO guardar(PlanRequestDTO dto){

        UsuarioDTO usuarioDTO = webClientBuilder.build()
                .get()
                .uri("http://USUARIO/gym/socios/" + dto.getIdUsuario())
                .retrieve()
                .onStatus(status -> status.is4xxClientError(), response ->
                        Mono.error(new RuntimeException("El socio con id " + dto.getIdUsuario() + " no existe."))
                )
                .bodyToMono(UsuarioDTO.class)
                .block();

        PlanNutricional planNutricional = new PlanNutricional(
                null,
                dto.getNombrePlan(),
                dto.getCalorias(),
                dto.getProteina(),
                dto.getCarbohidratos(),
                dto.getGrasas(),
                dto.getMomento(),
                dto.getAlimentos(),
                dto.getIdUsuario()
        );
        return maptoDTO(planRepository.save(planNutricional));
    }

    public Optional<PlanResponseDTO> actualizar(Long id, PlanRequestDTO dto){
        return planRepository.findById(id).map(existente ->{
            existente.setNombrePlan(dto.getNombrePlan());
            existente.setCalorias(dto.getCalorias());
            existente.setProteina(dto.getProteina());
            existente.setCarbohidratos(dto.getCarbohidratos());
            existente.setGrasas(dto.getGrasas());
            existente.setMomento(dto.getMomento());
            existente.setAlimentos(dto.getAlimentos());
            return maptoDTO(planRepository.save(existente));
        });
    }
    public void eliminar(Long id){planRepository.deleteById(id);}
}
