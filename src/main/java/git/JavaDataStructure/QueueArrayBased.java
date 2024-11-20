package git.JavaDataStructure;

public class QueueArrayBased {
    final static int ERROR_VALUE = -1;

    static int[] arr = new int[0];
    static int size = 0;
    static int HeadIdx = 0;
    static int TailIdx = 0;
    static int capacity = 0;

    private static boolean shrink() {
        int arrayHead = 0;
        for (int i = HeadIdx; i < size; i++, arrayHead++) {
            arr[arrayHead] = arr[i];
        }
        HeadIdx = 0;
        TailIdx = arrayHead - 1;
        size = arrayHead;
        return true;
    }

    private static boolean reserve(int newCapacity) {
        if (newCapacity < 0) return false;
        else if (newCapacity == 0) {
            newCapacity = 1;
        } else if (newCapacity > 2 && HeadIdx >= (newCapacity / 2) - 1) {
            shrink();
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

    public static boolean enqueue(int value) {
        if (size == capacity) {
            if (!reserve(size * 2)) return false;
        }
        arr[size++] = value;
        TailIdx = size - 1;
        return true;
    }

    public static int front() {
        if (HeadIdx == TailIdx) return ERROR_VALUE;
        return arr[HeadIdx];
    }


    public static int dequeue() {
        if (size == HeadIdx) return ERROR_VALUE;
        return arr[HeadIdx++];
    }

    public static void main(String[] args) {
        enqueue(1);
        enqueue(2);
        enqueue(3);
        System.out.println(dequeue());
        System.out.println(dequeue());
        System.out.println(dequeue());
        enqueue(4);
        //Array Utlization test
        //reusing the array space instead of makeing a new space
        enqueue(5);
    }

}
