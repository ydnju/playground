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

Producer: extends, Consumer: super, and remember, comparators and comparables are always consumers

## Effective Java

### Suppress unchecked warnings

* at the minimum level
* Always leave a comment about why it is safe here.