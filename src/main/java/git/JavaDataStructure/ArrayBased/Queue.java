package git.JavaDataStructure.ArrayBased;


public class Queue<T> implements Cloneable {
    private Dequeue<T> queue;

    public Queue() {
        queue = new Dequeue<>();
    }

    public void enqueue(T t) {
        queue.addLast(t);
    }

    public T dequeue() {
        return queue.removeFirst();
    }

    public T peek() {
        return queue.getFirst();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public int size() {
        return queue.getSize();
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Queue<T> clone = (Queue<T>) super.clone();
        clone.queue = (Dequeue<T>) queue.clone();
        return clone;
    }
}
