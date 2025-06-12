package com.santacruz.santacruzventa.UtilH2;

import com.santacruz.santacruzventa.Entidad.MetodoDePago;
import com.santacruz.santacruzventa.Entidad.Venta;
import com.santacruz.santacruzventa.Repositorio.MetodoDePagoRepositorio;
import com.santacruz.santacruzventa.Repositorio.VentaRepositorio;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class VentaSeeder implements CommandLineRunner {

    private final VentaRepositorio ventaRepositorio;
    private final MetodoDePagoRepositorio metodoDePagoRepositorio;

    public VentaSeeder(VentaRepositorio ventaRepositorio, MetodoDePagoRepositorio metodoDePagoRepositorio) {
        this.ventaRepositorio = ventaRepositorio;
        this.metodoDePagoRepositorio = metodoDePagoRepositorio;
    }

    @Override
    public void run(String... args) throws Exception {
        if (ventaRepositorio.count() == 0 && metodoDePagoRepositorio.count() > 0) {
            MetodoDePago metodo1 = metodoDePagoRepositorio.findAll().get(0); // Usamos el primer método

            Venta venta1 = Venta.builder()
                    .precioTotal(100)
                    .igv(18)
                    .codigoVenta("VTA001")
                    .vuelto(0)
                    .montoEntregado(100)
                    .idTrabajador(1L)
                    .metodoDePago(metodo1)
                    .idCliente(1L)
                    .build();

            Venta venta2 = Venta.builder()
                    .precioTotal(250)
                    .igv(45)
                    .codigoVenta("VTA002")
                    .vuelto(10)
                    .montoEntregado(260)
                    .idTrabajador(2L)
                    .metodoDePago(metodo1)
                    .idCliente(2L)
                    .build();

            ventaRepositorio.save(venta1);
            ventaRepositorio.save(venta2);

            System.out.println("Ventas insertadas correctamente en H2.");
        } else {
            System.out.println("Las ventas ya existen o no hay métodos de pago disponibles.");
        }
    }
}
