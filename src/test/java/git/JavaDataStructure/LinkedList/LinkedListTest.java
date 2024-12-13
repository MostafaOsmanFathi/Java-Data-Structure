package git.JavaDataStructure.LinkedList;

import junit.framework.TestCase;
import git.JavaDataStructure.LinkedList.LinkedList;
import git.JavaDataStructure.LinkedList.Node;

import java.util.Iterator;

public class LinkedListTest extends TestCase {

    public void testAddFirst() {
        LinkedList<Integer> list = new LinkedList<>();
        list.addFirst(1);
        list.addFirst(2);
        assertEquals(2, (int) list.getFirst());
        assertEquals(1, (int) list.getLast());
    }

    public void testAddLast() {
        LinkedList<Integer> list = new LinkedList<>();
        list.addLast(1);
        list.addLast(2);
        assertEquals(1, (int) list.getFirst());
        assertEquals(2, (int) list.getLast());
    }

    public void testRemoveFirst() {
        LinkedList<Integer> list = new LinkedList<>();
        list.addFirst(1);
        list.addFirst(2);
        assertEquals(2, list.size());
        assertEquals(2, (int) list.removeFirst());
        assertEquals(1, list.size());
        assertEquals(1, (int) list.getFirst());
    }

    public void testRemoveLast() {
        LinkedList<Integer> list = new LinkedList<>();
        list.addFirst(1);
        list.addFirst(2);
        assertEquals(1, (int) list.removeLast());
        assertEquals(2, (int) list.getLast());
    }

    public void testRemove() {
        LinkedList<Integer> list = new LinkedList<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.remove(1);
        assertEquals(-1, list.indexOf(2));
    }

    public void testGetFirst() {
        LinkedList<Integer> list = new LinkedList<>();
        list.addFirst(1);
        list.addFirst(2);
        assertEquals(2, (int) list.getFirst());
    }

    public void testGetLast() {
        LinkedList<Integer> list = new LinkedList<>();
        list.addLast(1);
        list.addLast(2);
        assertEquals(2, (int) list.getLast());
    }

    public void testIsEmpty() {
        LinkedList<Integer> list = new LinkedList<>();
        assertTrue(list.isEmpty());
        list.addFirst(1);
        assertFalse(list.isEmpty());
    }

    public void testInsert() {
        LinkedList<Integer> list = new LinkedList<>();
        list.addLast(1);
        list.addLast(3);
        list.insert(1, 2);
        assertEquals(2, (int) list.getIdx(1));
        System.out.print(list.toString());
    }

    public void testSize() {
        LinkedList<Integer> list = new LinkedList<>();
        list.addLast(1);
        list.addLast(2);
        assertEquals(2, list.size());
    }

    public void testIterator() {
        LinkedList<Integer> list = new LinkedList<>();
        list.addLast(1);
        list.addLast(2);
        Iterator<Integer> iterator = list.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(1, (int) iterator.next());
    }

    public void testIndexOf() {
        LinkedList<Integer> list = new LinkedList<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        assertEquals(1, list.indexOf(2));
    }

    public void testGetMiddleData() {
        LinkedList<Integer> list = new LinkedList<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        assertEquals(2, (int) list.getMiddleData());
    }

    public void testHasCycle() {
        LinkedList<Integer> list = new LinkedList<>();
        Node<Integer> node1 = new Node<>(1);
        Node<Integer> node2 = new Node<>(2);
        Node<Integer> node3 = new Node<>(3);
        list.head = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node1;
        assertTrue(list.hasCycle());
    }

    public void testSplitIntoTwo() {
        LinkedList<Integer> list = new LinkedList<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        LinkedList<Integer> split = list.splitIntoTwo();
        assertEquals(2, list.size());
        assertEquals(1, split.size());
    }


    public void testClear() {
        LinkedList<Integer> list = new LinkedList<>();
        list.addLast(1);
        list.addLast(2);
        list.clear();
        assertTrue(list.isEmpty());
    }

    public void testTestClone() throws CloneNotSupportedException {
        LinkedList<Integer> list = new LinkedList<>();
        list.addLast(1);
        list.addLast(2);
        LinkedList<Integer> clone = list.clone();
        assertEquals(list.size(), clone.size());
    }

    public void testTestToString() {
        LinkedList<Integer> list = new LinkedList<>();
        list.addLast(1);
        list.addLast(2);
        assertEquals("[1, 2]", list.toString());
    }
    /*public void testTestToString2() {
        LinkedList<Integer> list = new LinkedList<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        for(Integer i : list) {
            System.out.println(i);
        }
    }*/
}