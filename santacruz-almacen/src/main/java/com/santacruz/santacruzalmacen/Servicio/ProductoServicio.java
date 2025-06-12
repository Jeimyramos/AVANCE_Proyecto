package com.santacruz.santacruzalmacen.Servicio;

import com.santacruz.santacruzalmacen.Entidad.Producto;

import java.util.List;

public interface ProductoServicio {
    List<Producto> Listar();
    Producto Buscar(Long id);
    Producto Guardar(Producto producto);
    Producto Actualizar(Producto producto);
    Producto Eliminar(Producto producto);

}
