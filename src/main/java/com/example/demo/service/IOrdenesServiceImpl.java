package com.example.demo.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entities.Ordenes;
import com.example.demo.repository.ordenesRepository;

public class IOrdenesServiceImpl implements IOrdenesService {

	@Autowired
	private ordenesRepository ordenesRepository;

	public Ordenes crear(Ordenes ordenes) {
		// TODO Auto-generated method stub
		return this.ordenesRepository.save(ordenes);
	}

	public Optional<Ordenes> obtenerPorId(Long ordenesId) {
		// TODO Auto-generated method stub
		return null;
	}

	public Ordenes actualizar(Long ordenesId, double precioProducto, int cantProducto) {
		// TODO Auto-generated method stub
		Optional<Ordenes> ordenes = this.ordenesRepository.findById(ordenesId);
		if (ordenes.isPresent()) {
			Ordenes tmp = ordenes.get();
			tmp.setCantProducto(cantProducto);
			tmp.setPrecioProducto(precioProducto);			
			return crear(tmp);
		} 
		return null;
	}

	public boolean eliminar(Long ordenesId) {
		// TODO Auto-generated method stub
		this.ordenesRepository.deleteById(ordenesId);
		return true;
	}
}
