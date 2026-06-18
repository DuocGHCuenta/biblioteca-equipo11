package cl.duoc.tercer_modulo_api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    description = "Titulo del libro ",
    example = "Harry Potter "
    )
    @NotBlank(message = "El libro debe tener un titulo")
    @Size(min = 2, max = 50, message = "El titulo del libro debe tener entre 2 y 50 caracteres")
    private String titulo;


    @Schema(
    description = "Codigo ISBN ",
    example = "9788478884452 "
    )
    @NotBlank(message = "El libro debe tener un codigo ISBN ")
    private String isbn;


    @Schema(
    description = "Precio del libro ",
    example = "8500 pesos chilenos "
    )
    @NotNull(message = "El libro debe tener un precio")
    // puede ser gratis con 0 precio
    private int precio;

}
