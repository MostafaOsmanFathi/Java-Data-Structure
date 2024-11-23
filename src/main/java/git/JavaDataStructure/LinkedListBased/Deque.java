package git.JavaDataStructure.LinkedListBased;

public class Deque {

    static int ERROR_VALUE = -1;

    static class Node {
        int data;
        LinkedList.Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static LinkedList.Node head = null;
    static LinkedList.Node tail = null;

    static boolean push_back(int data) {
        if (head == null) {
            head = new LinkedList.Node((data));
            tail = head;
            return true;
        } else {
            tail.next = new LinkedList.Node(data);
            tail = tail.next;
            return true;
        }
    }

    static boolean push_front(int data) {
        if (head == null) {
            head = new LinkedList.Node((data));
            tail = head;
            return true;
        } else {
            LinkedList.Node tmp = new LinkedList.Node(data);
            tmp.next = head;
            head = tmp;
            return true;
        }
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



    static boolean pop_back() {
        if (head == null) {
            return false;
        }
        LinkedList.Node tmp = head;
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
