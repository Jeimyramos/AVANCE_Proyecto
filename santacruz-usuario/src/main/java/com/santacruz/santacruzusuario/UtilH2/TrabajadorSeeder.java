package com.santacruz.santacruzusuario.UtilH2;

import com.santacruz.santacruzusuario.Entidad.Trabajador;
import com.santacruz.santacruzusuario.Repositorio.TrabajadorRepositorio;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class TrabajadorSeeder implements CommandLineRunner {

    private final TrabajadorRepositorio trabajadorRepositorio;

    public TrabajadorSeeder(TrabajadorRepositorio trabajadorRepositorio) {
        this.trabajadorRepositorio = trabajadorRepositorio;
    }

    @Override
    public void run(String... args) throws Exception {
        if (trabajadorRepositorio.count() == 0) {
            Trabajador t1 = Trabajador.builder()
                    .nombres("Juan Carlos")
                    .apellidoPaterno("Rojas")
                    .apellidoMaterno("Delgado")
                    .Dni("12345678")
                    .Celular("999111222")
                    .Email("juan.rojas@santacruz.com")
                    .FechaNacimiento(LocalDate.of(1990, 5, 20))
                    .Sucursal_idSucursal(1L)
                    .build();

            Trabajador t2 = Trabajador.builder()
                    .nombres("Ana Lucía")
                    .apellidoPaterno("Salas")
                    .apellidoMaterno("Mendoza")
                    .Dni("87654321")
                    .Celular("998877665")
                    .Email("ana.salas@santacruz.com")
                    .FechaNacimiento(LocalDate.of(1995, 10, 15))
                    .Sucursal_idSucursal(2L)
                    .build();

            trabajadorRepositorio.save(t1);
            trabajadorRepositorio.save(t2);

            System.out.println("Trabajadores insertados correctamente en H2.");
        } else {
            System.out.println("Los trabajadores ya existen en H2.");
        }
    }
}
