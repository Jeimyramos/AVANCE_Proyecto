package com.santacruz.santacruzalmacen.Repositorio;

import com.santacruz.santacruzalmacen.Entidad.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepositorio extends JpaRepository<Producto, Long> {
}
