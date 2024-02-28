public class LinkedStack<T> implements IStack<T> {
    private Node<T> top;
    private int size;

    public LinkedStack() {
        top = null;
        size = 0;
    }

    @Override
    public int count() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public void push(T value) {
        Node<T> newNode = new Node<>(value);
        newNode.next = top;
        top = newNode;
        size++;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            return null;
        }
        T value = top.data;
        top = top.next;
        size--;
        return value;
    }

    @Override
    public T peek() {
        return isEmpty() ? null : top.data;
    }

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }
}
