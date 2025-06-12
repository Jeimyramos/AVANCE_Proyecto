package com.santacruz.santacruzusuario.Entidad;

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
public class Trabajador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTrabajador")
    private Long idTrabajador;;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String Dni;
    private String Celular;
    private String Email;
    private LocalDate FechaNacimiento;
    private Long Sucursal_idSucursal;


}
