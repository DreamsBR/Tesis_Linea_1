package com.lineauno.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "nombres", nullable = false, length = 100)
    private String nombres;
    @Column(name = "apellido_paterno", nullable = false, length = 100)
    private String apellidoPaterno;
    @Column(name = "apellido_materno", nullable = false, length = 100)
    private String apellidoMaterno;
    @Column(name = "tipo_documento", nullable = false, length = 45)
    private String tipo_documento;
    @Column(name = "numero_documento", nullable = false, length = 8)
    private String numero_documento;
    
}
