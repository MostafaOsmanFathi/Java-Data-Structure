package git.JavaDataStructure.ArrayBased;

import git.JavaDataStructure.Interfaces.RandomAccess;

import java.util.Iterator;

public class ArrayList<T> implements Cloneable, Iterable<T>, RandomAccess<T> {
    private T[] arr;
    private int capacity;
    private int size;

    @SuppressWarnings("unchecked")
    public ArrayList() {
        capacity = 1;
        size = 0;
        arr = (T[]) new Object[capacity];
    }

    @SuppressWarnings("unchecked")
    public ArrayList(int capacity) {
        this.capacity = capacity;
        size = 0;
        arr = (T[]) new Object[capacity];
    }

    @SuppressWarnings("unchecked")
    public ArrayList(ArrayList<T> list) {
        this.capacity = list.capacity;
        size = list.size;
        arr = (T[]) new Object[capacity];
        for (int i = 0; i < list.size; i++) {
            arr[i] = list.arr[i];
        }
    }

    @SuppressWarnings("unchecked")
    private void reserve(int newCapacity) {
        if (newCapacity < capacity || newCapacity <= 0) {
            throw new IllegalArgumentException("newCapacity must be  greater than capacity");
        }

        T[] newArr = (T[]) new Object[newCapacity];

        for (int i = 0; i < capacity; i++) {
            newArr[i] = arr[i];
        }
        this.capacity = newCapacity;
        arr = newArr;
    }

    @SuppressWarnings("unchecked")
    private void shrink(int newCapacity) {
        if (newCapacity > capacity || newCapacity <= 0) {
            throw new IllegalArgumentException("newCapacity must be  less than capacity and can't be Negative or Zero");
        }
        this.capacity = newCapacity;
        T[] newArr = (T[]) new Object[newCapacity];

        for (int i = 0; i < newCapacity; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
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

    public void addFirst(T value) {
        if (size == capacity) {
            reserve(capacity * 2);
        }
        insert(0, value);
    }

    public T removeLast() {
        if (size == 0) {
            throw new IllegalCallerException("there's not last element to remove");
        }
        T temp = arr[size - 1];
        size--;
        shrinkTest();

        return temp;
    }

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
        for (int i = 0; i < size; i++) {
            clone.arr[i] = arr[i];
        }
        return clone;
    }

    public int size() {
        return size;
    }

    @Override
    public boolean isValidIndex(int index) {
        return index >= 0 && index < size;
    }

    @Override
    public int indexOf(T value) {
        int index = 0;
        for (T idx : this) {
            if (idx.equals(value)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void clear() {
        capacity = 1;
        size = 0;
        arr = (T[]) new Object[capacity];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getCapacity() {
        return capacity;
    }

    public T getLast() {
        if (size == 0) {
            throw new IllegalCallerException("Array is Empty");
        }
        return arr[size - 1];
    }

    public T getFirst() {
        if (size == 0) {
            throw new IllegalCallerException("Array is Empty");
        }
        return arr[0];
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
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

    @Override
    public String toString() {
        if (this.isEmpty()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        for (T val : this) {
            sb.append(val.toString()).append(", ");
        }
        sb.delete(sb.length() - 1, sb.length());
        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }
}
