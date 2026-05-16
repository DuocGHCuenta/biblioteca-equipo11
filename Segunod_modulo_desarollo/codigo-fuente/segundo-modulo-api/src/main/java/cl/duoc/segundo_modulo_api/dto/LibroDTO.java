package cl.duoc.segundo_modulo_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class LibroDTO {

    private Integer id;
    private String titulo;
    private String isbn;

    private String idCliente;

    // Fecha cuando el cliente recibe el libro prestado
    private String fechaPrestamiento;   

    // Fecha cuando el cliente debe devolver el libro prestado
    private String fechaDevolucion;

    // Cuantas veces ha sido prestado.
    private int vecesPrestada;

    // Cual es la condicion del libro despues de prestarlo
    private String condicionAntesEntrega;
    private String condicionDevolucion;

}
