package cl.duoc.backend_api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import cl.duoc.backend_api.dto.LibroCreateDTO;
import cl.duoc.backend_api.dto.LibroDTO;
import cl.duoc.backend_api.model.Libro;
import cl.duoc.backend_api.service.LibroService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/inventariolibros")

@RequiredArgsConstructor
public class LibroController {

    private final LibroService libroService;

    // Obtener una lista de todos los libros
    @GetMapping()
    public List<Libro> findAll(){
        return libroService.findAll();
    }

    // Buscar el libro por la id
    @GetMapping("/{id}")
    public Libro findById(@PathVariable Integer id){
        return libroService.findById(id);
    }

    // Buscar libro por su ISBN
    @GetMapping("/isbn/{isbn}")
    public Libro findByIsbn(@PathVariable String isbn){
        return libroService.findByIsbn(isbn);
    }

    // Crear un libro 
    @PostMapping
    public Libro createLibro(@RequestBody Libro libro){

        libro.setId(null);

        return libroService.save(libro);
    }

    // Actualizar un libro
    @PutMapping("/{id}")
    public Libro updateLibro(
            @PathVariable Integer id,
            @RequestBody Libro libro){

        libro.setId(id);

        return libroService.save(libro);
    }

    // Eliminar un libro
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Integer id){

        libroService.deleteById(id);

        return ResponseEntity.ok("Libro eliminado correctamente");
    }

    // DTO GET
    @GetMapping("/dto/{id}")
    public ResponseEntity<LibroDTO> getLibro(@PathVariable Integer id){

        return ResponseEntity.ok(
                libroService.findDtoById(id)
        );
    }

    // DTO POST
    @PostMapping("/dto")
    public ResponseEntity<LibroDTO> crearLibro(
            @Valid @RequestBody LibroCreateDTO dto){

        LibroDTO creado = libroService.crearLibro(dto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(creado);
    }
}