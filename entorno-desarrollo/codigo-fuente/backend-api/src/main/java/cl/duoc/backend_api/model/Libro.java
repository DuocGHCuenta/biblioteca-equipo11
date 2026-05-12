package cl.duoc.backend_api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

// Esto es para tener un inventario de libros 
 
public class Libro {
    private Integer id;
    private String titulo;
    private String isbn;

    private int cantidad_copias;
    private String ubicacion_pasillo;
    private String ubicacion_estante;
    private String ubicacion_nivel;
}
