package cl.douc.cuarto_modulo_api.service;

import java.util.List;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.douc.cuarto_modulo_api.dto.LibroCreateDTO;
import cl.douc.cuarto_modulo_api.dto.LibroDTO;
import cl.douc.cuarto_modulo_api.exception.RecursoNoEncontradoException;
import cl.douc.cuarto_modulo_api.model.Libro;
import cl.douc.cuarto_modulo_api.repository.LibroRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class LibroService {
    //@Autowired
    private final LibroRepository libroRepository;

    public List <Libro> findAll(){
        return libroRepository.findAll();
    }


    public Libro findById(Integer id){
        return libroRepository.findById(id)
            .orElseThrow(() -> new RecursoNoEncontradoException("Libro no encontrado"));
    }



    public Libro findByIsbn(String isbn){
        return libroRepository.findByIsbn(isbn)
            .orElseThrow(() -> new RecursoNoEncontradoException("Libro no encontrado"));
    }


     public void deleteById(Integer id) {

        if (!libroRepository.existsById(id)) {
            throw new RecursoNoEncontradoException("Libro no encontrado");
        }

        libroRepository.deleteById(id);
    }


    public Libro save(Libro libro){
        return libroRepository.save(libro);
    }
    




    public LibroDTO findDtoById(Integer id) {

        Libro l1 = libroRepository.findById(id)

        .orElseThrow(() -> new RecursoNoEncontradoException("Libro no encontrado"));

            // throw new RecursoNoEncontradoException("Libro no encontrado");
            //.orElseThrow(() -> new RecursoNoEncontradoException("Libro no encontrado"));

        return new LibroDTO(
            l1.getId(),
            l1.getNombre(),
            l1.getCondicion(),
            l1.getIsbn()

        );
    }


    public LibroDTO crearLibro(LibroCreateDTO dto) {

    // 1. Convertir DTO de entrada a entidad
    Libro p = new Libro();
    p.setNombre(dto.getNombre());
    p.setCondicion(dto.getCondicion());
    p.setIsbn(dto.getIsbn());

    // El id, createdAt y otros campos internos los maneja JPA/BD

    // 2. Persistir en la base de datos
    Libro guardado = libroRepository.save(p);

    // 3. Convertir la entidad guardada a DTO de salida (ya con id)
    return new LibroDTO(
        guardado.getId(),
        guardado.getNombre(),
        guardado.getCondicion(),
        guardado.getIsbn()
    );
}

}
