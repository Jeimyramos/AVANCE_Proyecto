package com.santacruz.santacruzventa.Controlador;


import com.santacruz.santacruzventa.Entidad.MetodoDePago;
import com.santacruz.santacruzventa.Entidad.Venta;
import com.santacruz.santacruzventa.Servicio.VentaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ventas")
public class VentaControlador {
    @Autowired
    VentaServicio servicio;

    @GetMapping
    public ResponseEntity<List<Venta>> Listar() {
        return new ResponseEntity<>(servicio.Listar(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Venta> Buscar(Long id) {
        Venta instancia = servicio.Buscar(id);
        if (instancia != null) {
            return new ResponseEntity<>(instancia, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping
    public ResponseEntity<Venta> Guardar(Venta instancia) {
        Venta instanciaNueva = servicio.Guardar(instancia);
        return new ResponseEntity<>(instanciaNueva, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Venta> Actualizar(@PathVariable Long id, @RequestBody Venta instancia) {
        instancia.setIdVenta(id);
        Venta instanciaActualizada = servicio.Actualizar(instancia);
        if (instanciaActualizada != null) {
            return new ResponseEntity<>(instanciaActualizada, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        Venta instancia = new Venta();
        instancia.setIdVenta(id);
        servicio.Eliminar(instancia);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
