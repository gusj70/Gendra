package com.example.demo.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductosServiceTest {
	@Test
	public void productosTest() {
		IProductosService productosService = null;
		productosService.obtenerPorId((long) 10000000);
		Assertions.assertTrue(true);
	}
}
