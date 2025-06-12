package com.santacruz.santacruzusuario.Repositorio;

import com.santacruz.santacruzusuario.Entidad.Trabajador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrabajadorRepositorio extends JpaRepository<Trabajador, Long> {
}
