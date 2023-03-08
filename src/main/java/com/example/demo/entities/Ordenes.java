package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Ordenes {
	@Id
	private Long ordenesId;
	private Long clienteId;
	private Long productoId;
	private double precioProducto;
	private int cantProducto;
	
}
