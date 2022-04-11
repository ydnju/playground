package generics;

import java.io.Serializable;

// Always put tag interfaces like Serializables to the end,
// In type erasure, the T will be erased to Comparable. and inserts casts to Serializable when necessary,
// For efficiency, you should always put tagging interfaces at the end.
public class GenericInterval<T extends Comparable & Serializable> {
    private T lower;
    private T higher;

    public GenericInterval(T l, T h) {
        if (l.compareTo(h) < 0) {
            lower = l;
            higher = h;
        } else {
            lower = h;
            higher = l;
        }
    }
}
