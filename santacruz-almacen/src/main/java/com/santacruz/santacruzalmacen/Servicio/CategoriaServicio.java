package com.santacruz.santacruzalmacen.Servicio;

import com.santacruz.santacruzalmacen.Entidad.Categoria;

import java.util.List;

public interface CategoriaServicio {
    List<Categoria> Listar();
    Categoria Buscar(Long id);
    Categoria Guardar(Categoria categoria);
    Categoria Actualizar(Categoria categoria);
    Categoria Eliminar(Categoria categoria);

}
