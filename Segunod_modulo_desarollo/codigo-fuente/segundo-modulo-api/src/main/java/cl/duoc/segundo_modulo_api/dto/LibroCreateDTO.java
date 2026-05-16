package cl.duoc.segundo_modulo_api.dto;

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

    @NotBlank(message = "Se debe tener la ID del cliente")
    private String idCliente;

    // Fecha cuando el cliente recibe el libro prestado
    @NotBlank(message = "Se debe tener la fecha en que se presto el libro al cliente")   
    private String fechaPrestamiento;   


    // Fecha cuando el cliente debe devolver el libro prestado
    @NotBlank(message = "Se debe tener la fecha limite en que el cliente debe devolver el libro")
    private String fechaDevolucion;


    // Cuantas veces ha sido prestado.
    @NotNull(message = "Se debe anotar cuantas veces el mismo libro ya ha sido prestado")
    private int vecesPrestada;


    // Cual es la condicion del libro despues de prestarlo
    @NotBlank(message = "Se debe tener anotado la condicion del libro antes de ser prestado al cliente")
    private String condicionAntesEntrega;


    @NotBlank(message = "Se debe anotar la condicion del libro despues de ser usado por el cliente")
    private String condicionDevolucion;


}
