package cl.duoc.segundo_modulo_api.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.duoc.segundo_modulo_api.model.Libro;


// @Repository indica a Spring que este componente se encarga de la base de datos.
@Repository
public interface LibroRepository extends JpaRepository<Libro, Integer> {
    Optional<Libro> findByIsbn(String isbn);

}


