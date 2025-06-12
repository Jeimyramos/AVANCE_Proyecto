package com.santacruz.santacruzcompra.Entidad;

import com.santacruz.santacruzcompra.Dto.ProductoDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompraDetalle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCompraDetalle")
    private Long idCompraDetalle;

    private Integer precioUnitario;
    private Integer cantidad;

    @JoinColumn(name = "idCompra", referencedColumnName = "idCompra")
    @ManyToOne( fetch = FetchType.LAZY)
    private Compra compra;

    private Long idProducto;
    @Transient
    private ProductoDto productoDto;


}
