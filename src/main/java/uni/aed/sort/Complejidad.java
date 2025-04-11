package uni.aed.sort;

public class Complejidad {    
    public static final String BURBUJA_NINTERCAMBIOS = "Max (n-1)^2";
    public static final String BURBUJA_NCOMPARACIONES = "(n-1)^2";
    public static final String BURBUJA_COMPLEJIDAD_WORSTCASE = "O(n^2)";//complejidad cuadratica
    public static final String INSERCION_NCOMPARACIONES_BESTCASE = "(n-1)";
    public static final String INSERCION_NCOMPARACIONES_WORSTCASE = "(n^2)/2";//elementos en orden inverso
    public static final String INSERCION_NCOMPARACIONES_MIDLECASE = "(n^2)/4";
    public static final String INSERCION_NINTERCAMBIOS_WORSTCASE = "(n^2)/2";//elementos en orden inverso
    public static final String INSERCION_NINTERCAMBIOS_MIDLECASE = "(n^2)/4";
    public static final String INSERCION_COMPLEJIDAD_WORSTCASE = "O(n^2)";//complejidad cuadratica
    public static final String INSERCION_COMPLEJIDAD_MIDLECASE = "O(n^2)";//complejidad cuadratica
    public static final String INSERCION_COMPLEJIDAD_BESTCASE = "O(n)";//complejidad constante
    public static final String INSERCIONBINARIA_NCOMPARACIONES_WORSTCASE = "n * log2(n)";//log2(n)por ordenar cada elemento
    public static final String INSERCIONBINARIA_NINTERCAMBIOS_WORSTCASE = INSERCION_NINTERCAMBIOS_WORSTCASE;
    public static final String INSERCIONBINARIA_COMPLEJIDAD_WORSTCASE = "O(nlog(n))";//n * log2(n)
    public static final String SELECCION_NCOMPARACIONES_WORSTCASE = "(n^2)/2";//es el mismo para mejor caso y caso promedio
    public static final String SELECCION_NINTERCAMBIOS_WORSTCASE = "(n-1)";
    public static final String SELECCION_COMPLEJIDAD_WORSTCASE = "O(n^2)";//complejidad cuadratica
    public static final String SHELL_NCOMPARACIONES_WORSTCASE = "O(n * log^2(n)) a O(n^2)";//linealitmico a cuadratica, depende de secuencia de brechas utilizadas, propuesta algortimica, tamaño del salto 
    public static final String SHELL_NINTERCAMBIOS_WORSTCASE = "< o > (Max (n-1)^2)";//depende de secuencia de brechas utilizadas, propuesta algortimica, tamaño del salto 
    public static final String SHELL_COMPLEJIDAD_WORSTCASE = "O(n * log^2(n)) a O(n^2)";//depende de secuencia de brechas utilizadas, propuesta algortimica, tamaño del salto 
    public static final String QUICKSORT_NCOMPARACIONES = "O(n * log(n))";//sublistas dividas en partes iguales, sino seria O(n^2)
    public static final String QUICKSORT_NINTERCAMBIOS = "< (n-1)^2";//depende como se elija el pivote, siempre es menor que el de la burbuja
    public static final String QUICKSORT_COMPLEJIDAD_WORSTCASE = "O(n^2)";//rar vez se presenta,complejidad cuadratica
    public static final String QUICKSORT_COMPLEJIDAD_BESTCASE = "O(n * log(n))";//complejidad linealitmico
    public static final String QUICKSORT_COMPLEJIDAD_MIDLECASE = "O(n * log(n))";//complejidad linealitmico
    public static final String MERGESORT_NCOMPARACIONES_WORSTCASE = "(n - 1) * lgn";
    public static final String MERGESORT_NINTERCAMBIOS = "0";    
    public static final String MERGESORT_COMPLEJIDAD_WORSTCASE = "O(nlgn)";
    public static final String HEAPSORT_NCOMPARACIONES_WORSTCASE = "1.5nlgn";//considera todo el proceso de restricciones
    public static final String HEAPSORT_COMPLEJIDAD_WORSTCASE = "O(nlgn)";     
}
