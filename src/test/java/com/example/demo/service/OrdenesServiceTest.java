package com.example.demo.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrdenesServiceTest {
	@Test
	public void ordenesTest() {
		IOrdenesService ordenesService = null;
		ordenesService.obtenerPorId((long) 10000000);
		Assertions.assertTrue(true);
	}
}
