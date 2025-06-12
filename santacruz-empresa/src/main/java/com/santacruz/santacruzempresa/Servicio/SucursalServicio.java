package com.santacruz.santacruzempresa.Servicio;

import com.santacruz.santacruzempresa.Entidad.Sucursal;

import java.util.List;

public interface SucursalServicio {
    List<Sucursal> Listar();
    Sucursal Buscar(Long id);
    Sucursal Guardar(Sucursal sucursal);
    Sucursal Actualizar(Sucursal sucursal);
    Sucursal Eliminar(Sucursal sucursal);
}
