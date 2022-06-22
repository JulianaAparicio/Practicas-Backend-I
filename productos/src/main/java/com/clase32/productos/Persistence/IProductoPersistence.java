package com.clase32.productos.Persistence;

import com.clase32.productos.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductoPersistence extends JpaRepository<Producto, Long> {
}
