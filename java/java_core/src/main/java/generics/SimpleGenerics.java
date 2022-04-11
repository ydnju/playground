package generics;

public class SimpleGenerics {
    public static <T> T getMiddle (T... a) {
        return a[a.length / 2];
    }

    // Bounds
    public static <T extends Comparable> T min(T... a) {
        if (a == null || a.length == 0) return null;
        T smallest = a[0];
        for (int i = 1; i < a.length; i++) {
            if (smallest.compareTo(a[i]) > 0) {
                smallest = a[i];
            }
        }

        return smallest;
    }

    public static void main(String[] args) {
        System.out.println(getMiddle(1, 2, 3));
        System.out.println(min("asd", "sas", "aa", "assd"));
    }
}
