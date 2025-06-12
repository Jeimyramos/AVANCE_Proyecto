package com.santacruz.santacruzventa.Controlador;

import com.santacruz.santacruzventa.Entidad.MetodoDePago;
import com.santacruz.santacruzventa.Entidad.VentaDetalle;
import com.santacruz.santacruzventa.Servicio.VentaDetalleServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ventadetalles")
public class VentaDetalleControlador {
    @Autowired
    VentaDetalleServicio servicio;

    @GetMapping
    public ResponseEntity <List<VentaDetalle>> Listar() {
        return new ResponseEntity<>(servicio.Listar(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<VentaDetalle> Buscar(Long id) {
        VentaDetalle ventaDetalle = servicio.Buscar(id);
        if (ventaDetalle != null) {
            return new ResponseEntity<>(ventaDetalle, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping
    public ResponseEntity<VentaDetalle> Guardar(VentaDetalle ventaDetalle) {
        VentaDetalle nuevoVentaDetalle = servicio.Guardar(ventaDetalle);
        return new ResponseEntity<>(nuevoVentaDetalle, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<VentaDetalle> Actualizar(@PathVariable Long id, @RequestBody VentaDetalle instancia) {
        instancia.setIdVentaDetalle(id);
        VentaDetalle instanciaActualizada = servicio.Actualizar(instancia);
        if (instanciaActualizada != null) {
            return new ResponseEntity<>(instanciaActualizada, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        VentaDetalle instancia = new VentaDetalle();
        instancia.setIdVentaDetalle(id);
        servicio.Eliminar(instancia);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
