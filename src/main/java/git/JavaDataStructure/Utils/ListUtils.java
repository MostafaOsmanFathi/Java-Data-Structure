package git.JavaDataStructure.Utils;

import git.JavaDataStructure.Abstract.AbstractList;


import java.util.Iterator;
import java.util.Objects;

public class ListUtils {

    static <T> void mergeLists(AbstractList<T> destinationList, AbstractList<T> sourceList) {
        Objects.requireNonNull(destinationList, "destinationList cannot be null");
        Objects.requireNonNull(sourceList, "sourceList cannot be null");

        Iterator<T> sourceIterator = sourceList.iterator();
        while (sourceIterator.hasNext()) {
            destinationList.addLast(sourceIterator.next());
        }
    }

}
