package git.JavaDataStructure.Interfaces;

public interface RandomAccess<T> {

    T getIdx(int idx);

    void setIdx(int idx, T val);

    int size();

    boolean isValidIndex(int index);

    int indexOf(T value);

    void clear();

    T getLast();

    T getFirst();
}
