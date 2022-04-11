package generics;

public class GenericPair<T> {

    // caller provide a construction expression
    public static <T> GenericPair<T> makePair(Class<T> cl) {
        try {
            return new GenericPair<>(
                    cl.getConstructor().newInstance(),
                    cl.getConstructor().newInstance());
        } catch (Exception e) {
            return null;
        }
    }

    private T first;
    private T second;

    public GenericPair(T f, T s) {
        first = f;
        second = s;
    }

    @Override public String toString() {
        return first.toString() + ", " + second.toString();
    }

    public static void main(String[] args) {
        var pair = GenericPair.makePair(String.class);
        System.out.println(pair);
    }
}
