package git.JavaDataStructure.ArrayBased;

public class Stack<T> implements Cloneable {
    private ArrayList<T> stack;

    public Stack() {
        stack = new ArrayList<>();
    }

    @SuppressWarnings("unchecked")
    private Stack(ArrayList<T> stackClone) throws CloneNotSupportedException {
        stack = (ArrayList<T>) stackClone.clone();
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
    @SuppressWarnings("unchecked")
    public Object clone() throws CloneNotSupportedException {
        Stack<T> stackClone = (Stack<T>) super.clone();
        stackClone.stack = (ArrayList<T>) this.stack.clone();
        return stackClone;
    }
}
