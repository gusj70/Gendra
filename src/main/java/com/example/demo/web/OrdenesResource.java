package com.example.demo.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Clientes;
import com.example.demo.entities.Ordenes;
import com.example.demo.service.IOrdenesService;

@RestController
@RequestMapping("/api/v1")
public class OrdenesResource {

	@Autowired
	private IOrdenesService ordenesService;
	
	@PostMapping("ordenes")
	public ResponseEntity<Ordenes> crearOrdenes(@RequestBody Ordenes ordenes) {
		return new ResponseEntity(this.ordenesService.crear(ordenes), HttpStatus.CREATED);
	}
	
	@GetMapping("/ordenes/{ordenesId}")
	public ResponseEntity<Ordenes> obtenerOrdenes(@PathVariable("ordenesId") Long ordenesId) {
		Optional<Ordenes> optionalOrdenes = this.ordenesService.obtenerPorId(ordenesId);
		if (optionalOrdenes.isPresent())
			return new ResponseEntity(optionalOrdenes.get(), HttpStatus.OK);
		return ResponseEntity.notFound().build();
	}
	
 	@PutMapping("/ordenes/{ordenesId}")
	public ResponseEntity<Ordenes> actualizarOrdenes(@PathVariable("ordenesId") Long ordenesId,	
			@PathVariable("precioProducto") double precioProducto,
			@PathVariable("cantProducto") int cantProducto) {
		Ordenes ordenesActualizado = this.ordenesService.actualizar(ordenesId, precioProducto, cantProducto);
		if (ordenesActualizado != null) {
			return new ResponseEntity(ordenesActualizado, HttpStatus.OK);
		}
		return ResponseEntity.notFound().build();
	}
 	
	@DeleteMapping("/ordenes/{ordenesId}/")
	public ResponseEntity<Void> eliminarOrdenes(@PathVariable("ordenesId") Long ordenesId) {
		this.ordenesService.eliminar(ordenesId);
		return ResponseEntity.noContent().build();
	}
}
