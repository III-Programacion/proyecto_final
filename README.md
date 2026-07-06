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
🚀 Instrucciones de uso
Requisitos previos
Java 17+

Maven

PostgreSQL

IntelliJ IDEA

Postman (para pruebas de APIs)

GitHub (para clonar y versionar el repositorio)

Clonar el repositorio
bash
git clone https://github.com/III-Programacion/proyecto_final.git
cd proyecto_final
Configurar la base de datos
En application.properties:

properties
spring.datasource.url=jdbc:postgresql://localhost:5432/proyecto_final
spring.datasource.username=tu_usuario
spring.datasource.password=tu_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
Ejecutar la aplicación
bash
mvn spring-boot:run
La aplicación estará disponible en:

Código
http://localhost:8080
📊 Reportes
Reporte de Clientes

Reporte de Empleados

Reporte de Proyectos

Exportación a PDF

📂 Estructura del proyecto
Código
src/main/java/com/fernando6489/proyecto_final/
 ├── controller/
 ├── model/
 ├── repository/
 ├── service/
 └── security/
src/main/resources/
 ├── templates/
 └── static/
📈 Resultados obtenidos
Sistema funcional con autenticación y roles.

CRUD completo para clientes, empleados y proyectos.

Reportes dinámicos unificados en una sola vista (reporte.html).

Exportación de información relevante a PDF.

Integración con PostgreSQL como base de datos principal.

Pruebas exitosas de APIs con Postman.

Proyecto documentado y versionado en GitHub.

✅ Conclusiones
El sistema satisface las necesidades de gestión interna de CodeHub.

La seguridad y roles garantizan un acceso controlado.

La unificación de reportes mejora la mantenibilidad.

El uso de Spring Boot, Thymeleaf y PostgreSQL facilita la escalabilidad.

La integración con GitHub y Postman asegura buenas prácticas de desarrollo y pruebas.

El proyecto contribuye a la sostenibilidad al reducir el uso de papel mediante reportes digitales (ODS 12: Producción y consumo responsables).
