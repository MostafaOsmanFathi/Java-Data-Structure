package git.JavaDataStructure.ArrayBased;

import java.util.function.Function;

public class ArrayLibrary {
    final static int ERROR_VALUE = -1;

    static int[] arr = new int[0];
    static int size = 0;
    static int capacity = 0;

    public static boolean reserve(int newCapacity) {
        if (newCapacity < 0)
            return false;

        int[] newArr = new int[newCapacity];
        int copyLimit = Math.min(size, Math.min(newCapacity, capacity));
        for (int i = 0; i < copyLimit; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
        capacity = newCapacity;
        return true;
    }

    public static boolean resize(int newSize) {
        if (newSize < 0) {
            return false;
        } else if (newSize > capacity) {
            reserve(newSize * 2);
        }
        size = newSize;
        return true;
    }

    public static boolean addLast(int value) {
        if (size == capacity) {
            if (!reserve(size * 2))
                return false;
        }
        arr[size++] = value;
        return true;
    }

    public static boolean insert(int idx, int value) {
        if (size == capacity) {
            if (!reserve(size * 2))
                return false;
        }
        for (int i = size; i > idx; i--) {
            arr[i] = arr[i - 1];
        }
        arr[idx] = value;
        return true;
    }

    public static boolean removeLast(int idx) {
        if (size == 0) return false;
        --size;
        return true;
    }

    public static boolean remove(int idx) {
        if (size == 0) return false;
        for (int i = idx; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        --size;
        return true;
    }

    public static int getIdx(int idx) {
        if (idx >= 0 && idx < size) {
            return arr[idx];
        }
        return ERROR_VALUE;
    }

    public static boolean setIdx(int idx, int value) {
        if (idx >= 0 && idx < size) {
            return true;
        }
        return false;
    }

    public static boolean isEmpty() {
        return size == 0;
    }

    public static boolean reverse() {
        if (arr == null) return false;

        for (int i = 0; i < size; i++) {
            int tmp = arr[i];
            arr[i] = arr[size - i - 1];
            arr[size - i - 1] = tmp;
        }
        return true;
    }

    public static boolean mapFunction(Function<Integer, Integer> fun) {
        if (arr == null) return false;
        for (int i = 0; i < size; i++) {
            arr[i] = fun.apply(arr[i]);
        }
        return true;
    }

    public static int findIdx(int value) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == value)
                return i;
        }
        return ERROR_VALUE;
    }

    public static void main(String[] args) {


    }

    private ArrayLibrary() {
    }

}

