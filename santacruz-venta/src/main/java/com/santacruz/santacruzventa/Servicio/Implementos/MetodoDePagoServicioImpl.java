package com.santacruz.santacruzventa.Servicio.Implementos;

import com.santacruz.santacruzventa.Entidad.MetodoDePago;
import com.santacruz.santacruzventa.Repositorio.MetodoDePagoRepositorio;
import com.santacruz.santacruzventa.Servicio.MetodoDePagoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MetodoDePagoServicioImpl implements MetodoDePagoServicio {

    @Autowired
    private MetodoDePagoRepositorio repositorio;

    @Override
    public List<MetodoDePago> Listar(){
        return repositorio.findAll();
    }

    @Override
    public MetodoDePago Buscar(Long id){
        return repositorio.findById(id).orElse(null); // Retorna null si no se encuentra
    }

    @Override
    public MetodoDePago Guardar(MetodoDePago instancia){
        return repositorio.save(instancia);
    }

    @Override
    public MetodoDePago Actualizar(MetodoDePago instancia){
        return repositorio.save(instancia);
    }

    @Override
    public MetodoDePago Eliminar(MetodoDePago instancia){
        repositorio.delete(instancia); // Usamos delete() para eliminar
        return instancia; // Puedes retornar void si prefieres
    }

}
