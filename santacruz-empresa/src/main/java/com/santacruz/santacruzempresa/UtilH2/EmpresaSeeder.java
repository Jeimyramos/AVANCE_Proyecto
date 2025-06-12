package com.santacruz.santacruzempresa.UtilH2;

import com.santacruz.santacruzempresa.Entidad.Empresa;
import com.santacruz.santacruzempresa.Repositorio.EmpresaRepositorio;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class EmpresaSeeder implements CommandLineRunner {

    private final EmpresaRepositorio empresaRepositorio;

    public EmpresaSeeder(EmpresaRepositorio empresaRepositorio) {
        this.empresaRepositorio = empresaRepositorio;
    }

    @Override
    public void run(String... args) throws Exception {
        if (empresaRepositorio.count() == 0) {
            Empresa emp1 = Empresa.builder()
                    .NombreEmpresa("Santa Cruz SAC")
                    .rasonSocial("Santa Cruz Servicios Generales")
                    .Ruc("20481234567")
                    .Ubicacion("Av. Central 123")
                    .Msion("Brindar servicios de calidad")
                    .Vision("Ser líderes en el mercado local")
                    .build();

            Empresa emp2 = Empresa.builder()
                    .NombreEmpresa("Alimentos Cruz del Sur")
                    .rasonSocial("Cruz del Sur EIRL")
                    .Ruc("20654321098")
                    .Ubicacion("Jr. Comercio 456")
                    .Msion("Distribuir productos saludables")
                    .Vision("Expandir a nivel nacional")
                    .build();

            empresaRepositorio.save(emp1);
            empresaRepositorio.save(emp2);

            System.out.println("Empresas insertadas correctamente en H2.");
        } else {
            System.out.println("Las empresas ya existen en H2.");
        }
    }
}
