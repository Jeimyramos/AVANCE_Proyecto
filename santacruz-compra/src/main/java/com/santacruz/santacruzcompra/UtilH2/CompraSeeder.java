package com.santacruz.santacruzcompra.UtilH2;

import com.santacruz.santacruzcompra.Entidad.Compra;
import com.santacruz.santacruzcompra.Repositorio.CompraRepositorio;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class CompraSeeder implements CommandLineRunner {

    private final CompraRepositorio compraRepositorio;

    public CompraSeeder(CompraRepositorio compraRepositorio) {
        this.compraRepositorio = compraRepositorio;
    }

    @Override
    public void run(String... args) throws Exception {
        if (compraRepositorio.count() == 0) {
            Compra compra1 = Compra.builder()
                    .FechaCompra(LocalDate.now().toString())
                    .PrecioTotal(200)
                    .igv(36)
                    .codigo("CMP001")
                    .idTrabajador(1L)
                    .idMedioDePago(1L)
                    .build();

            Compra compra2 = Compra.builder()
                    .FechaCompra(LocalDate.now().toString())
                    .PrecioTotal(500)
                    .igv(90)
                    .codigo("CMP002")
                    .idTrabajador(2L)
                    .idMedioDePago(2L)
                    .build();

            compraRepositorio.save(compra1);
            compraRepositorio.save(compra2);

            System.out.println("Compras insertadas correctamente en H2.");
        } else {
            System.out.println("Las compras ya existen en H2.");
        }
    }
}
