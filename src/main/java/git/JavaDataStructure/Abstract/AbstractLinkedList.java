package git.JavaDataStructure.Abstract;

import git.JavaDataStructure.LinkedList.Node;
import git.JavaDataStructure.Utils.NodeUtils;

import java.util.Iterator;

public abstract class AbstractLinkedList<T> extends AbstractList<T> {
    protected Node<T> head;
    protected Node<T> tail;

    protected AbstractLinkedList(int size) {
        super(size);
    }

    @Override
    public T getFirst() {
        if (head == null) {
            throw new IllegalCallerException("List is Empty");
        }
        return head.data;
    }

    protected Node<T> getIdxNode(int idx) {
        if (idx < 0 || idx >= size) {
            throw new IllegalCallerException("index out of bounds");
        }
        if (idx == 0) {
            return head;
        } else if (idx == size - 1) {
            return tail;
        }

        Node<T> temp = head;
        while (temp.next != null && idx-- != 0) {
            temp = temp.next;
        }
        return temp;
    }

    @Override
    public T getIdx(int idx) {
        return getIdxNode(idx).data;
    }

    @Override
    public void setIdx(int index, T value) {
        getIdxNode(index).data = value;
    }

    @Override
    public T getLast() {
        if (tail == null) {
            throw new IllegalCallerException("List is Empty");
        }
        return tail.data;
    }


    @Override
    public void addLast(T data) {
        Node<T> newNode = new Node<>(data);
        if (tail == null) {
            addFirst(data);
            return;
        } else {
            NodeUtils.linkTwoNodes(tail, newNode);
            tail = newNode;
        }
        ++size;
    }

    @Override
    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            NodeUtils.linkTwoNodes(newNode, head);
            head = newNode;
        }
        ++size;
    }

    @Override
    public T removeFirst() {
        if (head == null) {
            throw new IllegalCallerException("linked list is empty");
        } else if (head == tail) {
            T data = head.data;
            clear();
            return data;
        }

        T data = head.data;
        head = head.next;
        --size;
        return data;

    }

    @Override
    public T removeLast() {
        if (tail == null) {
            throw new IllegalCallerException("linked list is empty");
        } else if (head == tail) {
            T data = tail.data;
            clear();
            return data;
        }

        T data = tail.data;
        tail = tail.prev;
        tail.next = null;
        --size;
        return data;
    }
    @Override
    public void clear() {
        tail = null;
        head = null;
        size = 0;
    }

    @Override
    public void insert(int idx, T data) {
        if (idx < 0 || idx >= size) {
            throw new IllegalCallerException("index out of bounds");
        } else if (idx == 0)
            addFirst(data);
        else {
            Node<T> newNode = new Node<>(data);
            Node<T> prevInsert = getIdxNode(idx - 1);
            NodeUtils.insertBetween2Nodes(prevInsert, prevInsert.next, newNode);
            ++size;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            Node<T> cur = head;

            @Override
            public boolean hasNext() {
                return cur != null;
            }

            @Override
            public T next() {
                T data = cur.data;
                cur = cur.next;
                return data;
            }
        };
    }


}
