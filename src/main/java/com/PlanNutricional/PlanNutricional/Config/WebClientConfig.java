package com.PlanNutricional.PlanNutricional.Config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
    //Configuracion para conectar con otros microservicios
    @Bean
    public WebClient.Builder webClientBuilder() {
        return WebClient.builder().defaultHeaders(headers ->
                headers.setBasicAuth("admin", "admin123")
        );
    }
}
