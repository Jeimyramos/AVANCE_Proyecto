package com.santacruz.santacruzusuario.Controlador;

import com.santacruz.santacruzusuario.Entidad.Trabajador;
import com.santacruz.santacruzusuario.Servicio.TrabajadorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trabajadores")
public class TrabajadorControlador {
    @Autowired
    TrabajadorServicio servicio;

    @GetMapping
    public ResponseEntity<List<Trabajador>> Listar() {
        return new ResponseEntity<>(servicio.Listar(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Trabajador> Buscar(Long id) {
        Trabajador instancia = servicio.Buscar(id);
        if (instancia != null) {
            return new ResponseEntity<>(instancia, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping
    public ResponseEntity<Trabajador> Guardar(Trabajador instancia) {
        Trabajador instanciaNueva = servicio.Guardar(instancia);
        return new ResponseEntity<>(instanciaNueva, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Trabajador> Actualizar(@PathVariable Long id, @RequestBody Trabajador instancia) {
        instancia.setIdTrabajador(id);
        Trabajador instanciaActualizada = servicio.Actualizar(instancia);
        if (instanciaActualizada != null) {
            return new ResponseEntity<>(instanciaActualizada, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        Trabajador instancia = new Trabajador();
        instancia.setIdTrabajador(id);
        servicio.Eliminar(instancia);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
