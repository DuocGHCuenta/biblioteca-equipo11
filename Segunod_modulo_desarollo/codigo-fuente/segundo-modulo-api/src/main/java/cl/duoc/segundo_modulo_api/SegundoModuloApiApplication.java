package cl.duoc.segundo_modulo_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SegundoModuloApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SegundoModuloApiApplication.class, args);
	}

}
