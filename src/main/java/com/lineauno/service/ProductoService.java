package com.lineauno.service;


import com.lineauno.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductoService {

    @Autowired
    ProductoRepository repository;

    public Producto save(Producto producto) {
        return repository.save(producto);
    }

    public Producto findById(Integer idProd) {
        Optional<Producto> producto = repository.findById(idProd);
        if (producto.isPresent())
            return repository.findById(idProd).get();
        else
            return null;
    }

    public Producto update(Producto producto){
        Producto objProducto = findById(producto.getIdPro());
        objProducto.setTipoProducto(producto.getTipoProducto());
        objProducto.setAnioAdquisición(producto.getAnioAdquisición());
        objProducto.setAnioVencimiento(producto.getAnioVencimiento());
        objProducto.setCodigo(producto.getCodigo());
        objProducto.setEstado(producto.getEstado());
        objProducto.setSaldo(producto.getSaldo());
        return repository.save(objProducto);
    }

    public List<Producto> findAll() {
        return (List<Producto>) repository.findAll();
    }

    public void deleteById(Integer idPro) {
        repository.deleteById(idPro);
    }
}
