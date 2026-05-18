package cl.duoc.tercer_modulo_api.client;

//import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import cl.duoc.tercer_modulo_api.dto.LibroInventarioDTO;

//@FeignClient(
//    name = "libro-client",
//    url = "${libros.service.url}"
//)

public interface LibroInventarioCliente {

    @GetMapping("/api/v1/compraryvenderlibros/dto/{id}")
    LibroInventarioDTO obtenerLibro(@PathVariable Integer id);
    
} 
