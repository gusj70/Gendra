package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.demo.entities.Ordenes;

public interface ordenesRepository extends CrudRepository<Ordenes, Long> {

}
