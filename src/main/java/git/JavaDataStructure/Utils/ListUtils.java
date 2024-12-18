package git.JavaDataStructure.Utils;

import git.JavaDataStructure.Abstract.AbstractList;


import java.util.Iterator;

public class ListUtils {

    static <T> void mergeLists(AbstractList<T> destinationList, AbstractList<T> sourceList) {
        Iterator<T> sourceIterator = sourceList.iterator();
        while (sourceIterator.hasNext()) {
            destinationList.addLast(sourceIterator.next());
        }
    }

}
