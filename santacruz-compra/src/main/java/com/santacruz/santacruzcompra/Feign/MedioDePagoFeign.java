package com.santacruz.santacruzcompra.Feign;

import com.santacruz.santacruzcompra.Dto.MedioDePagoDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "santacruz-venta-service", path = "/mediodepagos")
public interface MedioDePagoFeign {
    @GetMapping("/{id}")
    //resiliencia
    @CircuitBreaker(name = "medioDePagoListarPorIdCB", fallbackMethod = "fallbackMedioDePagoListarPorId")
    //tranceint
    public ResponseEntity<MedioDePagoDto> buscarMedioDePago(@PathVariable Long id);
    //resiliencia
    default ResponseEntity<MedioDePagoDto> fallbackMedioDePagoListarPorId(Long id, Exception e) {
        MedioDePagoDto instancia = new MedioDePagoDto();
        instancia.setNombre("Servicio no disponible de Medio De Pago");
        return ResponseEntity.ok(instancia);
    }
}
