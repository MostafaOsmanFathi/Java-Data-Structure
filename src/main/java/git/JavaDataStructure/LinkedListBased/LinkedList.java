package git.JavaDataStructure.LinkedListBased;

public class LinkedList {
    static int ERROR_VALUE = -1;

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node head = null;
    static Node tail = null;

    static boolean push_back(int data) {
        if (head == null) {
            head = new Node((data));
            tail = head;
            return true;
        } else {
            tail.next = new Node(data);
            tail = tail.next;
            return true;
        }
    }

    static boolean push_front(int data) {
        if (head == null) {
            head = new Node((data));
            tail = head;
            return true;
        } else {
            Node tmp = new Node(data);
            tmp.next = head;
            head = tmp;
            return true;
        }
    }

    static boolean insertNode(Node baseNode, Node newNode) {
        if (baseNode == null || newNode == null) {
            return false;
        }
        baseNode.next = newNode;
        return true;
    }

    static int front() {
        if (head == null) return ERROR_VALUE;
        return head.data;
    }

    static int back() {
        if (tail == null) return ERROR_VALUE;
        return tail.data;
    }

    static void clear() {
        head = null;
        tail = null;
    }

    static int getIdx(int idx) {
        Node tmp = head;
        while (tmp.next != null && idx-- != 0) {
            tmp = tmp.next;
        }

        if (tmp == null)
            return ERROR_VALUE;

        return tmp.data;
    }

    static boolean insertByIdx(int idx, int data) {

        Node iterator = head;
        while (iterator != null && idx-- != 0) {
            iterator = iterator.next;
        }
        if (iterator == null)
            return false;

        Node tmp = iterator.next;
        iterator.next = new Node(data);
        iterator.next.next = tmp;
        return true;
    }

    static boolean pop_back() {
        if (head == null) {
            return false;
        }
        Node tmp = head;
        while (tmp.next.next != null) {
            tmp = tmp.next;
        }
        tmp.next = null;
        return true;
    }

    static boolean pop_front() {
        if (head == null) {
            return false;
        }
        head = head.next;
        return true;
    }
}
