package com.santacruz.santacruzempresa.Servicio.Implementos;

import com.santacruz.santacruzempresa.Entidad.Empresa;
import com.santacruz.santacruzempresa.Repositorio.EmpresaRepositorio;
import com.santacruz.santacruzempresa.Servicio.EmpresaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaServicioImplemento implements EmpresaServicio {
    @Autowired
    private EmpresaRepositorio repositorio;

    @Override
    public List<Empresa> Listar(){
        return repositorio.findAll();
    }

    @Override
    public Empresa Buscar(Long id){
        return repositorio.findById(id).orElse(null); // Retorna null si no se encuentra
    }

    @Override
    public Empresa Guardar(Empresa instancia){
        return repositorio.save(instancia);
    }

    @Override
    public Empresa Actualizar(Empresa instancia){
        return repositorio.save(instancia);
    }

    @Override
    public Empresa Eliminar(Empresa instancia){
        repositorio.delete(instancia); // Usamos delete() para eliminar
        return instancia; // Puedes retornar void si prefieres
    }
}
