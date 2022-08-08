package com.lineauno.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lineauno.entity.Cliente;
import com.lineauno.entity.Movimiento;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class GenerarMovimientoDTO {

    private Movimiento movimiento;

    private Cliente cliente;

    public Movimiento getMovimiento(){
        return movimiento;
    }
}
