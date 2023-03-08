package com.example.demo.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entities.Clientes;
import com.example.demo.repository.clientesRepository;

public class IClientesServiceImpl implements IClientesService {
	
	@Autowired
	private clientesRepository clientesRepository;

	public Clientes crear(Clientes clientes) {
		// TODO Auto-generated method stub
		return this.clientesRepository.save(clientes);
	}

	public Optional<Clientes> obtenerPorId(Long clienteId) {
		// TODO Auto-generated method stub
		return null;
	}

	public Clientes actualizar(Long clienteId, String nomCliente, String dirCliente, int telCliente) {
		// TODO Auto-generated method stub
		Optional<Clientes> clientes = this.clientesRepository.findById(clienteId);
		if (clientes.isPresent()) {
			Clientes tmp = clientes.get();
			tmp.setDirCliente(dirCliente);
			tmp.setNomCliente(nomCliente);
			tmp.setTelCliente(telCliente);
			return crear(tmp);
		}
		return null;
	}

	public boolean eliminar(Long clienteId) {
		// TODO Auto-generated method stub
		this.clientesRepository.deleteById(clienteId);
		return true;
	}
}
