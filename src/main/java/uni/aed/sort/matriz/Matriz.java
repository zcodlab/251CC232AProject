package uni.aed.sort.matriz;

public class Matriz {
    private Integer[][] matriz;  

    // Carga la matriz con ceros, excepto el cuarto cuadrante
    public void cargar(int n, Integer[] datos) {
        matriz = new Integer[n][n];

        // Inicializar toda la matriz con ceros
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                matriz[i][j] = 0;

        int m = n / 2;  // La mitad del tamaño (asumiendo que n es par)

        int iniFila = n - m;  // Fila inicial del cuarto cuadrante
        int iniCol = n - m;  // Columna inicial del cuarto cuadrante

        int k = datos.length - m * m; // Índice inicial en la serie ordenada (los m*m más grandes)

        // Llenar el cuarto cuadrante con los mayores valores
        for (int i = iniFila; i < n; i++) {
            for (int j = iniCol; j < n; j++) {
                matriz[i][j] = datos[k]; // Insertar valor de la serie ordenada
                k++; // Avanzar al siguiente número
            }
        }
    }
    
    @Override
    public String toString() {
        if (matriz==null) return "";
        StringBuilder str=new StringBuilder();
        for (Integer[] fila : matriz) {
            for (Integer val : fila)
                str.append(String.format("%4d", val));
            str.append("\n");
        }
        return str.toString();        
    }
}
