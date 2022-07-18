package com.lineauno.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lineauno.entity.Cliente;
import com.lineauno.entity.Detalle;
import com.lineauno.entity.Movimiento;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class GenerarMovimientoDTO {

    private Movimiento movimiento;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Iterable<Detalle> detalle;

    private Cliente cliente;

    public Movimiento getMovimiento(){
        return movimiento;
    }
}
