package git.JavaDataStructure.LinkedListBased;

public class Stack {
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

    static boolean push(int data) {
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

    static int top() {
        if (tail == null) return ERROR_VALUE;
        return tail.data;
    }

    static void clear() {
        head = null;
        tail = null;
    }
}
