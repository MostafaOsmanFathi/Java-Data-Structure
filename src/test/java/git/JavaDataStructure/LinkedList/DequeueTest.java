package git.JavaDataStructure.LinkedList;

import junit.framework.TestCase;

public class DequeueTest extends TestCase {

    public void testAddFirst() {
        Dequeue<Integer> dq = new Dequeue<>();
        dq.addFirst(10);
        assertEquals(10, (int) dq.getFirst());
    }

    public void testAddLast() {
        Dequeue<Integer> dq = new Dequeue<>();
        dq.addLast(20);
        assertEquals(20, (int) dq.getLast());
    }

    public void testRemoveFirst() {
        Dequeue<Integer> dq = new Dequeue<>();
        dq.addFirst(30);
        assertEquals(30, (int) dq.removeFirst());
        assertTrue(dq.isEmpty());
    }

    public void testRemoveLast() {
        Dequeue<Integer> dq = new Dequeue<>();
        dq.addLast(40);
        assertEquals(40, (int) dq.removeLast());
        assertTrue(dq.isEmpty());
    }

    public void testGetFirst() {
        Dequeue<Integer> dq = new Dequeue<>();
        dq.addFirst(50);
        assertEquals(50, (int) dq.getFirst());
    }

    public void testGetLast() {
        Dequeue<Integer> dq = new Dequeue<>();
        dq.addLast(60);
        assertEquals(60, (int) dq.getLast());
    }

    public void testIsEmpty() {
        Dequeue<Integer> dq = new Dequeue<>();
        assertTrue(dq.isEmpty());
        dq.addFirst(70);
        assertFalse(dq.isEmpty());
    }

    public void testSize() {
        Dequeue<Integer> dq = new Dequeue<>();
        assertEquals(0, dq.size());
        dq.addFirst(80);
        dq.addLast(90);
        assertEquals(2, dq.size());
    }

    public void testTestClone() throws CloneNotSupportedException {
        Dequeue<Integer> dq = new Dequeue<>();
        dq.addFirst(100);
        Dequeue<Integer> dqClone = (Dequeue<Integer>) dq.clone();
        assertEquals(100, (int) dqClone.getFirst());
        assertEquals(1, dqClone.size());
    }

    public void testTestToString() {
        Dequeue<Integer> dq = new Dequeue<>();
        dq.addFirst(110);
        dq.addLast(120);
        assertEquals("[110, 120]", dq.toString());
    }
}