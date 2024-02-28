public class DoblementeEncadenado<T> implements IStack<T> {
    private Node<T> top;
    private int size;

    public DoblementeEncadenado() {
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
        if (top != null) {
            newNode.next = top;
            top.prev = newNode;
        }
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
        if (top != null) {
            top.prev = null;
        }
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
        Node<T> prev;

        Node(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
}

