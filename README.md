#Demo App - Personas
_____________
##Arquitectura

- Demo App es una aplicación hecha con Spring Boot v2.4. Está compuesta por una base de datos en memoria H2 como fuente de datos.
- Usa Maven como gestor de dependencias.
- Contiene un servidor web Tomcat embebido para levantar la aplicación. 
- Implementa un API REST para la manipulación de datos de personas (registro, consulta y edición).
- Cuenta con una aplicación web SPA hecha con Angular JS (https://github.com/JuliansM/demo-web) para la interfáz de usuario, la cual permite manipular la información de personas.

##Patrón de diseño utilizado
- Se implementa un patrón de diseño por capas para el API REST