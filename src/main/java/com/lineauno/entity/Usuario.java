package com.lineauno.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario", nullable = false)
    private Integer id_usuario;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "tarjeta", nullable = false)
    private Tarjeta tarjeta;

    @Column(name = "numero_documento", nullable = false, length = 8)
    private String numero_documento;

    @Column(name = "tipo_documento", nullable = false, length = 45)
    private String tipo_documento;

    @Column(name = "nombres", nullable = false, length = 100)
    private String nombres;

    @Column(name = "apellidos", nullable = false, length = 150)
    private String apellidos;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

}