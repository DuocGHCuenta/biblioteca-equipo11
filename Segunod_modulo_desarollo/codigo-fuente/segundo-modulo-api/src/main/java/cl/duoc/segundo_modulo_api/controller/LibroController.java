package cl.duoc.segundo_modulo_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.duoc.segundo_modulo_api.model.Libro;
import cl.duoc.segundo_modulo_api.service.LibroService;

// @RequiredArgsController
//@Autowired
@RestController

@RequestMapping("/api/v1/prestarlibrosconplazo")
public class LibroController {
    
    @Autowired

    private LibroService libroService;


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
}
