package com.santacruz.santacruzventa.Servicio;

import com.santacruz.santacruzventa.Entidad.MetodoDePago;

import java.util.List;

public interface MetodoDePagoServicio {
    List<MetodoDePago> Listar();
    MetodoDePago Buscar(Long id);
    MetodoDePago Guardar(MetodoDePago metodoDePago);
    MetodoDePago Actualizar(MetodoDePago metodoDePago);
    MetodoDePago Eliminar(MetodoDePago metodoDePago);

}
