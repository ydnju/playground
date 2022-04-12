package lambdas;

import java.util.Arrays;
import java.util.Comparator;

public class ComparingDemo {
    private String s1;
    private String s2;

    public ComparingDemo(String s1, String s2) {
        this.s1 = s1;
        this.s2 = s2;
    }

    public String getS1() {
        return s1;
    }

    public String getS2() {
        return s2;
    }

    public static void main(String[] args) {
        ComparingDemo[] arr = new ComparingDemo[2];
        arr[0] = new ComparingDemo("haha", "ha2");
        arr[1] = new ComparingDemo("haha", "ha1");
        Arrays.sort(arr, Comparator.comparing(ComparingDemo::getS1).thenComparing(ComparingDemo::getS2));
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i].getS2());
        }
    }
}
