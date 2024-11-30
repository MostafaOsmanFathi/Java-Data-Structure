package git.JavaDataStructure.ArrayBased;

import java.util.Iterator;

class Dequeue<T> implements Iterable<T>, Cloneable {
    private T[] arr;
    private int capacity;
    private int size;

    private int head;
    private int tail;

    @SuppressWarnings("unchecked")
    public Dequeue() {
        this.head = 0;
        this.tail = 1;
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

        this.capacity = newCapacity;
        T[] newArr = (T[]) new Object[newCapacity];

        for (int i = head; i <= tail; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
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
        }
        arr[head] = item;
        head = getCircularIndex(head + 1);
        size++;
    }

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
        if (index > size || index < 0) {
            throw new IllegalArgumentException("index out of range");
        }
        T temp = getIdx(index);
        for (int i = getCircularIndex(head + index); i < tail - 1; i = getCircularIndex(i + 1)) {
            arr[i] = arr[i + 1];
        }
        return temp;
    }

    public T getIdx(int index) {
        if (index < size && index >= 0) {
            return arr[getCircularIndex(head + index)];
        }
        throw new IllegalArgumentException("index out of range");
    }

    public T getFirst() {
        if (size == 0) {
            throw new IllegalCallerException("circular array is empty");
        }
        return arr[head];
    }

    public T getLast() {
        if (size == 0) {
            throw new IllegalCallerException("circular array is empty");
        }
        return arr[tail - 1];
    }

    public void setIdx(int index, T item) {
        if (index < size && index >= 0) {
            arr[getCircularIndex(head + index)] = item;
            return;
        }
        throw new IllegalArgumentException("index out of range");
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int current = head;

            @Override
            public boolean hasNext() {
                return current != tail;
            }

            @Override
            public T next() {
                T temp = arr[current];
                current = getCircularIndex(current + 1);
                return temp;
            }
        };
    }

    @Override
    @SuppressWarnings("unchecked")
    public Object clone() throws CloneNotSupportedException {
        Dequeue<T> clone = (Dequeue<T>) super.clone();
        clone.arr = (T[]) new Object[capacity];
        for (T tmp : this) {
            clone.addLast(tmp);
        }
        return clone;
    }
}
