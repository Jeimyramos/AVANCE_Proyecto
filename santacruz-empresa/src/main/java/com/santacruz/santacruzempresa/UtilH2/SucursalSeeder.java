package com.santacruz.santacruzempresa.UtilH2;

import com.santacruz.santacruzempresa.Entidad.Empresa;
import com.santacruz.santacruzempresa.Entidad.Sucursal;
import com.santacruz.santacruzempresa.Repositorio.EmpresaRepositorio;
import com.santacruz.santacruzempresa.Repositorio.SucursalRepositorio;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SucursalSeeder implements CommandLineRunner {

    private final SucursalRepositorio sucursalRepositorio;
    private final EmpresaRepositorio empresaRepositorio;

    public SucursalSeeder(SucursalRepositorio sucursalRepositorio, EmpresaRepositorio empresaRepositorio) {
        this.sucursalRepositorio = sucursalRepositorio;
        this.empresaRepositorio = empresaRepositorio;
    }

    @Override
    public void run(String... args) throws Exception {
        if (sucursalRepositorio.count() == 0 && empresaRepositorio.count() > 0) {
            List<Empresa> empresas = empresaRepositorio.findAll();

            Sucursal suc1 = Sucursal.builder()
                    .nombreSucursal("Sucursal Centro")
                    .Ubicacion("Av. Grau 101")
                    .telefono("987654321")
                    .Whatsapp("987654321")
                    .empresa(empresas.get(0))
                    .build();

            Sucursal suc2 = Sucursal.builder()
                    .nombreSucursal("Sucursal Norte")
                    .Ubicacion("Av. Los Incas 234")
                    .telefono("912345678")
                    .Whatsapp("912345678")
                    .empresa(empresas.get(1))
                    .build();

            sucursalRepositorio.save(suc1);
            sucursalRepositorio.save(suc2);

            System.out.println("Sucursales insertadas correctamente en H2.");
        } else {
            System.out.println("Las sucursales ya existen o no hay empresas.");
        }
    }
}
