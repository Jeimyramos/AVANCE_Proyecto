package com.santacruz.santacruzempresa.Entidad;

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
public class Sucursal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idSucursal")
    private Long idSucursal;
    private String nombreSucursal;
    private String Ubicacion;
    private String telefono;
    private String Whatsapp;


    @JoinColumn(name = "idEmpresa",referencedColumnName = "idEmpresa",nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private Empresa empresa;

}
