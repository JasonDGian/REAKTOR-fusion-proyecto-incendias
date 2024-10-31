package es.iesjandula.ReaktorIssuesServer.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Configuración CORS para la aplicación.
 * <p>
 * Esta clase define una configuración personalizada para los mapeos de CORS (Cross-Origin Resource Sharing).
 * Utiliza un bean para habilitar y configurar el acceso desde diferentes orígenes al endpoint "/incidencias".
 * <p>
 * El propósito de esta configuración es permitir que clientes desde diferentes dominios puedan realizar
 * solicitudes HTTP al servicio de incidencias.
 * </p>
 */
@Configuration
@EnableWebMvc // Anotación que sirve para 
public class CorsConfiguration implements WebMvcConfigurer
{

/**
 * Define a que URL atiende de manera abierta la API mediante tecnicas CORS.
 */
@Value("${urlCors}")
private String urlCors; // Actualmente solo una string porque la variable urlcors solo contiene una url.

// Configuración del mapeado de CORS
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping(urlCors)
            .allowedMethods("PUT", "DELETE", "POST", "GET");
    }

}