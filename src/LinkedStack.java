public class LinkedStack<T> implements StackADT<T> {
    private LinearNode<T> top;
    private int size;

    public LinkedStack() {
        top = null;
        size = 0;
    }

    public void push(T newItem) {
        LinearNode<T> newNode = new LinearNode<T>(newItem);

        if (isEmpty()) {
            top = newNode;
            size = 1;
        }

        else {
            newNode.setNext(top);
            top = newNode;
            size += 1;
        }
    }

    public T pop() throws EmptyCollectionException {
        if (isEmpty())
            throw new EmptyCollectionException("Stack is empty", null);

        var data = top.getData();
        var temp = top.getNext();
        top.setNext(null);
        top = temp;
        return data;
    }

    public T peek() {
        return top.getData();
    }

    public int size() {
        return size;
    }

    public Boolean isEmpty() {
        return size == 0;
    }

    public String toString() {
        String output = "";
        var current = top;

        while (current != null) {
            output = output + current.getData() + "\n";
            current = current.getNext();
        }

        return output;
    }
}
