package com.lineauno.service.impl;

import com.lineauno.dto.GenerarMovimientoDTO;
import com.lineauno.entity.Movimiento;
import com.lineauno.entity.Tarjeta;
import com.lineauno.repository.MovimientoRepository;
import com.lineauno.service.MovimientoService;
import com.lineauno.utils.GenericResponse;
import com.lineauno.utils.Globals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import org.springframework.util.ResourceUtils;

@Service
@Transactional
public class MovimientoServiceImpl implements MovimientoService {

    @Autowired
    private MovimientoRepository movimientoRepository;


    @Override
    public List<Movimiento> findAll() {
        return (List<Movimiento>) movimientoRepository.findAll();
    }

    @Override
    public Movimiento findById(Integer id) {
        return movimientoRepository.findById(id).get();
    }

    @Override
    public Movimiento save(Movimiento movimiento) {
        return movimientoRepository.save(movimiento);
    }

    @Override
    public Movimiento update(Integer id, Movimiento movimiento) {
        Movimiento objMovimiento = movimientoRepository.findById(id).get();
        objMovimiento.setFecha(movimiento.getFecha());
        objMovimiento.setTarjeta(movimiento.getTarjeta());
        objMovimiento.setMonto_total(movimiento.getMonto_total());
        return movimientoRepository.save(objMovimiento);
    }

    @Override
    public void delete(Integer id) {
        movimientoRepository.deleteById(id);
    }

    @Override
    public GenericResponse getLastFiveMovements(String email) {
        return new GenericResponse(Globals.TIPO_DATA, Globals.RPTA_OK, Globals.OPERACION_CORRECTA, this.movimientoRepository.getLastFiveMovements(email));
    }

    @Override
    public GenericResponse recargarSaldo(GenerarMovimientoDTO dto) {
        System.out.println("Cliente Servicio:--> " + dto + " hola service");
        Date date = new Date();
        //dto.getMovimiento().setId_movimiento();
        dto.getMovimiento().setFecha(new java.sql.Date(date.getTime()));
        System.out.println("Cliente Servicio:--> " + dto + " hola service");
        dto.getMovimiento().setMonto_total(dto.getMovimiento().getMonto_total());
        System.out.println("Cliente Servicio:--> " + dto.getMovimiento().getMonto_total());
        dto.getMovimiento().setTarjeta(new Tarjeta(1));
        System.out.println("Cliente Servicio:--> " + dto.getCliente());
        dto.getMovimiento().setEmail(dto.getMovimiento().getEmail());
        System.out.println("Cliente Servicio:--> " + dto.getCliente().getId());
        dto.getMovimiento().setToken(dto.getMovimiento().getToken());
        System.out.println("Token Servicio:--> " + dto.getMovimiento().getToken());
        System.out.println("Token Servicio:--> " + dto.getMovimiento().getEmail());
        this.movimientoRepository.save(dto.getMovimiento());
        return new GenericResponse(Globals.TIPO_DATA, Globals.RPTA_OK, Globals.OPERACION_CORRECTA, dto);
    }

    @Override
    public double getMontoTotal(String email) {
        return movimientoRepository.getMontoTotal(email);
    }

    @Override
    public ResponseEntity<Resource> exportInvoice() {
        List<Movimiento> optMovimiento = (List<Movimiento>) this.movimientoRepository.findAll();

        try {
            final File file = ResourceUtils.getFile("classpath:exportInvoice.jasper");
            final File imgLogo = ResourceUtils.getFile("classpath:images/linea1_logo.png");
            final JasperReport report = (JasperReport) JRLoader.loadObject(file);

            final HashMap<String, Object> parameters = new HashMap<>();

            parameters.put("imgLogo", new FileInputStream(imgLogo));
            parameters.put("nombreCliente", "Jostin Samuel Martinez Alvarez");

            optMovimiento.stream().forEach(x-> {
                parameters.put("fecha", x.getFecha());
                parameters.put("monto_total", x.getMonto_total());
                parameters.put("dsInvoice", new JRBeanCollectionDataSource((Collection<?>) this.movimientoRepository.findAll()));
            });

            JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameters, new JREmptyDataSource());
            byte[] reporte = JasperExportManager.exportReportToPdf(jasperPrint);
            String sdf = (new SimpleDateFormat("dd/MM/yyyy")).format(new Date());
            StringBuilder stringBuilder = new StringBuilder().append("Historial PDF:");
            ContentDisposition contentDisposition = ContentDisposition.builder("attachment")
                    .filename(stringBuilder
                            .append("generateDate:")
                            .append(sdf)
                            .append(".pdf")
                            .toString())
                    .build();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentDisposition(contentDisposition);
            return ResponseEntity.ok().contentLength((long) reporte.length)
                    .contentType(MediaType.APPLICATION_PDF)
                    .headers(headers).body(new ByteArrayResource(reporte));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
