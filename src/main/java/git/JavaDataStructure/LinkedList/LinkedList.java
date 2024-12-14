package git.JavaDataStructure.LinkedList;

import java.util.Iterator;

import git.JavaDataStructure.Abstract.AbstractList;
import git.JavaDataStructure.LinkedList.Node;
import git.JavaDataStructure.Utils.NodeUtils;

public class LinkedList<T> extends AbstractList<T> implements Iterable<T>, Cloneable {
    Node<T> head;
    Node<T> tail;

    public LinkedList() {
        super(0);
        head = null;
        tail = null;
    }

    private LinkedList(Node<T> head) {
        super(0);

        if (head == null) {
            tail = null;
            return;
        }
        this.head = head;
        Node<T> temp = head;
        int size = 1;

        while (temp.next != null) {
            temp = temp.next;
            size++;
        }
        this.size = size;
        tail = temp;
    }

    @Override
    public void addFirst(T data) {
        Node<T> newNode = new Node<T>(data);
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
    public void addLast(T data) {
        Node<T> newNode = new Node<T>(data);
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
    public T removeFirst() {
        if (head == null) {
            throw new IllegalCallerException("linked list is empty");
        } else if (head == tail) {
            T data = head.data;
            head = null;
            tail = null;
            --size;
            return data;
        }
        T data = head.data;
        if (tail == head)
            tail = null;
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
            head = null;
            tail = null;
            --size;
            return data;
        }

        T data = tail.data;
        tail = tail.prev;
        tail.next = null;
        --size;
        return data;
    }

    @Override
    public T remove(int index) {
        if (head == null) {
            throw new IllegalCallerException("linked list is empty");
        } else if (index == 0)
            return removeFirst();
        else if (index == size - 1)
            return removeLast();

        Node<T> targetNode = getIdxNode(index);
        T data = targetNode.data;
        NodeUtils.removeNodeBetween2Nodes(targetNode);
        --size;
        return data;
    }

    @Override
    public T getIdx(int idx) {
        return getIdxNode(idx).data;
    }

    @Override
    public void setIdx(int index, T value) {
        getIdxNode(index).data = value;
    }

    private Node<T> getIdxNode(int idx) {
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
        return new Iterator<T>() {
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




    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public LinkedList<T> clone() throws CloneNotSupportedException {
        LinkedList<T> list = (LinkedList<T>) super.clone();
        list.head = null;
        list.tail = null;
        list.size = 0;

        for (T data : this) {
            list.addLast((T) data);
        }
        return list;
    }
}
