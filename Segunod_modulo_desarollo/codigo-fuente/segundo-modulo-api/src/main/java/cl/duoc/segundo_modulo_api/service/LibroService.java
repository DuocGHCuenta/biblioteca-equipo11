package cl.duoc.segundo_modulo_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.duoc.segundo_modulo_api.dto.LibroCreateDTO;
import cl.duoc.segundo_modulo_api.dto.LibroDTO;
import cl.duoc.segundo_modulo_api.model.Libro;
import cl.duoc.segundo_modulo_api.repository.LibroRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class LibroService {
    @Autowired
    private LibroRepository libroRepository;

    public List <Libro> findAll(){
        return libroRepository.findAll();
    }


    public Libro findById(Integer id){
        return libroRepository.findById(id);
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
            l1.getId_cliente(),
            l1.getFecha_prestamiento(),
            l1.getFecha_devolucion(),
            l1.getVeces_prestada(),
            l1.getCondicion_antes_entrega(),
            l1.getCondicion_devolucion()
        );
    }


    public LibroDTO crearLibro(LibroCreateDTO dto) {

    // 1. Convertir DTO de entrada a entidad
    Libro p = new Libro();
    p.setTitulo(dto.getTitulo());
    p.setIsbn(dto.getIsbn());
    p.setId_cliente(dto.getId_cliente());
    p.setFecha_prestamiento(dto.getFecha_prestamiento());
    p.setFecha_devolucion(dto.getFecha_devolucion());
    p.setVeces_prestada(dto.getVeces_prestada());
    p.setCondicion_antes_entrega(dto.getCondicion_antes_entrega());
    p.setCondicion_devolucion(dto.getCondicion_devolucion());
  

    // El id, createdAt y otros campos internos los maneja JPA/BD

    // 2. Persistir en la base de datos
    Libro guardado = libroRepository.save(p);

    // 3. Convertir la entidad guardada a DTO de salida (ya con id)
    return new LibroDTO(
        guardado.getId(),
        guardado.getTitulo(),
        guardado.getIsbn(),
        guardado.getId_cliente(),
        guardado.getFecha_prestamiento(),
        guardado.getFecha_devolucion(),
        guardado.getVeces_prestada(),
        guardado.getCondicion_antes_entrega(),
        guardado.getCondicion_devolucion()
    );
}


}
