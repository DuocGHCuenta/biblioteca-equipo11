package cl.douc.cuarto_modulo_api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor


public class LibroCreateDTO {

    @NotBlank(message = "El libro debe tener un nombre o titulo")
    @Size(min = 2, max = 50, message = "El nombre del libro debe tener entre 2 y 50 caracteres")
    private String nombre;

    @NotBlank(message = "Se debe documentar la condicion del libro para decidir si necesita se reparado o no")
    private String condicion; // Del libro por si repararlo o no.

    @NotBlank(message = "El libro debe tener un codigo ISBN ")
    private String isbn;

}
