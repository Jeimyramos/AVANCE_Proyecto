package com.santacruz.santacruzusuario.UtilH2;

import com.santacruz.santacruzusuario.Entidad.Cliente;
import com.santacruz.santacruzusuario.Repositorio.ClienteRepositorio;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ClienteSeeder implements CommandLineRunner {

    private final ClienteRepositorio clienteRepositorio;

    public ClienteSeeder(ClienteRepositorio clienteRepositorio) {
        this.clienteRepositorio = clienteRepositorio;
    }

    @Override
    public void run(String... args) throws Exception {
        if (clienteRepositorio.count() == 0) {
            Cliente c1 = Cliente.builder()
                    .Nombres("Luis Alberto")
                    .ApellidoPaterno("Fernández")
                    .ApellidoMaterno("Gómez")
                    .Dni("74125896")
                    .build();

            Cliente c2 = Cliente.builder()
                    .Nombres("María José")
                    .ApellidoPaterno("Ramos")
                    .ApellidoMaterno("Torres")
                    .Dni("85296314")
                    .build();

            clienteRepositorio.save(c1);
            clienteRepositorio.save(c2);

            System.out.println("Clientes insertados correctamente en H2.");
        } else {
            System.out.println("Los clientes ya existen en H2.");
        }
    }
}
