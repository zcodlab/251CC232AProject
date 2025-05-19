package uni.aed.tda;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import uni.aed.model.Libro;

public class TdaMain {
    public static void main(String[] args){
        TdaMain tdaMain=new TdaMain();
        //tdaMain.casillero1();
        //tdaMain.casillero2();
        //tdaMain.casillero3();
        //tdaMain.testColeccionLibrosConParamtroDeTipo();
        tdaMain.testLinkedListLibrosConParamtroDeTipo();
    }
    
    private void casillero1(){
        Casillero1<String> casilleroUno;
        casilleroUno=new Casillero1<>();
        Casillero1<Integer> casilleroDos;
        casilleroDos=new Casillero1<>();
        casilleroUno.setContenido("Mochila");
        casilleroDos.setContenido(100);
        System.out.println("El casillero 1 tiene el contenido "+casilleroUno.getContenido());
        System.out.println("El casillero 2 tiene el contenido "+casilleroDos.getContenido());
        
    }
    private void casillero2(){
        Casillero2<String,Integer> casillero;
        casillero=new Casillero2<>("Mochila",100);
        Casillero2<String,String> saludo;
        saludo=new Casillero2<>("Hola", "AED");
        
        System.out.println("El casillero tiene el contenido "+casillero.getContenido1()+" - "+ casillero.getContenido2());
        System.out.println("El saludo es "+saludo.getContenido1()+" - "+ saludo.getContenido2());
    }
    private void casillero3(){
        Casillero3<Number> numerico1=new Casillero3<>(100);
        Casillero3<Double> numerico2=new Casillero3<>(10.0);
        Casillero3<Integer>numerico3=new Casillero3<>(10);
        System.out.println("El Casillero 3 tiene los contenidos numericos: " +
                numerico1.getContenido().toString()+" | "+
                numerico2.getContenido().toString()+" | "+
                numerico3.getContenido().toString());
    }
    private void testColeccionLibrosConParamtroDeTipo(){
        List<Libro> libros=new ArrayList<>();
        libros.add(new Libro("C. Thomas Wu"));
        libros.add(new Libro("Adam Drozdek"));
        libros.add(new Libro("Joyanes Aguilar"));
        
        Iterator it=libros.iterator();
        while(it.hasNext()){
            Libro libro=(Libro) it.next();
            System.out.println(libro.getAutor());
        }
        
        for(Libro libro:libros)
            System.out.println(libro.getAutor());
            
    }
    private void testLinkedListLibrosConParamtroDeTipo(){
        List<Libro> libros=new LinkedList<>();
        libros.add(new Libro("C. Thomas Wu"));
        libros.add(new Libro("Adam Drozdek"));
        libros.add(new Libro("Joyanes Aguilar"));
        
        Iterator it=libros.iterator();
        while(it.hasNext()){
            Libro libro=(Libro) it.next();
            System.out.println(libro.getAutor());
        }
        
        for(Libro libro:libros)
            System.out.println(libro.getAutor());
            
    }
    
}
