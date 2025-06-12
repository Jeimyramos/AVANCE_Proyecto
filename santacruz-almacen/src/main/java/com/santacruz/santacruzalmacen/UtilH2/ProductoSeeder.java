package com.santacruz.santacruzalmacen.UtilH2;

import com.santacruz.santacruzalmacen.Entidad.Categoria;
import com.santacruz.santacruzalmacen.Entidad.Producto;
import com.santacruz.santacruzalmacen.Repositorio.CategoriaRepositorio;
import com.santacruz.santacruzalmacen.Repositorio.ProductoRepositorio;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class ProductoSeeder implements CommandLineRunner {

    private final ProductoRepositorio productoRepositorio;
    private final CategoriaRepositorio categoriaRepositorio;

    public ProductoSeeder(ProductoRepositorio productoRepositorio, CategoriaRepositorio categoriaRepositorio) {
        this.productoRepositorio = productoRepositorio;
        this.categoriaRepositorio = categoriaRepositorio;
    }

    @Override
    public void run(String... args) throws Exception {
        if (productoRepositorio.count() == 0 && categoriaRepositorio.count() > 0) {
            List<Categoria> categorias = categoriaRepositorio.findAll();

            Producto prod1 = Producto.builder()
                    .nombre("Coca Cola 500ml")
                    .descripcion("Refresco gaseoso")
                    .fechaVencimiento(LocalDate.of(2026, 5, 1))
                    .precioUnitario(5)
                    .categoria(categorias.get(0)) // Bebidas
                    .Stock(100)
                    .Codigo(1010)
                    .Estado("ACTIVO")
                    .idSucursal("SUC01")
                    .build();

            Producto prod2 = Producto.builder()
                    .nombre("Papas Lay's")
                    .descripcion("Papas fritas sabor original")
                    .fechaVencimiento(LocalDate.of(2025, 12, 31))
                    .precioUnitario(3)
                    .categoria(categorias.get(1)) // Snacks
                    .Stock(200)
                    .Codigo(1020)
                    .Estado("ACTIVO")
                    .idSucursal("SUC02")
                    .build();

            productoRepositorio.save(prod1);
            productoRepositorio.save(prod2);

            System.out.println("Productos insertados correctamente en H2.");
        } else {
            System.out.println("Los productos ya existen o no hay categorías.");
        }
    }
}
