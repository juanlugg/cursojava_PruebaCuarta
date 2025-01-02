# CUARTA PRUEBA CURSO JAVA (FINAL)
### Juan Luis Guerra Gennich 02/01/2025

## Descripción
Proyecto que consiste en una aplicación para la gestión de una base de datos para una agencia de viajes basada en microservicios utilizando Spring.

## Funcionalidades
### Generales
 * *Cada uno de los tres microservicios tiene estos recursos independientemente.*
 * **Application** (com.curso.inicio) :
    Clase inicial para la ejecución y configuración para la gestión de cada tabla de la base de datos.
 * **Respository** (com.curso.repository) :
    Interfaz que proporcionará métodos CRUD de JpaRepository o personalizados para la gestión de las bases de datos.
 * **IService** (com.curso.service) :
    Interfaz que definirá las consultas que se quieren realizar en cada tabla.
 * **Controller** (com.curso.controller)
    Clase POJO que define los métodos para las peticiones RESTful de cada tabla.
### Hoteles
 * **Hotel** (com.curso.model) :
    Clase que reprensará la entidad "hoteles" en la base de datos de "agencia_viajes" que incluye los siguientes campos: idHotel (autonumérico), nombre, categoria, precio y disponible (si o no).
 * **HotelServiceImpl** (com.curso.service) : 
   Clase que será el servicio que gestione la funcionalidad de las consultas para hoteles. Tendrá una función para buscar una lista de hoteles que estén disponibles y otra para buscar un hotel por nombre
### Vuelos
 * **Vuelo** (com.curso.model) :
    Clase que reprensará la entidad "vuelos" en la base de datos de "agencia_viajes" que los siguientes campos: idVuelo (autonumérico), compañia, fechaVuelo, precio y plazas disponibles.
 * **VueloServiceImpl** (com.curso.service) : 
   Clase que será el servicio que gestione la funcionalidad de las consultas para vuelos. Tendrá una función para buscar una lista de vuelos que tengan X o más plazas disponibles y otra función para actualizar
   las plazas de un vuelo.
### Reservas
 * **Reserva** (com.curso.model) :
    Clase que reprensará la entidad "reserva" en la base de datos de "agencia_viajes" que los siguientes campos: idReserva(autonumérico), nombreCliente, dni, idHotel e idVuelo.
 * **ReservasServiceImpl** (com.curso.service) : 
   Clase que será el servicio que gestione la funcionalidad de las consultas para reservas. Tendrá una función para buscar las reservas de un hotel especificado por su nombre y otra función para crear una reserva
### Test Unitarios con JUnit
 * Varios test que se han realizado para comprobar una correcta ejecución del programa y cada microservicio.
