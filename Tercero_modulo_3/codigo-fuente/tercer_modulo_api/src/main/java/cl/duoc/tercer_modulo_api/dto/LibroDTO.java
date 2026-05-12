package cl.duoc.tercer_modulo_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

// Esto es para comprar y vender libros  

public class LibroDTO {

     private Integer id;
    private String titulo;
    private String isbn;
    private int precio;

}
