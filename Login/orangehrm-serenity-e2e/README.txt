# Instrucciones para ejecutar el proyecto OrangeHRM Serenity BDD

## Requisitos
- Java 17
- Maven 3.8+
- IntelliJ IDEA
- Chocolatey (opcional para instalar herramientas)

## Pasos de ejecución
1. Clonar el repositorio o descomprimir el archivo ZIP.
2. Abrir el proyecto en IntelliJ IDEA.
3. Ejecutar el siguiente comando en terminal:
   mvn clean verify
4. El reporte Serenity se generará en:
   target/site/serenity/index.html

## Estructura del proyecto
- `pom.xml`: configuración de dependencias y plugins.
- `serenity.properties`: configuración de navegador y URL base.
- `src/main/java`: clases de Page Objects y Steps.
- `src/test/java`: definiciones de pasos y runner.
- `src/test/resources`: archivo feature en Gherkin.
