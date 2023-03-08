package com.example.demo.service;

import java.util.Optional;
import com.example.demo.entities.Clientes;

public interface IClientesService {
	Clientes crear(Clientes clientes);
	Optional<Clientes> obtenerPorId(Long clienteId);
	Clientes actualizar(Long clienteId, String nomCliente, String dirCliente, int telCliente);
	boolean eliminar(Long clienteId);
}
