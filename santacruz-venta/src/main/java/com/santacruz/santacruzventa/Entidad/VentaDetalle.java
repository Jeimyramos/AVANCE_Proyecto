package com.santacruz.santacruzventa.Entidad;

import com.santacruz.santacruzventa.Dto.ProductoDto;
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
public class VentaDetalle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idVentaDetalle")
    private Long idVentaDetalle;
    private Integer precioUnitario;
    private Integer cantidad;
    @JoinColumn(name = "idVenta", referencedColumnName = "idVenta", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Venta venta;

    private Long idProducto;
    @Transient
    private ProductoDto productoDto;
}
