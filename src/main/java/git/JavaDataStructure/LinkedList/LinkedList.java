package git.JavaDataStructure.LinkedList;

import java.util.Iterator;

import git.JavaDataStructure.LinkedList.Node;
import git.JavaDataStructure.Utils.NodeUtils;

public class LinkedList<T> implements Iterable<T>, Cloneable {
    Node<T> head;
    Node<T> tail;
    int size;

    public LinkedList() {
        head = null;
        tail = null;
        this.size = 0;
    }

    private LinkedList(Node<T> head) {
        if (head == null) {
            tail = null;
            this.size = 0;
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

    T getIdx(int idx) {
        return getIdxNode(idx).data;
    }

    public T getFirst() {
        if (head == null) {
            throw new IllegalCallerException("linked list is empty");
        }
        return head.data;
    }

    public T getLast() {
        if (tail == null) {
            throw new IllegalCallerException("linked list is empty");
        }
        return tail.data;
    }

    public boolean isEmpty() {
        return head == null;
    }

    private Node<T> getIdxNode(int idx) {
        if (idx < 0 || idx >= size) {
            throw new IllegalCallerException("index out of bounds");
        }
        Node<T> temp = head;
        while (temp.next != null && idx-- != 0) {
            temp = temp.next;
        }
        return temp;
    }

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

    public int size() {
        return size;
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

    public int indexOf(T data) {
        int idx = -1;
        for (T node : this) {
            ++idx;
            if (node.equals(data)) {
                return idx;
            }
        }
        return -1;
    }

    private Node<T> findMiddle() {
        if (head == null) {
            throw new IllegalCallerException("linked list is empty");
        }
        Node<T> fast = head;
        Node<T> slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public T getMiddleData() {
        return findMiddle().data;
    }

    public boolean hasCycle() {
        if (head == null) {
            return false;
        }
        Node<T> fast = head;
        Node<T> slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    public LinkedList<T> splitIntoTwo() {
        Node<T> middleNode = findMiddle();
        Node<T> nextHalfHead = middleNode.next;

        this.size = (size / 2) + (size % 2);
        nextHalfHead.prev = null;
        middleNode.next = null;
        tail = middleNode;
        return new LinkedList<T>(nextHalfHead);
    }

    public void clear() {
        head = null;
        tail = null;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (T val : this) {
            sb.append(val.toString()).append(", ");
        }
        sb.delete(sb.length() - 1, sb.length());
        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }
}
