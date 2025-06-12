package com.santacruz.santacruzcompra.Controlador;

import com.santacruz.santacruzcompra.Entidad.CompraDetalle;
import com.santacruz.santacruzcompra.Servicio.CompraDetalleServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/compradetalles")
public class CompraDetalleControlador {
    @Autowired
    CompraDetalleServicio servicio;

    @GetMapping
    public ResponseEntity<List<CompraDetalle>> Listar() {
        return new ResponseEntity<>(servicio.Listar(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CompraDetalle> Buscar(Long id) {
        CompraDetalle instancia = servicio.Buscar(id);
        if (instancia != null) {
            return new ResponseEntity<>(instancia, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping
    public ResponseEntity<CompraDetalle> Guardar(CompraDetalle instancia) {
        CompraDetalle instanciaNueva = servicio.Guardar(instancia);
        return new ResponseEntity<>(instanciaNueva, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<CompraDetalle> Actualizar(@PathVariable Long id, @RequestBody CompraDetalle instancia) {
        instancia.setIdCompraDetalle(id);
        CompraDetalle instanciaActualizada = servicio.Actualizar(instancia);
        if (instanciaActualizada != null) {
            return new ResponseEntity<>(instanciaActualizada, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        CompraDetalle instancia = new CompraDetalle();
        instancia.setIdCompraDetalle(id);
        servicio.Eliminar(instancia);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
