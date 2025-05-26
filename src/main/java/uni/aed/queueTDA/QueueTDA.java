package uni.aed.queueTDA;

public interface QueueTDA<E> {
    public void enqueue(E data);//addLast
    public E dequeue() throws QueueEmptyExceptionTDA;//remove(0) poll()[JCF]
    public E peek() throws QueueEmptyExceptionTDA;//get(0)
    public void clear();
    public boolean isEmpty();
    public int size();
}
