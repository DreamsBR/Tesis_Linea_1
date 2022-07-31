package com.lineauno.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@Entity
@Table(name = "movimientos")
public class Movimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_movimiento", nullable = false)
    private Integer id_movimiento;

    @Column(name = "fecha", nullable = false)
    @JsonFormat(pattern = "dd-MM-yyyy", timezone = "America/Lima")
    private Date fecha;

    @Column(name = "monto_total", nullable = false)
    private Double monto_total;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Column(name = "token", nullable = false, length = 100)
    private String token;

    @JsonIgnore
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "tarjeta", nullable = false)
    private Tarjeta tarjeta;

}