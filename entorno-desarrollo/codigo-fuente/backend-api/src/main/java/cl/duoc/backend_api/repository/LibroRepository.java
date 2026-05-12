package cl.duoc.backend_api.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import cl.duoc.backend_api.model.Libro;
import jakarta.transaction.Transactional;

@Repository
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

        libroEncontrado.setCantidad_copias(libro.getCantidad_copias());
        libroEncontrado.setUbicacion_pasillo(libro.getUbicacion_pasillo());
        libroEncontrado.setUbicacion_estante(libro.getUbicacion_estante());
        libroEncontrado.setUbicacion_nivel(libro.getUbicacion_nivel());

        return libroEncontrado;
    }

}
