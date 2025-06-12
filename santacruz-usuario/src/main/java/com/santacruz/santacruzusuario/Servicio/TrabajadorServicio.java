package com.santacruz.santacruzusuario.Servicio;

import com.santacruz.santacruzusuario.Entidad.Trabajador;

import java.util.List;

public interface TrabajadorServicio {
    List<Trabajador> Listar();
    Trabajador Buscar(Long id);
    Trabajador Guardar(Trabajador trabajador);
    Trabajador Actualizar(Trabajador trabajador);
    Trabajador Eliminar(Trabajador trabajador);
}
