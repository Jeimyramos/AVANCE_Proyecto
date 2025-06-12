package com.santacruz.santacruzusuario.Servicio.Implementos;

import com.santacruz.santacruzusuario.Entidad.Trabajador;
import com.santacruz.santacruzusuario.Repositorio.TrabajadorRepositorio;
import com.santacruz.santacruzusuario.Servicio.TrabajadorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrabajadorServicioImplemento implements TrabajadorServicio {
    @Autowired
    private TrabajadorRepositorio repositorio;

    @Override
    public List<Trabajador> Listar(){
        return repositorio.findAll();
    }

    @Override
    public Trabajador Buscar(Long id){
        return repositorio.findById(id).orElse(null); // Retorna null si no se encuentra
    }

    @Override
    public Trabajador Guardar(Trabajador instancia){
        return repositorio.save(instancia);
    }

    @Override
    public Trabajador Actualizar(Trabajador instancia){
        return repositorio.save(instancia);
    }

    @Override
    public Trabajador Eliminar(Trabajador instancia){
        repositorio.delete(instancia); // Usamos delete() para eliminar
        return instancia; // Puedes retornar void si prefieres
    }
}
