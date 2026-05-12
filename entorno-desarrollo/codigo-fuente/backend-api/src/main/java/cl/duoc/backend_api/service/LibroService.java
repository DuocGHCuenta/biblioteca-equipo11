package cl.duoc.backend_api.service;

import java.util.List;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.duoc.backend_api.dto.LibroCreateDTO;
import cl.duoc.backend_api.dto.LibroDTO;
import cl.duoc.backend_api.model.Libro;
import cl.duoc.backend_api.repository.LibroRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class LibroService {
    //@Autowired
    private LibroRepository libroRepository;

    public List <Libro> findAll(){
        return libroRepository.findAll();
    }


    public Libro findById(Integer id){
        return libroRepository.findById(id);
    }


    public LibroDTO findDtoById(Integer id) {

        Libro l1 = libroRepository.findById(id);

         if (l1 == null){
            throw new RuntimeException("Libro no encontrado");
    }

            // throw new RecursoNoEncontradoException("Libro no encontrado");
            //.orElseThrow(() -> new RecursoNoEncontradoException("Libro no encontrado"));

        return new LibroDTO(
            l1.getId(),
            l1.getTitulo(),
            l1.getIsbn(),
            l1.getCantidad_copias(),
            l1.getUbicacion_pasillo(),
            l1.getUbicacion_estante(),
            l1.getUbicacion_nivel()
        );
    }


    public Libro findByIsbn(String isbn){
        return libroRepository.findByIsbn(isbn);
    }


    public Boolean deleteById(Integer id){
        return libroRepository.deleteById(id);
    }


    public Libro save(Libro libro){
        return libroRepository.save(libro);
    }



    // POST /api/libros       /api/v1/inventariolibros
public LibroDTO crearLibro(LibroCreateDTO dto) {

    // 1. Convertir DTO de entrada a entidad
    Libro p = new Libro();
    p.setTitulo(dto.getTitulo());
    p.setIsbn(dto.getIsbn());
    p.setCantidad_copias(dto.getCantidad_copias());
    p.setUbicacion_pasillo(dto.getUbicacion_pasillo());
    p.setUbicacion_estante(dto.getUbicacion_estante());
    p.setUbicacion_nivel(dto.getUbicacion_nivel());
    // El id, createdAt y otros campos internos los maneja JPA/BD


    // 2. Persistir en la base de datos
    Libro guardado = libroRepository.save(p);

    // 3. Convertir la entidad guardada a DTO de salida (ya con id)
    return new LibroDTO(
        guardado.getId(),
        guardado.getTitulo(),
        guardado.getIsbn(),
        guardado.getCantidad_copias(),
        guardado.getUbicacion_pasillo(),
        guardado.getUbicacion_estante(),
        guardado.getUbicacion_nivel()
    );
}
    
}
