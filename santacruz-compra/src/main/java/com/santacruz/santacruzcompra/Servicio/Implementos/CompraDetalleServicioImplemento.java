package com.santacruz.santacruzcompra.Servicio.Implementos;

import com.santacruz.santacruzcompra.Entidad.CompraDetalle;
import com.santacruz.santacruzcompra.Repositorio.CompraDetalleRepositorio;
import com.santacruz.santacruzcompra.Servicio.CompraDetalleServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CompraDetalleServicioImplemento implements CompraDetalleServicio {
    @Autowired
    private CompraDetalleRepositorio repositorio;

    @Override
    public List<CompraDetalle> Listar(){
        return repositorio.findAll();
    }

    @Override
    public CompraDetalle Buscar(Long id){
        return repositorio.findById(id).orElse(null); // Retorna null si no se encuentra
    }

    @Override
    public CompraDetalle Guardar(CompraDetalle instancia){
        return repositorio.save(instancia);
    }

    @Override
    public CompraDetalle Actualizar(CompraDetalle instancia){
        return repositorio.save(instancia);
    }

    @Override
    public CompraDetalle Eliminar(CompraDetalle instancia){
        repositorio.delete(instancia); // Usamos delete() para eliminar
        return instancia; // Puedes retornar void si prefieres
    }
}
