package cl.duoc.segundo_modulo_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    
}
