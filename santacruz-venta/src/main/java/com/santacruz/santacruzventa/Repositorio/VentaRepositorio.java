package com.santacruz.santacruzventa.Repositorio;

import com.santacruz.santacruzventa.Entidad.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VentaRepositorio extends JpaRepository<Venta, Long> {
}
