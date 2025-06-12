package com.santacruz.santacruzcompra.Feign;

import com.santacruz.santacruzcompra.Dto.TrabajadorDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "santacruz-usuario-service", path = "/trabajadores")
public interface TrabajadorFeign {
    @GetMapping("/{id}")
    //resiliencia
    @CircuitBreaker(name = "TrabajadorListarPorIdCB", fallbackMethod = "fallbackTrabajadorListarPorId")
    //tranceint
    public ResponseEntity<TrabajadorDto> buscarTrabajador(@PathVariable Long id);
    //resiliencia
    default ResponseEntity<TrabajadorDto> fallbackTrabajadorListarPorId(Long id, Exception e) {
        TrabajadorDto instancia = new TrabajadorDto();
        instancia.setNombre("Servicio no disponible de Medio De Pago");
        return ResponseEntity.ok(instancia);
    }
}
