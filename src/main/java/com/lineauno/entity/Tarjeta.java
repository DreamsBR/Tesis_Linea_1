package com.lineauno.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tarjetas")
public class Tarjeta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tarjeta", nullable = false)
    private Integer id_tarjeta;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "tipo_tarjeta", nullable = false)
    private TipoTarjeta tipo_tarjeta;

    @Column(name = "codigo", nullable = false, length = 8)
    private String codigo;

    @Column(name = "saldo", nullable = false, precision = 12, scale = 2)
    private Double saldo;

    @Column(name = "anio_compra", nullable = false, length = 4)
    private String anio_compra;

    @Column(name = "anio_vencimiento", nullable = false, length = 4)
    private String anio_vencimiento;

    @Column(name = "estado", nullable = false)
    private Boolean estado;

}