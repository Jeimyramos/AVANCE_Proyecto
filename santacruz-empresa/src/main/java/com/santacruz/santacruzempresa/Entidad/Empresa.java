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
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEmpresa")
    private Long idEmpresa;
    private String NombreEmpresa;
    private String rasonSocial;
    private String Ruc;
    private String Ubicacion;
    private String Msion;
    private String Vision;

}
