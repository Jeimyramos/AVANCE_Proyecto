package com.santacruz.santacruzcompra.Servicio;

import com.santacruz.santacruzcompra.Entidad.Compra;

import java.util.List;

public interface CompraServicio {
    List<Compra> Listar();
    Compra Buscar(Long id);
    Compra Guardar(Compra compra);
    Compra Actualizar(Compra compra);
    Compra Eliminar(Compra compra);

}
