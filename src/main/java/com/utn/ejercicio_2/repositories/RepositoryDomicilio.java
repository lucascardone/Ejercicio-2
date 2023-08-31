package com.utn.ejercicio_2.repositories;

import com.utn.ejercicio_2.entities.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryDomicilio extends JpaRepository<Domicilio, Long> {
}
