package cl.duoc.segundo_modulo_api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

// Esto es para prestar libro por un tiempo limitado
public class Libro {
    private Integer id;
    private String titulo;
    private String isbn;

    private String id_cliente;

    // Fecha cuando el cliente recibe el libro prestado
    private String fecha_prestamiento;   

    // Fecha cuando el cliente debe devolver el libro prestado
    private String fecha_devolucion;

    // Cuantas veces ha sido prestado.
    private int veces_prestada;

    // Cual es la condicion del libro despues de prestarlo
    private String condicion_antes_entrega;
    private String condicion_devolucion;
}
