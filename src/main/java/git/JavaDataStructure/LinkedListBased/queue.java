package git.JavaDataStructure.LinkedListBased;

public class queue {
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

    static boolean enqueue(int data) {
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


    static int front() {
        if (head == null) return ERROR_VALUE;
        return head.data;
    }


    static boolean dequeue() {
        if (head == null) {
            return false;
        }
        head = head.next;
        return true;
    }

    static void clear() {
        head = null;
        tail = null;
    }
}
