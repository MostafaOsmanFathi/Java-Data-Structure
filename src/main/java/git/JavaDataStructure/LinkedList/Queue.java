package git.JavaDataStructure.LinkedList;

import git.JavaDataStructure.Interfaces.QueueInterface;

public class Queue<T> implements QueueInterface<T> {
    LinkedList<T> queue;

    public Queue() {
        queue = new LinkedList<>();
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

    public int size() {
        return queue.size();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public String toString() {
        return queue.toString();
    }
}
