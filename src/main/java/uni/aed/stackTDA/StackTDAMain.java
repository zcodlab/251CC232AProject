package uni.aed.stackTDA;

public class StackTDAMain {
    public static void main(String[] args) {    
        StackTDAMain stackTDAMain=new StackTDAMain();
        //stackTDAMain.testLinkedStackTDA();
        //stackTDAMain.testArrayStackTDA();
        stackTDAMain.testListStackTDA();
    }
    
    private void testLinkedStackTDA(){
        StackTDA<String> pila =new LinkedStackTDA<>();
        System.out.println("Antes de Añadir elementos: "+pila.size());
        pila.push("Jose");
        pila.push("Beatriz");
        pila.push("Sandro");
        pila.push("Juan");
        System.out.println("Despues de Añadir elementos: "+pila.size());
        System.out.println("Visualizando elementos");
        System.out.println(pila.toString());        
        
        System.out.println("Eliminando elementos");
        System.out.println("Elemento Eliminando:"+pila.pop().toString());
        System.out.println("Despues de Eliminar elementos: "+pila.size());
        System.out.println("Visualizando elementos");
        System.out.println(pila.toString());        
        
        System.out.println("Recuperando elementos");
        System.out.println("Elemento Recuperado:"+pila.peek().toString());
        System.out.println("Despues de Recuperar elementos: "+pila.size());
        System.out.println("Visualizando elementos");
        System.out.println(pila.toString());        
    }    
    private void testArrayStackTDA(){
        StackTDA<String> pila = new ArrayStackTDA<>();
        System.out.println("Antes de Añadir elementos: "+pila.size());
        pila.push("Jose");
        pila.push("Beatriz");
        pila.push("Sandro");
        pila.push("Juan");
        System.out.println("Despues de Añadir elementos: "+pila.size());
        System.out.println("Visualizando elementos");
        System.out.println(pila.toString());        
        
        System.out.println("Eliminando elementos");
        System.out.println("Elemento Eliminando:"+pila.pop().toString());
        System.out.println("Despues de Eliminar elementos: "+pila.size());
        System.out.println("Visualizando elementos");
        System.out.println(pila.toString());        
        
        System.out.println("Recuperando elementos");
        System.out.println("Elemento Recuperado:"+pila.peek().toString());
        System.out.println("Despues de Recuperar elementos: "+pila.size());
        System.out.println("Visualizando elementos");
        System.out.println(pila.toString());  
    }
    private void testListStackTDA(){
        StackTDA<String> pila =new ListStackTDA<>();
        System.out.println("Antes de Añadir elementos: "+pila.size());
        pila.push("Jose");
        pila.push("Beatriz");
        pila.push("Sandro");
        pila.push("Juan");
        System.out.println("Despues de Añadir elementos: "+pila.size());
        System.out.println("Visualizando elementos");
        System.out.println(pila.toString());        
        
        System.out.println("Eliminando elementos");
        System.out.println("Elemento Eliminando:"+pila.pop().toString());
        System.out.println("Despues de Eliminar elementos: "+pila.size());
        System.out.println("Visualizando elementos");
        System.out.println(pila.toString());        
        
        System.out.println("Recuperando elementos");
        System.out.println("Elemento Recuperado:"+pila.peek().toString());
        System.out.println("Despues de Recuperar elementos: "+pila.size());
        System.out.println("Visualizando elementos");
        System.out.println(pila.toString());   
    }
}
