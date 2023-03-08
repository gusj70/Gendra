package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.demo.entities.Clientes;

public interface clientesRepository extends CrudRepository<Clientes, Long> {

}
