package uni.aed.tda.ListTDA;

public class NoSuchElementException extends RuntimeException{

    public NoSuchElementException() {
        this("Elemento solicitado no existe en la estructura de datos");
    }

    public NoSuchElementException(String message) {
        super(message);
    }
}
