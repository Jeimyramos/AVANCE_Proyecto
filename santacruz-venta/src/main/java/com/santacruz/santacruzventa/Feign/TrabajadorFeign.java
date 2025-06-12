package com.santacruz.santacruzventa.Feign;

import com.santacruz.santacruzventa.Dto.TrabajadorDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "santacruz-trabajador-service", path = "/trabajadores")
public interface TrabajadorFeign {

    @GetMapping("/{id}")
    //resiliencia
    @CircuitBreaker(name = "trabajadorListarPorIdCB", fallbackMethod = "fallbackTrabajadorListarPorId")

        //tranceint
    TrabajadorDto obtenerTrabajadorPorId(@PathVariable("id") Long id);

    //resiliencia
    default ResponseEntity<TrabajadorDto> fallbackTrabajadorListarPorId(Long id, Exception e) {
        TrabajadorDto instancia = new TrabajadorDto();
        instancia.setNombre("Servicio no disponible de Trabajadores");
        return ResponseEntity.ok(instancia);
    }

}
