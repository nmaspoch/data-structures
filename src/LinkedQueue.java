public class LinkedQueue<T> implements QueueADT<T> {
    private LinearNode<T> front;
    private LinearNode<T> rear;
    private int size;

    public LinkedQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    public T dequeue() throws EmptyCollectionException {
        if (isEmpty())
            throw new EmptyCollectionException("Queue is empty", null);

        var temp = front.getNext();
        var data = front.getData();
        front.setNext(null);
        front = temp;
        size -= 1;
        return data;
    }

    public void enqueue(T item) {
        LinearNode<T> newNode = new LinearNode<T>(item);

        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.setNext(newNode);
            rear = newNode;
        }
        size += 1;
    }

    public T first() {
        return front.getData();
    }

    public Boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public String toString() {
        String output = "";
        var current = front;
        while (current != null) {
            output += current.getData() + " ";
        }
        return output;
    }
}