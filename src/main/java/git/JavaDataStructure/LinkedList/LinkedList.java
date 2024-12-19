package git.JavaDataStructure.LinkedList;


import git.JavaDataStructure.Abstract.AbstractLinkedList;
import git.JavaDataStructure.Utils.NodeUtils;

public class LinkedList<T> extends AbstractLinkedList<T> implements Iterable<T>, Cloneable {


    public LinkedList() {
        super(0);
        head = null;
        tail = null;
    }

    @Override
    public T remove(int index) {
        if (head == null) {
            throw new IllegalCallerException("linked list is empty");
        } else if (index == 0)
            return removeFirst();
        else if (index == size - 1)
            return removeLast();

        Node<T> targetNode = getIdxNode(index);
        T data = targetNode.data;
        NodeUtils.removeNodeBetween2Nodes(targetNode);
        --size;
        return data;
    }

    @SuppressWarnings("unchecked")
    @Override
    public LinkedList<T> clone() throws CloneNotSupportedException {
        LinkedList<T> list = (LinkedList<T>) super.clone();
        list.clear();

        for (T data : this) {
            list.addLast(data);
        }
        return list;
    }
}
