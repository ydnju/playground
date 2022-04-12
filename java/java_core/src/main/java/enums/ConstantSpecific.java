package enums;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

public class ConstantSpecific {
    public static void main(String[] args) {
        System.out.println(Operation.PLUS.apply(2,3));
    }
}

enum Operation {
    PLUS {
        public double apply(double x, double y) {return x + y;}
    },

    MINUS {
        public double apply(double x, double y) {return x - y;}
    };
    public abstract double apply(double x, double y);

    private static final Map<String, Operation> stringToEnum =
            Stream.of(values()).collect(toMap(Object::toString, e -> e));

    public static Optional<Operation> fromString(String symbol) {
        return Optional.ofNullable(stringToEnum.get(symbol));
    }
}