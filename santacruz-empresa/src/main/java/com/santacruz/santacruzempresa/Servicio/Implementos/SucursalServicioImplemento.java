package com.santacruz.santacruzempresa.Servicio.Implementos;

import com.santacruz.santacruzempresa.Entidad.Sucursal;
import com.santacruz.santacruzempresa.Repositorio.SucursalRepositorio;
import com.santacruz.santacruzempresa.Servicio.SucursalServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SucursalServicioImplemento implements SucursalServicio {
    @Autowired
    private SucursalRepositorio repositorio;

    @Override
    public List<Sucursal> Listar(){
        return repositorio.findAll();
    }

    @Override
    public Sucursal Buscar(Long id){
        return repositorio.findById(id).orElse(null); // Retorna null si no se encuentra
    }

    @Override
    public Sucursal Guardar(Sucursal instancia){
        return repositorio.save(instancia);
    }

    @Override
    public Sucursal Actualizar(Sucursal instancia){
        return repositorio.save(instancia);
    }

    @Override
    public Sucursal Eliminar(Sucursal instancia){
        repositorio.delete(instancia); // Usamos delete() para eliminar
        return instancia; // Puedes retornar void si prefieres
    }
}
