package uni.aed.tda.historialweb;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// Definimos la clase que representa una página web visitada en el historial de navegación.
public class PaginaWeb implements Comparable<PaginaWeb>{
    private String url;                    // URL de la página web visitada
    private LocalDateTime tiempoAcceso;    // Momento exacto en que se visitó la página
    
    // Realizamos el constructor que crea una nueva página web con timestamp actual.
    public PaginaWeb(String url) {
        this.url = url;
        this.tiempoAcceso = LocalDateTime.now(); // Registra el momento actual de acceso
    }
    
    // Realizamos el constructor que permite especificar un tiempo de acceso personalizado.
    public PaginaWeb(String url, LocalDateTime tiempoAcceso) {
        this.url = url;
        this.tiempoAcceso = tiempoAcceso;
    }
    
    // Implementamos los métodos getter para acceder a los atributos privados
    public String getUrl() {
        return url;
    }
    
    public LocalDateTime getTiempoAcceso() {
        return tiempoAcceso;
    }    
    
    // Implementamos los métodos setter para modificar los atributos
    public void setUrl(String url) {
        this.url = url;
    }
    
    public void setTiempoAcceso(LocalDateTime tiempoAcceso) {
        this.tiempoAcceso = tiempoAcceso;
    }
    
    // Implementamos el método equals sobrescrito para comparar páginas web basándose únicamente en la URL.
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;                           // Misma referencia
        if (obj == null || getClass() != obj.getClass()) return false; // Null o clase diferente
        
        PaginaWeb that = (PaginaWeb) obj;
        return url != null ? url.equals(that.url) : that.url == null; // Comparación de URLs
    }
    
    // Implementamos el método hashCode sobrescrito para mantener consistencia con equals y un correcto funcionamiento en estructuras de datos.
    @Override
    public int hashCode() {
        return url != null ? url.hashCode() : 0;
    }
    
    // Implementamos el método toString que formatea la información de la página para mostrar.
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return String.format("%-30s | %s", url, tiempoAcceso.format(formatter));
    }
    
    // Implementamos el método para obtener solo la URL como string.
    public String getUrlString() {
        return this.url;
    }

    @Override
    public int compareTo(PaginaWeb o) {
        return this.tiempoAcceso.compareTo(o.tiempoAcceso);
    }
}



