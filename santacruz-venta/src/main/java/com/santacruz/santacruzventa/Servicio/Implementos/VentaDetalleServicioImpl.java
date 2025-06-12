package com.santacruz.santacruzventa.Servicio.Implementos;


import com.santacruz.santacruzventa.Entidad.VentaDetalle;
import com.santacruz.santacruzventa.Repositorio.VentaDetalleRepositorio;
import com.santacruz.santacruzventa.Servicio.VentaDetalleServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaDetalleServicioImpl implements VentaDetalleServicio {
    @Autowired
    private VentaDetalleRepositorio repositorio;

    @Override
    public List<VentaDetalle> Listar(){
        return repositorio.findAll();
    }

    @Override
    public VentaDetalle Buscar(Long id){
        return repositorio.findById(id).orElse(null); // Retorna null si no se encuentra
    }

    @Override
    public VentaDetalle Guardar(VentaDetalle instancia){
        return repositorio.save(instancia);
    }

    @Override
    public VentaDetalle Actualizar(VentaDetalle instancia){
        return repositorio.save(instancia);
    }

    @Override
    public VentaDetalle Eliminar(VentaDetalle instancia){
        repositorio.delete(instancia); // Usamos delete() para eliminar
        return instancia; // Puedes retornar void si prefieres
    }
}
