package cl.duoc.quinto_modulo_api.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor


public class GrupoCulturalDTO {

    private Integer id;
    private String nombre;
    private String tipoClub;
    private String descripcion;
    private String fechaClub;
    private int cantidadParticipantes;
    private String ubicacionClub;

}
