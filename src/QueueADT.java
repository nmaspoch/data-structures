public interface QueueADT<T>
{
    public T dequeue();
    public void enqueue(T item);
    public T first();
    public Boolean isEmpty();
    public int size();
    public String toString();
}