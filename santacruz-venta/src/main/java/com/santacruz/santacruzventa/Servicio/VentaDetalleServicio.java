package com.santacruz.santacruzventa.Servicio;

import com.santacruz.santacruzventa.Entidad.VentaDetalle;

import java.util.List;

public interface VentaDetalleServicio {
    List<VentaDetalle> Listar();
    VentaDetalle Buscar(Long id);
    VentaDetalle Guardar(VentaDetalle ventaDetalle);
    VentaDetalle Actualizar(VentaDetalle ventaDetalle);
    VentaDetalle Eliminar(VentaDetalle ventaDetalle);
}
