package com.santacruz.santacruzventa.Feign;

import com.santacruz.santacruzventa.Dto.ClienteDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "santacruz-cliente-service", path = "/clientes")
public interface ClienteFeign {

    @GetMapping("/{id}")
    //resiliencia
    @CircuitBreaker(name = "clienteListarPorIdCB", fallbackMethod = "fallbackClienteListarPorId")

    //tranceint
    ClienteDto obtenerClientePorId(@PathVariable("id") Long id);

    //resiliencia
    default ResponseEntity<ClienteDto> fallbackClienteListarPorId(Long id, Exception e) {
        ClienteDto instancia = new ClienteDto();
        instancia.setNombre("Servicio no disponible de clientes");
        return ResponseEntity.ok(instancia);
    }
}
