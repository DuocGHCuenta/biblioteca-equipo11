package cl.duoc.segundo_modulo_api.service;

import java.util.List;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.duoc.segundo_modulo_api.client.LibroInventarioClient;
import cl.duoc.segundo_modulo_api.dto.LibroCreateDTO;
import cl.duoc.segundo_modulo_api.dto.LibroDTO;
import cl.duoc.segundo_modulo_api.dto.LibroInventarioDTO;
import cl.duoc.segundo_modulo_api.model.Libro;
import cl.duoc.segundo_modulo_api.repository.LibroRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class LibroService {
    //@Autowired
    private final LibroRepository libroRepository;

    private final LibroInventarioClient libroInventarioClient;

    public List <Libro> findAll(){
        return libroRepository.findAll();
    }


    public Libro findById(Integer id){
        return libroRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Libro no encontrado"));
    }

    


    public Libro findByIsbn(String isbn){
        return libroRepository.findByIsbn(isbn)
            .orElseThrow(() -> new RuntimeException("Libro no encontrado"));
    }


     public void deleteById(Integer id) {

        if (!libroRepository.existsById(id)) {
            throw new RuntimeException("Libro no encontrado");
        }

        libroRepository.deleteById(id);
    }


    public Libro save(Libro libro){
        return libroRepository.save(libro);
    }
    





    public LibroDTO findDtoById(Integer id) {

        Libro l1 = libroRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Libro no encontrado"));

    

            // throw new RecursoNoEncontradoException("Libro no encontrado");
            //.orElseThrow(() -> new RecursoNoEncontradoException("Libro no encontrado"));

        return new LibroDTO(
            l1.getId(),
            l1.getTitulo(),
            l1.getIsbn(),
            l1.getIdCliente(),
            l1.getFechaPrestamiento(),
            l1.getFechaDevolucion(),
            l1.getVecesPrestada(),
            l1.getCondicionAntesEntrega(),
            l1.getCondicionDevolucion()
        );
    }


    public LibroDTO crearLibro(LibroCreateDTO dto) {


            // Llamada al microservicio Inventario
        LibroInventarioDTO libroInventario =
                libroInventarioClient.obtenerLibro(1);

        System.out.println("Libro encontrado: "
                + libroInventario.getTitulo());


        // 1. Convertir DTO de entrada a entidad
        Libro p = new Libro();
        p.setTitulo(dto.getTitulo());
        p.setIsbn(dto.getIsbn());
        p.setIdCliente(dto.getIdCliente());
        p.setFechaPrestamiento(dto.getFechaPrestamiento());
        p.setFechaDevolucion(dto.getFechaDevolucion());
        p.setVecesPrestada(dto.getVecesPrestada());
        p.setCondicionAntesEntrega(dto.getCondicionAntesEntrega());
        p.setCondicionDevolucion(dto.getCondicionDevolucion());
    

        // El id, createdAt y otros campos internos los maneja JPA/BD

        // 2. Persistir en la base de datos
        Libro guardado = libroRepository.save(p);

        // 3. Convertir la entidad guardada a DTO de salida (ya con id)
        return new LibroDTO(
            guardado.getId(),
            guardado.getTitulo(),
            guardado.getIsbn(),
            guardado.getIdCliente(),
            guardado.getFechaPrestamiento(),
            guardado.getFechaDevolucion(),
            guardado.getVecesPrestada(),
            guardado.getCondicionAntesEntrega(),
            guardado.getCondicionDevolucion()
        );
}


}
