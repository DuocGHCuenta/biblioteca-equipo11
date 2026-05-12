package cl.duoc.tercer_modulo_api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class LibroCreateDTO {

    @NotBlank(message = "El libro debe tener un titulo")
    @Size(min = 2, max = 50, message = "El titulo del libro debe tener entre 2 y 50 caracteres")
    private String titulo;

    @NotBlank(message = "El libro debe tener un codigo ISBN ")
    private String isbn;

    @NotNull(message = "El libro debe tener un precio")
    // puede ser gratis con 0 precio
    private int precio;

}
