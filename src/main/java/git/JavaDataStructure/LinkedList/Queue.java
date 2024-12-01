package git.JavaDataStructure.LinkedList;

public class Queue<T> {
    LinkedList<T> queue;

    public Queue() {
        queue = new LinkedList<>();
    }

    public void enqueue(T t) {
        queue.addLast(t);
    }

    public T dequeue() {
        return queue.removeFirst();
    }

    public T front() {
        return queue.getFirst();
    }
    public int size() {
        return queue.size();
    }
    public boolean isEmpty() {
        return queue.isEmpty();
    }

}
