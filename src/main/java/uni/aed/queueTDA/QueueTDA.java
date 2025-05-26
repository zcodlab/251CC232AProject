package uni.aed.queueTDA;

public interface QueueTDA<E> {
    public void enqueue(E data);//addLast
    public E dequeue() throws QueueEmptyExceptionTDA;//remove
    public E peek() throws QueueEmptyExceptionTDA;//get
    public void clear();
    public boolean isEmpty();
    public int size();
}
