package git.JavaDataStructure.Utils;

import junit.framework.TestCase;
import git.JavaDataStructure.LinkedList.LinkedList;
import git.JavaDataStructure.LinkedList.Node;
import org.junit.Test;

public class LinkedListUtilsTest extends TestCase {

    public void testGetMiddleData() {
        LinkedList<Integer> list = new LinkedList<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);

        LinkedListUtils utils = new LinkedListUtils();
        assertEquals(3, utils.getMiddleData(list));

        list.addLast(6); // Even-length list
        assertEquals(4, utils.getMiddleData(list));
    }


    public void testHasCycle() {
        LinkedList<Integer> list = new LinkedList<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);

        LinkedListUtils utils = new LinkedListUtils();
        assertFalse(utils.hasCycle(list));
    }
}