## Notes on generics

### Type Erasure
Type erasure in inheritance: virtual machine will synthesize bridge methods,
to mitigate the issue introduced by type erasure and polymorphism.

* There are no generics in VM, only ordinary classes and methods.
* All type parameters are replaced by their bounds.
* Bridge methods are synthesized to preserve polymorphism.
* Casts are inserted as necessary to preserve type safety.

### Restrictions and Limitations

* No primitive types for generics
* 
* instanceof getClass can only apply to raw types
* Arrays of generic types are not allowed (erasure then array store exception)
* You cannot instantiate type variable.
  * Use supplier
  * Use constructor from reflection
* Array creation is also difficult: cast Comparable[] to String[] is invalid, 
  and you should consider providing construction methods too

* You cannot use T in static contexts
* You cannot throw or catch instances of a generic class
* To support translation by erasure, it is not legal for a class to be subtype
  of two interface types with different parameterizations of the same interface.

### Inheritance rule for generics

A is subtype of B, but Pair&lt;A>; is not subtype of Pair&lt;B>

List&lt;Manager> is subtype of List

ArrayList&lt;Manager> is subtype of List&lt;Manager>

### Wildcard types

Use wildcard types if you want type inheritance: ? extends Employee

You can safely get, but unsafely mutate with bounded wildcard variables,

you can write with supertype bound, and read with subtype bound.

Usage of super:

* predicate: default boolean removeIf(Predicate<? super E> filter);
* type bounds

Unbounded wildcards

Pair<?>: can call get but never set

unbound wildcards are used when:

* you write a functionality that can be implemented with object's methods
* the method do not rely on the type, e.g. length or size()

Producer: extends, Consumer: super, and remember, comparators and comparables are always consumers

List<? extends Integer> is subtype of List<? extends Number>

#### Wildcard Capture

The compiler infers type from a wildcard, use a private helper method to capture th wildcard.

another code that is fundamentally wrong:


```java
public class WildcardErrorBad {

    void swapFirst(List<? extends Number> l1, List<? extends Number> l2) {
      Number temp = l1.get(0);
      l1.set(0, l2.get(0)); // expected a CAP#1 extends Number,
                            // got a CAP#2 extends Number;
                            // same bound, but different types
      l2.set(0, temp);	    // expected a CAP#1 extends Number,
                            // got a Number
    }
}
```

#### Wildcard Guidelines

Some rules, which do not apply to return type, Returned types should not use wildcards:

* in variable: extends
* out variable: super
* in variable can be accessed using methods defined in Object class: unbound wildcard
* both in and out, do not use wildcard

### Type Erasure

generic types are erased to Object, bounded are erased to bounded type.

Inheritance and Erasure: bridge methods, and some restrictions to avoid conflict bridge methods.

### Non reifiable types

a reifiable type is a type whose type information is fully available at runtime, e.g. primitive types, non-generic
types, raw types, invocations of unbound wildcards.

non-reifiable: whose information is removed by erasure at runtime. e.g. List&lt;String> and List&lt;Number>

## Effective Java

### Suppress unchecked warnings

* at the minimum level
* Always leave a comment about why it is safe here.

### Varargs

When use generics with varargs, first ensure it is type safe, then mark it with @SafeVarargs
and try to use generics instead of arrays as much as possible.