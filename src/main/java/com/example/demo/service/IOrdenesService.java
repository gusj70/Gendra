package com.example.demo.service;

import java.util.Optional;
import com.example.demo.entities.Ordenes;

public interface IOrdenesService {
	Ordenes crear(Ordenes ordenes);
	Optional<Ordenes> obtenerPorId(Long ordenesId);
	Ordenes actualizar(Long ordenesId, double precioProducto, int cantProducto);
	boolean eliminar(Long ordenesId);
}
