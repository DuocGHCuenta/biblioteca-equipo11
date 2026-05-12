package cl.duoc.quinto_modulo_api.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import cl.duoc.quinto_modulo_api.model.GrupoCultural;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class GrupoCulturalRepository {
    private List <GrupoCultural> listaGruposCulturales = new ArrayList <>();

    public List<GrupoCultural> findAll(){
        return listaGruposCulturales;
    }

    public GrupoCultural findById(int id){
        for (GrupoCultural librofor : listaGruposCulturales){
            if (librofor.getId() == id){
                return librofor;
            }
        }
        return null;
    }


    public GrupoCultural findByNombre(String nombre){
        for (GrupoCultural libroisbn : listaGruposCulturales){
            if (libroisbn.getNombre().equals (nombre)){
                return libroisbn;
            }
        }
        return null;
    }


    public Boolean deleteById(int id){
        for (GrupoCultural librodel : listaGruposCulturales){
            if (librodel.getId() == id){
                listaGruposCulturales.remove(librodel);
                return true;
            }
        }
        return false;
    }


    public GrupoCultural save(GrupoCultural libro){
        if (libro.getId() == null){
            int lastId = listaGruposCulturales.size() + 1;
            libro.setId(lastId);
            listaGruposCulturales.add(libro);
            return libro;
        }

        GrupoCultural libroEncontrado = findById(libro.getId());
        if (libroEncontrado == null) return null;

        libroEncontrado.setNombre(libro.getNombre());
        libroEncontrado.setTipo_club(libro.getTipo_club());
        libroEncontrado.setDescripcion(libro.getDescripcion());
        libroEncontrado.setFecha_club(libro.getFecha_club());
        libroEncontrado.setCantidad_participantes(libro.getCantidad_participantes());
        libroEncontrado.setUbicacion_club(libro.getUbicacion_club());

        return libroEncontrado;
    }

}
