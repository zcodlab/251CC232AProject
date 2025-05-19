package uni.aed.tda.fortunecookie;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import uni.aed.tda.ArrayListTDA.ArrayListTDA;
import uni.aed.tda.ListTDA.ListTDA;


public class FortuneCookieFile {
    private ListTDA<String> lista;

    public FortuneCookieFile() {
        lista = new ArrayListTDA<>();                
        loadFortunesFromFile("fortunes.txt");
        
    }

    public ListTDA<String> getLista() {
        return lista;
    }   
    
    //el archivo debe estar dentro del classpath (como en src/main/resources) para poder cargarlo como un recurso.
    private void loadFortunesFromFile(String filePath) {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filePath);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lista.add(line);
            }
        } catch (IOException e) {
            System.out.println("Error al cargar mensajes de la suerte desde el archivo: " + e.getMessage());
        }
    }
    //acceder a archivo con ruta absoluta: loadFortunesFromFile("src\\main\\java\\uni\\aed\\FortuneCookie\\fortunes.txt");
    private void loadFortunesFromFileAbsolutePath(String filePath) {    
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lista.add(line);
            }
        } catch (IOException e) {
            System.out.println("Error al cargar mensajes de la suerte desde el archivo: " + e.getMessage());
        }
    }
    
    

}
