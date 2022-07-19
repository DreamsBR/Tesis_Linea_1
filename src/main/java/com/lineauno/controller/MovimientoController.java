package com.lineauno.controller;

import com.culqi.Culqi;
import com.lineauno.dto.GenerarMovimientoDTO;
import com.lineauno.entity.Movimiento;
import com.lineauno.service.DetalleService;
import com.lineauno.service.MovimientoService;
import com.lineauno.utils.GenericResponse;
import com.lineauno.utils.Globals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/movimiento")
public class MovimientoController {
    
    @Autowired
    private MovimientoService movimientoService;

    @GetMapping
    public List<Movimiento> findAll(){
        return movimientoService.findAll();
    }

    @PostMapping
    public ResponseEntity<Movimiento> save(@RequestBody Movimiento movimiento){
        return new ResponseEntity<>(movimientoService.save(movimiento), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movimiento> update(@PathVariable("id") Integer id, @RequestBody Movimiento movimiento){
        return new ResponseEntity<>(movimientoService.update(id, movimiento), HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Movimiento> findById(@PathVariable("id") Integer id){
        return new ResponseEntity<>(movimientoService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Integer id){
        movimientoService.delete(id);
    }

    @GetMapping("/historial/{email}")
    public GenericResponse getLastFiveMovements(@PathVariable("email") String email){
        return movimientoService.getLastFiveMovements(email);
    }

    // GUARDAR PEDIDO
    @PostMapping("/recargarSaldo")
    public GenericResponse recargarSaldo(@RequestBody GenerarMovimientoDTO dto) throws Exception {
        System.out.println("Token controlador = " + dto.getMovimiento().getToken());
        System.out.println("Id -- > " + dto.getMovimiento().getId_movimiento());
        System.out.println("monto -- > " + dto.getMovimiento().getMonto_total());

        try {
            Culqi culqi = new Culqi();
            culqi.secret_key = "sk_test_6033e299086641e3";
            Map<String, Object> charge = new HashMap<String, Object>();
            Map<String, Object> metadata = new HashMap<String, Object>();
            String token = dto.getMovimiento().getToken().toString();
            System.out.println("Token controlador = " + token);
            String idMovimiento = String.valueOf(dto.getMovimiento().getId_movimiento());
            System.out.println("Id try-- > " + idMovimiento);
            metadata.put("oder_id", idMovimiento);
            Double monto = Math.round(dto.getMovimiento().getMonto_total() * 100.0) / 100.0;
            int montoInt = Integer.valueOf(monto.intValue() * 100);
            System.out.println("monto integer-- > " + montoInt + "\nmonto double-- > " + monto);
            charge.put("amount", montoInt);
            charge.put("currency_code", "PEN");
            charge.put("email", dto.getMovimiento().getEmail());
            System.out.println("Email-- > " + dto.getMovimiento().getEmail());
            charge.put("source_id", token);
            culqi.charge.create(charge);
            System.out.println("Culqi response: venta exitosa");

        }catch (Exception e) {
            System.out.println("Error en culqi: \n" + e.getMessage() + "\n" + e.getCause() + "\n" + e.getStackTrace()
                    + "\n" + e.getLocalizedMessage());
        }

        System.out.println("Hola -- > " + dto.getMovimiento().getId_movimiento());

        return this.movimientoService.recargarSaldo(dto);
    }

    @GetMapping("/montoTotal/{email}")
    public double getMontoTotal(@PathVariable("email") String email){
        return movimientoService.getMontoTotal(email);
    }
}
