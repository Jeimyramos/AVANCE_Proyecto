package com.santacruz.santacruzventa.UtilH2;

import com.santacruz.santacruzventa.Entidad.Venta;
import com.santacruz.santacruzventa.Entidad.VentaDetalle;
import com.santacruz.santacruzventa.Repositorio.VentaDetalleRepositorio;
import com.santacruz.santacruzventa.Repositorio.VentaRepositorio;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class VentaDetalleSeeder implements CommandLineRunner {

    private final VentaDetalleRepositorio ventaDetalleRepositorio;
    private final VentaRepositorio ventaRepositorio;

    public VentaDetalleSeeder(VentaDetalleRepositorio ventaDetalleRepositorio, VentaRepositorio ventaRepositorio) {
        this.ventaDetalleRepositorio = ventaDetalleRepositorio;
        this.ventaRepositorio = ventaRepositorio;
    }

    @Override
    public void run(String... args) throws Exception {
        if (ventaDetalleRepositorio.count() == 0 && ventaRepositorio.count() > 0) {
            Venta venta1 = ventaRepositorio.findAll().get(0);

            VentaDetalle detalle1 = VentaDetalle.builder()
                    .precioUnitario(50)
                    .cantidad(2)
                    .venta(venta1)
                    .build();

            VentaDetalle detalle2 = VentaDetalle.builder()
                    .precioUnitario(125)
                    .cantidad(1)
                    .venta(venta1)
                    .build();

            ventaDetalleRepositorio.save(detalle1);
            ventaDetalleRepositorio.save(detalle2);

            System.out.println("Detalles de venta insertados en H2.");
        } else {
            System.out.println("Los detalles de venta ya existen o no hay ventas registradas.");
        }
    }
}
