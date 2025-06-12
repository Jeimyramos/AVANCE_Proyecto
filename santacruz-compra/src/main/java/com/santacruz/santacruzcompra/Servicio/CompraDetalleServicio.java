package com.santacruz.santacruzcompra.Servicio;

import com.santacruz.santacruzcompra.Entidad.CompraDetalle;

import java.util.List;

public interface CompraDetalleServicio {
    List<CompraDetalle> Listar();
    CompraDetalle Buscar(Long id);
    CompraDetalle Guardar(CompraDetalle compraDetalle);
    CompraDetalle Actualizar(CompraDetalle compraDetalle);
    CompraDetalle Eliminar(CompraDetalle compraDetalle);

}
