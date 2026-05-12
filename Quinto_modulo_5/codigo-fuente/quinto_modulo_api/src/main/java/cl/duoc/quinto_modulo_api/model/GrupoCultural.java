package cl.duoc.quinto_modulo_api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

// Esto es para grupos culturales

public class GrupoCultural {
    private Integer id;
    private String nombre;
    private String tipo_club;
    private String descripcion;
    private String fecha_club;
    private int cantidad_participantes;
    private String ubicacion_club;

}

