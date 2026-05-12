package cl.douc.cuarto_modulo_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor


public class LibroDTO {

    private Integer id;
    private String nombre;
    private String condicion; // Del libro por si repararlo o no.
    private String isbn;

}
