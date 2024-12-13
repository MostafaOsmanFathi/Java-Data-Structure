package git.JavaDataStructure.ArrayBased;

import junit.framework.TestCase;


import junit.framework.TestCase;

import java.util.Iterator;

public class DequeueTest extends TestCase {

    public void testAddLast() {
        Dequeue<Integer> deque = new Dequeue<>();
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);
        assertEquals("[1, 2, 3]", deque.toString());
    }

    public void testRemoveLast() {
        Dequeue<Integer> deque = new Dequeue<>();
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);

        deque.removeLast();
        assertEquals("[1, 2]", deque.toString());
        deque.removeLast();
        assertEquals("[1]", deque.toString());
        deque.removeLast();
        assertEquals("[]", deque.toString());
    }

    public void testAddFirst() {
        Dequeue<Integer> deque = new Dequeue<>();
        deque.addFirst(1);
        deque.addFirst(2);
        assertEquals("[2, 1]", deque.toString());
        deque.addFirst(3);
        assertEquals("[3, 2, 1]", deque.toString());
    }

    public void testRemoveFirst() {
        Dequeue<Integer> deque = new Dequeue<>();
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);

        deque.removeFirst();
        assertEquals("[2, 3]", deque.toString());
        deque.removeFirst();
        assertEquals("[3]", deque.toString());
        deque.removeFirst();
        assertEquals("[]", deque.toString());
    }

    public void testInsert() {
        Dequeue<Integer> deque = new Dequeue<>();
        deque.addLast(1);
        deque.addLast(3);
        deque.insert(1, 2); // Insert 2 at index 1
        assertEquals("[1, 2, 3]", deque.toString());
    }

    public void testRemove() {
        Dequeue<Integer> deque = new Dequeue<>();
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);

        deque.remove(1); // Remove element at index 1
        assertEquals("[1, 3]", deque.toString());

        deque.remove(1);
        assertEquals("[1]", deque.toString());

        deque.remove(0); // Remove element at index 1
        assertEquals("[]", deque.toString());

    }

    public void testGetIdx() {
        Dequeue<Integer> deque = new Dequeue<>();
        deque.addLast(10);
        deque.addLast(20);
        deque.addLast(30);

        assertEquals(10, (int) deque.getIdx(0));
        assertEquals(20, (int) deque.getIdx(1));
        assertEquals(30, (int) deque.getIdx(2));
    }

    public void testGetFirst() {
        Dequeue<Integer> deque = new Dequeue<>();
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);

        assertEquals(1, (int) deque.getFirst());
    }

    public void testGetLast() {
        Dequeue<Integer> deque = new Dequeue<>();
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);

        assertEquals(3, (int) deque.getLast());
    }

    public void testSetIdx() {
        Dequeue<Integer> deque = new Dequeue<>();
        deque.addLast(10);
        deque.addLast(20);
        deque.addLast(30);

        deque.setIdx(1, 25); // Set index 1 to 25
        assertEquals("[10, 25, 30]", deque.toString());
    }

    public void testSize() {
        Dequeue<Integer> deque = new Dequeue<>();
        assertEquals(0, deque.size());

        deque.addLast(1);
        assertEquals(1, deque.size());

        deque.addLast(2);
        deque.addLast(3);
        assertEquals(3, deque.size());
    }

    public void testIsValidIndex() {
        Dequeue<Integer> deque = new Dequeue<>();
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);

        assertTrue(deque.isValidIndex(0));
        assertTrue(deque.isValidIndex(2));
        assertFalse(deque.isValidIndex(3));
        assertFalse(deque.isValidIndex(-1));
    }

    public void testIndexOf() {
        Dequeue<Integer> deque = new Dequeue<>();
        deque.addLast(10);
        deque.addLast(20);
        deque.addLast(30);

        assertEquals(0, deque.indexOf(10));
        assertEquals(1, deque.indexOf(20));
        assertEquals(2, deque.indexOf(30));
        assertEquals(-1, deque.indexOf(40)); // Element not present
    }

    public void testClear() {
        Dequeue<Integer> deque = new Dequeue<>();
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);

        deque.clear();
        assertEquals(0, deque.size());
        assertEquals("[]", deque.toString());
    }

    public void testIsEmpty() {
        Dequeue<Integer> deque = new Dequeue<>();
        assertTrue(deque.isEmpty());

        deque.addLast(1);
        assertFalse(deque.isEmpty());

        deque.removeLast();
        assertTrue(deque.isEmpty());
    }

    public void testIterator() {
        Dequeue<Integer> deque = new Dequeue<>();
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);

        Iterator<Integer> iterator = deque.iterator();
        StringBuilder result = new StringBuilder();
        while (iterator.hasNext()) {
            result.append(iterator.next()).append(" ");
        }
        assertEquals("1 2 3 ", result.toString());
    }

    public void testTestClone() throws CloneNotSupportedException {
        Dequeue<Integer> deque = new Dequeue<>();
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);

        Dequeue<Integer> clonedDeque = (Dequeue<Integer>) deque.clone();
        assertEquals(deque.toString(), clonedDeque.toString());
        assertNotSame(deque, clonedDeque); // Ensure it's a deep copy
    }

    public void testTestToString() {
        Dequeue<Integer> deque = new Dequeue<>();
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);

        assertEquals("[1, 2, 3]", deque.toString());
    }
}
