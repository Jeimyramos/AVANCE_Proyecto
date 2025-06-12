package com.santacruz.santacruzempresa.Controlador;

import com.santacruz.santacruzempresa.Entidad.Empresa;
import com.santacruz.santacruzempresa.Servicio.EmpresaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empresas")
public class EmpresaControlador {
    @Autowired
    EmpresaServicio servicio;

    @GetMapping
    public ResponseEntity<List<Empresa>> Listar() {
        return new ResponseEntity<>(servicio.Listar(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Empresa> Buscar(Long id) {
        Empresa instancia = servicio.Buscar(id);
        if (instancia != null) {
            return new ResponseEntity<>(instancia, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping
    public ResponseEntity<Empresa> Guardar(Empresa instancia) {
        Empresa instanciaNueva = servicio.Guardar(instancia);
        return new ResponseEntity<>(instanciaNueva, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Empresa> Actualizar(@PathVariable Long id, @RequestBody Empresa instancia) {
        instancia.setIdEmpresa(id);
        Empresa instanciaActualizada = servicio.Actualizar(instancia);
        if (instanciaActualizada != null) {
            return new ResponseEntity<>(instanciaActualizada, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        Empresa instancia = new Empresa();
        instancia.setIdEmpresa(id);
        servicio.Eliminar(instancia);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
