package git.JavaDataStructure.LinkedList;

public class Node<T> {
    public Node<T> next;
    public Node<T> prev;
    public T data;

    public Node(T data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
