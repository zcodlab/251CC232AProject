package uni.aed.stackTDA;

public interface StackTDA<E> {
    public void push(E elemento);
    public E pop() throws StackEmptyExceptionTDA;
    public E peek() throws StackEmptyExceptionTDA;
    public void clear();
    public int size();
    public boolean isEmpty();
}
