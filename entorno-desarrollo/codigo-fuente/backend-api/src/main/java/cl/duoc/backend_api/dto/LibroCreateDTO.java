package cl.duoc.backend_api.dto;

import jakarta.validation.constraints.Min;
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

    // -- Aparentemente no tiene id

    @NotBlank(message = "El libro debe tener un titulo")
    @Size(min = 2, max = 50, message = "El titulo del libro debe tener entre 2 y 50 caracteres")
    private String titulo;

    @NotBlank(message = "El libro debe tener un codigo ISBN ")
    private String isbn;

    @NotNull(message = "Se debe confirmar cuantas copias tiene el libro")
    @Min(value = 1, message = "Debe haber al menos 1 copia del libro")
    private Integer cantidad_copias;

    @NotBlank(message = "Se debe informar en que pasillo esta el libro")
    private String ubicacion_pasillo;

    @NotBlank(message = "Se debe informar en que estante esta el libro")
    private String ubicacion_estante;

    @NotBlank(message = "Se debe informar en que nivel esta el libro")
    private String ubicacion_nivel;

}
