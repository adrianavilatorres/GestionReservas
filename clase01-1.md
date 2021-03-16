# Creación del proyecto en modo interactivo (MAVEN)

Si has clonado este repositorio, no es necesario hacer este paso, sólamente cuando quieras crear un proyecto como éste.

Para crear en modo interactivo el proyecto, estructura de directorios, fichero pom.xml, etc.  **desde cero**, tendríamos que usar el proyecto Maven Java Web desde el IDE o bien desde línea de comandos ejecutaríamos esta instrucción:

```bash
$ mvn archetype:generate -DarchetypeGroupId=org.apache.maven.archetypes \
    -DarchetypeArtifactId=maven-archetype-webapp -DarchetypeVersion=1.4
```

Tras indicar el grupo (com.iesvdc.acceso.simplecrud) y el artefacto (simplecrud) Maven crea los ficheros necesarios.

## Dependencias Maven

Antes de comenzar, veamos las dependencias (librerías) adicionales que va a necesitar nuestro proyecto.

### MySQL

Necesitamos importar en la CLASS_PATH del proyecto el driver JDBC de MySQL.

```xml
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>8.0.1</version>
    </dependency>
```

### Soporte J2EE (Servlets)

Para poder usar JSP (Java Server Pages) y Servlets (las clases necesarias), tenemos que cargar la API Web de Java:

```xml
    <dependency>
        <groupId>javax</groupId>
        <artifactId>javaee-web-api</artifactId>
        <version>8.0.1</version>
        <scope>provided</scope>
    </dependency>
```

### Soporte para JSLT (para JSP)

Para poder usar las extensiones JSLT dentro de una página JSP, necesitamos importar la API JSLT:

```xml
    <dependency>
        <groupId>javax.servlet</groupId>
        <artifactId>jstl</artifactId>
        <version>1.2</version>
    </dependency>
```

### Soporte JSON

Para hacer el marshalling/unmarshalling de objetos es muy sencillo usar la API Gson de Google. Ya vimos JAXB y Moxy, ahora exploramos otra opción.

```xml
    <dependency>
        <groupId>com.google.code.gson</groupId>
        <artifactId>gson</artifactId>
        <version>2.8.6</version>
    </dependency>
```

### Insertando el servidor Tomcat en Maven

Para poder ejecutar Tomcat desde maven para no necesitar descargar e instalar el servidor de aplicaciones Java de la Apache foundation, añadimos estas líneas dentro de "build->plugins":

```xml
    <plugin>
        <groupId>org.apache.tomcat.maven</groupId>
        <artifactId>tomcat7-maven-plugin</artifactId>
        <version>2.2</version>
        <configuration>
            <port>9090</port>
            <path>/</path>
            </configuration>
    </plugin>
```
