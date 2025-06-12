package com.santacruz.santacruzcompra.Entidad;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.OptBoolean;
import com.santacruz.santacruzcompra.Dto.MedioDePagoDto;
import com.santacruz.santacruzcompra.Dto.TrabajadorDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCompra")
    private Long idCompra;
    @CreationTimestamp
    @JsonFormat(pattern = "yyyy-MM-dd", lenient = OptBoolean.TRUE)
    private String FechaCompra;

    private Integer PrecioTotal;
    private Integer igv;
    private String codigo;

    private Long idTrabajador;
    @Transient
    private TrabajadorDto trabajadorDto;

    private Long idMedioDePago;
    @Transient
    private MedioDePagoDto medioDePagoDto;

}
