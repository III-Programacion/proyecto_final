# Proyecto Final — Aplicación Web Empresarial (CodeHub)

## 📖 Tema
**Proyecto Final — Desarrollo de una aplicación web empresarial con seguridad, relaciones entre entidades y generación de reportes**

---

## 📝 Descripción
Este proyecto consiste en el desarrollo de una aplicación web orientada a la gestión interna de **CodeHub**, una empresa de desarrollo de software que necesita administrar:

- Sus **proyectos**
- Los **empleados** que participan en ellos
- Los **clientes** que los contratan

El sistema incluye:
- Autenticación de usuarios
- Control de acceso según roles (`ADMIN`, `MANAGER`, `EMPLOYEE`)
- Manejo de relaciones entre entidades del negocio
- Generación de reportes en formato **PDF**
- Pruebas de APIs con **Postman**
- Control de versiones y documentación en **GitHub**

---

## 🎯 Planteamiento del problema
Las empresas de desarrollo de software requieren sistemas internos que permitan:
- Gestionar clientes y proyectos de manera organizada.
- Asignar empleados a proyectos según sus perfiles.
- Controlar accesos y permisos según el rol del usuario.
- Generar reportes que faciliten la toma de decisiones.
- Reducir el uso de papel mediante reportes digitales, contribuyendo a la sostenibilidad.

---

## 🎯 Objetivos

### Objetivo general
Desarrollar una aplicación web empresarial con autenticación de usuarios, gestión de proyectos, clientes y empleados, y generación de reportes en PDF.

### Objetivos específicos
- Implementar un sistema web seguro con autenticación y roles.  
- Modelar las relaciones entre entidades:  
  - Un empleado tiene un perfil asociado.  
  - Un cliente puede tener varios proyectos.  
  - Un proyecto puede contar con varios empleados asignados.  
- Permitir CRUD completo de clientes, empleados y proyectos.  
- Generar reportes dinámicos y exportables en PDF.  
- Documentar y versionar el proyecto en **GitHub**.  
- Validar las APIs REST con **Postman**.  

---

## 🛠️ Tecnologías utilizadas
- **Java 17**
- **Spring Boot 3.x**
- **Spring Security**
- **Thymeleaf**
- **Hibernate / JPA**
- **PostgreSQL** (base de datos principal)
- **Maven**
- **IntelliJ IDEA**
- **GitHub** (repositorio remoto y control de versiones)
- **Postman** (pruebas de APIs REST)

---

## 🗂️ Diseño del sistema

### Modelo de datos
- **Empleado**: `id`, `nombre`, `email`, relación con `Perfil` y `Proyecto`.  
- **Perfil**: describe cargo y habilidades.  
- **Cliente**: `id`, `nombre`, `empresa`, relación con `Proyecto`.  
- **Proyecto**: `id`, `nombre`, `descripcion`, relación con `Cliente` y `Empleado`.  

### Relaciones
- `Empleado` ↔ `Perfil` → OneToOne  
- `Cliente` ↔ `Proyecto` → OneToMany  
- `Proyecto` ↔ `Empleado` → ManyToMany  

---

## 📊 Diagrama ERD (Entidad-Relación)

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
