package cl.duoc.segundo_modulo_api.client;


import cl.duoc.segundo_modulo_api.dto.LibroInventarioDTO;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
    name = "libro-client",
    url = "${libros.service.url}"
)
public interface LibroInventarioClient {

     @GetMapping("/api/v1/inventariolibros/dto/{id}")
    LibroInventarioDTO obtenerLibro(@PathVariable Integer id);

    
} 
