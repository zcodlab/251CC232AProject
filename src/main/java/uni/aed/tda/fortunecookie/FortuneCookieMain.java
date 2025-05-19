package uni.aed.tda.fortunecookie;

import java.util.Scanner;

public class FortuneCookieMain {
    private static final FortuneCookieManager fortuna=new FortuneCookieManager();        ;
    private static Scanner scr=new Scanner(System.in).useDelimiter("\n");        
    public static void main(String[] args) {
        FortuneCookieMain fortunaMain=new FortuneCookieMain();        
        fortunaMain.getFortuneCookie();
    }    
    
    private void getFortuneCookie(){        
        String rpta;        
        System.out.println("****Galletas de la Fortuna****");
        System.out.println(fortuna.nexFortune());        
        System.out.println("Pulse S para continuar obteniendo galletas de la fortuna, N para salir:");        
        while(true){
            rpta=scr.next();
            if(!rpta.equalsIgnoreCase("N"))
                System.out.println(fortuna.nexFortune());    
            else break;
        }
    }
    
}
