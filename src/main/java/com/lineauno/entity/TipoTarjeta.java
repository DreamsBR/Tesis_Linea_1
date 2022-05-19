package com.lineauno.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tipo_tarjetas")
public class TipoTarjeta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_tarjeta", nullable = false)
    private Integer id_tipo_tarjeta;

    @Column(name = "descripcion", nullable = false, length = 150)
    private String descripcion;



}