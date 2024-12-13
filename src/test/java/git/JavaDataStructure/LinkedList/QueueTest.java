package git.JavaDataStructure.LinkedList;

import junit.framework.TestCase;

public class QueueTest extends TestCase {

    public void testEnqueue() {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        assertEquals(3, queue.size());
        assertEquals(1, (int) queue.peek());
    }

    public void testDequeue() {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        assertEquals(1, (int) queue.dequeue());
        assertEquals(2, queue.size());
        assertEquals(2, (int) queue.peek());
    }

    public void testPeek() {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        assertEquals(1, (int) queue.peek());
        assertEquals(2, queue.size());
    }

    public void testSize() {
        Queue<Integer> queue = new Queue<>();
        assertEquals(0, queue.size());
        queue.enqueue(10);
        queue.enqueue(20);
        assertEquals(2, queue.size());
    }

    public void testIsEmpty() {
        Queue<Integer> queue = new Queue<>();
        assertTrue(queue.isEmpty());
        queue.enqueue(5);
        assertFalse(queue.isEmpty());
    }

    public void testTestToString() {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        assertEquals("[1, 2, 3]", queue.toString());
    }
}