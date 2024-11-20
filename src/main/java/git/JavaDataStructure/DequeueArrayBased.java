package git.JavaDataStructure;

public class DequeueArrayBased {
    final static int ERROR_VALUE = -1;

    static int[] arr = new int[2];
    static int size = 0;
    static int HeadIdx = 0;
    static int TailIdx = 1;
    static int capacity = 2;

    static void resetHeadAndTail() {
        HeadIdx = ((HeadIdx % arr.length) + arr.length) % arr.length;
        TailIdx = ((TailIdx % arr.length) + arr.length) % arr.length;
    }

    static boolean reserve(int newCapacity) {
        if (capacity >= newCapacity) {
            return false;
        }
        newCapacity = Math.max(1, newCapacity);
        int[] newArr = new int[newCapacity];

        for (int i = HeadIdx + 1, iTrack = 0; i % arr.length != TailIdx; i++, iTrack++) {
            newArr[iTrack] = arr[i % arr.length];
        }

        arr = newArr;
        capacity = newCapacity;
        HeadIdx = -1;
        TailIdx = size;
        resetHeadAndTail();

        return true;
    }

    static boolean push_back(int value) {
        resetHeadAndTail();
        if (HeadIdx == TailIdx) {
            if (!reserve(capacity * 2)) return false;
        }
        arr[TailIdx] = value;
        TailIdx++;
        resetHeadAndTail();
        size++;
        return true;
    }

    static int pop_back() {
        if (size == 0) {
            return ERROR_VALUE;
        }
        int value = arr[TailIdx];
        TailIdx--;
        resetHeadAndTail();
        size--;
        return value;
    }

    static boolean push_front(int value) {
        if (HeadIdx == TailIdx) {
            if (!reserve(capacity * 2)) return false;
        }
        arr[HeadIdx] = value;
        HeadIdx--;
        resetHeadAndTail();
        size++;
        return true;
    }

    static int pop_front() {
        if (size == 0) {
            return ERROR_VALUE;
        }
        int value = arr[HeadIdx];
        HeadIdx++;
        resetHeadAndTail();
        size--;
        return value;
    }

    static int front() {
        if (size == 0) {
            return ERROR_VALUE;
        }
        return arr[HeadIdx];
    }

    static int back() {
        if (size == 0) {
            return ERROR_VALUE;
        }
        return arr[TailIdx];
    }

    //Circular DeQueue is random access in array Based
    static int getIdx(int i) {
        if (i >= size) return ERROR_VALUE;

        int idx = (((HeadIdx + i + 1) % arr.length) + arr.length) % arr.length;
        return arr[idx];
    }

    static int setIdx(int i, int value) {
        if (i >= size) return ERROR_VALUE;

        int idx = (((HeadIdx + i + 1) % arr.length) + arr.length) % arr.length;
        arr[idx] = value;
        return arr[idx];
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            push_back(i + 1);
        }
        for (int i = 0; i < size; i++) {
            System.out.print(getIdx(i) + " ");
        }
        for (int i = 10; i < 15; i++) {
            push_front(i);
        }
        System.out.println();
        for (int i = 0; i < size; i++) {
            System.out.print(getIdx(i) + " ");
        }

        for (int i = 0; i < 6; i++) {
            pop_back();
        }

        System.out.println();
        for (int i = 0; i < size; i++) {
            System.out.print(getIdx(i) + " ");
        }

        pop_front();
        pop_front();

        System.out.println();
        for (int i = 0; i < size; i++) {
            System.out.print(getIdx(i) + " ");
        }
    }

}