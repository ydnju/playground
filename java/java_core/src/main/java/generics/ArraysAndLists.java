package generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ArraysAndLists<T> {
    private final List<T> list;

    public ArraysAndLists(Collection<T> choices) {
        list = new ArrayList<>(choices);
    }

    public static void main(String[] args) {
        Object[] arrs = new Long[1];
        // throws exception at runtime
        arrs[0] = "Ahhh";
    }
}

// Not good, but reasonable, need cast and suppress warning, and
// also may fail at runtime
class ArrayChoices<T> {
    private final T[] list;

    @SuppressWarnings("unchecked")
    public ArrayChoices(Collection<T> choices) {
        list = (T[]) choices.toArray();
    }
}