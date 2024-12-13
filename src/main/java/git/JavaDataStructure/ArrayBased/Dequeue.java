package git.JavaDataStructure.ArrayBased;

import git.JavaDataStructure.Interfaces.DequeueInterface;
import git.JavaDataStructure.Interfaces.RandomAccess;

import java.util.Iterator;

class Dequeue<T> implements Iterable<T>, Cloneable, RandomAccess<T>, DequeueInterface<T> {
    private T[] arr;
    private int capacity;
    private int size;

    private int head;
    private int tail;

    @SuppressWarnings("unchecked")
    public Dequeue() {
        this.head = 0;
        this.tail = 0;
        capacity = 2;
        size = 0;
        arr = (T[]) new Object[capacity];
    }

    @SuppressWarnings("unchecked")
    public Dequeue(Dequeue<T> list) {
        this.head = list.head;
        this.tail = list.tail;
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


        for (int i = 0; i < size; i++) {
            newArr[i] = arr[getCircularIndex(head + i)];
        }
        this.capacity = newCapacity;
        arr = newArr;
        head = 0;
        tail = size;
    }

    private int getCircularIndex(int index) {
        return ((index % capacity) + capacity) % capacity;
    }

    public void addLast(T item) {
        if (size == capacity) {
            reserve(capacity * 2);
        }
        arr[tail] = item;
        tail++;
        tail = getCircularIndex(tail);
        size++;
    }

    @Override
    public T removeLast() {
        if (size == 0) {
            throw new IllegalCallerException("circular array is empty");
        }
        T temp = arr[tail];
        arr[tail] = null;
        tail = getCircularIndex(tail - 1);
        size--;
        return temp;
    }

    public void addFirst(T item) {
        if (size == capacity) {
            reserve(capacity * 2);
        } else if (head == tail) {
            addLast(item);
            return;
        }
        head = getCircularIndex(head - 1);
        arr[head] = item;
        size++;
    }

    @Override
    public T removeFirst() {
        if (size == 0) {
            throw new IllegalCallerException("there's not last element to remove");
        }
        T item = arr[head];

        head = getCircularIndex(head + 1);
        size--;
        return item;
    }

    public void insert(int index, T item) {
        if (index > size || index < 0) {
            throw new IllegalArgumentException("index out of range");
        } else if (size == capacity) {
            reserve(capacity * 2);
        }
        head = getCircularIndex(head);
        tail = getCircularIndex(tail);
        for (int i = tail; i >= getCircularIndex(head + index); i = getCircularIndex(i - 1)) {
            arr[i] = arr[i - 1];
        }
        tail = getCircularIndex(tail + 1);
        size++;
        setIdx(index, item);
    }

    public T remove(int index) {
        if (index >= size || index < 0) {
            throw new IllegalArgumentException("index out of range index between 0 and " + (size - 1));
        } else if (index == size - 1) {
            return removeLast();
        }
        T temp = getIdx(index);
        index = getCircularIndex(index + head);

        for (int i = index; i < size - 1; i++) {
            arr[getCircularIndex(head + i)] = arr[getCircularIndex(head + i + 1)];
        }
        --size;
        return temp;
    }

    @Override
    public T getIdx(int index) {
        if (index < size && index >= 0) {
            return arr[getCircularIndex(head + index)];
        }
        throw new IllegalArgumentException("index out of range");
    }

    @Override
    public T getFirst() {
        if (size == 0) {
            throw new IllegalCallerException("circular array is empty");
        }
        return arr[head];
    }

    @Override
    public T getLast() {
        if (size == 0) {
            throw new IllegalCallerException("circular array is empty");
        }
        return arr[tail - 1];
    }

    @Override
    public void setIdx(int index, T item) {
        if (index < size && index >= 0) {
            arr[getCircularIndex(head + index)] = item;
            return;
        }
        throw new IllegalArgumentException("index out of range");
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isValidIndex(int index) {
        return index < size && index >= 0;
    }

    @Override
    public int indexOf(T value) {
        int index = 0;
        for (T idxVal : this) {
            if (idxVal.equals(value)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    @Override
    public void clear() {
        this.head = 0;
        this.tail = 0;
        capacity = 2;
        size = 0;
        arr = (T[]) new Object[capacity];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int current = head;
            private int tmpSize = size;

            @Override
            public boolean hasNext() {

                return tmpSize != 0;
            }

            @Override
            public T next() {
                T temp = arr[current];
                current = getCircularIndex(current + 1);
                --tmpSize;
                return temp;
            }
        };
    }

    @Override
    @SuppressWarnings("unchecked")
    public Object clone() throws CloneNotSupportedException {
        Dequeue<T> clone = (Dequeue<T>) super.clone();
        clone.arr = (T[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            clone.arr[i] = arr[i];
        }
        return clone;
    }

    @Override
    public String toString() {
        if (size == 0)
            return "[]";
        StringBuilder sb = new StringBuilder("[");
        for (T val : this) {
            sb.append(val.toString()).append(", ");
        }
        sb.delete(sb.length() - 1, sb.length());
        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }
}
