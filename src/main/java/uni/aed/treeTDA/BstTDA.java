package uni.aed.treeTDA;

import uni.aed.queueTDA.LinkedQueueTDA;
import uni.aed.queueTDA.QueueTDA;
import uni.aed.tda.LinkedListTDA.LinkedListTDA;
import uni.aed.tda.ListTDA.IteratorTDA;
import uni.aed.tda.ListTDA.ListTDA;

/** 
 * BST: Binary Search Tree
 */
public class BstTDA<E extends Comparable<E>> {
    public static final int NOT_FOUND=-1;
    public static final int IS_EMPTY=0;
    public static final int FOUND=1;    
    protected BstNodeTDA<E> root;
    
    public BstTDA() {
        this.root = null;
    }    
    
    public void add(E e){
        BstNodeTDA<E> p = root;
        BstNodeTDA<E> prev = null;
        while(p!=null){
            prev=p;
            if(p.getKey().compareTo(e)<0)
                p=p.getRight();
            else    
                p=p.getLeft();
        }
        if(root==null)
            root=new BstNodeTDA(e);
        else if(prev.getKey().compareTo(e) < 0)
            prev.setRight(new BstNodeTDA(e));
        else
            prev.setLeft(new BstNodeTDA(e));
    }    
    
    public int deleteByMerging(E e ){
        BstNodeTDA<E> tmp;        
        BstNodeTDA<E> node,p=root,prev=null;        
        while(p!=null && p.getKey().compareTo(e)!=0){
            prev=p;
            if(p.getKey().compareTo(e)<0)
                p=p.getRight();
            else
                p=p.getLeft();
        }
        node=p;
        if(p!=null && p.getKey().compareTo(e)==0){
            if(node.getRight()==null)
                node=node.getLeft();
            else if (node.getLeft()==null)
                node=node.getRight();
            else{
                tmp=node.getLeft();
                while(tmp.getRight()!=null){
                    tmp=tmp.getRight();
                }
                tmp.setRight(node.getRight());
                node=node.getLeft();
            }
            if(p==root)
                root=node;
            else if(prev.getLeft()==p)
                prev.setLeft(node);
            else
                prev.setRight(node);
        }
        else if(root!=null)
            return NOT_FOUND;
            //System.out.println("El valor no se encuentra en el arbol");
        else
            return IS_EMPTY;
            //System.out.println("El arbol esta vacio");
        return FOUND;
    }
    
    //Eliminacion por copiado
    public int deleteByCopying(E e){
        BstNodeTDA<E> tmp;
        BstNodeTDA<E> node,p=root,prev=null, previous;
        //buscamos el nodo a eliminar
        while(p!=null && p.getKey().compareTo(e)!=0){
            prev=p;
            if(p.getKey().compareTo(e)<0)
                p=p.getRight();
            else
                p=p.getLeft();
        }
        node=p;
        if(p!=null && p.getKey()==e){//encontro el elemento a eliminar
            if(node.getRight()==null)//no tiene hijo derecho
                node=node.getLeft();
            else if (node.getLeft()==null)//no tiene hijo izq
                node=node.getRight();
            else{//el nodo tiene dos hijos
                tmp=node.getLeft();
                previous=node;
                while(tmp.getRight()!=null){//rama derecha de la rama izq del nodo a elimar
                    previous=tmp;
                    tmp=tmp.getRight();
                }
                node.setKey(tmp.getKey());//copiamos el nodo derecho mas extremo de la rama izq del nodo con dos hijos a eliminar
                if(previous==node)
                    previous.setLeft(tmp.getLeft());
                else
                    previous.setRight(tmp.getLeft());
            }
            if(p==root)
                root=node;
            else if(prev.getLeft()==p)
                prev.setLeft(node);
            else
                prev.setRight(node);
        }
        else if(root!=null)//no encontro el elemento a elimnar en el arbol
            return NOT_FOUND;
            //System.out.println("El valor bno se encuentra en el arbol");
        else
            return IS_EMPTY;
            //System.out.println("El arbol esta vacio");
        return FOUND;
    }
                           
    public BstNodeTDA<E> search(E e){
        return search(root,e);
    }
    public BstNodeTDA<E> search(BstNodeTDA<E> p, E e){
        while(p!=null){            
            if(e.compareTo(p.getKey())==0)
                return p;
            else if(e.compareTo(p.getKey())<0)
                p=p.getLeft();
            else
                p=p.getRight();
        }
        return null;
    }
    
    public void visit(BstNodeTDA<E> p,StringBuilder str){
        if(p==null){
            str.append(NOT_FOUND);
            return;
        }
        if (!str.isEmpty()) 
            str.append(",");  
        str.append(p.getKey());        
    }
    
    //LVR
    public void inorder(StringBuilder str){
        inorder(root,str);
    }
    private void inorder(BstNodeTDA<E> p,StringBuilder str){
        if(p!=null){
            inorder(p.getLeft(),str);
            visit(p,str);
            inorder(p.getRight(),str);
        }        
    }
    
     //Resuelve 4PC:VisualizarArbol Final: LVR inorder
    public BstTDA<E> inorder(){
        BstTDA<E> bst=new BstTDA<>();
        ListTDA<E> lista=new LinkedListTDA<>();
        inorder(root,lista);
        IteratorTDA<E> it=lista.iterador();        
        while(it.hasNext()){            
            E e=it.next();    
            bst.add(e);
        }
        return bst;
    }
    private void inorder(BstNodeTDA<E> p,ListTDA<E> l){
        if(p!=null){
            inorder(p.getLeft(),l);
            l.add(p.getKey());            
            inorder(p.getRight(),l);}
    }
    
    //VLR preorder
    public void preorder(StringBuilder str){
        preorder(root,str);
    }
    public void preorder(BstNodeTDA<E> p,StringBuilder str){//VLR
        if(p!=null){
            visit(p,str);
            preorder(p.getLeft(),str);
            preorder(p.getRight(),str);}
    }
    
    //LRV postorder
    public void postorder(StringBuilder str){//LRV
        postorder(root,str);
    }
    public void postorder(BstNodeTDA<E> p,StringBuilder str){//LRV
        if(p!=null){            
            postorder(p.getLeft(),str);
            postorder(p.getRight(),str);
            visit(p,str);   
        }         
    }
     //recorrido primero en amplitud
    public void breadthFirst(StringBuilder str){
        BstNodeTDA<E> p=root;
        QueueTDA<BstNodeTDA> queue= new LinkedQueueTDA();
        if(p!=null){
            queue.enqueue(p);
            while(!queue.isEmpty()){
                p=queue.dequeue();
                visit(p,str);
                if(p.getLeft()!=null)
                    queue.enqueue(p.getLeft());
                if(p.getRight()!=null)
                    queue.enqueue(p.getRight());                    
            }
        }
    }

    @Override
    public String toString() {        
        return root.toString();        
    }
    
    
}
