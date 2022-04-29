package com.lineauno.service;

import com.lineauno.controller.TipoProductoController;
import com.lineauno.entity.TipoProducto;
import com.lineauno.respository.TipoProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoProductoService {

    @Autowired
    private TipoProductoRepository tipoProductoRepository;

    public TipoProducto saveTipoProducto (TipoProducto tipoProducto){
        return tipoProductoRepository.save(tipoProducto);
    }

    public List<TipoProducto> getTipoProducto(){
        return tipoProductoRepository.findAll();
    }

    public void delete (Integer id){
        tipoProductoRepository.deleteById(id);
    }


}
