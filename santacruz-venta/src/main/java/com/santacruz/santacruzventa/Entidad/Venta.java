package com.santacruz.santacruzventa.Entidad;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.santacruz.santacruzventa.Dto.ClienteDto;
import com.santacruz.santacruzventa.Dto.TrabajadorDto;
import jakarta.persistence.*;

import java.time.LocalDate;

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
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idVenta")
    private Long idVenta;

    @CreationTimestamp
    @Column(name = "fechaRegistro", updatable = false)
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate fecharegistro;
    private Integer precioTotal;
    private Integer igv;
    private String codigoVenta;
    private Integer vuelto;
    private Integer montoEntregado;

    private Long idTrabajador;
    @Transient
    private TrabajadorDto trabajadorDto;

    @JoinColumn(name = "idMetodoPago", referencedColumnName = "idMetodoPago", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private MetodoDePago metodoDePago;

    private Long idCliente;
    @Transient
    private ClienteDto clienteDto;

}
