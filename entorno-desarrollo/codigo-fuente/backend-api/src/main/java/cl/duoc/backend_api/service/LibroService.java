package cl.duoc.backend_api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cl.duoc.backend_api.dto.LibroCreateDTO;
import cl.duoc.backend_api.dto.LibroDTO;
import cl.duoc.backend_api.exception.RecursoNoEncontradoException;
import cl.duoc.backend_api.model.Libro;
import cl.duoc.backend_api.repository.LibroRepository;
import lombok.RequiredArgsConstructor;

// @Service indica que esta clase contiene la lógica de negocio.
@Service

// @RequiredArgsConstructor indica a Lombok que genere automaticamente un constructor con los atributos obligatorios de la clase.
@RequiredArgsConstructor
public class LibroService {

    private final LibroRepository libroRepository;

    // Obtener todos los libros
    public List<Libro> findAll() {
        return libroRepository.findAll();
    }

    // Buscar libro por ID
    public Libro findById(Integer id) {

        return libroRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Libro no encontrado"));
    }

    // Buscar libro DTO por ID
    public LibroDTO findDtoById(Integer id) {

        Libro l1 = libroRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Libro no encontrado"));

        return new LibroDTO(
                l1.getId(),
                l1.getTitulo(),
                l1.getIsbn(),
                l1.getCantidadCopias(),
                l1.getUbicacionPasillo(),
                l1.getUbicacionEstante(),
                l1.getUbicacionNivel()
        );
    }

    // Buscar libro por ISBN
    public Libro findByIsbn(String isbn) {

        return libroRepository.findByIsbn(isbn)
                .orElseThrow(() -> new RecursoNoEncontradoException("Libro no encontrado"));
    }

    // Eliminar libro por ID
    public void deleteById(Integer id) {

        if (!libroRepository.existsById(id)) {
            throw new RecursoNoEncontradoException("Libro no encontrado");
        }

        libroRepository.deleteById(id);
    }

    // Guardar libro
    public Libro save(Libro libro) {
        return libroRepository.save(libro);
    }

    // Crear libro usando DTO
    public LibroDTO crearLibro(LibroCreateDTO dto) {

        // Convertir DTO a entidad
        Libro p = new Libro();

        p.setTitulo(dto.getTitulo());
        p.setIsbn(dto.getIsbn());
        p.setCantidadCopias(dto.getCantidadCopias());
        p.setUbicacionPasillo(dto.getUbicacionPasillo());
        p.setUbicacionEstante(dto.getUbicacionEstante());
        p.setUbicacionNivel(dto.getUbicacionNivel());

        // Guardar en BD
        Libro guardado = libroRepository.save(p);

        
        // Convertir entidad a DTO
        return new LibroDTO(
                guardado.getId(),
                guardado.getTitulo(),
                guardado.getIsbn(),
                guardado.getCantidadCopias(),
                guardado.getUbicacionPasillo(),
                guardado.getUbicacionEstante(),
                guardado.getUbicacionNivel()
        );
    }
}