package com.example.demo.service;

import java.util.Optional;
import com.example.demo.entities.Productos;

public interface IProductosService {
	Productos crear(Productos productos);
	Optional<Productos> obtenerPorId(Long productoId);
	Productos actualizar(Long productoId, String nomProducto, String mcaProducto, int precioProducto);
	boolean eliminar(Long productoId);
}
