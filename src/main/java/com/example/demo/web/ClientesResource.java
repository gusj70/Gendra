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
import com.example.demo.service.IClientesService;

@RestController
@RequestMapping("/api/v1")
public class ClientesResource {

	@Autowired
	private IClientesService clientesService;
	
	@PostMapping("clientes")
	public ResponseEntity<Clientes> crearClientes(@RequestBody Clientes clientes) {
		return new ResponseEntity(this.clientesService.crear(clientes), HttpStatus.CREATED);
	}
	
	@GetMapping("/clientes/{idCliente}")
	public ResponseEntity<Clientes> obtenerClientes(@PathVariable("idCliente") Long idCliente) {
		Optional<Clientes> optionalClientes = this.clientesService.obtenerPorId(idCliente);
		if (optionalClientes.isPresent())
			return new ResponseEntity(optionalClientes.get(), HttpStatus.OK);
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/clientes/{idCliente}")
	public ResponseEntity<Clientes> actualizarClientes(@PathVariable("idCliente") Long idCliente,	
			@PathVariable("nomCliente") String nomCliente, 
			@PathVariable("dirCliente") String dirCliente, 
			@PathVariable("telCliente") int telCliente) {
		Clientes clientesActualizado = this.clientesService.actualizar(idCliente, nomCliente, dirCliente, telCliente);
		if (clientesActualizado != null) {
			return new ResponseEntity(clientesActualizado, HttpStatus.OK);
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/clientes/{idCliente}/")
	public ResponseEntity<Void> eliminarClientes(@PathVariable("idCliente") Long idCliente) {
		this.clientesService.eliminar(idCliente);
		return ResponseEntity.noContent().build();
	}
}
