package cl.duoc.quinto_modulo_api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.duoc.quinto_modulo_api.model.GrupoCultural;


// @Repository indica a Spring que este componente se encarga de la base de datos.
@Repository
public interface GrupoCulturalRepository extends JpaRepository<GrupoCultural, Integer> {
    Optional<GrupoCultural> findByNombre(String nombre);

}
