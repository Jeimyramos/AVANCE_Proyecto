package com.santacruz.santacruzventa.UtilH2;

import com.santacruz.santacruzventa.Entidad.MetodoDePago;
import com.santacruz.santacruzventa.Repositorio.MetodoDePagoRepositorio;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MetodoDePagoSeeder implements CommandLineRunner {

    private final MetodoDePagoRepositorio metodoDePagoRepositorio;

    public MetodoDePagoSeeder(MetodoDePagoRepositorio metodoDePagoRepositorio) {
        this.metodoDePagoRepositorio = metodoDePagoRepositorio;
    }

    @Override
    public void run(String... args) throws Exception {
        if (metodoDePagoRepositorio.count() == 0) {
            MetodoDePago efectivo = MetodoDePago.builder()
                    .nombreMedioPago("Efectivo")
                    .numeroMedioPago("N/A")
                    .build();

            MetodoDePago yape = MetodoDePago.builder()
                    .nombreMedioPago("Yape")
                    .numeroMedioPago("999999999")
                    .build();

            MetodoDePago plin = MetodoDePago.builder()
                    .nombreMedioPago("Plin")
                    .numeroMedioPago("988888888")
                    .build();

            metodoDePagoRepositorio.save(efectivo);
            metodoDePagoRepositorio.save(yape);
            metodoDePagoRepositorio.save(plin);

            System.out.println("Métodos de pago insertados en H2.");
        } else {
            System.out.println("Métodos de pago ya existen en H2.");
        }
    }
}
