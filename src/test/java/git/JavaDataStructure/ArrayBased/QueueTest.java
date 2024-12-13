package git.JavaDataStructure.ArrayBased;

import junit.framework.TestCase;

import static org.junit.Assert.assertNotEquals;

public class QueueTest extends TestCase {

    public void testEnqueue() {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(1);
        assertEquals(1, (int) queue.peek());
    }

    public void testDequeue() {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        int dequeued = queue.dequeue();
        assertEquals(1, dequeued);
        assertEquals(1, queue.size());
        assertEquals(2, (int) queue.peek());
    }

    public void testPeek() {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        assertEquals(1, (int) queue.peek());
        queue.dequeue();
        assertEquals(2, (int) queue.peek());
    }

    public void testIsEmpty() {
        Queue<Integer> queue = new Queue<>();
        assertTrue(queue.isEmpty());
        queue.enqueue(1);
        assertFalse(queue.isEmpty());
        queue.dequeue();
        assertTrue(queue.isEmpty());
    }

    public void testSize() {
        Queue<Integer> queue = new Queue<>();
        assertEquals(0, queue.size());
        queue.enqueue(1);
        queue.enqueue(2);
        assertEquals(2, queue.size());
        queue.dequeue();
        assertEquals(1, queue.size());
    }

    public void testTestClone() throws CloneNotSupportedException {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        Queue<Integer> clonedQueue = (Queue<Integer>) queue.clone();
        assertEquals(queue.size(), clonedQueue.size());
        assertEquals(queue.peek(), clonedQueue.peek());
        clonedQueue.dequeue();
        assertNotEquals(queue.size(), clonedQueue.size());
    }

    public void testTestToString() {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        assertEquals("[1, 2]", queue.toString());
        queue.dequeue();
        assertEquals("[2]", queue.toString());
    }
}