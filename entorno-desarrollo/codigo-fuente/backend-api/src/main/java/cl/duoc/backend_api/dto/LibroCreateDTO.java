package cl.duoc.backend_api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
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

@Schema(description = "Datos para crear un libro ")
public class LibroCreateDTO {

    // -- Aparentemente no tiene id

    @Schema(
    description = "Titulo del libro",
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
    description = "Cuantas copias tiene el libros ",
    example = "42 Copias del libro "
    )
    @NotNull(message = "Se debe confirmar cuantas copias tiene el libro")
    @Min(value = 1, message = "Debe haber al menos 1 copia del libro")
    private Integer cantidadCopias;


    @Schema(
    description = "Donde se ubica el libro en el pasillo ",
    example = "Quinto pasillo "
    )
    @NotBlank(message = "Se debe informar en que pasillo esta el libro")
    private String ubicacionPasillo;


    @Schema(
    description = "Donde se ubica el libro en el estante ",
    example = "El septimo desde la izquierda "
    )
    @NotBlank(message = "Se debe informar en que estante esta el libro")
    private String ubicacionEstante;


    @Schema(
    description = "En que nivel se ubica el libro ",
    example = "En el segundo nivel "
    )
    @NotBlank(message = "Se debe informar en que nivel esta el libro")
    private String ubicacionNivel;

}
