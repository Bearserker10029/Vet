# Sistema de Gestión Veterinaria

> Aplicación web desarrollada con Spring Boot y Thymeleaf para gestionar mascotas en una clínica veterinaria.

## Tabla de Contenidos

- [Descripción](#-descripción-del-proyecto)
- [Tecnologías](#-tecnologías-usadas)
- [Estructura](#-estructura-principal)
- [Flujo Funcional](#-flujo-funcional-implementado)
- [Modelo de Datos](#-modelo-de-datos)
- [Estado](#-estado-frente-a-la-consigna)
- [Ejecución](#-cómo-ejecutar)

---

## Descripción del Proyecto

Una aplicación web que simula un sistema de gestión de una clínica veterinaria, permitiendo a los usuarios:

- Registrar nuevas mascotas con sus datos y información del dueño
- Listar todas las mascotas registradas
- Editar información de mascotas existentes
- Eliminar mascotas del sistema
- Buscar mascotas por nombre, especie o estado

## Tecnologías Usadas

| Tecnología | Versión | Uso |
|-----------|---------|-----|
| Java | 17 | Lenguaje base |
| Spring Boot | 4.0.5 | Framework MVC y persistencia |
| Spring Data JPA | Incluido | Acceso a datos y ORM |
| Spring MVC | Incluido | Controladores HTTP |
| Thymeleaf | Starter | Motor de plantillas |
| MySQL | 8.0 | Base de datos relacional |
| Lombok | Latest | Anotaciones de código |
| Maven | Wrapper | Gestor de dependencias |

## Estructura Principal

```
vet/
├── src/
│   ├── main/
│   │   ├── java/com/example/vet/
│   │   │   ├── VetApplication.java
│   │   │   ├── controller/
│   │   │   │   └── MascotaController.java
│   │   │   ├── model/
│   │   │   │   └── Mascota.java
│   │   │   └── repository/
│   │   │       └── MascotaRepository.java
│   │   └── resources/
│   │       ├── application.properties
│   │       ├── static/
│   │       └── templates/
│   │           ├── ListaMascota.html
│   │           ├── RegistroMascota.html
│   │           └── EditarMascota.html
│   └── test/
├── pom.xml
├── mvnw
├── mvnw.cmd
└── HELP.md
```

## Flujo Funcional Implementado

```
┌─────────────────────────────────────────────────────────────┐
│              SISTEMA DE GESTIÓN VETERINARIA                 │
├─────────────────────────────────────────────────────────────┤
│  1. GET /mascota/lista                                      │
│     ↓ Muestra lista de mascotas                             │
│                                                             │
│  2. GET /mascota/new                                        │
│     ↓ Muestra formulario de registro                        │
│                                                             │
│  3. POST /mascota/save                                      │
│     ↓ Guarda mascota en base de datos                       │
│                                                             │
│  4. GET /mascota/edit?id=X                                  │
│     ↓ Muestra formulario de edición                         │
│                                                             │
│  5. GET /mascota/delete?id=X                                │
│     ↓ Elimina mascota y redirige                            │
└─────────────────────────────────────────────────────────────┘
```

| Endpoint | Método | Descripción |
|----------|--------|-------------|
| `/mascota/lista` | GET | Lista todas las mascotas |
| `/mascota/new` | GET | Formulario de nuevo registro |
| `/mascota/save` | POST | Guarda o actualiza mascota |
| `/mascota/edit` | GET | Formulario de edición |
| `/mascota/delete` | GET | Elimina mascota por ID |

## Modelo de Datos

### Entidad Mascota

| Campo | Tipo | Descripción |
|-------|------|-------------|
| `id` | int | Identificador único (auto-generado) |
| `nombre` | String | Nombre de la mascota |
| `especie` | String | Especie (perro, gato, etc.) |
| `raza` | String | Raza de la mascota |
| `edad` | int | Edad en años |
| `nombreDuenio` | String | Nombre del dueño |
| `telefono` | String | Teléfono de contacto |
| `estado` | int | Estado de la mascota (1=activo, 0=inactivo) |

## Funcionalidades Implementadas

- [x] Controlador con rutas CRUD completas
- [x] Entity con anotaciones JPA para persistencia
- [x] Repository con Spring Data JPA
- [x] Vistas de lista, registro y edición
- [x] Búsqueda por nombre, especie y estado
- [x] Mensajes de éxito tras operaciones
- [x] Conexión a base de datos MySQL

## Cómo Ejecutar

### Requisitos Previos

- Java 17+ (compatible con Spring Boot 4.0.5)
- Maven 3.6+ (incluido como wrapper)
- MySQL 8.0+ corriendo en localhost:3306

### Configuración de Base de Datos

Crear base de datos `clinica_veterinaria` en MySQL:

```sql
CREATE DATABASE clinica_veterinaria;
```

### Ejecutar la Aplicación

**En Windows (PowerShell):**

```powershell
.\mvnw.cmd spring-boot:run
```

**En Linux/macOS:**

```bash
chmod +x mvnw
./mvnw spring-boot:run
```

### Acceder a la Aplicación

Una vez iniciada, abre tu navegador en:

```
http://localhost:8080/mascota/lista
```

**Puerto por defecto:** 8080

---

## Recursos Adicionales

- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [Thymeleaf Guide](https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html)
- [MySQL Connector](https://dev.mysql.com/doc/connector-j/8.0/)

---

## Licencia

Este proyecto es de uso académico y educativo como parte de un laboratorio de curso universitario.