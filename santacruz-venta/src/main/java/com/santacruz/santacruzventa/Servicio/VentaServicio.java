package com.santacruz.santacruzventa.Servicio;

import com.santacruz.santacruzventa.Entidad.Venta;

import java.util.List;

public interface VentaServicio {
    List<Venta> Listar();
    Venta Buscar(Long id);
    Venta Guardar(Venta venta);
    Venta Actualizar(Venta venta);
    Venta Eliminar(Venta venta);

}
