package com.santacruz.santacruzalmacen.Servicio.Implementos;

import com.santacruz.santacruzalmacen.Entidad.Categoria;
import com.santacruz.santacruzalmacen.Repositorio.CategoriaRepositorio;
import com.santacruz.santacruzalmacen.Servicio.CategoriaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoriaServicioImplemento implements CategoriaServicio {
    @Autowired
    private CategoriaRepositorio repositorio;

    @Override
    public List<Categoria> Listar(){
        return repositorio.findAll();
    }

    @Override
    public Categoria Buscar(Long id){
        return repositorio.findById(id).orElse(null); // Retorna null si no se encuentra
    }

    @Override
    public Categoria Guardar(Categoria instancia){
        return repositorio.save(instancia);
    }

    @Override
    public Categoria Actualizar(Categoria instancia){
        return repositorio.save(instancia);
    }

    @Override
    public Categoria Eliminar(Categoria instancia){
        repositorio.delete(instancia); // Usamos delete() para eliminar
        return instancia; // Puedes retornar void si prefieres
    }
}
