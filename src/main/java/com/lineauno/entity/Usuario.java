package com.lineauno.entity;

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
    private int id;
    @Column(name = "email", nullable = false, length = 100)
    private String email;
    @Column(name = "clave", nullable = false, length = 100)
    private String clave;
    @Column
    private boolean vigencia;
    @OneToOne
    private Cliente cliente;

}