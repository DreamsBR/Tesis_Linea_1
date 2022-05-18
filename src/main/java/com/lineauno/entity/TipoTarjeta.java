package com.lineauno.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tipo_tarjetas")
public class TipoTarjeta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTipoTarjeta", nullable = false)
    private Integer id;

    @Column(name = "descripcion", nullable = false, length = 150)
    private String descripcion;



}