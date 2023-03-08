package com.example.demo.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ClientesServiceTest {
	@Test
	public void clientesTest() {
		IClientesService clientesService = null;
		clientesService.obtenerPorId((long) 10000000);
		Assertions.assertTrue(true);
	}
}
