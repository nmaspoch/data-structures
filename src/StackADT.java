public interface StackADT<T> {
    public void push(T dataItem);

    public T pop();

    public T peek();

    public int size();

    public Boolean isEmpty();

    public String toString();
}
