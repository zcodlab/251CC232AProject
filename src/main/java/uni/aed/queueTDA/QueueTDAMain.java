package uni.aed.queueTDA;

import uni.aed.model.Persona;

public class QueueTDAMain {
    public static void main(String[] args) {    
        QueueTDAMain queueTDAMain=new QueueTDAMain();  
        queueTDAMain.testIntegerPriorityQueueTDA();
        //queueTDAMain.testPersonaArrayQueueTDA();
        //queueTDAMain.testStringArrayQueueTDA();
        //queueTDAMain.testIntegerArrayQueueTDA();
        //queueTDAMain.testPersonaLinkedQueueTDA();
        //queueTDAMain.testStringLinkedQueueTDA();
        //queueTDAMain.testIntegerLinkedQueueTDA();
    }
    private void testIntegerLinkedQueueTDA(){
        QueueTDA<Integer> q=new LinkedQueueTDA();
        q.enqueue(30);
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(5);
        System.out.println("Despues de Añadir elementos: "+q.size());
        System.out.println("Visualizando la cola");
        System.out.println(q.toString());        
        
        System.out.println("Eliminando elementos");
        System.out.println("Elemento Eliminando:"+q.dequeue().toString());
        System.out.println("Despues de Eliminar elementos: "+q.size());
        System.out.println("Visualizando elementos");
        System.out.println(q.toString());        
        
        System.out.println("Recuperando elementos");
        System.out.println("Elemento Recuperado:"+q.peek().toString());
        System.out.println("Despues de Recuperar elementos: "+q.size());
        System.out.println("Visualizando elementos");
        System.out.println(q.toString());  
    }
    private void testStringLinkedQueueTDA(){
        QueueTDA<String> q=new LinkedQueueTDA();
        q.enqueue("Jose");
        q.enqueue("Ana");
        q.enqueue("Juan");
        q.enqueue("Betty");
        System.out.println("Despues de Añadir elementos: "+q.size());
        System.out.println("Visualizando la cola");
        System.out.println(q.toString());        
        
        System.out.println("Eliminando elementos");
        System.out.println("Elemento Eliminando:"+q.dequeue().toString());
        System.out.println("Despues de Eliminar elementos: "+q.size());
        System.out.println("Visualizando elementos");
        System.out.println(q.toString());        
        
        System.out.println("Recuperando elementos");
        System.out.println("Elemento Recuperado:"+q.peek().toString());
        System.out.println("Despues de Recuperar elementos: "+q.size());
        System.out.println("Visualizando elementos");
        System.out.println(q.toString());  
    }
    private void testPersonaLinkedQueueTDA(){
        QueueTDA<Persona> q=new LinkedQueueTDA();
        q.enqueue(new Persona("Jose",36));
        q.enqueue(new Persona("Ana",46));
        q.enqueue(new Persona("Juan",16));
        q.enqueue(new Persona("Betty",66));
        
        System.out.println("Despues de Añadir elementos: "+q.size());
        System.out.println("Visualizando la cola");
        System.out.println(q.toString());        
        
        System.out.println("Eliminando elementos");
        System.out.println("Elemento Eliminando:"+q.dequeue().toString());
        System.out.println("Despues de Eliminar elementos: "+q.size());
        System.out.println("Visualizando elementos");
        System.out.println(q.toString());        
        
        System.out.println("Recuperando elementos");
        System.out.println("Elemento Recuperado:"+q.peek().toString());
        System.out.println("Despues de Recuperar elementos: "+q.size());
        System.out.println("Visualizando elementos");
        System.out.println(q.toString());  
    }
    
    private void testIntegerArrayQueueTDA(){
        QueueTDA<Integer> q=new ArrayQueueTDA(4);
        q.enqueue(30);
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(5);
        System.out.println("Despues de Añadir elementos: "+q.size());
        System.out.println("Visualizando la cola");
        System.out.println(q.toString());        
        
        System.out.println("Eliminando elementos");
        System.out.println("Elemento Eliminando:"+q.dequeue().toString());
        System.out.println("Despues de Eliminar elementos: "+q.size());
        System.out.println("Visualizando elementos");
        System.out.println(q.toString());        
        
        System.out.println("Recuperando elementos");
        System.out.println("Elemento Recuperado:"+q.peek().toString());
        System.out.println("Despues de Recuperar elementos: "+q.size());
        System.out.println("Visualizando elementos");
        System.out.println(q.toString());  
    }
    
    private void testStringArrayQueueTDA(){
        QueueTDA<String> q=new ArrayQueueTDA(4);
        q.enqueue("Jose");
        q.enqueue("Ana");
        q.enqueue("Juan");
        q.enqueue("Betty");
        System.out.println("Despues de Añadir elementos: "+q.size());
        System.out.println("Visualizando la cola");
        System.out.println(q.toString());        
        
        System.out.println("Eliminando elementos");
        System.out.println("Elemento Eliminando:"+q.dequeue().toString());
        System.out.println("Despues de Eliminar elementos: "+q.size());
        System.out.println("Visualizando elementos");
        System.out.println(q.toString());        
        
        System.out.println("Recuperando elementos");
        System.out.println("Elemento Recuperado:"+q.peek().toString());
        System.out.println("Despues de Recuperar elementos: "+q.size());
        System.out.println("Visualizando elementos");
        System.out.println(q.toString());  
    }
    private void testPersonaArrayQueueTDA(){
        QueueTDA<Persona> q=new ArrayQueueTDA(4);
        q.enqueue(new Persona("Jose",36));
        q.enqueue(new Persona("Ana",46));
        q.enqueue(new Persona("Juan",16));
        q.enqueue(new Persona("Betty",66));
        
        System.out.println("Despues de Añadir elementos: "+q.size());
        System.out.println("Visualizando la cola");
        System.out.println(q.toString());        
        
        System.out.println("Eliminando elementos");
        System.out.println("Elemento Eliminando:"+q.dequeue().toString());
        System.out.println("Despues de Eliminar elementos: "+q.size());
        System.out.println("Visualizando elementos");
        System.out.println(q.toString());        
        
        System.out.println("Recuperando elementos");
        System.out.println("Elemento Recuperado:"+q.peek().toString());
        System.out.println("Despues de Recuperar elementos: "+q.size());
        System.out.println("Visualizando elementos");
        System.out.println(q.toString());  
    }
    
     private void testIntegerPriorityQueueTDA(){
        int n=7;
        QueueTDA<Integer> q=new PriorityQueueTDA(n);
        q.enqueue(56);
        q.enqueue(88);
        q.enqueue(7);
        q.enqueue(60);
        q.enqueue(2);
        q.enqueue(71);
        q.enqueue(59);
        
        System.out.println("Despues de Añadir elementos: "+q.size());
        System.out.println("Visualizando la cola");
        System.out.println(q.toString());                
        
        System.out.println("Recuperando elementos");
        System.out.println("Elemento Recuperado:"+q.peek().toString());
        System.out.println("Despues de Recuperar elementos: "+q.size());
        System.out.println("Visualizando elementos");
        System.out.println(q.toString());  
        
        System.out.println("Eliminando elementos - Extraendo todos los elementos del heap");
        for(int i=0;i<n;i++)                
            System.out.println("Elemento Eliminando:"+q.dequeue().toString());
        System.out.println("Despues de Eliminar elementos: "+q.size());
        System.out.println("Visualizando elementos");
        System.out.println(q.toString());        
    }
}
