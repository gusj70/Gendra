package com.example.demo.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entities.Ordenes;
import com.example.demo.entities.Productos;
import com.example.demo.repository.productosRepository;

public class IProductosServiceImpl implements IProductosService {

	@Autowired
	private productosRepository productosRepository;

	public Productos crear(Productos productos) {
		// TODO Auto-generated method stub
		return this.productosRepository.save(productos);
	}

	public Optional<Productos> obtenerPorId(Long productoId) {
		// TODO Auto-generated method stub
		return null;
	}

	public Productos actualizar(Long productoId, String nomProducto, String mcaProducto, int precioProducto) {
		// TODO Auto-generated method stub
		Optional<Productos> productos = this.productosRepository.findById(productoId);
		if (productos.isPresent()) {
			Productos tmp = productos.get();			
			tmp.setMcaProducto(mcaProducto);
			tmp.setNomProducto(nomProducto);
			tmp.setPrecioProducto(precioProducto);
			return crear(tmp);
		} 
		return null;
	}

	public boolean eliminar(Long productoId) {
		// TODO Auto-generated method stub
		this.productosRepository.deleteById(productoId);
		return true;
	} 
	
}
