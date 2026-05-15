package cl.duoc.backend_api.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import cl.duoc.backend_api.model.Libro;
import jakarta.transaction.Transactional;

// @Repository indica a Spring que este componente se encarga de la base de datos.
@Repository

// @Transactional indica que las operaciones de la base de datos dentro de esta clase se ejecutar como una transaccion segura.
@Transactional
public class LibroRepository {
    private List <Libro> listaLibros = new ArrayList <>();

    public List<Libro> findAll(){
        return listaLibros;
    }

    public Libro findById(int id){
        for (Libro librofor : listaLibros){
            if (librofor.getId() == id){
                return librofor;
            }
        }
        return null;
    }


    public Libro findByIsbn(String isbn){
        for (Libro libroisbn : listaLibros){
            if (libroisbn.getIsbn().equals (isbn)){
                return libroisbn;
            }
        }
        return null;
    }


    public Boolean deleteById(int id){
        for (Libro librodel : listaLibros){
            if (librodel.getId() == id){
                listaLibros.remove(librodel);
                return true;
            }
        }
        return false;
    }


    public Libro save(Libro libro){
        if (libro.getId() == null){
            int lastId = listaLibros.size() + 1;
            libro.setId(lastId);
            listaLibros.add(libro);
            return libro;
        }

        Libro libroEncontrado = findById(libro.getId());
        if (libroEncontrado == null) return null;

        libroEncontrado.setTitulo(libro.getTitulo());
        libroEncontrado.setIsbn(libro.getIsbn());

        libroEncontrado.setCantidadCopias(libro.getCantidadCopias());
        libroEncontrado.setUbicacionPasillo(libro.getUbicacionPasillo());
        libroEncontrado.setUbicacionEstante(libro.getUbicacionEstante());
        libroEncontrado.setUbicacionNivel(libro.getUbicacionNivel());

        return libroEncontrado;
    }

}
