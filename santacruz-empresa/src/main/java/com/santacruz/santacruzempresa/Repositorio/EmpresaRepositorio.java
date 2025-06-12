package com.santacruz.santacruzempresa.Repositorio;

import com.santacruz.santacruzempresa.Entidad.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepositorio extends JpaRepository<Empresa, Long> {
}
