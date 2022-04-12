## Lambda

Conversion to Functional interface is the only thing you can do with a lambda,
In java you cannot define function types.

### Generic function interfaces in java.util package

* BiFunction<T, U, R>

BiFunction<String, String, Integer> comp = (first, second) -> first.length() - second.length();

* Predicate&lt;T>
* Supplier&lt;T>

e.g. use Object.requieNonNullOrElseGet(..., () -> new LocalDate()); // lazy evaluation saves time.

### Method References

System.out::println is a method reference, can also be attached to a functional interface.

Three types of method reference:

* object::instanceMethod // bind to instance
* Class::instanceMehtod
* class::staticMethod

### Constructor Reference

String::new

Person[] people = stream.toArray(Person[]::new)

### Variable Scope

variables can be captured by a lambda expression, so its lifetime is extended.

In java, you can only reference variables whose value doesn't change. It mainly relates to concurrency and safety.

Every captured variable must be effectively final.

### Processing Lambda Expressions

The reason for using lambda expression is deferred execution, many reasons:

* Running the code in a separate thread
* Running the code multiple times
* Running the code at the right point
* Running the code when something happens
* Running the code only when necessary

There are a lot of functional interfaces for primitive types, like IntConsumer, it is always good to use a

Functional interface whenever you can.

### More about comparators

Use Comparator.comparing helper method, use thenComparing to break ties if needed.