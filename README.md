Proyecto Final — Aplicación Web Empresarial (CodeHub)
📖 Tema
Desarrollo de una aplicación web empresarial con seguridad, relaciones entre entidades y generación de reportes.

📝 Resumen
Como parte de mi formación en desarrollo de software, desarrollé CodeHub, una aplicación web empresarial orientada a la gestión interna de proyectos, clientes y empleados. El sistema integra autenticación de usuarios, control de acceso por roles (ADMIN, MANAGER, EMPLOYEE), manejo de relaciones entre entidades y generación de reportes en PDF. Además, validé las APIs con Postman y versioné el proyecto en GitHub.

🎯 Problema y objetivos
Las empresas de software requieren sistemas que permitan organizar clientes y proyectos, asignar empleados según perfiles, controlar accesos y generar reportes confiables, reduciendo el uso de papel.

Objetivo general: Crear una aplicación web empresarial segura con gestión de proyectos, clientes y empleados, y reportes en PDF.

Objetivos específicos:

Implementar autenticación y roles.

Modelar relaciones entre entidades en PostgreSQL.

CRUD completo de clientes, empleados y proyectos.

Generar reportes dinámicos en PDF.

Versionar en GitHub y validar APIs con Postman.

🛠️ Tecnologías
Java 17 · Spring Boot · Spring Security · Thymeleaf · Hibernate/JPA · PostgreSQL · Maven · IntelliJ IDEA · GitHub · Postman

🗂️ Diseño del sistema
Cliente ↔ Proyecto → OneToMany

Proyecto ↔ Empleado → ManyToMany

Empleado ↔ Perfil → OneToOne

🚀 Implementación
Configuré el entorno en IntelliJ IDEA con Maven.

Creé entidades principales (Cliente, Empleado, Proyecto).

Implementé relaciones JPA.

Configuré seguridad con Spring Security.

Desarrollé controladores y vistas con Thymeleaf.

Generé reportes en HTML y PDF.

Probé APIs con Postman y datos en PostgreSQL.

Subí el proyecto a GitHub.

📈 Resultados
Sistema funcional con autenticación y roles.

CRUD completo de clientes, empleados y proyectos.

Reportes dinámicos en PDF.

Integración con PostgreSQL.

Pruebas exitosas con Postman.

Proyecto documentado en GitHub.

✅ Conclusiones
El sistema satisface la gestión interna de CodeHub.

Seguridad y roles garantizan acceso controlado.

Reportes digitales reducen uso de papel (ODS 12).

GitHub y Postman fortalecen buenas prácticas de desarrollo.
