public class LinearNode<T> {
    private T data;
    private LinearNode<T> next;

    public LinearNode()
    {
        data = null;
        next = null;
    }

    public LinearNode(T dataItem)
    {
        data = dataItem;
        next = null;
    }

    public T getData()
    {
        return data;
    }

    public LinearNode<T> getNext()
    {
        return next;
    }

    public void setData(T dataItem)
    {
        data = dataItem;
    }

    public void setNext(LinearNode<T> item)
    {
        next = item;
    }

    
}
