package com.example.retotecnico.repository;

import com.example.retotecnico.entity.Change;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ChangeRepository extends CrudRepository<Change, Double> {
    Optional<Change> findByMonedaOrigenAndMonedaDestino(String monedaOrigen, String monedaDestino);
}
