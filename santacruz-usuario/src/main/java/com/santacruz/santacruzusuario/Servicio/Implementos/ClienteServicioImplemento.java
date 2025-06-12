package com.santacruz.santacruzusuario.Servicio.Implementos;

import com.santacruz.santacruzusuario.Entidad.Cliente;
import com.santacruz.santacruzusuario.Repositorio.ClienteRepositorio;
import com.santacruz.santacruzusuario.Servicio.ClienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServicioImplemento implements ClienteServicio {
    @Autowired
    private ClienteRepositorio repositorio;

    @Override
    public List<Cliente> Listar(){
        return repositorio.findAll();
    }

    @Override
    public Cliente Buscar(Long id){
        return repositorio.findById(id).orElse(null); // Retorna null si no se encuentra
    }

    @Override
    public Cliente Guardar(Cliente instancia){
        return repositorio.save(instancia);
    }

    @Override
    public Cliente Actualizar(Cliente instancia){
        return repositorio.save(instancia);
    }

    @Override
    public Cliente Eliminar(Cliente instancia){
        repositorio.delete(instancia); // Usamos delete() para eliminar
        return instancia; // Puedes retornar void si prefieres
    }
}
