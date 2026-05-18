# Biblioteca-equipo11

# [Proyecto Fullstack]

## 🔗 Comunicación entre microservicios (Hito 2)

El prestamiento de libros por un plazo necesita validar que los libros esten en la librearia en primer lugar → llama al servicio de Inventario de Libros.

La venta y compra de libros necesita validar si la librearia ya tiene el libro y cuantas copias tiene cada uno para ver si vale la pena venderlos o comprar más → llama al servicio de Inventario de Libros

La reparacion de libros necesita validar la condicion de los libros que estan en la libreria porlo que encesita revisar cada libro y sabe donde se ubican → llama al servicio de Inventario de Libros

Los clubs o grupo culturales no necesitan nada de los libros en si, sino neceita el espacio de la librearia en sí por algunas horas. → No llama a nadie por que no necesita a nadie.


### Diagrama de dependencias
[Insertar imagen del diagrama de la Fase 1 con los 5 servicios] 
┌─────────────────────────────────────────────────────────┐
│                                                         │
│  ┌──────────────┐  Feign   ┌──────────────────────┐          
│  │ Contenedor 2 ├────────▶│ Contenedor 1          │
│  │Prestar Libros│  │       │    Inventario Libros│
│  │ Puerto 8181  │          │      puerto 8080     │ 
│  │  (Consumidor)│          │      (Provedor)      │
│  └────┬─────────┘          └────┬─────────────────┘     
│       │                         │                       
│  ┌────▼───────┐            ┌────▼──────┐           
│  │ db-libros  │            │ db-libros │ 
│  │ MySQL 8.0  │            │ MySQL 8.0 │ 
│  │ libros_db  │            │ libros_db │                    
│  └────────────┘            └───────────┘          
│
│
│                                                         
│  ┌──────────────┐  Feign      ┌──────────────────────┐          
│  │ Contenedor 3 ├────────────▶│ Contenedor 1        │
│  │ Comprar/Vender Libros│     │   Inventario Libros  │  
│  │ Puerto 8282  │             │      puerto 8080     │ 
│  │  (Consumidor)│             │      (Provedor)      │
│  └────┬─────────┘             └────┬─────────────────┘     
│       │                            │                       
│  ┌────▼───────┐               ┌────▼──────┐           
│  │ db-libros  │               │ db-libros │ 
│  │ MySQL 8.0  │               │ MySQL 8.0 │ 
│  │ libros_db  │               │ libros_db │                    
│  └────────────┘               └───────────┘          
│      
│
│
│                                                   
│  ┌──────────────┐  Feign   ┌──────────────────────┐          
│  │ Contenedor 4 ├────────▶│    Contenedor 1       │
│  │Reparar Libros│          │   Inventario Libros  │
│  │ Puerto 8383  │          │    puerto 8080       │ 
│  │  (Consumidor)│          │      (Provedor)      │
│  └────┬─────────┘          └────┬─────────────────┘     
│       │                         │                       
│  ┌────▼───────┐            ┌────▼──────┐           
│  │ db-libros  │            │ db-libros │ 
│  │ MySQL 8.0  │            │ MySQL 8.0 │ 
│  │ libros_db  │            │ libros_db │                    
│  └────────────┘            └───────────┘          
│
│
│
│  ┌──────────────┐      
│  │ Contenedor 5 │
│  │Grupo Cultural│  
│  │ Puerto 8484  │   
│  │(NO Conectado)│       
│  └────┬─────────┘            
│       │                                          
│  ┌────▼─────────────────┐           
│  │ db-gruposculturales  │            
│  │ MySQL 8.0            │         
│  │ gruposculturales_db  │                          
│  └──────────────────────┘         
│                                                         
│   Cada servicio sigue siendo dueño de SU base.          
│   Nadie consulta directo la BD de otro servicio.        │
│                                                         │
└─────────────────────────────────────────────────────────┘

### Tabla de contratos

| Entorno-desarollo | Libro | GET | "/api/v1/inventariolibros" | LibroDTO |

| Segunod_modulo_desarollo | Libro | GET | "/api/v1/prestarlibrosconplazo" | LibroDTO |

| Tercero_modulo_3 | Libro | GET | "/api/v1/compraryvenderlibros" | LibroDTO |

| Cuarto_modulo_4 | Libro | GET | "/api/v1/repararlibros" | LibroDTO |

| Quinto_modulo_5 | GrupoCultural | GET | "/api/v1/grupoculturalclub" | GrupoCulturalDTO |


### Tecnología utilizada
- Cliente REST: **Feign Client** 
- Manejo de errores: `@ControllerAdvice` + excepciones personalizadas
- Logs: SLF4J en cada llamada externa
- Pruebas de integración: colección Postman en `/postman/hito2-integracion.json`

### Escenario de despliegue
- [ ] Escenario A — Todos los servicios en una sola instancia EC2
- [X] Escenario B — Servicios distribuidos en múltiples instancias EC2
  - IPs y puertos por servicio: ...
  - Security Groups configurados: sí/no

  ## Puse los 5 contenedore con su propio "docker-compose.yml" en el mismo EC2 de AWS

### Cómo probar la integración
1. Levantar todos los servicios: `docker compose up -d`
2. Importar `postman/hito2-integracion.json` en Postman
3. Ejecutar el flujo "Crear cita - caso éxito"
4. Para probar resiliencia: `docker stop pacientes-app` y reintentar