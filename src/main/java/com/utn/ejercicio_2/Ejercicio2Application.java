package com.utn.ejercicio_2;

import com.utn.ejercicio_2.entities.Domicilio;
import com.utn.ejercicio_2.entities.Persona;
import com.utn.ejercicio_2.repositories.RepositoryDomicilio;
import com.utn.ejercicio_2.repositories.RepositoryPersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Ejercicio2Application {

    @Autowired
    private RepositoryDomicilio repositoryDomicilio;
    @Autowired
    private RepositoryPersona repositoryPersona;

    public static void main(String[] args) {
        SpringApplication.run(Ejercicio2Application.class, args);
    }

    @Bean
    CommandLineRunner init(RepositoryPersona repositoryPersona, RepositoryDomicilio repositoryDomicilio) {
        return args -> {
            System.out.println("############ Consultas SQL ############");
            Domicilio domicilio = new Domicilio();
            domicilio.setCalle("Siempreviva");
            domicilio.setNumero(890);


            Persona persona = new Persona();
            persona.setNombre("Lucas");
            persona.setApellido("Cardone");
            persona.setEdad(21);
            persona.setDomicilio(domicilio);

            repositoryPersona.save(persona);

            // Recuperar el objeto Persona desde la base de datos
            Persona personaRecuperada = repositoryPersona.findById(persona.getId()).orElse(null);
            if (personaRecuperada != null) {
                System.out.println("Nombre: " + personaRecuperada.getNombre());
                System.out.println("Apellido: " + personaRecuperada.getApellido());
                System.out.println("Edad: " + personaRecuperada.getEdad());
                System.out.println("Domicilio: " + personaRecuperada.getDomicilio());
            }
        };
    }

}
