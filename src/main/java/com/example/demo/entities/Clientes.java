package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Clientes {
	@Id
	private Long idCliente;
	private String nomCliente;
	private String dirCliente;
	private int telCliente;
	
}
