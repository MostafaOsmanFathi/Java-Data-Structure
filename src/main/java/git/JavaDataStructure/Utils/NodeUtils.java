package git.JavaDataStructure.Utils;

import git.JavaDataStructure.LinkedList.Node;

import java.util.Objects;

public class NodeUtils {
    public static <T> void linkTwoNodes(Node<T> first, Node<T> second) {
        Objects.requireNonNull(first);
        Objects.requireNonNull(second);

        first.next = second;
        second.prev = first;
    }

    public static <T> void insertBetween2Nodes(Node<T> first, Node<T> second, Node<T> insertedNode) {
        Objects.requireNonNull(first);
        Objects.requireNonNull(second);
        Objects.requireNonNull(insertedNode);
        linkTwoNodes(first, insertedNode);
        linkTwoNodes(insertedNode, second);
    }

    public static <T> void removeNodeBetween2Nodes(Node<T> node) {
        Objects.requireNonNull(node);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}
