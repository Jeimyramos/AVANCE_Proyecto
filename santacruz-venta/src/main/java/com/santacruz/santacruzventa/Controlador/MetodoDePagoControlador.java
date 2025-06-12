package com.santacruz.santacruzventa.Controlador;


import com.santacruz.santacruzventa.Entidad.MetodoDePago;
import com.santacruz.santacruzventa.Servicio.MetodoDePagoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mediodepagos")
public class MetodoDePagoControlador {
    @Autowired
    MetodoDePagoServicio servicio;

    @GetMapping
    public ResponseEntity<List<MetodoDePago>> Listar() {
        return new ResponseEntity<>(servicio.Listar(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<MetodoDePago> Buscar(Long id) {
        MetodoDePago instancia = servicio.Buscar(id);
        if (instancia != null) {
            return new ResponseEntity<>(instancia, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping
    public ResponseEntity<MetodoDePago> Guardar(MetodoDePago instancia) {
        MetodoDePago instanciaNueva = servicio.Guardar(instancia);
        return new ResponseEntity<>(instanciaNueva, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<MetodoDePago> Actualizar(@PathVariable Long id, @RequestBody MetodoDePago instancia) {
        instancia.setIdMetodoPago(id);
        MetodoDePago instanciaActualizada = servicio.Actualizar(instancia);
        if (instanciaActualizada != null) {
            return new ResponseEntity<>(instanciaActualizada, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        MetodoDePago instancia = new MetodoDePago();
        instancia.setIdMetodoPago(id);
        servicio.Eliminar(instancia);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
