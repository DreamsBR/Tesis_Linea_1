package com.lineauno.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tarjetas")
public class Tarjeta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTarjeta", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idTipoTarjeta", nullable = false)
    private TipoTarjeta idTipoTarjeta;

    @Column(name = "codigo", nullable = false, length = 8)
    private String codigo;

    @Column(name = "saldo", nullable = false, precision = 12, scale = 2)
    private BigDecimal saldo;

    @Column(name = "anioCompra", nullable = false, length = 4)
    private String anioCompra;

    @Column(name = "anioVencimiento", nullable = false, length = 4)
    private String anioVencimiento;

    @Column(name = "estado", nullable = false)
    private Integer estado;

}