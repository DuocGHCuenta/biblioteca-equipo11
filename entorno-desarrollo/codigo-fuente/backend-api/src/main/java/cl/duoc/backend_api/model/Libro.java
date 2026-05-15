package cl.duoc.backend_api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// La anotación @Data es de Lombok y genera automáticamente los métodos getter, setter y constructores.
@Data

// @AllArgsConstructor hace que el Lombok crea automaticamente un constructor con todos los atributos de la clase.
@AllArgsConstructor

// @NoArgsConstructor hace que el Lombok crea automaticamente un constructor vacío, sin ningun parámetro.
@NoArgsConstructor

// La anotación @Entity le dice a Spring que esta clase se convertirá en una tabla en la base de datos.
@Entity

// Esto es para tener un inventario de libros 
public class Libro {

    // @Id indica que esta variable será la clave primaria (identificador único) de la tabla.
    @Id

    // @GeneratedValue indica que la base de datos asignará este número automáticamente de forma secuencial.
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private String titulo;
    private String isbn;

    private Integer cantidadCopias; // cantidad_copias;
    private String ubicacionPasillo; // ubicacion_pasillo;
    private String ubicacionEstante; //ubicacion_estante;
    private String ubicacionNivel; //ubicacion_nivel;
}
