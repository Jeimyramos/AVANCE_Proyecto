package com.santacruz.santacruzalmacen.Entidad;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.santacruz.santacruzalmacen.Dto.SucursalDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProducto")
    private Long idProducto;
    private String nombre;
    private String descripcion;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaVencimiento;
    private Integer precioUnitario;

    @JoinColumn(name = "idCategoria", referencedColumnName = "idCategoria", insertable = false, updatable = false)
    //@ManyToOne(fetch = FetchType.EAGER)
    @ManyToOne(fetch = FetchType.LAZY)
    private Categoria categoria;
    private Integer Stock;
    private Integer Codigo;
    private String Estado;

    private String idSucursal;
    @Transient
    private SucursalDto sucursalDto;

}
