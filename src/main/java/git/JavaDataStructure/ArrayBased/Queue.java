package git.JavaDataStructure.ArrayBased;


import git.JavaDataStructure.Interfaces.QueueInterface;

public class Queue<T> implements Cloneable, QueueInterface<T> {
    private Dequeue<T> queue;

    public Queue() {
        queue = new Dequeue<>();
    }

    @Override
    public void enqueue(T t) {
        queue.addLast(t);
    }

    @Override
    public T dequeue() {
        return queue.removeFirst();
    }

    @Override
    public T peek() {
        return queue.getFirst();
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public int size() {
        return queue.size();
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Queue<T> clone = (Queue<T>) super.clone();
        clone.queue = (Dequeue<T>) queue.clone();
        return clone;
    }
}
