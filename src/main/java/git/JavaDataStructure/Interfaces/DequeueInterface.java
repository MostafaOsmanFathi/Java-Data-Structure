package git.JavaDataStructure.Interfaces;

public interface DequeueInterface<T> {
    T getFirst();

    T getLast();

    void addLast(T element);

    T removeLast();

    T removeFirst();

    int size();

    boolean isEmpty();
}
