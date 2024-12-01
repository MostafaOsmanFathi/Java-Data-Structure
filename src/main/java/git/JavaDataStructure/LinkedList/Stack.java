package git.JavaDataStructure.LinkedList;

public class Stack<T> implements Cloneable {

    private LinkedList<T> stack;

    public Stack() {
        stack = new LinkedList<>();
    }

    public void push(T t) {
        stack.addLast(t);
    }

    public T pop() {
        return stack.removeLast();
    }

    public T peek() {
        return stack.getLast();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Stack<T> stackClone = (Stack<T>) super.clone();
        stackClone.stack = (LinkedList<T>) stack.clone();
        return stackClone;
    }
}
