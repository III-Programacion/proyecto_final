# Proyecto Final — Aplicación Web Empresarial (CodeHub)

## 📖 Tema
**Desarrollo de una aplicación web empresarial con seguridad, relaciones entre entidades y generación de reportes**

---

## 📝 Descripción
Este proyecto consiste en una aplicación web para la gestión interna de **CodeHub**, empresa de desarrollo de software que administra:

- **Proyectos**
- **Empleados**
- **Clientes**

Incluye:
- Autenticación de usuarios
- Control de acceso por roles (`ADMIN`, `MANAGER`, `EMPLOYEE`)
- Relaciones entre entidades
- Reportes en **PDF**
- Pruebas de APIs con **Postman**
- Control de versiones en **GitHub**

---

## 🎯 Planteamiento del problema
Las empresas de software necesitan sistemas que permitan:
- Gestionar clientes y proyectos de forma organizada.  
- Asignar empleados según perfiles.  
- Controlar accesos según roles.  
- Generar reportes confiables.  
- Reducir uso de papel mediante digitalización.  

---

## 🎯 Objetivos
- **General:** Desarrollar una aplicación web empresarial con autenticación, gestión de proyectos/clientes/empleados y reportes en PDF.  
- **Específicos:**  
  - Implementar seguridad y roles.  
  - Modelar relaciones entre entidades.  
  - CRUD completo de clientes, empleados y proyectos.  
  - Generar reportes dinámicos en PDF.  
  - Versionar en **GitHub** y validar APIs con **Postman**.  

---

## 🛠️ Tecnologías
- Java 17  
- Spring Boot 3.x  
- Spring Security  
- Thymeleaf  
- Hibernate / JPA  
- PostgreSQL  
- Maven  
- IntelliJ IDEA  
- GitHub  
- Postman  

---

## 🗂️ Diseño del sistema
### Modelo de datos
- **Empleado**: `id`, `nombre`, `email`, relación con `Perfil` y `Proyecto`.  
- **Perfil**: cargo y habilidades.  
- **Cliente**: `id`, `nombre`, `empresa`, relación con `Proyecto`.  
- **Proyecto**: `id`, `nombre`, `descripcion`, relación con `Cliente` y `Empleado`.  

### Relaciones
- Empleado ↔ Perfil → OneToOne  
- Cliente ↔ Proyecto → OneToMany  
- Proyecto ↔ Empleado → ManyToMany  

---

## 📊 Diagrama ERD
```plantuml
@startuml
entity Cliente {
  *id : int
  nombre : string
  empresa : string
}

entity Proyecto {
  *id : int
  nombre : string
  descripcion : string
}

entity Empleado {
  *id : int
  nombre : string
  email : string
}

entity Perfil {
  *id : int
  cargo : string
  habilidades : string
}

Cliente ||--o{ Proyecto : "tiene"
Proyecto }o--o{ Empleado : "asigna"
Empleado ||--|| Perfil : "posee"
@enduml
