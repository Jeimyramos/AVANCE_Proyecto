package com.santacruz.santacruzalmacen.UtilH2;

import com.santacruz.santacruzalmacen.Entidad.Categoria;
import com.santacruz.santacruzalmacen.Repositorio.CategoriaRepositorio;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CategoriaSeeder implements CommandLineRunner {

    private final CategoriaRepositorio categoriaRepositorio;

    public CategoriaSeeder(CategoriaRepositorio categoriaRepositorio) {
        this.categoriaRepositorio = categoriaRepositorio;
    }

    @Override
    public void run(String... args) throws Exception {
        if (categoriaRepositorio.count() == 0) {
            Categoria cat1 = Categoria.builder()
                    .NombreCategoria("Bebidas")
                    .descripcion("Líquidos para consumo")
                    .build();

            Categoria cat2 = Categoria.builder()
                    .NombreCategoria("Snacks")
                    .descripcion("Aperitivos y productos salados")
                    .build();

            categoriaRepositorio.save(cat1);
            categoriaRepositorio.save(cat2);

            System.out.println("Categorías insertadas correctamente en H2.");
        } else {
            System.out.println("Las categorías ya existen en H2.");
        }
    }
}
