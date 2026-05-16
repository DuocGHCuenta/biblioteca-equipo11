package cl.douc.cuarto_modulo_api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.douc.cuarto_modulo_api.dto.LibroCreateDTO;
import cl.douc.cuarto_modulo_api.dto.LibroDTO;
import cl.douc.cuarto_modulo_api.model.Libro;
import cl.douc.cuarto_modulo_api.service.LibroService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
//@Autowired
@RestController

@RequestMapping("/api/v1/repararlibros")
public class LibroController {

    private final LibroService libroService;


    // tener una lista de todos
    @GetMapping()
    public List <Libro> findAll(){
        return libroService.findAll();

    }


    // Buscar y obtener por la id del libro
    @GetMapping("{id}")
        public Libro findById (@PathVariable Integer id){
            return libroService.findById(id);
        }


        // Encontrarlo por el isbn del libro
    @GetMapping("/isbn/{isbn}")
        public Libro findByIsbn (@PathVariable String isbn){
            return libroService.findByIsbn(isbn);
        }   

    

    // Agregar un libro a la libreria
    @PostMapping
    public Libro createLibro(@RequestBody Libro libro){
        libro.setId(null); // libro.setId(null);
        return libroService.save(libro);
    }


    @PutMapping("/{id}")
    public Libro updateLibro(@PathVariable Integer id, @RequestBody Libro libro){
        libro.setId(id); //libro.setId(id);
        return libroService.save(libro);
    }


    // Eliminar un libro
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Integer id){

        libroService.deleteById(id);

        return ResponseEntity.ok("Libro eliminado correctamente");
    }



    

    

    // Devuelve LibroDTO (salida)
    @GetMapping("/dto/{id}")
    public ResponseEntity<LibroDTO> getLibro(@PathVariable Integer id) {
        return ResponseEntity.ok(libroService.findDtoById(id));
    }

    // Recibe LibroCreateDTO (entrada) y devuelve LibroDTO (salida)
    @PostMapping("/dto")
    public ResponseEntity<LibroDTO> crearLibro(
            @Valid @RequestBody LibroCreateDTO dto) {
        LibroDTO creado = libroService.crearLibro(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

}
