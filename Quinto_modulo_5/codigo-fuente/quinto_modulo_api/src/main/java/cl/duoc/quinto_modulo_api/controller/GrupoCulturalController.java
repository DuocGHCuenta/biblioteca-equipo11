package cl.duoc.quinto_modulo_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.duoc.quinto_modulo_api.dto.GrupoCulturalCreateDTO;
import cl.duoc.quinto_modulo_api.dto.GrupoCulturalDTO;
import cl.duoc.quinto_modulo_api.model.GrupoCultural;
import cl.duoc.quinto_modulo_api.service.GrupoCulturalService;
import jakarta.validation.Valid;

// @RequiredArgsController
//@Autowired
@RestController

@RequestMapping("/api/v1/grupoculturalclub")
public class GrupoCulturalController {
    
    @Autowired

    private GrupoCulturalService grupoCulturalService;


    // tener una lista de todos
    @GetMapping()
    public List <GrupoCultural> findAll(){
        return grupoCulturalService.findAll();

    }


    // Buscar y obtener por la id del club
    @GetMapping("/{id}") // podria ser @GetMapping("{id}") sin la /
        public GrupoCultural findById (@PathVariable Integer id){
            return grupoCulturalService.findById(id);
        }


        // Encontrarlo por el club por el nombre
     @GetMapping("/nombre/{nombre}")
        public GrupoCultural findByNombre (@PathVariable String nombre){
            return grupoCulturalService.findByNombre(nombre);
        }   

    

    // Agregar un club
    @PostMapping
    public GrupoCultural createLibro(@RequestBody GrupoCultural libro){
        libro.setId(null); // libro.setId(null);
        return grupoCulturalService.save(libro);
    }


    @PutMapping("/{id}")
    public GrupoCultural updateLibro(@PathVariable Integer id, @RequestBody GrupoCultural libro){
        libro.setId(id); //libro.setId(id);
        return grupoCulturalService.save(libro);
    }








// Devuelve GrupoCulturalDTO (salida)
    @GetMapping("/dto/{id}")
    public ResponseEntity<GrupoCulturalDTO> getGrupoCultural(@PathVariable Integer id) {
        return ResponseEntity.ok(grupoCulturalService.findDtoById(id));
    }

    // Recibe GrupoCulturalCreateDTO (entrada) y devuelve GrupoCulturalDTO (salida)
    @PostMapping("/dto")
    public ResponseEntity<GrupoCulturalDTO> crearGrupoCultural(
            @Valid @RequestBody GrupoCulturalCreateDTO dto) {
        GrupoCulturalDTO creado = grupoCulturalService.crearGrupoCultural(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

}
