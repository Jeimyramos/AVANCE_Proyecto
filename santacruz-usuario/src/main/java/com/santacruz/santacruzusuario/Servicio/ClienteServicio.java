package com.santacruz.santacruzusuario.Servicio;

import com.santacruz.santacruzusuario.Entidad.Cliente;

import java.util.List;

public interface ClienteServicio {
    List<Cliente> Listar();
    Cliente Buscar(Long id);
    Cliente Guardar(Cliente cliente);
    Cliente Actualizar(Cliente cliente);
    Cliente Eliminar(Cliente cliente);
}
