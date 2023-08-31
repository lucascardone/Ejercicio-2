package com.utn.ejercicio_2.repositories;

import com.utn.ejercicio_2.entities.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryPersona extends JpaRepository<Persona, Long> {
}
