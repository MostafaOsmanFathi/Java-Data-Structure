package git.JavaDataStructure.ArrayBased;

public class StackArrayBased {
    final static int ERROR_VALUE = -1;

    static int[] arr = new int[0];
    static int size = 0;
    static int capacity = 0;

    private static boolean reserve(int newCapacity) {
        if (newCapacity < 0)
            return false;
        else if (newCapacity == 0) {
            newCapacity = 1;
        }
        int[] newArr = new int[newCapacity];
        int copyLimit = Math.min(size, Math.min(newCapacity, capacity));
        for (int i = 0; i < copyLimit; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
        capacity = newCapacity;
        return true;
    }

    public static boolean push(int value) {
        if (size == capacity) {
            if (!reserve(size * 2))
                return false;
        }
        arr[size++] = value;
        return true;
    }


    public static int pop() {
        if (size == 0) return ERROR_VALUE;
        int value = arr[--size];
        return value;
    }

    public static boolean isEmpty() {
        return size == 0;
    }

    public static int top() {
        if (size == 0) return ERROR_VALUE;
        return arr[size - 1];
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            push(i);
        }
        while (!isEmpty()) {
            System.out.println(pop());
        }
    }

}
