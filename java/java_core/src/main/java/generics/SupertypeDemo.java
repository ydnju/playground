package generics;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;

public class SupertypeDemo {

    // Note the ? super here, LocalDate extends ChronoLocalDate which implements Comparable<ChronoLocaldate>
    public static <T extends Comparable<? super T>> T min(T[] a) {
        if (a == null || a.length == 0) return null;
        T curmin = a[0];
        for (int i = 1; i < a.length; i++) {
            if (curmin.compareTo(a[i]) > 0) {
                curmin = a[i];
            }
        }

        return curmin;
    }

    public static void main(String[] args) {
        LocalDate[] dates = new LocalDate[]{ LocalDate.now(), LocalDate.MAX, LocalDate.MIN };
        var minLocalDate = min(dates);
        System.out.println(minLocalDate);

        // Another use of super
        ArrayList<String> arr = new ArrayList<>();
        arr.add("hello");
        arr.add("world");

        // predicate should be ? super E because we could use parent's methods for predicate
        arr.removeIf(elem -> elem.equals("hello"));
        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i));
        }
    }
}
