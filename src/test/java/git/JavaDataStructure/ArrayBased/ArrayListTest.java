package git.JavaDataStructure.ArrayBased;

import junit.framework.TestCase;

import java.util.Iterator;

public class ArrayListTest extends TestCase {

    // Already implemented test cases

    public void testInsert() {
        ArrayList<Integer> list = new ArrayList<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(4);

        list.insert(2, 3); // Insert 3 at index 2
        assertEquals("[1, 2, 3, 4]", list.toString());

        list.insert(0, 0); // Insert 0 at index 0
        assertEquals("[0, 1, 2, 3, 4]", list.toString());
    }

    public void testRemove() {
        ArrayList<Integer> list = new ArrayList<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);

        list.remove(1); // Remove element at index 1
        assertEquals("[1, 3, 4]", list.toString());

        list.remove(0); // Remove first element
        assertEquals("[3, 4]", list.toString());

        list.remove(list.size() - 1); // Remove last element
        assertEquals("[3]", list.toString());
    }

    public void testGetIdx() {
        ArrayList<Integer> list = new ArrayList<>();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);

        assertEquals(10, (int) list.getIdx(0));
        assertEquals(20, (int) list.getIdx(1));
        assertEquals(30, (int) list.getIdx(2));
    }

    public void testSetIdx() {
        ArrayList<Integer> list = new ArrayList<>();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);

        list.setIdx(1, 25); // Set index 1 to 25
        assertEquals("[10, 25, 30]", list.toString());

        list.setIdx(0, 5); // Set index 0 to 5
        assertEquals("[5, 25, 30]", list.toString());
    }

    public void testTestClone() throws CloneNotSupportedException {
        ArrayList<Integer> list = new ArrayList<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);

        ArrayList<Integer> clonedList = (ArrayList<Integer>) list.clone();
        assertEquals(list.toString(), clonedList.toString());
        assertNotSame(list, clonedList); // Ensure it's a deep copy
    }

    public void testSize() {
        ArrayList<Integer> list = new ArrayList<>();
        assertEquals(0, list.size());

        list.addLast(1);
        assertEquals(1, list.size());

        list.addLast(2);
        list.addLast(3);
        assertEquals(3, list.size());

        list.removeLast();
        assertEquals(2, list.size());
    }

    public void testIsValidIndex() {
        ArrayList<Integer> list = new ArrayList<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);

        assertTrue(list.isValidIndex(0));
        assertTrue(list.isValidIndex(2));
        assertFalse(list.isValidIndex(3));
        assertFalse(list.isValidIndex(-1));
    }

    public void testIndexOf() {
        ArrayList<Integer> list = new ArrayList<>();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);

        assertEquals(0, list.indexOf(10));
        assertEquals(1, list.indexOf(20));
        assertEquals(2, list.indexOf(30));
        assertEquals(-1, list.indexOf(40)); // Element not present
    }

    public void testClear() {
        ArrayList<Integer> list = new ArrayList<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);

        list.clear();
        assertEquals(0, list.size());
        assertEquals("[]", list.toString());
    }

    public void testIsEmpty() {
        ArrayList<Integer> list = new ArrayList<>();
        assertTrue(list.isEmpty());

        list.addLast(1);
        assertFalse(list.isEmpty());

        list.removeLast();
        assertTrue(list.isEmpty());
    }

    public void testGetCapacity() {
        ArrayList<Integer> list = new ArrayList<>(5);
        assertEquals(5, list.getCapacity());

        list.addLast(1);
        list.addLast(2);
        assertEquals(5, list.getCapacity());
    }

    public void testGetLast() {
        ArrayList<Integer> list = new ArrayList<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);

        assertEquals(3, (int) list.getLast());
    }

    public void testGetFirst() {
        ArrayList<Integer> list = new ArrayList<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);

        assertEquals(1, (int) list.getFirst());
    }

    public void testIterator() {
        ArrayList<Integer> list = new ArrayList<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);

        Iterator<Integer> iterator = list.iterator();
        StringBuilder result = new StringBuilder();
        while (iterator.hasNext()) {
            result.append(iterator.next()).append(" ");
        }
        assertEquals("1 2 3 ", result.toString());
    }

    public void testTestToString() {
        ArrayList<Integer> list = new ArrayList<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);

        assertEquals("[1, 2, 3]", list.toString());
    }
}
