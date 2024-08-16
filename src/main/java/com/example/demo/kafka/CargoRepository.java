package com.example.demo.kafka;

import org.springframework.data.repository.CrudRepository;

public interface CargoRepository extends CrudRepository<Cargo, Long> {

    Cargo findById(long id);
}
