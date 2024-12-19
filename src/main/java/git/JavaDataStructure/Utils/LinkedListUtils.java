package git.JavaDataStructure.Utils;

import git.JavaDataStructure.LinkedList.LinkedList;
import git.JavaDataStructure.LinkedList.Node;

import java.lang.reflect.Field;

public class LinkedListUtils {



    public static Node<?> getHeadNode(LinkedList<?> list) {
        try {
            Class<?> currentClass = list.getClass();

            // Traverse up the hierarchy to find the 'head' field
            while (currentClass != null) {
                try {
                    Field headField = currentClass.getDeclaredField("head");
                    headField.setAccessible(true);
                    return (Node<?>) headField.get(list); // Access 'head' field
                } catch (NoSuchFieldException e) {
                    // If 'head' is not found in the current class, move up the hierarchy
                    currentClass = currentClass.getSuperclass();
                }
            }

            // If we traverse the entire hierarchy and still can't find 'head'
            throw new NoSuchFieldException("'head' field not found in the class hierarchy");
        } catch (NoSuchFieldException e) {
            throw new IllegalCallerException("'head' field not found - the structure may be incorrect");
        } catch (IllegalAccessException e) {
            throw new IllegalCallerException("Access to the 'head' field is not allowed");
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
