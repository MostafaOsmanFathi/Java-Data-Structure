package git.JavaDataStructure.Interfaces;

public interface QueueInterface<T> {

    void enqueue(T element);

    T dequeue();

    T peek();

    boolean isEmpty();
}
