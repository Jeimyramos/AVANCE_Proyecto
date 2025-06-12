package com.santacruz.santacruzusuario.Repositorio;

import com.santacruz.santacruzusuario.Entidad.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {
}
