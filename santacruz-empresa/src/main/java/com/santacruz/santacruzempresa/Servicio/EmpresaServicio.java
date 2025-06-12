package com.santacruz.santacruzempresa.Servicio;

import com.santacruz.santacruzempresa.Entidad.Empresa;

import java.util.List;

public interface EmpresaServicio {
    List<Empresa> Listar();
    Empresa Buscar(Long id);
    Empresa Guardar(Empresa empresa);
    Empresa Actualizar(Empresa empresa);
    Empresa Eliminar(Empresa empresa);
}
