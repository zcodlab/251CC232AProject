package uni.aed.TDA;

public class TdaMain {
    public static void main(String[] args){
        TdaMain tdaMain=new TdaMain();
        tdaMain.casillero1();
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
    
}
