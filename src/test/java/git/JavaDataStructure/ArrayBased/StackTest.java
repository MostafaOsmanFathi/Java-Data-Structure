package git.JavaDataStructure.ArrayBased;

import junit.framework.TestCase;

public class StackTest extends TestCase {

    public void testPush() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        assertEquals("[1, 2]", stack.toString());
    }

    public void testPop() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        assertEquals((Integer) 2, stack.pop());
        assertEquals((Integer) 1, stack.pop());
        assertTrue(stack.isEmpty());
    }

    public void testPeek() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        assertEquals((Integer) 2, stack.peek());
        assertEquals("[1, 2]", stack.toString());
    }

    public void testIsEmpty() {
        Stack<Integer> stack = new Stack<>();
        assertTrue(stack.isEmpty());
        stack.push(1);
        assertFalse(stack.isEmpty());
    }

    public void testTestClone() throws CloneNotSupportedException {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        Stack<Integer> clonedStack = (Stack<Integer>) stack.clone();
        assertEquals("[1, 2]", clonedStack.toString());
        clonedStack.pop();
        assertEquals("[1, 2]", stack.toString());
        assertEquals("[1]", clonedStack.toString());
    }

    public void testTestToString() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        assertEquals("[1, 2]", stack.toString());
    }
}