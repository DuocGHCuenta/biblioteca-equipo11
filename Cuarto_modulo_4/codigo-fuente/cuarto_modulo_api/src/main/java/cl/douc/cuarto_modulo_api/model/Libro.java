package cl.douc.cuarto_modulo_api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

// Esto es para reparar libros  

public class Libro {
    private Integer id;
    private String nombre;
    private String condicion; // Del libro por si repararlo o no.
    private String isbn;

}
