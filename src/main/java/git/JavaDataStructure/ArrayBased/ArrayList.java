package git.JavaDataStructure.ArrayBased;

import git.JavaDataStructure.Abstract.AbstractList;

import java.util.Iterator;
import java.util.Objects;

public class ArrayList<T> extends AbstractList<T> implements Cloneable, Iterable<T> {
    private T[] arr;
    private int capacity;

    @SuppressWarnings("unchecked")
    public ArrayList() {
        super(0);
        this.capacity = 1;
        this.size = 0;
        this.arr = (T[]) new Object[capacity];
    }

    @SuppressWarnings("unchecked")
    public ArrayList(int capacity) {
        super(0);
        this.capacity = capacity;
        this.arr = (T[]) new Object[capacity];
    }


    @SuppressWarnings("unchecked")
    public ArrayList(ArrayList<T> list) {
        super(0);
        Objects.requireNonNull(list);
        this.capacity = list.capacity;
        this.size = list.size;
        this.arr = (T[]) new Object[capacity];
        copyArray(list.arr, arr, list.size);
    }

    @SuppressWarnings("unchecked")
    private void reserve(int newCapacity) {
        if (newCapacity < capacity || newCapacity <= 0) {
            throw new IllegalArgumentException("newCapacity must be  greater than capacity");
        }

        T[] newArr = (T[]) new Object[newCapacity];

        copyArray(arr, newArr, capacity);

        this.capacity = newCapacity;
        this.arr = newArr;
    }

    @SuppressWarnings("unchecked")
    private void shrink(int newCapacity) {
        if (newCapacity > capacity || newCapacity <= 0) {
            throw new IllegalArgumentException("newCapacity must be  less than capacity and can't be Negative or Zero");
        }
        this.capacity = newCapacity;
        T[] newArr = (T[]) new Object[newCapacity];

        copyArray(arr, newArr, newCapacity);
        this.arr = newArr;
    }

    private void shrinkTest() {
        if (size < capacity / 4) {
            shrink(capacity / 2);
        }
    }

    public void addLast(T value) {
        if (size == capacity) {
            reserve(capacity * 2);
        }
        arr[size] = value;
        size++;
    }

    public void insert(int index, T value) {
        if (index > size || index < 0) {
            throw new IllegalArgumentException("index out of range index between 0 and " + (size));
        } else if (index == size) {
            addLast(value);
            return;
        } else if (size == capacity) {
            reserve(capacity * 2);
        }
        for (int i = size; i > index; i--) {
            arr[i] = arr[i - 1];
        }
        arr[index] = value;
        size++;
    }

    @Override
    public T remove(int index) {
        if (index >= size || index < 0) {
            throw new IllegalArgumentException("index out of range index between 0 and " + (size - 1));
        } else if (index == size - 1) {
            return removeLast();
        }
        T temp = arr[index];
        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        size--;
        shrinkTest();
        return temp;
    }

    @Override
    public void addFirst(T value) {
        if (size == capacity) {
            reserve(capacity * 2);
        }
        insert(0, value);
    }

    @Override
    public T removeLast() {
        if (size == 0) {
            throw new IllegalCallerException("there's not last element to remove");
        }
        T temp = arr[size - 1];
        size--;
        shrinkTest();

        return temp;
    }

    @Override
    public T removeFirst() {
        return remove(0);
    }

    @Override
    public T getIdx(int index) {
        if (index >= size || index < 0) {
            throw new IllegalArgumentException("index out of range index between 0 and " + (size - 1));
        }
        return arr[index];
    }

    @Override
    public void setIdx(int index, T value) {
        if (index >= size || index < 0) {
            throw new IllegalArgumentException("index out of range index between 0 and " + (size - 1));
        }
        arr[index] = value;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Object clone() throws CloneNotSupportedException {
        ArrayList<T> clone = (ArrayList<T>) super.clone();
        clone.arr = (T[]) new Object[capacity];
        copyArray(arr, clone.arr, size);
        return clone;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void clear() {
        capacity = 1;
        size = 0;
        arr = (T[]) new Object[capacity];
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return index != size;
            }

            @Override
            public T next() {
                index++;
                return arr[index - 1];
            }
        };
    }

}
