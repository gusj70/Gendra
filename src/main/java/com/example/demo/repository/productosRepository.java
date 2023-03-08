package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.demo.entities.Productos;

public interface productosRepository extends CrudRepository<Productos, Long> {

}
