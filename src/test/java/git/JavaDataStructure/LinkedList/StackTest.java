package git.JavaDataStructure.LinkedList;

import junit.framework.TestCase;

import static org.junit.Assert.assertNotEquals;

public class StackTest extends TestCase {

    public void testPush() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.peek().intValue());
        stack.push(3);
        assertEquals(3, stack.peek().intValue());
    }

    public void testPop() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.pop().intValue());
        assertEquals(1, stack.pop().intValue());
        try {
            stack.pop();
            fail("Expected an exception for popping from an empty stack");
        } catch (RuntimeException e) {
            // Expected exception
        }
    }

    public void testPeek() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.peek().intValue());
        stack.pop();
        assertEquals(1, stack.peek().intValue());
        stack.pop();
        try {
            stack.peek();
            fail("Expected an exception for peeking into an empty stack");
        } catch (RuntimeException e) {
            // Expected exception
        }
    }

    public void testIsEmpty() {
        Stack<Integer> stack = new Stack<>();
        assertTrue(stack.isEmpty());
        stack.push(1);
        assertFalse(stack.isEmpty());
        stack.pop();
        assertTrue(stack.isEmpty());
    }

    public void testTestClone() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        try {
            Stack<Integer> clonedStack = (Stack<Integer>) stack.clone();
            assertEquals(stack.peek(), clonedStack.peek());
            clonedStack.pop();
            assertNotEquals(stack.peek(), clonedStack.peek());
        } catch (CloneNotSupportedException e) {
            fail("Cloning failed");
        }
    }

    public void testTestToString() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        assertEquals("[1, 2]", stack.toString());
        stack.pop();
        assertEquals("[1]", stack.toString());
    }
}