package git.JavaDataStructure.ArrayBased;

import git.JavaDataStructure.Interfaces.StackInterface;

public class Stack<T> implements Cloneable, StackInterface<T> {
    private ArrayList<T> stack;

    public Stack() {
        stack = new ArrayList<>();
    }

    @SuppressWarnings("unchecked")
    private Stack(ArrayList<T> stackClone) throws CloneNotSupportedException {
        stack = (ArrayList<T>) stackClone.clone();
    }

    @Override
    public void push(T t) {
        stack.addLast(t);
    }

    @Override
    public T pop() {
        return stack.removeLast();
    }

    @Override
    public T peek() {
        return stack.getLast();
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    @SuppressWarnings("unchecked")
    public Object clone() throws CloneNotSupportedException {
        Stack<T> stackClone = (Stack<T>) super.clone();
        stackClone.stack = (ArrayList<T>) this.stack.clone();
        return stackClone;
    }

    @Override
    public String toString() {
        return stack.toString();
    }
}
