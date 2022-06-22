package com.clase32.productos.service;

import com.clase32.productos.Persistence.IProductoPersistence;
import com.clase32.productos.entities.Producto;
import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {
    IProductoPersistence repository;
    Mapper mapper = new Mapper();

    @Autowired
    public void setRepository(IProductoPersistence repository){
        this.repository = repository;
    }

    public Producto crearProducto(Producto producto){
        return repository.save(producto);
    }

    public ArrayList<Producto> buscarTodos(){
        List<Producto> listaProductos = repository.findAll();
        ArrayList<Producto> listaEncontrados = new ArrayList<>();
        for (Producto p: listaProductos){
            if(p.getCantidad() > 0){
                listaEncontrados.add(p);
            }
        }
        return listaEncontrados;
    }

    public void eliminarPorId(Long id){
        if(!repository.findById(id).isPresent()){
            repository.deleteById(id);
        }
    }

    public Producto actualizarCantidad(Long id, int cantidad){
        Optional<Producto> productoAModificar = repository.findById(id);
        if(productoAModificar.isPresent()){
            Producto producto = productoAModificar.get();
            if(producto.getCantidad() >= cantidad){
                producto.setCantidad(producto.getCantidad() - cantidad);
                return producto;
            }
            return null;
        }
        return null;

    }



}
