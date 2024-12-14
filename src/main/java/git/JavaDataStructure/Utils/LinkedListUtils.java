package git.JavaDataStructure.Utils;

import git.JavaDataStructure.LinkedList.LinkedList;
import git.JavaDataStructure.LinkedList.Node;

import java.lang.reflect.Field;

public class LinkedListUtils {


    public static Node<?> getHeadNode(LinkedList<?> list) {
        try {
            Class<?> reflectedClass = list.getClass();
            Field headField = reflectedClass.getDeclaredField("head");
            headField.setAccessible(true);
            return (Node<?>) headField.get(list);
        } catch (NoSuchFieldException e) {
            throw new IllegalCallerException("'head' field not found in LinkedList class - the structure may be incorrect");
        } catch (IllegalAccessException e) {
            throw new IllegalCallerException("Access to the 'head' field in LinkedList class is not allowed");
        }
    }

    public static Node<?> findMiddle(LinkedList<?> list) {
        if (list.isEmpty()) {
            throw new IllegalCallerException("linked list is empty");
        }
        Node<?> fast = getHeadNode(list);
        Node<?> slow = fast;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;

    }

    public static Object getMiddleData(LinkedList<?> list) {
        return findMiddle(list).data;
    }

    public static boolean hasCycle(LinkedList<?> list) {
        Node<?> head = getHeadNode(list);
        if (head == null) {
            return false;
        }
        Node<?> fast = head;
        Node<?> slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

}
