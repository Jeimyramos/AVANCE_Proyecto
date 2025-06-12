package com.santacruz.santacruzalmacen.Controlador;

import com.santacruz.santacruzalmacen.Entidad.Categoria;
import com.santacruz.santacruzalmacen.Servicio.CategoriaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaControlador {
    @Autowired
    CategoriaServicio servicio;

    @GetMapping
    public ResponseEntity<List<Categoria>> Listar() {
        return new ResponseEntity<>(servicio.Listar(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Categoria> Buscar(Long id) {
        Categoria instancia = servicio.Buscar(id);
        if (instancia != null) {
            return new ResponseEntity<>(instancia, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping
    public ResponseEntity<Categoria> Guardar(Categoria instancia) {
        Categoria instanciaNueva = servicio.Guardar(instancia);
        return new ResponseEntity<>(instanciaNueva, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Categoria> Actualizar(@PathVariable Long id, @RequestBody Categoria instancia) {
        instancia.setIdCategoria(id);
        Categoria instanciaActualizada = servicio.Actualizar(instancia);
        if (instanciaActualizada != null) {
            return new ResponseEntity<>(instanciaActualizada, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        Categoria instancia = new Categoria();
        instancia.setIdCategoria(id);
        servicio.Eliminar(instancia);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
