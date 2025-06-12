package com.santacruz.santacruzcompra.UtilH2;

import com.santacruz.santacruzcompra.Entidad.Compra;
import com.santacruz.santacruzcompra.Entidad.CompraDetalle;
import com.santacruz.santacruzcompra.Repositorio.CompraDetalleRepositorio;
import com.santacruz.santacruzcompra.Repositorio.CompraRepositorio;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CompraDetalleSeeder implements CommandLineRunner {

    private final CompraDetalleRepositorio compraDetalleRepositorio;
    private final CompraRepositorio compraRepositorio;

    public CompraDetalleSeeder(CompraDetalleRepositorio compraDetalleRepositorio, CompraRepositorio compraRepositorio) {
        this.compraDetalleRepositorio = compraDetalleRepositorio;
        this.compraRepositorio = compraRepositorio;
    }

    @Override
    public void run(String... args) throws Exception {
        if (compraDetalleRepositorio.count() == 0 && compraRepositorio.count() > 0) {
            List<Compra> compras = compraRepositorio.findAll();
            Compra compra1 = compras.get(0);

            CompraDetalle detalle1 = CompraDetalle.builder()
                    .precioUnitario(100)
                    .cantidad(2)
                    .compra(compra1)
                    .idProducto(1L)
                    .build();

            CompraDetalle detalle2 = CompraDetalle.builder()
                    .precioUnitario(50)
                    .cantidad(1)
                    .compra(compra1)
                    .idProducto(2L)
                    .build();

            compraDetalleRepositorio.save(detalle1);
            compraDetalleRepositorio.save(detalle2);

            System.out.println("Detalles de compra insertados en H2.");
        } else {
            System.out.println("Los detalles de compra ya existen o no hay compras.");
        }
    }
}
