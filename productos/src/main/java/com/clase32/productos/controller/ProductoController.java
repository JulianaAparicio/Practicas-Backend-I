package com.clase32.productos.controller;

import com.clase32.productos.entities.Producto;
import com.clase32.productos.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    ProductoService productoService;

    @Autowired
    public ProductoController(ProductoService productoService){
        this.productoService = productoService;
    }

    @GetMapping("/listarTodos")
    public ResponseEntity<ArrayList<Producto>> mostrarTodosLosProductos(){
        ArrayList<Producto> listaProductos = productoService.buscarTodos();
        return ResponseEntity.ok(listaProductos);
    }

    @DeleteMapping("{id}")
    public ResponseEntity eliminarPorId(@PathVariable Long id){
        productoService.eliminarPorId(id);
        return ResponseEntity.noContent().build(); // 204
    }

    @PatchMapping("/{id}")
    public ResponseEntity actualizarStock(@PathVariable Long id, @RequestBody int cantidad){
        productoService.actualizarCantidad(id, cantidad);
        return ResponseEntity.accepted().build();
    }

    @PostMapping("crear")
    public Producto crearProducto(@RequestBody Producto producto){
        return productoService.crearProducto(producto);
    }


}
