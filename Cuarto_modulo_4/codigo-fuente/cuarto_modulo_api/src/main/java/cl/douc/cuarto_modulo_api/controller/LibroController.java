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
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor // 
//@Autowired

@Tag(
  name = "Libros reparacion",
  description = "Gestion de reparacion de libros"
)
@RestController

@RequestMapping("/api/v1/repararlibros")
public class LibroController {

    private final LibroService libroService;


    // tener una lista de todos
    @Operation(
        summary = "Listar libros ",
        description = "Devuelve una lista de todos lo libros y en que estado estan "
    )
    @ApiResponse(responseCode = "200", description = "Lista de libros obtenida exitosamente")
    @GetMapping()
    public List <Libro> findAll(){

        return libroService.findAll();

    }


    // Buscar y obtener por la id del libro
    @Operation(
        summary = "Buscar libro ID ",
        description = "Buscar y encontrar un libro especificado por el numero de su ID "
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Libro encontrado"),
        @ApiResponse(responseCode = "404", description = "Libro no encontrado")
    })
    @GetMapping("/{id}")
        public Libro findById(
            @Parameter(description = "ID del libro", required = true)
            @PathVariable Integer id ){

            return libroService.findById(id);
        }


    // Encontrarlo por el isbn del libro
    @Operation(
        summary = "Buscar libro ISBN ",
        description = "Buscar y encontrar un libro especificado por su codigo ISBN "
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Libro encontrado"),
        @ApiResponse(responseCode = "404", description = "Libro no encontrado")
    })
    @GetMapping("/isbn/{isbn}")
        public Libro findByIsbn(
            @Parameter(description = "codigo ISBN del libro", required = true)
            @PathVariable String isbn ){

            return libroService.findByIsbn(isbn);
        }   

    

    // Agregar un libro a la libreria
    @Operation(
        summary = "Agregar libro ",
        description = "Agregar un libro mas a la libreria "
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Libro agregado exitosamente "),
        @ApiResponse(responseCode = "404", description = "Datos invalidos ")
    })
    @PostMapping
    public Libro createLibro(
        @Parameter(description = "Datos del libro", required = true)
        @RequestBody Libro libro ){

        libro.setId(null); // libro.setId(null);
        return libroService.save(libro);
    }

    
    //
    @Operation(
        summary = "Actualizar libro ID",
        description = "Actualizar libro especificado por el numero de su ID "
    )
    @PutMapping("/{id}")
    public Libro updateLibro(
        @Parameter(description = "ID del libro", required = true)
        @PathVariable Integer id, 
        
        @Parameter(description = "Datos actualizados del libro", required = true)
        @RequestBody Libro libro ){

        libro.setId(id); //libro.setId(id);
        return libroService.save(libro);
    }


    // Eliminar un libro
    @Operation(
        summary = "Eliminar libro ",
        description = "Eliminar un libro especificado por el numero de su ID, quitandolo de la libreria "
    )
    @ApiResponses({
        @ApiResponse(responseCode = "204", description = "Libro eliminado exitosamente "),
        @ApiResponse(responseCode = "404", description = "Libro no encontrado ")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(
        @Parameter(description = "ID del libro", required = true)
        @PathVariable Integer id ){

        libroService.deleteById(id);

        return ResponseEntity.ok("Libro eliminado correctamente");
    }


    

    // Devuelve LibroDTO (salida)
    @Operation(
        summary = "Devuelve libro dto ",
        description = "Devulve el libro dto por numero de ID "
    )
    @GetMapping("/dto/{id}")
    public ResponseEntity<LibroDTO> getLibro(
        @Parameter(description = "ID del libro", required = true)
        @PathVariable Integer id ) {

        return ResponseEntity.ok(libroService.findDtoById(id));
    }

    
    // Recibe LibroCreateDTO (entrada) y devuelve LibroDTO (salida)
    @Operation(
        summary = "Recibir y devolver libros dto",
        description = "Recibe LibroCreateDTO (entrada) y devuelve LibroDTO (salida) "
    )
    @PostMapping("/dto")
    public ResponseEntity<LibroDTO> crearLibro(
        @Parameter(description = "Datos del libro", required = true)
        @Valid @RequestBody LibroCreateDTO dto ) {

        LibroDTO creado = libroService.crearLibro(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

}

