package com.santacruz.santacruzcompra.Servicio.Implementos;

import com.santacruz.santacruzcompra.Entidad.Compra;
import com.santacruz.santacruzcompra.Repositorio.CompraRepositorio;
import com.santacruz.santacruzcompra.Servicio.CompraServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CompraServicioImplemento implements CompraServicio {
    @Autowired
    private CompraRepositorio repositorio;

    @Override
    public List<Compra> Listar(){
        return repositorio.findAll();
    }

    @Override
    public Compra Buscar(Long id){
        return repositorio.findById(id).orElse(null); // Retorna null si no se encuentra
    }

    @Override
    public Compra Guardar(Compra instancia){
        return repositorio.save(instancia);
    }

    @Override
    public Compra Actualizar(Compra instancia){
        return repositorio.save(instancia);
    }

    @Override
    public Compra Eliminar(Compra instancia){
        repositorio.delete(instancia); // Usamos delete() para eliminar
        return instancia; // Puedes retornar void si prefieres
    }
}
