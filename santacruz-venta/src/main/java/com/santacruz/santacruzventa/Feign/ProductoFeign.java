package com.santacruz.santacruzventa.Feign;

import com.santacruz.santacruzventa.Dto.ProductoDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "santacruz-almacen-service", path = "/productos")
public interface ProductoFeign {
    @GetMapping("/{id}")
    //resiliencia
    @CircuitBreaker(name = "productoListarPorIdCB", fallbackMethod = "fallbackProductoListarPorId")
    //tranceint
    public ResponseEntity<ProductoDto> buscarProducto(@PathVariable Long id);
    //resiliencia
    default ResponseEntity<ProductoDto> fallbackProductoListarPorId(Long id, Exception e) {
        ProductoDto instancia = new ProductoDto();
        instancia.setNombre("Servicio no disponible de productos");
        return ResponseEntity.ok(instancia);
    }

}