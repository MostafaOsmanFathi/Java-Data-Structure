package git.JavaDataStructure.ArrayBased;

import git.JavaDataStructure.Abstract.AbstractList;
import git.JavaDataStructure.Interfaces.DequeueInterface;

import java.util.Iterator;

class Dequeue<T> extends AbstractList<T> implements Iterable<T>, Cloneable, DequeueInterface<T> {
    private T[] arr;
    private int capacity;

    private int head;
    private int tail;

    @SuppressWarnings("unchecked")
    public Dequeue() {
        super(0);
        this.head = 0;
        this.tail = 0;
        this.capacity = 2;
        this.arr = (T[]) new Object[capacity];
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
        this.arr = newArr;
        this.head = 0;
        this.tail = size;
    }

    private int getCircularIndex(int index) {
        return ((index % capacity) + capacity) % capacity;
    }

    @Override
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

    @Override
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

    @Override
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

    @Override
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


    @SuppressWarnings("unchecked")
    @Override
    public void clear() {
        this.head = 0;
        this.tail = 0;
        this.capacity = 2;
        this.size = 0;
        this.arr = (T[]) new Object[capacity];
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
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
        clone.clear();

        for (T item : this) {
            clone.addLast(item);
        }

        return clone;
    }
}
