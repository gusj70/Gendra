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

import com.example.demo.entities.Productos;
import com.example.demo.service.IProductosService;

@RestController
@RequestMapping("/api/v1")
public class ProductosResource {

	@Autowired
	private IProductosService productosService;
	
	@PostMapping("productos")
	public ResponseEntity<Productos> crearProductos(@RequestBody Productos productos) {
		return new ResponseEntity(this.productosService.crear(productos), HttpStatus.CREATED);
	}
	
	@GetMapping("/productos/{productosId}")
	public ResponseEntity<Productos> obtenerProductos(@PathVariable("productosId") Long productosId) {
		Optional<Productos> optionalProductos = this.productosService.obtenerPorId(productosId);
		if (optionalProductos.isPresent())
			return new ResponseEntity(optionalProductos.get(), HttpStatus.OK);
		return ResponseEntity.notFound().build();
	}
	
 	@PutMapping("/productos/{productosId}")
	public ResponseEntity<Productos> actualizarProductos(@PathVariable("productoId") Long productoId,
			@PathVariable("nomProducto") String nomProducto, 
			@PathVariable("mcaProducto") String mcaProducto, 
			@PathVariable("precioProducto") int precioProducto) {
 		Productos productosActualizado = this.productosService.actualizar(productoId, nomProducto, mcaProducto, precioProducto);
		if (productosActualizado != null) {
			return new ResponseEntity(productosActualizado, HttpStatus.OK);
		}
		return ResponseEntity.notFound().build();
	}
 	
	@DeleteMapping("/productos/{productosId}/")
	public ResponseEntity<Void> eliminarProductos(@PathVariable("productosId") Long productosId) {
		this.productosService.eliminar(productosId);
		return ResponseEntity.noContent().build();
	}
}
