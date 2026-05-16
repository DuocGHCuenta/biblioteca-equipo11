# Biblioteca-equipo11

... [secciones existentes del Hito 1.5] ...

## 🔗 Comunicación entre microservicios (Hito 2)
## Que microservio necesita del otro
## Por ejemplo reparar libros necesita el microservio de inventario

El prestamiento de libros por un plazo necesita validar que los libros esten en la librearia en primer lugar → llama al servicio de Inventario de Libros.

La venta y compra de libros necesita validar si la librearia ya tiene el libro y cuantas copias tiene cada uno para ver si vale la pena venderlos o comprar más → llama al servicio de Inventario de Libros

La reparacion de libros necesita validar la condicion de los libros que estan en la libreria porlo que encesita revisar cada libro y sabe donde se ubican → llama al servicio de Inventario de Libros

Los clubs o grupo culturales no necesitan nada de los libros en si, sino neceita el espacio de la librearia en sí por algunas horas. → No llama a nadie por que no necesita a nadie.

### Diagrama de dependencias
[Insertar imagen del diagrama de la Fase 1 con los 5 servicios] 
┌─────────────────────────────────────────────────────────┐
│                                                         │
│  ┌──────────┐  Feign   ┌──────────┐  Feign  ┌────────┐  
│  │MODULO 2  ├─────────▶│ servicio ├────────▶│  C     │  
│  │    A     │          │    B     │         │        │  
│  └────┬─────┘          └────┬─────┘         └───┬────┘  
│       │                     │                   │       
│  ┌────▼─────┐          ┌────▼─────┐          ┌──▼───┐   
│  │  db_a    │          │  db_b    │          │ db_c │   
│  └──────────┘          └──────────┘          └──────┘   

    ┌──────────┐  Feign  ┌──────────┐  Feign  ┌────────┐  
│  │MODULO 3 ├─────────▶│ servicio ├────────▶│  C     │  
│  │    A     │          │    B     │         │        │  
│  └────┬─────┘          └────┬─────┘         └───┬────┘  
│       │                     │                   │       
│  ┌────▼─────┐          ┌────▼─────┐          ┌──▼───┐   
│  │  db_a    │          │  db_b    │          │ db_c │   
│  └──────────┘          └──────────┘          └──────┘   
┌──────────┐  Feign   ┌──────────┐  Feign  ┌────────┐  
│  │MODULO 4  ├─────────▶│ servicio ├────────▶│  C     │  
│  │    A     │          │    B     │         │        │  
│  └────┬─────┘          └────┬─────┘         └───┬────┘  
│       │                     │                   │       
│  ┌────▼─────┐          ┌────▼─────┐          ┌──▼───┐   
│  │  db_a    │          │  db_b    │          │ db_c │   
│  └──────────┘          └──────────┘          └──────┘   
│                                                         
│   Cada servicio sigue siendo dueño de SU base.          
│   Nadie consulta directo la BD de otro servicio.        │
│                                                         
└─────────────────────────────────────────────────────────┘

### Tabla de contratos

| Entorno-desarollo | Libro | GET | "/api/v1/inventariolibros" | LibroDTO |

| Segunod_modulo_desarollo | Libro | GET | "/api/v1/prestarlibrosconplazo" | LibroDTO |

| Tercero_modulo_3 | Libro | GET | "/api/v1/compraryvenderlibros" | LibroDTO |

| Cuarto_modulo_4 | Libro | GET | "/api/v1/repararlibros" | LibroDTO |

| Quinto_modulo_5 | GrupoCultural | GET | "/api/v1/grupoculturalclub" | GrupoCulturalDTO |


### Tecnología utilizada
- Cliente REST: **Feign Client** (justificación: ...)
- Manejo de errores: `@ControllerAdvice` + excepciones personalizadas
- Logs: SLF4J en cada llamada externa
- Pruebas de integración: colección Postman en `/postman/hito2-integracion.json`

### Escenario de despliegue
- [ ] Escenario A — Todos los servicios en una sola instancia EC2
- [X] Escenario B — Servicios distribuidos en múltiples instancias EC2
  - IPs y puertos por servicio: ...
  - Security Groups configurados: sí/no

### Cómo probar la integración
1. Levantar todos los servicios: `docker compose up -d`
2. Importar `postman/hito2-integracion.json` en Postman
3. Ejecutar el flujo "Crear cita - caso éxito"
4. Para probar resiliencia: `docker stop pacientes-app` y reintentar