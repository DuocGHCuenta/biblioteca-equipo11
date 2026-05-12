package cl.duoc.quinto_modulo_api.service;

import java.util.List;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.duoc.quinto_modulo_api.dto.GrupoCulturalCreateDTO;
import cl.duoc.quinto_modulo_api.dto.GrupoCulturalDTO;
import cl.duoc.quinto_modulo_api.model.GrupoCultural;
import cl.duoc.quinto_modulo_api.repository.GrupoCulturalRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class GrupoCulturalService {
    //@Autowired
    private GrupoCulturalRepository grupoCulturalRepository;

    public List <GrupoCultural> findAll(){
        return grupoCulturalRepository.findAll();
    }


    public GrupoCultural findById(Integer id){
        return grupoCulturalRepository.findById(id);
    }


    public GrupoCultural findByNombre(String nombre){
        return grupoCulturalRepository.findByNombre(nombre);
    }


    public Boolean deleteById(Integer id){
        return grupoCulturalRepository.deleteById(id);
    }


    public GrupoCultural save(GrupoCultural libro){
        return grupoCulturalRepository.save(libro);
    }




    

    public GrupoCulturalDTO findDtoById(Integer id) {

        GrupoCultural l1 = grupoCulturalRepository.findById(id);

         if (l1 == null){
            throw new RuntimeException("Club no encontrado");
    }

            // throw new RecursoNoEncontradoException("Libro no encontrado");
            //.orElseThrow(() -> new RecursoNoEncontradoException("Libro no encontrado"));

        return new GrupoCulturalDTO(
            l1.getId(),
            l1.getNombre(),
            l1.getTipo_club(),
            l1.getDescripcion(),
            l1.getFecha_club(),
            l1.getCantidad_participantes(),
            l1.getUbicacion_club()
        );
    }


    public GrupoCulturalDTO crearGrupoCultural(GrupoCulturalCreateDTO dto) {

    // 1. Convertir DTO de entrada a entidad
    GrupoCultural p = new GrupoCultural();
    p.setNombre(dto.getNombre());
    p.setTipo_club(dto.getTipo_club());
    p.setDescripcion(dto.getDescripcion());
    p.setFecha_club(dto.getFecha_club());
    p.setCantidad_participantes(dto.getCantidad_participantes());
    p.setUbicacion_club(dto.getUbicacion_club());


    // El id, createdAt y otros campos internos los maneja JPA/BD

    // 2. Persistir en la base de datos
    GrupoCultural guardado = grupoCulturalRepository.save(p);

    // 3. Convertir la entidad guardada a DTO de salida (ya con id)
    return new GrupoCulturalDTO(
        guardado.getId(),
        guardado.getNombre(),
        guardado.getTipo_club(),
        guardado.getDescripcion(),
        guardado.getFecha_club(),
        guardado.getCantidad_participantes(),
        guardado.getUbicacion_club()
        
    );
}
}
