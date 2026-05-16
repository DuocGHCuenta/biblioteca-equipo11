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
    private final GrupoCulturalRepository grupoCulturalRepository;

    public List <GrupoCultural> findAll(){
        return grupoCulturalRepository.findAll();
    }


    public GrupoCultural findById(Integer id){
        return grupoCulturalRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Club no encontrado"));
    }


    public GrupoCultural findByNombre(String nombre){
        return grupoCulturalRepository.findByNombre(nombre)
        .orElseThrow(() -> new RuntimeException("Club no encontrado"));
    }


     public void deleteById(Integer id) {

        if (!grupoCulturalRepository.existsById(id)) {
            throw new RuntimeException("Club no encontrado");
        }

        grupoCulturalRepository.deleteById(id);
    }


    public GrupoCultural save(GrupoCultural libro){
        return grupoCulturalRepository.save(libro);
    }




    

    public GrupoCulturalDTO findDtoById(Integer id) {

        GrupoCultural l1 = grupoCulturalRepository.findById(id)

        .orElseThrow(() -> new RuntimeException("Club no encontrado"));

        return new GrupoCulturalDTO(
            l1.getId(),
            l1.getNombre(),
            l1.getTipoClub(),
            l1.getDescripcion(),
            l1.getFechaClub(),
            l1.getCantidadParticipantes(),
            l1.getUbicacionClub()
        );
    }


    public GrupoCulturalDTO crearGrupoCultural(GrupoCulturalCreateDTO dto) {

    // 1. Convertir DTO de entrada a entidad
    GrupoCultural p = new GrupoCultural();
    p.setNombre(dto.getNombre());
    p.setTipoClub(dto.getTipoClub());
    p.setDescripcion(dto.getDescripcion());
    p.setFechaClub(dto.getFechaClub());
    p.setCantidadParticipantes(dto.getCantidadParticipantes());
    p.setUbicacionClub(dto.getUbicacionClub());


    // El id, createdAt y otros campos internos los maneja JPA/BD

    // 2. Persistir en la base de datos
    GrupoCultural guardado = grupoCulturalRepository.save(p);

    // 3. Convertir la entidad guardada a DTO de salida (ya con id)
    return new GrupoCulturalDTO(
        guardado.getId(),
        guardado.getNombre(),
        guardado.getTipoClub(),
        guardado.getDescripcion(),
        guardado.getFechaClub(),
        guardado.getCantidadParticipantes(),
        guardado.getUbicacionClub()
        
    );
}
}
