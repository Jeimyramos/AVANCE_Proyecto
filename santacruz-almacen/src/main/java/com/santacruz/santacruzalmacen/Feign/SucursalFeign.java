package com.santacruz.santacruzalmacen.Feign;

import com.santacruz.santacruzalmacen.Dto.SucursalDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "santacruz-empresa-service", path = "/sucursales")
public interface SucursalFeign {
    @GetMapping("/{id}")
    //resiliencia
    @CircuitBreaker(name = "sucursalListarPorIdCB", fallbackMethod = "fallbackSucursalListarPorId")
    //tranceint
    public ResponseEntity<SucursalDto> buscarSucursal(@PathVariable Long id);
    //resiliencia
    default ResponseEntity<SucursalDto> fallbackSucursalListarPorId(Long id, Exception e) {
        SucursalDto instancia = new SucursalDto();
        instancia.setNombre("Servicio no disponible de Sucursal");
        return ResponseEntity.ok(instancia);
    }
}
