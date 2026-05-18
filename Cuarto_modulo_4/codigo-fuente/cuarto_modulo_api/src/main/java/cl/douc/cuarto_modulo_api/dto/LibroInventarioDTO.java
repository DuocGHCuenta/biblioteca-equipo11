package cl.douc.cuarto_modulo_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor


public class LibroInventarioDTO {

    
    private Integer id;
    private String titulo;
    private String isbn;

    private Integer cantidadCopias;
    private String ubicacionPasillo;
    private String ubicacionEstante;
    private String ubicacionNivel;

}
