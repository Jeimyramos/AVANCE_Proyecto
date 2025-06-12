package com.santacruz.santacruzalmacen.Servicio.Implementos;

import com.santacruz.santacruzalmacen.Entidad.Producto;
import com.santacruz.santacruzalmacen.Repositorio.ProductoRepositorio;
import com.santacruz.santacruzalmacen.Servicio.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductoServicioImplemento implements ProductoServicio {
    @Autowired
    private ProductoRepositorio repositorio;

    @Override
    public List<Producto> Listar(){
        return repositorio.findAll();
    }

    @Override
    public Producto Buscar(Long id){
        return repositorio.findById(id).orElse(null); // Retorna null si no se encuentra
    }

    @Override
    public Producto Guardar(Producto instancia){
        return repositorio.save(instancia);
    }

    @Override
    public Producto Actualizar(Producto instancia){
        return repositorio.save(instancia);
    }

    @Override
    public Producto Eliminar(Producto instancia){
        repositorio.delete(instancia); // Usamos delete() para eliminar
        return instancia; // Puedes retornar void si prefieres
    }
}
