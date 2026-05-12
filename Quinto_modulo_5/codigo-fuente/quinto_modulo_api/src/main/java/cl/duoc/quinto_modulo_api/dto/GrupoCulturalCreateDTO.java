package cl.duoc.quinto_modulo_api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class GrupoCulturalCreateDTO {

    @NotBlank(message = "El grupo o club debe tener un nombre")
    private String nombre;


    @NotBlank(message = "Se debe dar informacion sobre que tipo de club es")
    private String tipo_club;


    @NotBlank(message = "Debe haber una descripcion de lo que se trata el club")
    @Size(min = 10, max = 300, message = "La descripcion debe tener almenos 10 caracteres")
    private String descripcion;


    @NotBlank(message = "Se debe informacion sobre los horarios del club y el dia en que ocurren")
    private String fecha_club;


    @NotNull(message = "Se debe saber cuantas personas participan en el club")
    private int cantidad_participantes;


    @NotBlank(message = "Se debe informar sobre la ubicacion del grupo o club")
    private String ubicacion_club;

}
