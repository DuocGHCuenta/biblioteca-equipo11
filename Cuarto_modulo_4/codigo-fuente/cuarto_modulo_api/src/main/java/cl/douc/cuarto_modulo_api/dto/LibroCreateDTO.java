package cl.douc.cuarto_modulo_api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

@Schema(description = "Datos para crear un libro ")
public class LibroCreateDTO {

    @Schema(
    description = "Nombre del libro ",
    example = "Harry Potter "
    )
    @NotBlank(message = "El libro debe tener un nombre o titulo")
    @Size(min = 2, max = 50, message = "El nombre del libro debe tener entre 2 y 50 caracteres")
    private String nombre;
 
    
    @Schema(
    description = "Condicion del libro ",
    example = "Muy Buena "
    )
    @NotBlank(message = "Se debe documentar la condicion del libro para decidir si necesita se reparado o no")
    private String condicion; // Del libro por si repararlo o no.


    @Schema(
    description = "Codigo ISBN ",
    example = "9788478884452 "
    )
    @NotBlank(message = "El libro debe tener un codigo ISBN ")
    private String isbn;

}
