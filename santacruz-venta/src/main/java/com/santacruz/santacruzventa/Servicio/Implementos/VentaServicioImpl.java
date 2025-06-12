package com.santacruz.santacruzventa.Servicio.Implementos;


import com.santacruz.santacruzventa.Entidad.Venta;
import com.santacruz.santacruzventa.Repositorio.VentaRepositorio;
import com.santacruz.santacruzventa.Servicio.VentaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaServicioImpl implements VentaServicio {
    @Autowired
    private VentaRepositorio repositorio;

    @Override
    public List<Venta> Listar(){
        return repositorio.findAll();
    }

    @Override
    public Venta Buscar(Long id){
        return repositorio.findById(id).orElse(null); // Retorna null si no se encuentra
    }

    @Override
    public Venta Guardar(Venta instancia){
        return repositorio.save(instancia);
    }

    @Override
    public Venta Actualizar(Venta instancia){
        return repositorio.save(instancia);
    }

    @Override
    public Venta Eliminar(Venta instancia){
        repositorio.delete(instancia); // Usamos delete() para eliminar
        return instancia; // Puedes retornar void si prefieres
    }
}
