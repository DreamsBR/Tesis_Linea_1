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
@Table(name = "tipo_producto")
public class TipoProducto {
    @Id
    @Column(name = "id_tp")
    private Integer idTp;

    @Column(name = "descripcion")
    private String descripcion;

}
