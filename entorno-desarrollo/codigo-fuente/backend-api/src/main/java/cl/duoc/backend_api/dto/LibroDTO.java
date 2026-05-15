package cl.duoc.backend_api.dto;

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

    private int cantidadCopias;
    private String ubicacionPasillo;
    private String ubicacionEstante;
    private String ubicacionNivel;

}
