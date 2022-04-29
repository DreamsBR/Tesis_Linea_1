package com.lineauno.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "producto")
public class Producto {
    @Id
    @Column(name = "id_pro")
    private Integer idPro;

    @Column(name = "codigo")
    private Integer codigo;

    @Column(name = "saldo")
    private Double saldo;

    @Column(name = "anio_adquisición")
    private Integer anioAdquisición;

    @Column(name = "anio_vencimiento")
    private Integer anioVencimiento;

    @Column(name = "estado")
    private Byte estado;

    @Column(name = "tipo_producto")
    private Integer tipoProducto;

}
