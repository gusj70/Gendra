package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Productos {
	@Id
	private Long productoId;
	private String nomProducto;
	private String mcaProducto;
	private int precioProducto;

}
